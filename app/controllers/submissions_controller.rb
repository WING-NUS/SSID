class SubmissionsController < ApplicationController
  def index
    @assignment = Assignment.find(params[:assignment_id])
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
    @submission = Submission.find(params["submission_id"])
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
    @submission = Submission.find(params["submission_id"])
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
