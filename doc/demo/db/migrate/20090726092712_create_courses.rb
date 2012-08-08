class CreateCourses < ActiveRecord::Migration
  def self.up
    create_table :courses, :force => true do |t|
      t.string  :code
      t.string  :name
      t.string  :academic_year
      t.integer :semester
      t.datetime  :expiry

      t.timestamps
    end

    add_index :courses, [:code, :academic_year, :semester], :unique => true
  end

  def self.down
    drop_table :courses
  end
end
