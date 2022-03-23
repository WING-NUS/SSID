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

    # users don't belong to any course
    @loners = User.all - User.joins(:memberships) - @admins
  end

  # GET /admin/users/new
  # GET /admin/users/new?course_id=1
  def new
    @the_user = User.new
    @course = nil
    if params[:course_id]
      @course = Course.find(params[:course_id])
    end
  end

  # POST /admin/users/
  def create
    @the_user = User.new
    @course = nil

    # Check if we have a course_id
    if params[:user]["course_id"]
      @course = Course.find(params[:user]["course_id"])  
      @the_user.errors.add :base, "Course could not be found." unless @course
    end

    # Construct basic attributes for course user or for admin user
    if !@course.nil?
      # Check if user exists
      @existing_user = User.where(id_string: params[:user]["id_string"]).first
      if @existing_user
        @the_user = @existing_user
      else
        @the_user.full_name = params[:user]["full_name"]
        @the_user.id_string = params[:user]["id_string"]
        @the_user.name = params[:user]["name"]
      end
    else
      @the_user.is_admin = true
      @the_user.full_name = params[:user]["full_name"]
      @the_user.name = params[:user]["name"]
      @the_user.id_string = params[:user]["name"]
    end

    # Validate password unless its an existing user
    unless @existing_user
      @the_user.errors.add :password, "cannot be blank" if params[:user]["password"].empty?
      @the_user.errors.add :password, "must be at least #{User::MIN_PASSWORD_LENGTH} characters long" if params[:user]["password"].length < User::MIN_PASSWORD_LENGTH
      @the_user.errors.add :confirm_password, "does not match password" if params[:user]["password"] != params[:user]["confirm_password"]

      # Set password
      @the_user.password_digest = BCrypt::Password.create(params[:user]["password"]) if @the_user.errors.empty?
    end

    # Before we can add membership, we need to save the user first, so we use a transaction
    if @the_user.errors.empty?
      @the_user.transaction do
        # Add membership if @course
        if @the_user.save and @course
          membership = UserCourseMembership.new { |m|
            m.role = params[:user]["course_role"]
            m.user = @the_user
            m.course = @course
          }
          raise ActiveRecord::Rollback unless membership.save
          
          # if user is guest, create a entry under guest database as well
          if params[:user]["course_role"] == GUEST_USER_ROLE_ID 
            guest = GuestUsersDetail.new { |g|
              g.user_id = @the_user.id
              g.course_id = @course.id
              g.hash_string = params[:user]["id_string"]
              g.assignment_id = 0
            }
            raise ActiveRecord::Rollback unless guest.save
          end
        end
      end
    end

    @user = User.find_by_id(session[:user_id]) 

    # Check for errors and render view
    if @the_user.errors.empty? and @the_user.save
      if @existing_user or not @course.nil?
        redirect_to course_users_url(@course), notice: "User was successfully added 
        to #{@course.code}."
      else 
        redirect_to admin_users_url, notice: 'User was successfully created.'
      end
    else
      render action: "new"
    end
    
  end

  # GET /admin/users/1/edit
  # GET /admin/users/1/edit?course_id=1
  def edit
    @the_user = User.find(params[:id])
    @course = nil
    @membership = nil
    if params[:course_id]
      @course = Course.find(params[:course_id])
      @membership = @course.membership_for_user(@the_user)
    end
  end

  # PUT /admin/users/1
  def update
    @the_user = User.find(params[:id])
    @membership = nil
    @course = nil

    # Check if we have a course_id
    if params[:user]["course_id"]
      @course = Course.find(params[:user]["course_id"])  
      @the_user.errors.add :base, "Course could not be found." unless @course
    end

    # Update basic attributes for course user or for admin user
    if @course
      @the_user.full_name = params[:user]["full_name"]
      @the_user.id_string = params[:user]["id_string"]
      @the_user.name = params[:user]["name"]

      # Update role unless student
      @membership = @course.membership_for_user(@the_user)
      unless @membership.role == UserCourseMembership::ROLE_STUDENT
        @membership.role = params[:user]["course_role"]
      end
    else
      @the_user.full_name = params[:user]["full_name"]
      @the_user.name = params[:user]["name"]
    end

    # Validate password unless blank
    unless params[:user]["new_password"].blank?
      @the_user.errors.add :new_password, "must be at least #{User::MIN_PASSWORD_LENGTH} characters long" if params[:user]["new_password"].length < User::MIN_PASSWORD_LENGTH
      @the_user.errors.add :confirm_new_password, "does not match password" if params[:user]["new_password"] != params[:user]["confirm_new_password"]

      # Set password
      @the_user.password_digest = BCrypt::Password.create(params[:user]["new_password"]) if @the_user.errors.empty?
    end

    # Save in transaction
    @the_user.transaction do
      raise ActiveRecord::Rollback unless @the_user.save
      if @membership and not @membership.save
        @the_user.errors.add :base, @membership.errors.to_a.join(", ")
        raise ActiveRecord::Rollback
      end
    end

    # Check for errors and render view
    if @the_user.errors.empty?
      if @course
        redirect_to admin_users_url, notice: "#{@course.code} User was successfully updated."
      else
        redirect_to admin_users_url, notice: "Admin User was successfully updated."
      end
    else
      render action: "new"
    end
  end

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
      
      # redirect link accordingly depending on whether user is admin or teaching staff
      @user = User.find_by_id(session[:user_id]) 
      url = admin_users_url
      if (!@user.is_admin)
        url = course_users_url(course)
      end
      
      if membership && membership.role == UserCourseMembership::ROLE_GUEST && guest.destroy && membership.destroy 
        redirect_to url, notice: "User was removed from #{course.code}."
      elsif membership && membership.role != UserCourseMembership::ROLE_STUDENT && membership.destroy
        redirect_to url, notice: "User was removed from #{course.code}."
      else
        redirect_to url, alert: "Error removing user"
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
