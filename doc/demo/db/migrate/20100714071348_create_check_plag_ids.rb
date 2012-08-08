class CreateCheckPlagIds < ActiveRecord::Migration
  def self.up
    create_table :check_plag_ids do |t|
      t.integer :assignment_id
      t.integer :pid
    end

    add_index :check_plag_ids, [:assignment_id]
  end

  def self.down
    drop_table :check_plag_ids
  end
end
