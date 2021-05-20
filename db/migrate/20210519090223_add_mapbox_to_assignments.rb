class AddMapboxToAssignments < ActiveRecord::Migration[6.0]
  def change
    add_column :assignments, :mapbox, :boolean, default: false
  end
end
