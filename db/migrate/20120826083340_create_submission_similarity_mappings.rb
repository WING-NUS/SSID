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

class CreateSubmissionSimilarityMappings < ActiveRecord::Migration
  def change
    create_table :submission_similarity_mappings do |t|
      t.integer :submission_similarity_id, null: false
      t.integer :start_index1
      t.integer :end_index1
      t.integer :start_index2
      t.integer :end_index2
      t.integer :start_line1
      t.integer :end_line1
      t.integer :start_line2
      t.integer :end_line2
      t.integer :statement_count
      t.boolean :is_plagiarism, null: false, default: false

      t.timestamps
    end

    add_index :submission_similarity_mappings, :submission_similarity_id
  end
end
