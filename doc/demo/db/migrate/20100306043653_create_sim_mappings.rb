class CreateSimMappings < ActiveRecord::Migration
  def self.up
    create_table :sim_mappings do |t|
      t.integer :result_id
      t.integer :startIndex1
      t.integer :endIndex1
      t.integer :startIndex2
      t.integer :endIndex2
      t.integer :startLine1
      t.integer :endLine1
      t.integer :startLine2
      t.integer :endLine2
      t.integer :stmtMappedCount
      t.boolean :isPlagMapping
    end

    add_index :sim_mappings, :result_id
  end

  def self.down
    drop_table :sim_mappings
  end
end
