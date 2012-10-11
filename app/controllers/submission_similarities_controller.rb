class SubmissionSimilaritiesController < ApplicationController
  # GET /assignments/1/submission_similarities
  def index
    @assignment = Assignment.find(params["assignment_id"])
    @course = @assignment.course
    @submission_similarities = SubmissionSimilarity.where(
      assignment_id: @assignment.id 
    ).paginate  page: params[:page], 
                order: 'similarity desc', 
                per_page: 20
  end

  # GET /assignments/1/submission_similarities/1
  def show
    @assignment = Assignment.find(params["assignment_id"])
    @course = @assignment.course
    @submission_similarity = SubmissionSimilarity.find(params["id"])
    @submission1 = @submission_similarity.submission1
    @submission2 = @submission_similarity.submission2
    @student1 = @submission1.student
    @student2 = @submission2.student
  end

  # GET /students/1/submission_similarities/show_table_partial
  def show_table_partial
    locals = {}
    locals[:student] = User.find(params["student_id"])
    if params["course_id"]
      locals[:assignments] = Course.find(params["course_id"]).assignments
    elsif params["assignment_id"]
      locals[:assignments] = [ Assignment.find(params["assignment_id"]) ]
    end
    locals[:num_display] = params["num_display"].to_i
    render partial: "submission_similarities_table", locals: locals
  end

  # PUT /students/1/submission_similarities/1/confirm_as_plagiarism
  def confirm_as_plagiarism
    @assignment = Assignment.find(params["assignment_id"])
    @submission_similarity = SubmissionSimilarity.find(params["submission_similarity_id"])
    @submission_similarity.status = SubmissionSimilarity::STATUS_CONFIRMED_AS_PLAGIARISM
    if @submission_similarity.save
      SubmissionLog.create { |sl|
        sl.submission_similarity = @submission_similarity
        sl.submission = @submission_similarity.submission1
        sl.marker = @user
        sl.log_type = SubmissionLog::TYPE_PAIR_CONFIRM_AS_PLAGIARISM
      }
      SubmissionLog.create { |sl|
        sl.submission_similarity = @submission_similarity
        sl.submission = @submission_similarity.submission2
        sl.marker = @user
        sl.log_type = SubmissionLog::TYPE_PAIR_CONFIRM_AS_PLAGIARISM
      }
    end
    redirect_to assignment_submission_similarity_url(@assignment, @submission_similarity)
  end

  # PUT /students/1/submission_similarities/1/suspect_as_plagiarism
  def suspect_as_plagiarism
    @assignment = Assignment.find(params["assignment_id"])
    @submission_similarity = SubmissionSimilarity.find(params["submission_similarity_id"])
    @submission_similarity.status = SubmissionSimilarity::STATUS_SUSPECTED_AS_PLAGIARISM
    if @submission_similarity.save
      mark_student_as_not_guilty(@submission_similarity.submission1, @submission_similarity)
      mark_student_as_not_guilty(@submission_similarity.submission2, @submission_similarity)
      SubmissionLog.create { |sl|
        sl.submission_similarity = @submission_similarity
        sl.submission = @submission_similarity.submission1
        sl.marker = @user
        sl.log_type = SubmissionLog::TYPE_PAIR_SUSPECT_AS_PLAGIARISM
      }
      SubmissionLog.create { |sl|
        sl.submission_similarity = @submission_similarity
        sl.submission = @submission_similarity.submission2
        sl.marker = @user
        sl.log_type = SubmissionLog::TYPE_PAIR_SUSPECT_AS_PLAGIARISM
      }
    end
    redirect_to assignment_submission_similarity_url(@assignment, @submission_similarity)
  end

  # PUT /students/1/submission_similarities/1/unmark_as_plagiarism
  def unmark_as_plagiarism
    @assignment = Assignment.find(params["assignment_id"])
    @submission_similarity = SubmissionSimilarity.find(params["submission_similarity_id"])
    @submission_similarity.status = SubmissionSimilarity::STATUS_NOT_PLAGIARISM
    if @submission_similarity.save
      mark_student_as_not_guilty(@submission_similarity.submission1, @submission_similarity)
      mark_student_as_not_guilty(@submission_similarity.submission2, @submission_similarity)
      SubmissionLog.create { |sl|
        sl.submission_similarity = @submission_similarity
        sl.submission = @submission_similarity.submission1
        sl.marker = @user
        sl.log_type = SubmissionLog::TYPE_PAIR_UNMARK_AS_PLAGIARISM
      }
      SubmissionLog.create { |sl|
        sl.submission_similarity = @submission_similarity
        sl.submission = @submission_similarity.submission2
        sl.marker = @user
        sl.log_type = SubmissionLog::TYPE_PAIR_UNMARK_AS_PLAGIARISM
      }
    end
    redirect_to assignment_submission_similarity_url(@assignment, @submission_similarity)
  end

  private

  def mark_student_as_not_guilty(submission, submission_similarity)
    return unless submission.is_plagiarism
    submission.is_plagiarism = false
    if submission.save
      SubmissionLog.create { |sl|
        sl.submission_similarity = submission_similarity
        sl.submission = submission
        sl.marker = @user
        sl.log_type = SubmissionLog::TYPE_STUDENT_MARK_AS_NOT_GUILTY
      }
    end
  end
end
