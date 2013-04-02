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

class CoursesController < ApplicationController
  before_filter { |controller|
    controller.send :authenticate_actions_for_admin, only: [ :new, :create, :edit, :update, :destroy ]
  }
  before_filter { |controller|
    if params[:course_id]
      @course = Course.find(params[:course_id])
    elsif params[:id]
      @course = Course.find(params[:id])
    end
    if @course
      controller.send :authenticate_actions_for_role, UserCourseMembership::ROLE_TEACHING_STAFF,
                                                      course: @course,
                                                      only: [ :index, :cluster_students , :status]
      controller.send :authenticate_actions_for_role, UserCourseMembership::ROLE_TEACHING_ASSISTANT,
                                                      course: @course,
                                                      only: [ :index, :cluster_students , :status]
      controller.send :authenticate_actions_for_role, UserCourseMembership::ROLE_STUDENT,
                                                      course: @course,
                                                      only: [ :index ]
    end
  }
  
  # GET /courses/1/assignments/processing
  def status
    @course = Course.find(params[:course_id])
    @empty_assignments = @course.empty_assignments
    @processing_assignments = @course.processing_assignments
    @processed_assignments = @course.processed_assignments
    @erroneous_assignments = @course.erroneous_assignments
    
    respond_to do |format|
      format.js
    end
  end

  # GET /courses
  def index
    @courses = @user.is_admin ? Course.all : @user.courses
  end

  # GET /courses/new
  def new
    @course = Course.new
  end

  # POST /courses
  def create
    @course = Course.new { |c|
      c.code = params[:course]["code"]
      c.name = params[:course]["name"]
      c.academic_year = params[:course]["academic_year"]
      c.semester = params[:course]["semester"]
      c.expiry = Time.zone.local_to_utc(DateTime.new(params[:course]["expiry(1i)"].to_i,
                                                     params[:course]["expiry(2i)"].to_i,
                                                     params[:course]["expiry(3i)"].to_i,
                                                     params[:course]["expiry(4i)"].to_i,
                                                     params[:course]["expiry(5i)"].to_i))
    }
    
    if @course.errors.empty? and @course.save
      redirect_to courses_url, notice: 'Course was successfully created.'
    else
      render action: "new"
    end
  end

  # GET /courses/1/edit
  def edit
    @course = Course.find(params[:id])
  end

  # PUT /courses/1
  def update
    @course = Course.find(params[:id])
    @course.code = params[:course]["code"]
    @course.name = params[:course]["name"]
    @course.academic_year = params[:course]["academic_year"]
    @course.semester = params[:course]["semester"]
    @course.expiry = Time.zone.local_to_utc(DateTime.new(params[:course]["expiry(1i)"].to_i,
                                                         params[:course]["expiry(2i)"].to_i,
                                                         params[:course]["expiry(3i)"].to_i,
                                                         params[:course]["expiry(4i)"].to_i,
                                                         params[:course]["expiry(5i)"].to_i))
    
    if @course.errors.empty? and @course.save
      redirect_to courses_url, notice: 'Course was successfully updated.'
    else
      render action: "new"
    end
  end

  # DELETE /courses/1
  def destroy
    @course = Course.find(params[:id])
    @course.destroy

    redirect_to courses_url, notice: 'Course was successfully deleted.'
  end

  # GET /courses/1/cluster_students.json
  def cluster_students
    respond_to do |format|
      format.json { 
        render json: @course.cluster_students.collect { |s| 
          { id: s.id, id_string: s.id_string } 
        } 
      }
    end
  end
end
