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
  # GET /assignments
  def index
    @course = Course.find(params[:course_id])
    @assignments = @course.assignments
  end

  # GET /assignments/1
  def show
    @assignment = Assignment.find(params[:id])
  end

  # GET /assignments/new
  def new
    @course = Course.find(params[:course_id])
    @assignment = Assignment.new
  end

  # GET /assignments/1/edit
  def edit
    @assignment = Assignment.find(params[:id])
  end

  # POST /assignments
  def create
    @assignment = Assignment.new(params[:assignment])

    if @assignment.save
      format.html { redirect_to @assignment, notice: 'Assignment was successfully created.' }
    else
      format.html { render action: "new" }
    end
  end

  # PUT /assignments/1
  def update
    @assignment = Assignment.find(params[:id])

    if @assignment.update_attributes(params[:assignment])
      format.html { redirect_to @assignment, notice: 'Assignment was successfully updated.' }
    else
      format.html { render action: "edit" }
    end
  end

  # DELETE /assignments/1
  def destroy
    @assignment = Assignment.find(params[:id])
    @assignment.destroy
  
    redirect_to assignments_url
  end
end
