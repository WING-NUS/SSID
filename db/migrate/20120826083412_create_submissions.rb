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

class CreateSubmissions < ActiveRecord::Migration
  def change
    create_table :submissions do |t|
      t.text    :lines, limit: 4294967295
      t.integer :assignment_id, null: false
      t.integer :student_id, null: false
      t.boolean :is_plagiarism, default: false, null: false

      t.timestamps
    end

    add_index :submissions, :student_id
    add_index :submissions, [:student_id, :is_plagiarism]
  end
end
