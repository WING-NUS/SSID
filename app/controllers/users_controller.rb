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

class UsersController < ApplicationController
  skip_before_action :authorize, only: [:new, :create]
  before_action { |controller|
    if params[:course_id]
      @course = Course.find(params[:course_id])
      controller.send :authenticate_actions_for_role, UserCourseMembership::ROLE_STUDENT,
                                                      course: @course,
                                                      only: [ ]
      controller.send :authenticate_actions_for_role, UserCourseMembership::ROLE_GUEST,
                                                      course: @course,
                                                      only: [ ]
    end
  }

  # GET /signup
  def new
    @user = User.new
  end

  def create
    @user = User.new(user_params)
    if @user.save
      UserMailer.account_activation(@user).deliver_now
      flash[:notice] = "Please check your email to activate your account."
      redirect_to root_url
    else
      render 'new'
    end
  end



    

  # GET /courses/1/users
  def index
    @course = Course.find(params[:course_id])
    @users = @course.users
    @staff = @course.staff
    @teaching_assistants = @course.teaching_assistants
    @students = @course.students
    @guests = @course.guests
  end

  # GET /users/1/edit
  def edit
    @user = User.find(params[:id])
  end

  # PUT /users/1
  def update
    @user = User.find(params[:id])

    # Check for new password unless admin and do not wish to change password
    unless @user.is_admin and params[:user]["new_password"].strip.empty?
      UsersHelper.validate_password(@user, params[:user]["new_password"], params[:user]["confirm_new_password"])
    end

    # Check for old password
    unless @user.is_admin
      @user.errors.add :old_password, "is incorrect" unless @user.authenticate(params[:user]["old_password"])
      @user.errors.add :new_password, "must be different from the old password" if params[:user]["new_password"] == params[:user]["old_password"] 
    end

    # Check for email
    UsersHelper.validate_email(@user, params[:user]["email"])

    # Update user
    unless @user.is_admin and params[:user]["new_password"].strip.empty?
      @user.password_digest = BCrypt::Password.create(params[:user]["new_password"]) if @user.errors.empty?
    end
    if @user.is_admin
      @user.full_name = params[:user]["full_name"]
      @user.name = params[:user]["name"]
    end
      
    if @user.errors.empty? and @user.save
      redirect_to edit_user_url(@user), notice: 'User settings were successfully updated.'
    else
      render action: "edit"
    end
  end

  private
  def user_params
    params.require(:user).permit(:name, :email, :password, :password_confirmation, :full_name)
  end
end
