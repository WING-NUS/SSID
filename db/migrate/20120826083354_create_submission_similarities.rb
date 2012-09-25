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

class CreateSubmissionSimilarities < ActiveRecord::Migration
  def change
    create_table :submission_similarities do |t|
      t.integer :assignment_id, null: false
      t.integer :submission1_id, null: false
      t.integer :submission2_id, null: false
      t.decimal :similarity_1_to_2, precision: 5, scale: 3
      t.decimal :similarity_2_to_1, precision: 5, scale: 3
      t.decimal :similarity, precision: 5, scale: 3
      t.integer :status, null: false, default: 0 # See model for status constants

      t.timestamps
    end

    add_index :submission_similarities, [:assignment_id, :submission1_id, :submission2_id], name: "on_assignment_id_and_submission1_id_and_submission2_id"
    add_index :submission_similarities, [:assignment_id, :similarity], name: "on_assignment_id_and_similarity"
    add_index :submission_similarities, [:assignment_id, :similarity_1_to_2], name: "on_assignment_id_and_similarity_1_to_2"
    add_index :submission_similarities, [:assignment_id, :similarity_2_to_1], name: "on_assignment_id_and_similarity_2_to_1"
    add_index :submission_similarities, [:assignment_id, :similarity_1_to_2, :similarity_2_to_1], name: "on_assignment_id_and_similarity_1_to_2_and_similarity_2_to_1"
    add_index :submission_similarities, :assignment_id
    add_index :submission_similarities, [:assignment_id, :status]
  end
end
