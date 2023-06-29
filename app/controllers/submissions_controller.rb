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

class SubmissionsController < ApplicationController
  before_action { |controller|
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

  # GET /assignments/id/list
  def index
    @submissions = @assignment.submissions

    respond_to do |format|
      format.json { 
        render json: @submissions.collect { |s| 
          { id: s.id, student_id: s.student.id, student_name: s.student_name } 
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
    # render body :nil, status: 200
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
    # render body: nil, status: 200
  end
end
