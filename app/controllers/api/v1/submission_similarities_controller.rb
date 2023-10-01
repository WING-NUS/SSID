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
        set_api_key_and_assignment
        handle_errors
        render_submission_similarities
      end

      def show
        set_api_key_and_assignment
        handle_errors
        render_pair_of_flagged_submissions
      end

      private

      def set_api_key_and_assignment
        set_api_key
        set_course_and_assignment
      end

      def set_api_key
        api_key_value = request.headers['X-API-KEY']
        APIKeysHandler.api_key = ApiKey.find_by(value: api_key_value)
      end

      def set_course_and_assignment(assignment_id = params[:assignment_id])
        assignment = Assignment.find_by(id: assignment_id)
        return nil if assignment.nil?

        APIKeysHandler.course = assignment.course
        assignment
      end

      def handle_errors
        begin
          APIKeysHandler.authenticate_api_key
        rescue APIKeysHandler::APIKeyError => e
          render json: { error: e.message }, status: e.status
          return
        end
      end

      def render_submission_similarities
        assignment = Assignment.find_by(id: params[:assignment_id])
        submission_similarities = assignment.submission_similarities
        render json: submission_similarities
      end

      def render_pair_of_flagged_submissions
        submission_similarity = SubmissionSimilarity.find_by(
          assignment_id: params[:assignment_id],
          id: params[:submission_similarity_id]
        )

        if submission_similarity.nil?
          render json: { error: "Submission similarities requested do not exist." }, status: :bad_request
          return
        end

        max_similarity_percentage = submission_similarity.similarity
        matches = []

        submission_similarity.similarity_mappings.each do |similarity|
          matches.append(
            {
              student1: similarity.line_range1_string,
              student2: similarity.line_range2_string,
              statementCount: similarity.statement_count
            }
          )
        end

        render json: {
          maxSimilarityPercentage: max_similarity_percentage,
          matches: matches
        }, status: :ok
      end
    end
  end
end
