=begin
This file is part of SSID.

SSID is free software: you can redistribute it and/or modify
it under the terms of the GNU Lesser General Public License as published by
the Free Software Foundation, either version 3 of the License, or
(at your option) any later version.

SSID is distributed in the hope that it will be useful,
but WITHOUT ANY WARRANTY; without even the implied warranty of
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
GNU Lesser General Public License for more details.

You should have received a copy of the GNU Lesser General Public License
along with SSID.  If not, see <http://www.gnu.org/licenses/>.
=end

require 'zip'
require 'api_keys_handler'


class Api::V1::AssignmentsController < ApplicationController
  skip_before_action :authenticate_user!

  before_action { |controller|
    @course = Course.find(params["course_id"]) if params["course_id"]
  }

  before_action :init_api_key_handler

  # Define valid zip mime types as constant variables
  X_ZIP_COMPRESSED_MIME_TYPE = "application/x-zip-compressed"
  ZIP_COMPRESSED_MIME_TYPE = "application/zip-compressed"
  APPLICATION_ZIP_MIME_TYPE = "application/zip"
  MULTIPART_X_ZIP_MIME_TYPE = "multipart/x-zip"
  OCTET_STREAM_MIME_TYPE = "application/octet-stream"
  REQUIRED_PARAMS = ["title", "language"]
  ALLOWED_PARAMS = ["title", "language", "useFingerprints", "minimumMatchLength", "sizeOfNGram", "studentSubmissions", "mappingFile"]
  ALLOWED_LANGUAGES = ["java", "python3", "c", "cpp", "javascript", "r", "ocaml", "matlab", "scala"]

  def init_api_key_handler
    APIKeysHandler.api_key = ApiKey.find_by(value: request.headers["X-API-KEY"])
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
        render json: {"error": "Missing required parameter '#{p}'"}, status: :bad_request
        return
      end
    end

    request.request_parameters.each do |k, v|
      if ALLOWED_PARAMS.include?(k) == false
        render json: {"error": "Parameter #{k} is invalid or not yet supported."}, status: :bad_request
        return
      end
    end

    @assignment = Assignment.new { |a|
      a.title = params["title"]
      a.language = params["language"]
      a.min_match_length = params["minimumMatchLength"].presence || 2 # defaults to 2 if not specified
      a.ngram_size = params["sizeOfNGram"].presence || 5 # defaults to 5 if not specified
      a.course_id = @course.id
    }

    begin 
      APIKeysHandler.authenticate_api_key
    rescue APIKeysHandler::APIKeyError => e
      render json: {"error": e.message}, status: e.status
      return
    end

    REQUIRED_PARAMS.each do |p|
      if params[p].nil?  
        render json: {"error": "Missing required parameter '#{p}'"}, status: :bad_request
        return
      end
    end

    if !ALLOWED_LANGUAGES.include?(params["language"])
      render json: { "error": "Value of language is not valid. We currently support #{ALLOWED_LANGUAGES.to_s}. Ensure the parameter value must be in lowercase and match exactly one of the options." }, status: :bad_request
      return
    end

    if params["useFingerprints"] && !["Yes", "No"].include?(params["useFingerprints"])
      render json: { "error": "Value of useFingerprints is not valid. The value should be \"Yes\" or \"No\". Ensure the parameter value must be in lowercase and match exactly one of the options." }, status: :bad_request
      return
    end

    puts "DEBUG 06: Enable fingerprints checkbox?"
    puts "Checkbox: #{params["useFingerprints"]}"
    # Process file if @assignment is valid and file was uploaded
    if @assignment.valid?
 
      # Save assignment to obtain id
      return render action: "new" unless @assignment.save

      isMapEnabled = (params["mappingFile"].nil?) ? false : true
      used_fingerprints = (params["useFingerprints"] == "Yes")? true : false

      # No student submission file was uploaded
      # Student submission file is a valid zip
      if (is_valid_zip?(params["studentSubmissions"].content_type, params["studentSubmissions"].path))
        # Don't process the file and show error if the mapping was enabled but no mapping file was uploaded
        if (is_valid_map_or_no_map?(isMapEnabled, params["mappingFile"])) 
          self.start_upload(@assignment, params["studentSubmissions"], isMapEnabled, params["mappingFile"], used_fingerprints)
        # Don't process the file and show error if the mapping was enabled but no mapping file was uploaded
        else 
          @assignment.errors.add :mapfile, "containing mapped student names must be a valid csv file"
          render json: { "error": "Value of mappingFile is not valid. The mapping file must be a valid csv file. #{isMapEnabled}, #{params["mappingFile"].content_type}" }, status: :bad_request
        end
      # Student submission file is not a valid zip file
      else
        @assignment.errors.add :file, "containing student submission files must be a valid zip file"
        render json: { "error": "Value of studentSubmissions is not valid. studentSubmissions must be a valid zip file." }, status: :bad_request
        return render action: "new"
      end
    else
      render action: "new"
    end
  end

  def start_upload(assignment, submissionFile, isMapEnabled, mapFile, used_fingerprints)
      require 'submissions_handler'

      # Process upload file
      submissions_path = SubmissionsHandler.process_upload(submissionFile, isMapEnabled, mapFile, assignment)
      if submissions_path
        # Launch java program to process submissions
        SubmissionsHandler.process_submissions(submissions_path, assignment, isMapEnabled, used_fingerprints)
        
        process = assignment.submission_similarity_process
        notice = 'SSID will start to process the assignment now. Please refresh this page after a few minutes to view the similarity results.'
        if process && process.status == SubmissionSimilarityProcess::STATUS_WAITING
          notice = 'Your assignment has been put into a waiting list. SSID will process it soon. Thank you for your patience.'
        end
        render json: {"assignmentID": @assignment.id}, status: :ok
      else
        assignment.errors.add "Submission zip file", ": SSID supports both directory-based and file-based submissions. Please select the submissions you want to evaluate and compress." 
        return render action: "show"
      end

  end

  # Responsible for verifying whether a uploaded file is zip by checking its mime type and/or whether can it be extracted by the zip library.
  # For files with mime type = application/octet-stream, it needs to be further verified by the zip library as it can be a rar file.
  # Params:
  # +mimeType+:: string that contains the file's mimetype
  # +filePath+:: string that contains the file's path which is to be used by the zip library when extracting the file
  def is_valid_zip?(mimeType, filePath)
    # Valid zip file mime types that does not required to be further verified by the zip library
    if mimeType == X_ZIP_COMPRESSED_MIME_TYPE || 
      mimeType == ZIP_COMPRESSED_MIME_TYPE ||
      mimeType == APPLICATION_ZIP_MIME_TYPE ||
      mimeType == MULTIPART_X_ZIP_MIME_TYPE
      return true;
    # Need to be further verified by zip library as it can be a rar file
    elsif mimeType == OCTET_STREAM_MIME_TYPE && is_opened_as_zip?(filePath)
      return true;
    # For other mime types, safe to consider that it is not a zip file
      return false;
    end
  end

  # Responsible for verifying whether a uploaded file is zip by checking whether can it be extracted by the zip library
  # Params:
  # +filePath+:: string that contains the file's path which is to be used by the zip library when extracting the file
  def is_opened_as_zip?(path)
    # File is zip if the zip library is able to extract the file
    zip = Zip::File.open(path)
    true
  rescue => error_msg
    puts error_msg
    false
  ensure
    zip.close if zip
  end

  def is_valid_map_or_no_map?(isMapEnabled, mapFile)
    if (!isMapEnabled)
      return true
    else
      if (mapFile.nil?) 
        return false
      elsif mapFile.path.split('.').last.to_s.downcase == 'csv'
        return true
      else 
        return false
      end
    end
  end
end