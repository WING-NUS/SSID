class Api::V1::SubmissionSimilaritiesController < ApplicationController
  skip_before_action :authenticate_user!
  before_action :authenticate_api_key
  before_action :set_course_and_assignment

  def index
    render_unauthorized("Can't find API key") if @api_key.nil?
    render_unauthorized('Unauthorized access') unless authorized_for_course?(@api_key.user_id, @assignment.course)
    
    # Fetch all submission similarities associated with this assignment
    submission_similarities = @assignment.submission_similarities
    render json: submission_similarities
  end
  
  private

  def authenticate_api_key
    @api_key = ApiKey.find_by(value: request.headers['X-API-KEY'])
  end

  def set_course_and_assignment
    @assignment = Assignment.find_by_id(params[:assignment_id])
    if @assignment.nil?
      render json: {'Status': 'Assignment not found'}, status: :not_found
      return
    end
    @course = @assignment.course
  end
  
  def authorized_for_course?(user, course)
    UserCourseMembership.exists?(user: user, course: course)
  end
  
end
