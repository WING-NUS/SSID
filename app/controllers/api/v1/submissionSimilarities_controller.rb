class Api::V1::SubmissionSimilaritiesController < ApplicationController
    skip_before_action :authenticate_user!
    before_action :set_course_and_assignment

    def sample_get
        api_key = ApiKey.find_by(value: request.headers["X-API-KEY"])
        
        if api_key
            if authorized_for_course?(api_key.user, @course) 
                render json: {"Status": "OK"}, status: :ok
            else
                render json: {"Status": "Unauthorized access"}, status: :unauthorized
            end
        else
            render json: {"Status": "Can't find API key"}, status: :not_found
        end
    end

    def sample_post
        api_key = ApiKey.find_by(value: request.headers["X-API-KEY"])
        
        if api_key
            if authorized_for_course?(api_key.user, @course) 
                render json: {"Status": "OK"}, status: :ok
            else
                render json: {"Status": "Unauthorized access"}, status: :unauthorized
            end
        else
            render json: {"Status": "Can't find API key"}, status: :not_found
        end 
    end

    def get_similarities_for_assignment
        assignment_id = params[:assignment_id]
        assignment = Assignment.find_by(id: params[:assignment_id])
    
        if assignment.nil?
            render json: {"Status": "Assignment not found"}, status: :not_found
            return
        end
    
        # Fetch all submission similarities associated with this assignment
        submission_similarities = assignment.submission_similarities
    
        # Assuming you want to return the similarities as a JSON response
        render json: submission_similarities
    end
    
    private

    def set_course_and_assignment
        @course = Course.find(params[:course_id]) if params[:course_id]
        @assignment = Assignment.find(params[:assignment_id]) if params[:assignment_id]
    end

    def authorized_for_course?(user, course)
        user_course_membership = UserCourseMembership.find_by(user: user, course: course)
        return user_course_membership.present?
    end
end
