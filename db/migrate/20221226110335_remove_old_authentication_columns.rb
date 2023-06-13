class RemoveOldAuthenticationColumns < ActiveRecord::Migration[6.0]
  def change
    remove_column :users, :activation_digest
    remove_column :users, :activated
    remove_column :users, :activated_at
  end
end
