class AddFilesProcessToAssignments < ActiveRecord::Migration[6.0]
  def change
    add_column :assignments, :filesProcess, :string
  end
end
