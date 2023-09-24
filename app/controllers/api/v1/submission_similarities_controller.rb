# frozen_string_literal: true

require 'api_keys_handler'

module Api
  module V1
    # The `SubmissionSimilaritiesController` is responsible for handling API requests related to
    # fetching submission similarities for assignments. It provides an endpoint for clients to
    # retrieve submission similarities associated with a given assignment. The API key must be
    # provided and validated for access, and the user associated with the API key must have
    # authorization for the specified course.
    class SubmissionSimilaritiesController < ApplicationController
      skip_before_action :authenticate_user!

      def index
        api_key_value = request.headers['X-API-KEY']
        APIKeysHandler.api_key = ApiKey.find_by(value: api_key_value)
        assignment = set_course_and_assignment(params[:assignment_id])
        render json: { Status: 'Assignment not found' }, status: :not_found if assignment.nil?
        return if assignment.nil?
      
        APIKeysHandler.authenticate_api_key
        render_unauthorized("Can't find API key") if APIKeysHandler.api_key.nil?
        render_unauthorized('Unauthorized access') unless APIKeysHandler.authorized_for_course?(APIKeysHandler.api_key.user_id, assignment.course.id)
      
        submission_similarities = assignment.submission_similarities
        render json: submission_similarities
      end
      
      def set_course_and_assignment(assignment_id)
        assignment = Assignment.find_by(id: assignment_id)
        return nil if assignment.nil?
      
        APIKeysHandler.course = assignment.course
        assignment
      end
      
      
    end
  end
end
