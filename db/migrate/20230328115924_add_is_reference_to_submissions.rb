class AddIsReferenceToSubmissions < ActiveRecord::Migration[6.0]
  def change
    add_column :submissions, :is_reference, :boolean, default: false    
  end
end
