class RemoveIdStringToUsers < ActiveRecord::Migration[6.0]
  def change
    remove_column :users, :id_string
  end
end
