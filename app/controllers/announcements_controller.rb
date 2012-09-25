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
  # GET /announcements
  def index
    @announcements = Announcement.order("updated_at DESC")
  end

  # GET /announcements/1
  def show
    @announcement = Announcement.find(params[:id])
  end

  # GET /announcements/new
  def new
    @announcement = Announcement.new
  end

  # GET /announcements/1/edit
  def edit
    @announcement = Announcement.find(params[:id])
  end

  # POST /announcements
  def create
    @announcement = Announcement.new(params[:announcement])

    if @announcement.save
      format.html { redirect_to @announcement, notice: 'Announcement was successfully created.' }
    else
      format.html { render action: "new" }
    end
  end

  # PUT /announcements/1
  def update
    @announcement = Announcement.find(params[:id])

    if @announcement.update_attributes(params[:announcement])
      format.html { redirect_to @announcement, notice: 'Announcement was successfully updated.' }
    else
      format.html { render action: "edit" }
    end
  end

  # DELETE /announcements/1
  def destroy
    @announcement = Announcement.find(params[:id])
    @announcement.destroy
  
    redirect_to announcements_url
  end
end
