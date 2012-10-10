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

class CreateSubmissionLogs < ActiveRecord::Migration
  def change
    create_table :submission_logs do |t|
      t.integer :submission_id, null: false
      t.integer :submission_similarity_id, null: false
      t.integer :marker_id, null: false
      t.integer :log_type, null: false # See model for type constants

      t.timestamps
    end

    add_index :submission_logs, :marker_id
    add_index :submission_logs, :submission_id
    add_index :submission_logs, :submission_similarity_id
  end
end
