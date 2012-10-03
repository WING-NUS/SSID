class AddUploadLogToAssignments < ActiveRecord::Migration
  def change
    add_column :assignments, :upload_log, :text
  end
end
