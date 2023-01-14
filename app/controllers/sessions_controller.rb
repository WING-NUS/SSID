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

class SessionsController < ApplicationController
  skip_before_action :authenticate_user!, only: [:new, :create, :check_hash]

  def index
    render "layouts/cover"
  end

  def new
  end
  #orRgKyGUs7cz
  def create
    user = User.find_by_name(params[:name])

    if user and user.authenticate(params[:password]) and user.is_admin_approved
      if user.activated?
        session[:user_id] = user.id
        redirect_to root_url
      else
        redirect_to login_url, alert: "Your account is not activated. Please check your email for the activation link."
      end
    else
      redirect_to login_url, alert: "Invalid user/password combination or user account is still being processed."
    end
  end

  def check_hash
    # obtain the hash
    input_hash = params[:id]
    # verify the hash
    guest_user = GuestUsersDetail.find_by_hash_string(params[:id])
    # allow access if the hash is verified and else redirect to login page
    if guest_user
      session[:user_id] = guest_user.user_id
      redirect_to root_url
    else
      redirect_to login_url, alert: "The hash is not valid. Please use a valid sharable link or log in with your credientals."
    end
  end

  def destroy
    session[:user_id] = nil
    redirect_to cover_url
  end
end
