# frozen_string_literal: true

# This file is part of SSID.
#
# SSID is free software: you can redistribute it and/or modify
# it under the terms of the GNU Lesser General Public License as published by
# the Free Software Foundation, either version 3 of the License, or
# (at your option) any later version.
#
# SSID is distributed in the hope that it will be useful,
# but WITHOUT ANY WARRANTY; without even the implied warranty of
# MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
# GNU Lesser General Public License for more details.
#
# You should have received a copy of the GNU Lesser General Public License
# along with SSID.  If not, see <http://www.gnu.org/licenses/>.

require 'zip'
require 'api_keys_handler'

module Api
  module V1
    class AssignmentsController < ApplicationController
      skip_before_action :authenticate_user!

      before_action do |_controller|
        @course = Course.find(params['course_id']) if params['course_id']
      end

      before_action :init_api_key_handler

      # Define valid zip mime types as constant variables
      X_ZIP_COMPRESSED_MIME_TYPE = 'application/x-zip-compressed'
      ZIP_COMPRESSED_MIME_TYPE = 'application/zip-compressed'
      APPLICATION_ZIP_MIME_TYPE = 'application/zip'
      MULTIPART_X_ZIP_MIME_TYPE = 'multipart/x-zip'
      OCTET_STREAM_MIME_TYPE = 'application/octet-stream'
      REQUIRED_PARAMS = %w[title language studentSubmissions].freeze
      ALLOWED_PARAMS = %w[title language useFingerprints minimumMatchLength sizeOfNGram studentSubmissions
                          mappingFile].freeze
      ALLOWED_LANGUAGES = %w[java python3 c cpp javascript r ocaml matlab scala].freeze

      def init_api_key_handler
        APIKeysHandler.api_key = ApiKey.find_by(value: request.headers['X-API-KEY'])
        APIKeysHandler.course = @course
      end

      # GET api/v1/courses/1/assignments/new
      def new
        @assignment = Assignment.new
      end

      # POST api/v1/courses/1/assignments
      def create
        REQUIRED_PARAMS.each do |p|
          if params[p].nil?
            render json: { error: "Missing required parameter '#{p}'" }, status: :bad_request
            return
          end
        end

        request.request_parameters.each do |k, _v|
          if ALLOWED_PARAMS.include?(k) == false
            render json: { error: "Parameter #{k} is invalid or not yet supported." }, status: :bad_request
            return
          end
        end

        @assignment = Assignment.new do |a|
          a.title = params['title']
          a.language = params['language']
          a.min_match_length = params['minimumMatchLength'].presence || 2 # defaults to 2 if not specified
          a.ngram_size = params['sizeOfNGram'].presence || 5 # defaults to 5 if not specified
          a.course_id = @course.id
        end

        begin
          APIKeysHandler.authenticate_api_key
        rescue APIKeysHandler::APIKeyError => e
          render json: { error: e.message }, status: e.status
          return
        end

        REQUIRED_PARAMS.each do |p|
          if params[p].nil?
            render json: { error: "Missing required parameter '#{p}'" }, status: :bad_request
            return
          end
        end

        unless ALLOWED_LANGUAGES.include?(params['language'])
          render json: { error: "Value of language is not valid.' +
              'We currently support #{ALLOWED_LANGUAGES}.' +
              'The parameter value must be in lowercase and match exactly one of the options." },
                 status: :bad_request
          return
        end

        if params['useFingerprints'] && %w[Yes No].exclude?(params['useFingerprints'])
          render json: { error: 'Value of useFingerprints is not valid. ' \
                                'The value should be "Yes" or "No". ' \
                                'The parameter value must be in lowercase and match exactly one of the options.' },
                 status: :bad_request
          return
        end

        Rails.logger.debug 'DEBUG 06: Enable fingerprints checkbox?'
        Rails.logger.debug { "Checkbox: #{params['useFingerprints']}" }
        # Process file if @assignment is valid and file was uploaded
        if @assignment.valid?

          # Save assignment to obtain id
          return render action: 'new' unless @assignment.save

          is_map_enabled = !params['mappingFile'].nil?
          used_fingerprints = params['useFingerprints'] == 'Yes'

          # No student submission file was uploaded
          # Student submission file is a valid zip
          if valid_zip?(params['studentSubmissions'].content_type, params['studentSubmissions'].path)
            # Don't process the file and show error if the mapping was enabled but no mapping file was uploaded
            if valid_map_or_no_map?(is_map_enabled, params['mappingFile'])
              start_upload(@assignment, params['studentSubmissions'], is_map_enabled, params['mappingFile'],
                           used_fingerprints)
            # Don't process the file and show error if the mapping was enabled but no mapping file was uploaded
            else
              @assignment.errors.add :mapfile, 'containing mapped student names must be a valid csv file'
              render json: { error: "Value of mappingFile is not valid. '
                + 'The mapping file must be a valid csv file." },
                     status: :bad_request
            end
          # Student submission file is not a valid zip file
          else
            @assignment.errors.add :file, 'containing student submission files must be a valid zip file'
            render json: { error: 'Value of studentSubmissions is not valid. ' \
                                  'studentSubmissions must be a valid zip file.' },
                   status: :bad_request
          end
        else
          render action: 'new'
        end
      end

      def start_upload(assignment, submission_file, is_map_enabled, map_file, used_fingerprints)
        require 'submissions_handler'

        # Process upload file
        submissions_path = SubmissionsHandler.process_upload(submission_file, is_map_enabled, map_file, assignment)
        if submissions_path
          # Launch java program to process submissions
          SubmissionsHandler.process_submissions(submissions_path, assignment, is_map_enabled, used_fingerprints)

          render json: { assignmentID: @assignment.id }, status: :ok
        else
          assignment.errors.add 'Submission zip file',
                                ': SSID supports both directory-based and file-based submissions. ' \
                                'Please select the submissions you want to evaluate and compress.'
          render action: 'show'
        end
      end

      # Responsible for verifying whether a uploaded file is zip by checking its mime
      # type and/or whether can it be extracted by the zip library.
      # For files with mime type = application/octet-stream, it needs to be further verified
      # by the zip library as it can be a rar file.
      # Params:
      # +mime_type+:: string that contains the file's mimetype
      # +filePath+:: string that contains the file's path which is to be used
      # by the zip library when extracting the file
      def valid_zip?(mime_type, file_path)
        # Valid zip file mime types that does not required to be further verified by the zip library
        if [X_ZIP_COMPRESSED_MIME_TYPE, ZIP_COMPRESSED_MIME_TYPE, APPLICATION_ZIP_MIME_TYPE,
            MULTIPART_X_ZIP_MIME_TYPE].include?(mime_type)
          return true
        # Need to be further verified by zip library as it can be a rar file
        elsif mime_type == OCTET_STREAM_MIME_TYPE && opened_as_zip?(file_path)
          return true
          # For other mime types, safe to consider that it is not a zip file
        end
        false
      end

      # Responsible for verifying whether a uploaded file is zip by checking whether can it be extracted by the zip
      # library
      # Params:
      # +filePath+:: string that contains the file's path which is to be used by the zip library
      # when extracting the file
      def opened_as_zip?(path)
        # File is zip if the zip library is able to extract the file
        zip = Zip::File.open(path)
        true
      rescue StandardError => e
        Rails.logger.debug e
        false
      ensure
        zip&.close
      end

      def valid_map_or_no_map?(is_map_enabled, map_file)
        return true unless is_map_enabled

        if map_file.nil?
          false
        else
          map_file.path.split('.').last.to_s.downcase == 'csv'
        end
      end
    end
  end
end
