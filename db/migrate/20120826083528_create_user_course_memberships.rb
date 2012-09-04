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

class CreateUserCourseMemberships < ActiveRecord::Migration
  def change
    create_table :user_course_memberships do |t|
      t.integer :user_id, :null => false
      t.integer :course_id, :null => false
      t.integer :role, :null => false # See model for role constants

      t.timestamps
    end

    add_index :user_course_memberships, [:user_id, :course_id], :unique => true
  end
end
