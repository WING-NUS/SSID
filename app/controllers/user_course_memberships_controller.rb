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

class UserCourseMembershipsController < ApplicationController
  # before action: either teaching staff or admin can add/ update/ remove 

  def show 
  end




  def new
    @course = Course.find_by_id(params[:course_id])
    @user_course_membership = UserCourseMembership.new
  end

  def create
    byebug
    # params[:user_course_membership][:user_email]
    @user = User.find_by_email(params[:user_course_membership][:user_email])

    @course = Course.find_by_id(params[:course_id])
    course_role = params[:user_course_membership][:course_role]
    @user_course_membership = UserCourseMembership.new { |ucm|
      ucm.course = @course
      ucm.user = @user
      ucm.role = course_role
    }

    if @user_course_membership.save 
      return redirect_to course_users_url, notice: "User was successfully added to the course."
    else
      return render action: "new"
    end
  end

  def edit
    @course = Course.find_by_id(params[:course_id])
    @user_course_membership = UserCourseMembership.find_by_id(params[:id])
  end

  def update
    @user_course_membership = UserCourseMembership.find_by_id(params[:id])  
    course_role = params[:user_course_membership][:course_role]
    @user_course_membership.role = course_role
    if @user_course_membership.save 
      return redirect_to course_users_url, notice: "User course role was successfully updated."
    else
      return render action: "edit"
    end      
  end

  def destroy
    byebug
    @user_course_membership = UserCourseMembership.find_by_id(params[:id])
    @user_course_membership.destroy

    # delete user if he is guest



    redirect_to course_users_url, notice: "User was successfully removed from the course."
  end
end
