class AddEmailToUsers < ActiveRecord::Migration[6.0]
  def change
    # TODO: Ensure new user records will have email address for password reset service
    # add_column :users, :email, :string, { null: false }
    add_column :users, :email, :string
    add_index :users, :email
  end
end
