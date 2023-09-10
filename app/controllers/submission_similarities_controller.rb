=begin
This file is part of SSID.

SSID is free software: you can redistribute it and/or modify
it under the terms of the GNU Lesser General Public License as published by
the Free Software Foundation, either version 3 of the License, or
(at your option) any later version.

SSID is distributed in the hope that it will be useful,
but WITHOUT ANY WARRANTY; without even the implied warranty of
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
GNU Lesser General Public License for more details.

You should have received a copy of the GNU Lesser General Public License
along with SSID.  If not, see <http://www.gnu.org/licenses/>.
=end

class SubmissionSimilaritiesController < ApplicationController
  
  before_action { |controller|
    @course = nil
    if params[:assignment_id]
      @assignment = Assignment.find(params["assignment_id"])
      @course = @assignment.course
    end
    if params[:course_id]
      @course = Course.find(params[:course_id])
    end
    if @course
      controller.send :authenticate_actions_for_role, UserCourseMembership::ROLE_STUDENT,
                                                      course: @course,
                                                      only: [ ]
      controller.send :authenticate_actions_for_role, UserCourseMembership::ROLE_GUEST,
                                                      course: @course,
                                                      only: [ :index, :show ]
    end
  }

  # GET /assignments/1/submission_similarities
  def index
    # obtain parameters (if any)
    @hashed_url = session[:hashed_url]
    @displayDialog = session[:displayDialog]
    session[:displayDialog] = false
    
    # Determine sort direction
    sort_direction = params[:sort_direction] || 'descending'
    order_string = sort_direction == 'ascending' ? 'status asc' : 'status desc'
  
    @submission_similarities = SubmissionSimilarity.where(
      assignment_id: @assignment.id 
    ).order(order_string, 'similarity desc').paginate(page: params[:page], per_page: 20)
  end

  def create_guest_user
    @assignment = Assignment.find(params[:id])
    @course = @assignment.course

    @user = User.find_by_id(session[:user_id]) 
    @guest_user = @course.guest_user_finder(@user)
    # do not allow to create a sharable link if user is a guest user
    if (@guest_user)
      redirect_to assignment_submission_similarities_url(params[:id]), notice: 'You cannot create a sharable link as you are using SSID as a guest user. To create a sharable link and/or use other features, log in to SSID.'
    else
      # create a secure hash
      hash_string = SecureRandom.urlsafe_base64(9).gsub(/-|_/,('a'..'z').to_a[rand(26)])
      
      # hashed public url
      @hashed_url = request.base_url + "/guest_user/" + hash_string
      
      # create the user in database
      @guest_user = User.new { |u|
        u.name = hash_string
        u.full_name = hash_string
        u.password_digest = BCrypt::Password.create("password")
        u.email = "#{hash_string}@ssid.example.com"
        u.is_admin_approved = 1
        u.activated = 1
        u.activated_at = Time.zone.now
      }
     
      # create a entry under other tables in database
      @guest_user.transaction do
        if @guest_user.save and @course
          # create entry under membership
          membership = UserCourseMembership.new { |m|
            m.role = 3
            m.user = @guest_user
            m.course = @course
          }
          raise ActiveRecord::Rollback unless membership.save

          # create entry under guest user
          guest = GuestUsersDetail.new { |m|
            m.user_id = @guest_user.id
            m.course_id = @course.id
            m.hash_string = hash_string
            m.assignment_id = @assignment.id
          }
          raise ActiveRecord::Rollback unless guest.save

        end
      end
      
      # save the parameters and redirect
      session[:hashed_url] = @hashed_url
      session[:displayDialog] = true
      redirect_to assignment_submission_similarities_url(params[:id])
    end
  end

  # GET /assignments/1/submission_similarities/1/view_printable
  def view_printable
    @submission_similarity = SubmissionSimilarity.find(params["submission_similarity_id"])

    render partial: "pair_report"
  end

  # GET /assignments/1/view_printable_multiple?submission_similarity_ids=1,2,3
  def view_printable_multiple
    @submission_similarity_ids = params["submission_similarity_ids"].split(',')

    render partial: "pair_report_multiple"
  end

  # GET /assignments/1/submission_similarities/1
  def show
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
    @submission_similarity = SubmissionSimilarity.find(params["submission_similarity_id"])
    @submission_similarity.status = SubmissionSimilarity::STATUS_CONFIRMED_AS_PLAGIARISM
    if @submission_similarity.save
      SubmissionLog.create { |sl|
        sl.submission_similarity = @submission_similarity
        sl.submission = @submission_similarity.submission1
        sl.marker = current_user
        sl.log_type = SubmissionLog::TYPE_PAIR_CONFIRM_AS_PLAGIARISM
      }
      SubmissionLog.create { |sl|
        sl.submission_similarity = @submission_similarity
        sl.submission = @submission_similarity.submission2
        sl.marker = current_user
        sl.log_type = SubmissionLog::TYPE_PAIR_CONFIRM_AS_PLAGIARISM
      }
    end
    redirect_to assignment_submission_similarity_url(@assignment, @submission_similarity)
  end

  # PUT /students/1/submission_similarities/1/suspect_as_plagiarism
  def suspect_as_plagiarism
    @submission_similarity = SubmissionSimilarity.find(params["submission_similarity_id"])
    @submission_similarity.status = SubmissionSimilarity::STATUS_SUSPECTED_AS_PLAGIARISM
    if @submission_similarity.save
      mark_student_as_not_guilty(@submission_similarity.submission1, @submission_similarity)
      mark_student_as_not_guilty(@submission_similarity.submission2, @submission_similarity)
      SubmissionLog.create { |sl|
        sl.submission_similarity = @submission_similarity
        sl.submission = @submission_similarity.submission1
        sl.marker = current_user
        sl.log_type = SubmissionLog::TYPE_PAIR_SUSPECT_AS_PLAGIARISM
      }
      SubmissionLog.create { |sl|
        sl.submission_similarity = @submission_similarity
        sl.submission = @submission_similarity.submission2
        sl.marker = current_user
        sl.log_type = SubmissionLog::TYPE_PAIR_SUSPECT_AS_PLAGIARISM
      }
    end
    redirect_to assignment_submission_similarity_url(@assignment, @submission_similarity)
  end

  # PUT /students/1/submission_similarities/1/unmark_as_plagiarism
  def unmark_as_plagiarism
    @submission_similarity = SubmissionSimilarity.find(params["submission_similarity_id"])
    @submission_similarity.status = SubmissionSimilarity::STATUS_NOT_PLAGIARISM
    if @submission_similarity.save
      mark_student_as_not_guilty(@submission_similarity.submission1, @submission_similarity)
      mark_student_as_not_guilty(@submission_similarity.submission2, @submission_similarity)
      SubmissionLog.create { |sl|
        sl.submission_similarity = @submission_similarity
        sl.submission = @submission_similarity.submission1
        sl.marker = current_user
        sl.log_type = SubmissionLog::TYPE_PAIR_UNMARK_AS_PLAGIARISM
      }
      SubmissionLog.create { |sl|
        sl.submission_similarity = @submission_similarity
        sl.submission = @submission_similarity.submission2
        sl.marker = current_user
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
        sl.marker = current_user
        sl.log_type = SubmissionLog::TYPE_STUDENT_MARK_AS_NOT_GUILTY
      }
    end
  end
end
