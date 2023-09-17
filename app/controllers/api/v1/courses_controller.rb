class Api::V1::CoursesController < ApplicationController
    skip_before_action :authenticate_user!

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
        if ApiKey.find_by(value: request.headers["X-API-KEY"])
            assignment_id = params[:assignment_id]
            submission_similarity_id = params[:submission_similarity_id]

            submission_similarity = SubmissionSimilarity.find_by(
                assignment_id: assignment_id,
                id: submission_similarity_id
            )
            # Fetch details of the flagged submissions
            max_similarity_percentage = submission_similarity.maximum_similarity
            matches = []

            if max_similarity_percentage >= 0 && max_similarity_percentage <= 1
                render json: {
                    "maxSimilarityPercentage": max_similarity_percentage,
                    "matches": matches
                }, status: :ok
            else
                render json: {"error": "Submission similarities requested does not exist."}, status: :bad_request
        else
            render json: {"error": "Missing or invalid API key."}, status: :unauthorized
        end
    end
end