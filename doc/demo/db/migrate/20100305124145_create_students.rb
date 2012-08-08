class CreateStudents < ActiveRecord::Migration
  def self.up
    create_table :students do |t|
      t.string :matric
    end

    add_index :students, :matric, :unique => true
  end

  def self.down
    drop_table :students
  end
end
