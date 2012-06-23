class CreateAssignmentCodes < ActiveRecord::Migration
    def self.up
        create_table :assignment_codes do |t|
            t.integer :code_line
            t.text :code_array, :limit => 4294967295
            t.integer :student_id
            t.boolean :plagiarism, :default => false, :null => false
            t.timestamps
        end
        add_index :assignment_codes, :student_id
        add_index :assignment_codes, [:student_id, :plagiarism]
    end

    def self.down
        drop_table :assignment_codes
    end
end
