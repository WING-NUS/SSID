class Api::V1::SubmissionSimilaritiesController < ApplicationController
    skip_before_action :authenticate_user!
    before_action :set_course_and_assignment

    def sample_get
        if ApiKey.find_by(value: request.headers["X-API-KEY"])
            render json: {"Status": "OK"}, status: :ok
        else
            render json: {"Status": "Can't find API key"}, status: :ok
        end
    end

    def sample_post
        if ApiKey.find_by(value: request.headers["X-API-KEY"])
            render json: {"Status": "OK"}, status: :ok
        else
            render json: {"Status": "Can't find API key"}, status: :ok
        end
    end

    def get_pair_of_flagged_submission_details
        api_key = ApiKey.find_by(value: request.headers["X-API-KEY"])

        if api_key.nil?
            render json: {"error": "Missing or invalid API key."}, status: :unauthorized
            return # Exit early if the API key is missing
        end

        if !authorized_for_course?(api_key.user, @course) 
            render json: {"error": "Your API key is not authorized to access this resource."}, status: :unauthorized
            return # Exit early if not authorized
        end

        assignment_id = params[:assignment_id]
        submission_similarity_id = params[:submission_similarity_id]

        submission_similarity = SubmissionSimilarity.find_by(
            assignment_id: assignment_id,
            id: submission_similarity_id
        )

        if submission_similarity.nil?
            render json: {"error": "Submission similarities requested does not exist."}, status: :bad_request
            return
        end

        # Fetch details of the flagged submissions
        max_similarity_percentage = submission_similarity.similarity
        matches = []

        submission_similarity.similarity_mappings.each do |similarity| 
            matches.append({
              "student1": similarity.line_range1_string,
              "student2": similarity.line_range2_string,
              "statementCount": similarity.statement_count
            })
        end

        render json: {
            "maxSimilarityPercentage": max_similarity_percentage,
            "matches": matches
        }, status: :ok
    end

    def set_course_and_assignment
        @course = Course.find(params[:course_id]) if params[:course_id]
        @assignment = Assignment.find(params[:assignment_id]) if params[:assignment_id]
    end

    def authorized_for_course?(user, course)
        user_course_membership = UserCourseMembership.find_by(user: user, course: course)
        user_course_membership.present?
    end
end