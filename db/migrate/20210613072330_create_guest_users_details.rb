class CreateGuestUsersDetails < ActiveRecord::Migration[6.0]
  def change
    create_table :guest_users_details do |t|
      t.integer :user_id
      t.integer :course_id
      t.integer :assignment_id
      t.string :hash_string

      t.timestamps
    end

    
  end
end
