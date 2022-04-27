class AddFileStructureToAssignments < ActiveRecord::Migration[6.0]
  def change
    add_column :assignments, :fileStructure, :string
  end
end
