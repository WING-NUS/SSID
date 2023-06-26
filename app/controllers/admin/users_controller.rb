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

class Admin::UsersController < ApplicationController
  
  GUEST_USER_ROLE_ID = '3'
  
  before_action { |controller|
    
  # obtain course (if any) to determine whether the user has any course membership
    begin
      @course = Course.find(params[:course_id])
    rescue ActiveRecord::RecordNotFound
        @course = Course.find(params[:user]["course_id"]) rescue nil
    end
   
    controller.send :authenticate_actions_for_admin_or_teaching_staff,
                    course: @course, 
                    only: [ :index, :new, :create, :edit, :update, :destroy ] # all methods
  }

  # GET /admin/users
  def index
    @admins = User.where(is_admin: true)

    @signups = User.where(is_admin_approved: false)

    # users don't belong to any course
    @loners = User.all - User.joins(:memberships) - @admins - @signups

    
  end

  def approve
    @the_user = User.find(params[:user_id])
    @the_user.update_attribute(:is_admin_approved, true)
    @the_user.save
    UserMailer.admin_approved(@the_user).deliver_now
    redirect_to admin_users_url, notice: 'User was successfully approved.'
  end

  # TODO: refactor later
  # DELETE /admin/users/1
  # DELETE /admin/users/1?course_id=1
  def destroy
    @the_user = User.find(params[:id])

    # Check if we are destroying the membeship, not the user
    if params[:course_id]
      course = Course.find(params[:course_id])
      
      # see whether the user to be deleted is a guest user
      membership = course.membership_for_user(@the_user)
      guest = course.guest_user_finder(@the_user)
      
      # Redirect current user back to the course users page
      url = course_users_url(course)
      
      if membership && membership.role == UserCourseMembership::ROLE_GUEST && guest.destroy && membership.destroy 
        redirect_to url, notice: "User was removed from #{course.code}."
      elsif membership && membership.role != UserCourseMembership::ROLE_STUDENT && membership.destroy
        redirect_to url, notice: "User was removed from #{course.code}."
      else
        redirect_to url, alert: "Error removing user"
      end
    else
      if @the_user.is_admin
        if @the_user.destroy
          redirect_to admin_users_url, notice: 'User was successfully deleted.'
        else
          redirect_to admin_users_url, alert: @the_user.errors.to_a.join(", ")
        end
      else
        if @the_user.destroy
          redirect_to admin_users_url, notice: 'User was successfully deleted.'
        else
          redirect_to admin_users_url, alert: @the_user.errors.to_a.join(", ")
        end
      end
    end
  end
end
