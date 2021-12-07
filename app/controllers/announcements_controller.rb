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

class AnnouncementsController < ApplicationController
  before_action { |controller|
    if params[:announcement] and params[:announcement]["course_id"]
      @course = Course.find(params[:announcement]["course_id"])
      controller.send :authenticate_actions_for_role, UserCourseMembership::ROLE_TEACHING_ASSISTANT,
                                                      course: @course,
                                                      only: [ :index ]
      controller.send :authenticate_actions_for_role, UserCourseMembership::ROLE_STUDENT,
                                                      course: @course,
                                                      only: [ :index ]
    end
  }

  # GET /announcements
  def index
    @announcements = @user.courses.collect { |c| c.announcements }.flatten
  end

  # GET /announcements/new
  def new
    @announcement = Announcement.new
    @announceable_courses = @user.courses.select { |course|
      course.membership_for_user(@user).role == UserCourseMembership::ROLE_TEACHING_STAFF
    }
  end

  # POST /announcements
  def create
    # Fill in parameters
    @announcement = Announcement.new { |a|
      a.title = params[:announcement]["title"]
      a.html_content = params[:announcement]["html_content"]
    }

    # Find course
    course = nil
    if params[:announcement] and params[:announcement]["course_id"]
      course = Course.find(params[:announcement]["course_id"])
    end

    # Check permissions
    @announceable_courses = @user.courses.select { |course|
      course.membership_for_user(@user).role == UserCourseMembership::ROLE_TEACHING_STAFF
    }
    if course and @announceable_courses.include? course
      @announcement.announceable = course
    else
      @announcement.errors.add :course_id, "must be selected from the available options"
    end

    if @announcement.errors.empty? and @announcement.save
      redirect_to announcements_url, notice: 'Announcement was successfully created.'
    else
      render action: "new"
    end
  end

  # GET /announcements/1/edit
  def edit
    @announcement = Announcement.find(params[:id])
    @announceable_courses = @user.courses.select { |course|
      course.membership_for_user(@user).role == UserCourseMembership::ROLE_TEACHING_STAFF
    }
  end

  # PUT /announcements/1
  def update
    # Find announcement
    @announcement = Announcement.find(params[:id])

    # Update
    @announcement.title = params[:announcement]["title"]
    @announcement.html_content = params[:announcement]["html_content"]

    # Find course
    course = nil
    if params[:announcement] and params[:announcement]["course_id"]
      course = Course.find(params[:announcement]["course_id"])
    end

    # Check permissions
    @announceable_courses = @user.courses.select { |course|
      course.membership_for_user(@user).role == UserCourseMembership::ROLE_TEACHING_STAFF
    }
    if course and @announceable_courses.include? course
      @announcement.announceable = course
    else
      @announcement.errors.add :course_id, "must be selected from the available options"
    end
  
    # Check content
    if @announcement.html_content.nil? or @announcement.html_content.empty? 
      @announcement.errors.add :html_content, "must be not blank"
    end

    if @announcement.errors.empty? and @announcement.save
      redirect_to announcements_url, notice: 'Announcement was successfully updated.'
    else
      render action: "edit"
    end
  end

  # DELETE /announcements/1
  def destroy
    @announcement = Announcement.find(params[:id])
    @announcement.destroy

    redirect_to announcements_url, notice: 'Announcement was successfully deleted.'
  end
end
