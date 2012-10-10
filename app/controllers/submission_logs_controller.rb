class SubmissionLogsController < ApplicationController
  # GET /assignments/1/submissions/1/log
  def index
    @assignment = Assignment.find(params["assignment_id"])
    @course = @assignment.course
    @submission = Submission.find(params["submission_id"])
    @submission_logs = @submission.logs
  end
end
