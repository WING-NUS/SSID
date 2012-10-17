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

class AssignmentsController < ApplicationController
  before_filter { |controller|
    if params[:course_id]
      @course = Course.find(params[:course_id])
      controller.send :authenticate_actions_for_role, UserCourseMembership::ROLE_TEACHING_ASSISTANT,
                                                      course: @course,
                                                      only: [ :index, :cluster_students ]
      controller.send :authenticate_actions_for_role, UserCourseMembership::ROLE_STUDENT,
                                                      course: @course,
                                                      only: [ ]
    end
  }

  # GET /courses/1/assignments
  def index
    @assignments = @course.assignments
    @processing_assignments = @course.processing_assignments
    @processed_assignments = @course.processed_assignments
    @erroneous_assignments = @course.erroneous_assignments
  end

  def cluster_students
    @assignment = Assignment.find(params["assignment_id"])
    respond_to do |format|
      format.json { 
        render json: @assignment.cluster_students.collect { |s| 
          { id: s.id, id_string: s.id_string } 
        } 
      }
    end
  end

  # GET /courses/1/assignments/1/upload_log
  def show_log
    @course = Course.find(params[:course_id])
    @assignment = Assignment.find(params[:assignment_id])
  end

  # GET /courses/1/assignments/new
  def new
    @course = Course.find(params[:course_id])
    @assignment = Assignment.new
  end

  # POST /courses/1/assignments
  def create
    @course = Course.find(params[:course_id])
    @assignment = Assignment.new { |a|
      a.title = params[:assignment]["title"]
      a.language = params[:assignment]["language"]
      a.min_match_length = params[:assignment]["min_match_length"]
      a.ngram_size = params[:assignment]["ngram_size"]
      a.course_id = @course.id
    }

    # Process file if @assignment is valid and file was uploaded
    if @assignment.valid? and not (params[:assignment]["file"].nil? or params[:assignment]["file"].content_type != "application/zip")
      require 'submissions_handler'

      # Save assignment to obtain id
      return render action: "new" unless @assignment.save

      # Process upload file
      submissions_path = SubmissionsHandler.process_upload(params[:assignment]["file"], @assignment)

      # Launch java program to process submissions
      SubmissionsHandler.process_submissions(submissions_path, @assignment)

      redirect_to course_assignments_url(@course), notice: 'Assignment was successfully created.'
    else
      if params[:assignment]["file"].nil?
        @assignment.errors.add :file, "is not selected for upload"
      elsif params[:assignment]["file"].content_type != "application/zip"
        @assignment.errors.add :file, "for upload must be a zip file"
      end
      render action: "new"
    end
  end

  # DELETE /courses/1/assignments/1
  def destroy
    @course = Course.find(params[:course_id])
    @assignment = Assignment.find(params[:id])
    @assignment.destroy
  
    redirect_to course_assignments_url(@course), notice: 'Assignment was successfully deleted.'
  end
end
