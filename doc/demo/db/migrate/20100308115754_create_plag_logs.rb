class CreatePlagLogs < ActiveRecord::Migration
  def self.up
    create_table :plag_logs do |t|
      t.integer :student_id
      t.integer :account_id
      t.integer :assignment_code_id
      t.integer :assignment_sim_result_id
      
      # 0 = reported pair as plagirism, 1 = the pair is found innocent, 2 = the pair is confirmed as plagirism
      # 3 = confirmed student plagirism, 4 = the student is found innocent
      t.integer :log_type, :null => false
      t.timestamps
    end

    add_index :plag_logs, [:student_id]
    add_index :plag_logs, [:account_id]
    add_index :plag_logs, [:assignment_code_id]
    add_index :plag_logs, [:assignment_sim_result_id]
  end

  def self.down
    drop_table :plag_logs
  end
end
