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

# Filters added to this controller apply to all controllers in the application.
# Likewise, all the methods added will be available for all controllers.

class ApplicationController < ActionController::Base
  protect_from_forgery
  before_filter :authorize, :except => [:login, :logout]
  before_filter :sanitize_id, only: [:show, :edit, :create, :update, :destroy]
  helper :all # include all helpers, all the time
  protect_from_forgery # See ActionController::RequestForgeryProtection for details

  # Scrub sensitive parameters from your log
  # filter_parameter_logging :password

  protected
  #  Get the current controller and action name
  #  def set
  #    flash[:controller_name] = controller_name
  #    flash[:action_name] = action_name
  #  end

  def authorize
    @user_account = Account.find_by_login(session[:login])
    unless @user_account
      flash[:notice] = 'Please log in'
      redirect_to :controller => 'login', :action => 'login'
#   else
#     checkrole
    end
    
  end

  def checkrole
    case @user_account.role
    when 0 then redirect_to :controller => 'admins', :action => 'index' if controller_name != 'admins'
    when 1 then redirect_to :controller => 'users', :action => 'index' if controller_name != 'users'
    end
  end
  
  #  def checkrole
  #    unless @user_account.role == 0
  #    unless USER_ACCESSIBLE[controller_name] && USER_ACCESSIBLE[controller_name].rindex(action_name)
  #      flash[:notice] = 'Invalid access'
  #      redirect_to :controller => 'admins', :action => 'index'
  #    end
  #    end
  #  end
  #
  #  private
  #  MYNUM = 1
  #  USER_ACCESSIBLE = Hash[
  #    'announcements' => ['new', 'show', 'index'],
  #    'admins' => ['index']
  #  ]

  private

  def sanitize_id
    begin
      @obj = controller_name.classify.constantize.find_by_id(params[:id])
      unless @obj
        flash[:notice] = "Could not find any #{controller_name.classify.tableize.humanize.pluralize.titleize} with id #{params[:id]}"
        redirect_to controller: controller_name, action: "index"
      end
    rescue
      # controller_name did not correspond to any known models
    end
  end
end
