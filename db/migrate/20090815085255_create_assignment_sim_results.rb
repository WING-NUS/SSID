class CreateAssignmentSimResults < ActiveRecord::Migration
  def self.up
    create_table :assignment_sim_results do |t|
      t.integer :assignment_id
      t.integer :id1
      t.integer :id2
      t.decimal :sim1To2, :precision => 5, :scale => 3
      t.decimal :sim2To1, :precision => 5, :scale => 3
      t.decimal :sim, :precision => 5, :scale => 3

      # 0 = not plagiarism, 1 = innocent, 2 = confirmed, 3 = flagged (Reason: ORDER BY easier) - View Flagged cases more important than admitted case
      t.integer :status, :null => false, :default => 0

      t.timestamps
    end

    add_index :assignment_sim_results, [:assignment_id, :id1, :id2]
    add_index :assignment_sim_results, [:assignment_id, :sim]
    add_index :assignment_sim_results, [:assignment_id, :sim1To2]
    add_index :assignment_sim_results, [:assignment_id, :sim2To1]
    add_index :assignment_sim_results, [:assignment_id, :sim1To2, :sim2To1], :name => "index_aId_sims"
    add_index :assignment_sim_results, [:assignment_id]
    add_index :assignment_sim_results, [:assignment_id, :status], :name => "index_a_status"

  end

  def self.down
    drop_table :assignment_sim_results
  end
end
