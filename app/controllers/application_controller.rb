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
  before_filter :authorize
  before_filter :sanitize_id, only: [:index, :show, :edit, :update, :destroy]

  protected

  def authorize
    @user = User.find_by_id(session[:user_id]) 
    unless @user
      redirect_to login_url, notice: "Please log in"
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
end
