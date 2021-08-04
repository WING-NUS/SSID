class AddFilesIgnoreToAssignments < ActiveRecord::Migration[6.0]
  def change
    add_column :assignments, :filesIgnore, :string
  end
end
