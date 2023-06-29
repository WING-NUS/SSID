class CreatePasswordResets < ActiveRecord::Migration[6.0]
  def change
    create_table :password_resets do |t|
      t.integer :user_id, null: false
      t.string :token, null: false

      t.timestamps
    end

    add_index :password_resets, :user_id
    add_index :password_resets, :token
  end
end
