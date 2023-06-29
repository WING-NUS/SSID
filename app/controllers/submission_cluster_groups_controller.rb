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

class SubmissionClusterGroupsController < ApplicationController
  before_action { |controller|
    if params[:assignment_id]
      @assignment = Assignment.find(params[:assignment_id])
      @course = @assignment.course
      controller.send :authenticate_actions_for_role, UserCourseMembership::ROLE_TEACHING_ASSISTANT,
                                                      course: @course,
                                                      only: [ :index, :new, :create ]
      controller.send :authenticate_actions_for_role, UserCourseMembership::ROLE_STUDENT,
                                                      course: @course,
                                                      only: [ ]
      controller.send :authenticate_actions_for_role, UserCourseMembership::ROLE_GUEST,
                                                      course: @course,
                                                      only: [ ]
    end
  }

  # GET /assignments/1/cluster_groups
  def index
    @cluster_groups = @assignment.submission_cluster_groups
  end

  # GET /assignments/1/cluster_groups/new
  def new
    @assignment_plagiarism_cases = []
    @assignment_plagiarism_cases[SubmissionClusterGroup::TYPE_CONFIRMED_OR_SUSPECTED_PLAGIARISM_CRITERION] =
      @assignment.suspected_plagiarism_cases + @assignment.confirmed_plagiarism_cases
    @assignment_plagiarism_cases[SubmissionClusterGroup::TYPE_CONFIRMED_PLAGIARISM_CRITERION] =
      @assignment.confirmed_plagiarism_cases
    @submission_cluster_group = SubmissionClusterGroup.new
  end

  # POST /assignments/1/cluster_groups
  def create
    # Determine cut-off criterion if type requires
    if params[:submission_cluster_group]["cut_off_criterion_type"] == SubmissionClusterGroup::TYPE_CONFIRMED_OR_SUSPECTED_PLAGIARISM_CRITERION.to_s
      params[:submission_cluster_group]["cut_off_criterion"] = @assignment.confirmed_or_suspected_plagiarism_cases.collect { |submission_similarity|
        submission_similarity.similarity
      }.min
    elsif params[:submission_cluster_group]["cut_off_criterion_type"] == SubmissionClusterGroup::TYPE_CONFIRMED_PLAGIARISM_CRITERION.to_s
      params[:submission_cluster_group]["cut_off_criterion"] = @assignment.confirmed_plagiarism_cases.collect { |submission_similarity|
        submission_similarity.similarity
      }.min
    end

    @submission_cluster_group = SubmissionClusterGroup.new { |scg|
      scg.cut_off_criterion_type = params[:submission_cluster_group]["cut_off_criterion_type"]
      scg.cut_off_criterion = params[:submission_cluster_group]["cut_off_criterion"]
      scg.description = SubmissionClusterGroup::DESCRIPTIONS[params[:submission_cluster_group]["cut_off_criterion_type"].to_i]
      scg.assignment_id = @assignment.id
    }
    
    # Run java program if @submission_cluster_group is valid
    if @submission_cluster_group.valid?
      require 'submissions_handler'
      
      # Rollback if clustering error
      error_message = ""
      @submission_cluster_group.transaction do
        @submission_cluster_group.save
        begin
          SubmissionsHandler.process_cluster_group(@submission_cluster_group)
          redirect_to assignment_cluster_groups_url(@assignment), notice: 'Submission cluster group was successfully created.'
        rescue Exception => e
          error_message = e.message
          raise ActiveRecord::Rollback
        end
      end

      # Render #new and display errors
      unless @submission_cluster_group.id
        @assignment_plagiarism_cases = []
        @assignment_plagiarism_cases[SubmissionClusterGroup::TYPE_CONFIRMED_OR_SUSPECTED_PLAGIARISM_CRITERION] =
          @assignment.suspected_plagiarism_cases + @assignment.confirmed_plagiarism_cases
        @assignment_plagiarism_cases[SubmissionClusterGroup::TYPE_CONFIRMED_PLAGIARISM_CRITERION] =
          @assignment.confirmed_plagiarism_cases
        @submission_cluster_group.errors.add :base, error_message
        render action: "new" 
      end
    else
      @assignment_plagiarism_cases = []
      @assignment_plagiarism_cases[SubmissionClusterGroup::TYPE_CONFIRMED_OR_SUSPECTED_PLAGIARISM_CRITERION] =
        @assignment.suspected_plagiarism_cases + @assignment.confirmed_plagiarism_cases
      @assignment_plagiarism_cases[SubmissionClusterGroup::TYPE_CONFIRMED_PLAGIARISM_CRITERION] =
        @assignment.confirmed_plagiarism_cases
      render action: "new"
    end
  end

  # DELETE /assignments/1/cluster_groups/1
  def destroy
    @submission_cluster_group = SubmissionClusterGroup.find(params[:id])
    @submission_cluster_group.destroy

    redirect_to assignment_cluster_groups_url(@assignment), notice: 'Submission cluster group was successfully deleted.'
  end
end
