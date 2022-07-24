class AddAdminApproveToUsers < ActiveRecord::Migration[6.0]
  def change
    add_column :users, :is_admin_approved, :boolean, default: false

  end
end
