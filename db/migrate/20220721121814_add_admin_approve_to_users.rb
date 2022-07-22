class AddAdminApproveToUsers < ActiveRecord::Migration[6.0]
  def change
    add_column :users, :admin_approved, :boolean, default: false

  end
end
