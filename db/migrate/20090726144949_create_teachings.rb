class CreateTeachings < ActiveRecord::Migration
  def self.up
    #create a table without an incrementing id
    create_table :teachings, :force => true do |t|
      t.integer :account_id, :null => false
      t.integer :course_id, :null => false
      t.integer  :role, :null => false

      t.timestamps
    end

    add_index :teachings, [:account_id, :course_id], :unique => true
  end

  def self.down
    drop_table :teachings
  end
end