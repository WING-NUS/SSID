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

class LoginController < ApplicationController

  def login
    if request.post?
      acc = Account.authenticate(params[:login], params[:password])
      if acc
        session[:login] = acc.login
        session[:username] = acc.name
        redirect(acc.role)
      else
        flash.now[:notice] = "Invalid id/password combination"
      end
    elsif session[:login] && session[:login].length > 0
      acc = Account.find_by_login(session[:login])
      if acc
        redirect(acc.role)
      end
    end
  end

  def logout
    session[:login] = nil
    session[:username] = nil
    redirect_to :controller => 'login', :action => 'login'
  end

  private
  def redirect(type)
    case type
    when 0 then redirect_to :controller => 'admins', :action => 'index'
    when 1 then redirect_to :controller => 'users', :action => 'index'
    end
  end
end
