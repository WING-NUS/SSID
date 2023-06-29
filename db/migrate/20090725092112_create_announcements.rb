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

class CreateAnnouncements < ActiveRecord::Migration[6.0]
  def change
    create_table :announcements, :force => true do |t|
      t.string :title
      t.text :html_content, null: false
      t.integer :announceable_id, :null => false
      t.string :announceable_type, :null => false
      t.integer :announceable_category

      t.timestamps
    end
  end
end
