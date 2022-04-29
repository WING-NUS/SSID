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

class SubmissionLogsController < ApplicationController
  before_action { |controller|
    if params[:assignment_id] and params[:submission_similarity_id]
      controller.send :authenticate_custom_actions_for_teaching_staff, only: [:view_similarity]                                                                    
    elsif params[:assignment_id]
      @assignment = Assignment.find(params["assignment_id"])
      @course = @assignment.course
      controller.send :authenticate_actions_for_role, UserCourseMembership::ROLE_STUDENT,
                                                      course: @course,
                                                      only: [ ]
      controller.send :authenticate_actions_for_role, UserCourseMembership::ROLE_GUEST,
                                                      course: @course,
                                                      only: [ ]
    end
  }

  # GET /assignments/1/submissions/1/log
  def index
    @submission = Submission.find(params["submission_id"])
    @submission_logs = @submission.logs
  end

  # 
  def view_similarity
    @assignment = Assignment.find(params[:assignment_id])

    unless @user.is_admin
      course = @assignment.course
      membership = course.membership_for_user(@user)

      unless membership
        # Create a guest entry for current user
        SubmissionSimilaritiesService.create_guest_entry(@assignment, @user)      
      end
    end

    submission_similarity = SubmissionSimilarity.find(params[:submission_similarity_id])
    redirect_to assignment_submission_similarity_path(@assignment, submission_similarity)
  end

end
