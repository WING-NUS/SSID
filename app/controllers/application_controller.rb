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
  before_filter :sanitize_id, only: [:show, :edit, :update, :destroy]

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
