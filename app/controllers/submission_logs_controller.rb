class SubmissionLogsController < ApplicationController
  before_filter { |controller|
    if params[:assignment_id]
      @assignment = Assignment.find(params["assignment_id"])
      @course = @assignment.course
      controller.send :authenticate_actions_for_role, UserCourseMembership::ROLE_STUDENT,
                                                      course: @course,
                                                      only: [ ]
    end
  }

  # GET /assignments/1/submissions/1/log
  def index
    @submission = Submission.find(params["submission_id"])
    @submission_logs = @submission.logs
  end
end
