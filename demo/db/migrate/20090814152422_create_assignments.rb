class CreateAssignments < ActiveRecord::Migration
  def self.up
    create_table :assignments do |t|
      t.string :title
      t.string :language
      t.integer :course_id, :null => false
      t.integer :status, :default => -1 # -1 = running, 0 = done, -2 = error
      t.timestamps
    end
    add_index :assignments, :course_id
  end
  
  def self.down
    drop_table :assignments
  end
end
