class AddLastLoginTimeToUsers < ActiveRecord::Migration[6.0]
  def change
    add_column :users, :last_login_time, :datetime, :null => false, default: Time.now
  end
end
