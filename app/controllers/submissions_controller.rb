class SubmissionsController < ApplicationController
  before_filter { |controller|
    @course = nil
    if params[:assignment_id]
      @assignment = Assignment.find(params[:assignment_id])
      @course = @assignment.course
    elsif params["submission_id"]
      @submission = Submission.find(params["submission_id"])
      @course = @submission.course
    end

    if @course
      controller.send :authenticate_actions_for_role, UserCourseMembership::ROLE_STUDENT,
                                                      course: @course,
                                                      only: [ ]
    end
  }

  def index
    @submissions = @assignment.submissions

    respond_to do |format|
      format.json { 
        render json: @submissions.collect { |s| 
          { id: s.id, student_id: s.student.id, student_id_string: s.student_id_string } 
        } 
      }
    end
  end

  def show_log
  end

  def mark_as_guilty
    @submission_similarity = SubmissionSimilarity.find(params["submission_similarity_id"])
    @submission.is_plagiarism = true
    if @submission.save
      SubmissionLog.create { |sl|
        sl.submission_similarity = @submission_similarity
        sl.submission = @submission
        sl.marker = @user
        sl.log_type = SubmissionLog::TYPE_STUDENT_MARK_AS_GUILTY
      }
    end
    render nothing: true, status: 200
  end

  def mark_as_not_guilty
    @submission_similarity = SubmissionSimilarity.find(params["submission_similarity_id"])
    @submission.is_plagiarism = false
    if @submission.save
      SubmissionLog.create { |sl|
        sl.submission_similarity = @submission_similarity
        sl.submission = @submission
        sl.marker = @user
        sl.log_type = SubmissionLog::TYPE_STUDENT_MARK_AS_NOT_GUILTY
      }
    end
    render nothing: true, status: 200
  end
end
