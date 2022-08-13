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

class ApplicationController < ActionController::Base
    protect_from_forgery
    before_action :authorize
    before_action :sanitize_id, only: [:index, :show, :edit, :update, :destroy]
  
    protected
  
    def authorize
      # get user and respective membership
      @user = User.find_by_id(session[:user_id]) 

      unless @user
        # redirect_to login_url, notice: "Please log in"       
        redirect_to cover_url
        
      else
        @membership = UserCourseMembership.find_by_user_id(@user.id)
      end
    end
  
    private
  
    def sanitize_id
      begin
        # Since we have nested controllers, we need to check for every "_id" params
        params.each { |key, value|
          next unless key.to_s.match(/_id$/)
          controller_for_key = key.to_s.scan(/^(.+)_id$/).first.first
          @obj = controller_for_key.classify.constantize.find_by_id(value)
          unless @obj
            message = "Could not find any #{controller_for_key.classify.tableize.humanize.pluralize.titleize} with id #{value}"
            if action_name != "index"
              redirect_to({ controller: controller_name, action: "index" }, alert: message)
            else
              redirect_to({ controller: "announcements", action: "index" }, alert: message)
            end
          end
        }
      rescue
        # controller_name did not correspond to any known models
      end
    end
  
    # This method should be called by each controller for every role in UserCourseMembership to whitelist
    # actions allowed for each role. The method delegates how to find the course object to the controller
    # Example usage:
    #
    # before_action { |controller|
    #   @course = get_course_from_params
    #   if params[:course_id]
    #     controller.send :authenticate_actions_for_role, UserCourseMembership::ROLE_TEACHING_STAFF,
    #                                                     course: @course,
    #                                                     only: [ :edit ]
    #   end
    # }

    def authenticate_actions_for_role(role, opts={})
      return if @user.is_admin
  
      # Sanitize
      raise unless opts[:course]
      raise unless opts[:only]
  
      # Get course
      course = opts[:course]
  
      # Get current user's role
      membership = course.membership_for_user(@user)
      
      # Check if we need to authenticate
      if membership.nil? or (membership and membership.role == role and !opts[:only].include? action_name.intern)
        redirect_to( { controller: "announcements", action: "index" }, alert: "You do not have access to the url \"#{request.env['REQUEST_URI']}\". Please contact the administrator for more information.")
        return
      end
    end

    def authenticate_custom_actions_for_teaching_staff(opts)
      return if @user.is_admin

      # Sanitize
      raise unless opts[:only]

      unless @user.is_staff_or_ta? and opts[:only].include? action_name.intern
        redirect_to( { controller: "announcements", action: "index" }, alert: "You do not have access to the url \"#{request.env['REQUEST_URI']}\". Please contact the administrator for more information.")
        return
      end
    end
  
    def authenticate_actions_for_admin(opts)
      raise unless opts[:only]
  
      # Check if we need to authenticate
      unless @user.is_admin
        if opts[:only].include? action_name.intern
          redirect_to( { controller: "announcements", action: "index" }, alert: "You do not have access to the url \"#{request.env['REQUEST_URI']}\". Please contact the administrator for more information.")
        end
      end
    end

    def authenticate_actions_for_admin_or_teaching_staff(opts)
      # Sanitize
      raise unless opts[:only]
  
      user_current_role = nil

      # Get course
      if (opts[:course] != nil && !@user.is_admin)
        course = opts[:course]
        # check current user role (if any)
        user_current_role = course.membership_for_user(@user).role
      end
     
      # Check if we need to authenticate
      unless @user.is_admin or user_current_role == UserCourseMembership::ROLE_TEACHING_STAFF
        if opts[:only].include? action_name.intern
          redirect_to( { controller: "announcements", action: "index" }, alert: "You do not have access to the url \"#{request.env['REQUEST_URI']}\". Please contact the administrator for more information.")
        end
      end
    end
  end