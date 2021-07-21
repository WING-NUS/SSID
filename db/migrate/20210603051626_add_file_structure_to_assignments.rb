class AddFileStructureToAssignments < ActiveRecord::Migration[6.0]
  def change
    add_column :assignments, :file_structure, :string
  end
end
