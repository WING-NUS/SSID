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

class AdminsController < ApplicationController
  #Verify the user is an administrator
  #before_filter :check_role

  def index
    flash[:notice] = flash[:notice]
    redirect_to :action => 'announcement_index'
  end

  def announcement_index
    #@announcements = Announcement.all(:order => "updated_at DESC", :conditions => 'updated_at >= \'' + Time.now.strftime("%Y-%m-%d %H:%M:%S") + '\'')
    @announcements = Announcement.all(:order => "updated_at DESC")
  end
  def announcement_show
    @announcement = Announcement.find(params[:id])
    respond_to do |format|
      format.html # show.html.erb
    end
  rescue
    flash[:notice] = 'Announcement not found'
    redirect_to :action => 'announcement_index'
  end
  def announcement_new
    @announcement = Announcement.new
  end
  def announcement_create
    params[:announcement][:account_id] = Account.find_by_login(session[:login]).id

    @announcement = Announcement.new(params[:announcement])

    #format may refer to the respond page type (show, indoex...)
    respond_to do |format|
      if @announcement.save
        flash[:notice] = 'Announcement was successfully created.'
        format.html { redirect_to(:action => 'announcement_index') }
      else
        format.html { render :action => "announcement_new" }
      end
    end
  end
  def announcement_edit
    @announcement = Announcement.find(params[:id])
  end
  def announcement_update
    @announcement = Announcement.find(params[:id])

    respond_to do |format|
      if @announcement.update_attributes(params[:announcement])
        flash[:notice] = 'Announcement was successfully updated.'
        format.html { redirect_to( :action => 'announcement_index' ) }
      else
        format.html { render :action => 'announcement_edit' }
      end
    end
  end
  def announcement_delete
    @announcement = Announcement.find(params[:id])
    @announcement.destroy

    respond_to do |format|
      format.html { redirect_to( :action => 'announcement_index' ) }
    end
  end

  def account_index
    @accounts = Account.all
  end
  def account_show
    @account = Account.find(params[:id])
    respond_to do |format|
      format.html
    end
  rescue
    flash[:notice] = 'Account not found'
    redirect_to :action => 'account_index'
  end
  def account_new
    @account = Account.new
  end
  def account_create
    params[:account][:matric] = params[:account][:matric].upcase
    @account = Account.new(params[:account])

    #format may refer to the respond page type (show, indoex...)
    respond_to do |format|
      if @account.save
        flash[:notice] = 'Account was successfully created.'
        format.html { redirect_to(:action => 'account_index') }
      else
        format.html { render :action => "account_new" }
      end
    end
  end
  def account_edit
    @account = Account.find(params[:id])
  end
  def account_update
    params[:account][:matric] = params[:account][:matric].upcase
    @account = Account.find(params[:id])

    respond_to do |format|
      if @account.update_attributes(params[:account])
        flash[:notice] = 'Account was successfully updated.'
        format.html { redirect_to( :action => 'account_index' ) }
      else
        format.html { render :action => 'account_edit' }
      end
    end
  end
  def account_delete
    @account = Account.find(params[:id])
    @account.destroy

    respond_to do |format|
      format.html { redirect_to( :action => 'account_index' ) }
    end
  end

  def module_index
    @module = Course.all
  end
  def module_show
    @module = Course.find(params[:id])
    respond_to do |format|
      format.html
    end
  rescue
    flash[:notice] = 'Module not found'
    redirect_to :action => 'module_index'
  end
  def module_new
    @module = Course.new
    #role = 1 (User)
    @accounts = Account.find(:all, :conditions => [ "role = 1" ])
  end
  def module_create
    #params['Class Name']['Attribute']
    @module = Course.new(params[:course])

    #format may refer to the respond page type (show, indoex...)
    respond_to do |format|
      if @module.save

        #Add staffs to the module
        teaching = @module.teachings
        params[:associated_account].each do | account_id, result |
          if result == "1"
            role = params[:associated_account_role]
            teaching.create(:role => role[account_id], :account_id => account_id)
          end
        end
        
        flash[:notice] = 'Module was successfully created.'
        format.html { redirect_to(:action => 'module_index') }
      else
        format.html { render :action => "module_new" }
      end
    end
  end
  def module_edit
    @module = Course.find(params[:id])
    @accounts = Account.find(:all, :conditions => [ "role = 1" ])
  end
  def module_update

    #params[:course][:code] = params[:course][:code].upcase
    @module = Course.find(params[:id])

    respond_to do |format|
      if @module.update_attributes(params[:course])

        #Remove all teaching staffs
        Teaching.delete_all("course_id = " + @module.id.to_s)

        #Add in teaching staffs with role
        teaching = @module.teachings
        #@module.teachings.delete(object)
        
        params[:associated_account].each do | account_id, result |
          if result == "1" && role = params[:associated_account_role]
            teaching.create(:role => role[account_id], :account_id => account_id)
          end
        end


        flash[:notice] = 'Module was successfully updated.'
        format.html { redirect_to( :action => 'module_index' ) }
      else
        format.html { render :action => 'module_edit' }
      end
    end
  end
  def module_delete
    @module = Course.find(params[:id])
    @module.destroy

    respond_to do |format|
      format.html { redirect_to( :action => 'module_index' ) }
    end
  end
end
