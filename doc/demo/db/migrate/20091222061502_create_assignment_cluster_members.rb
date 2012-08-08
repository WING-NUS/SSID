class CreateAssignmentClusterMembers < ActiveRecord::Migration
    def self.up
        create_table :assignment_cluster_members, :force => true do |t|
            t.integer :assignment_cluster_id, :null => false
            t.integer :assignment_code_id, :null => false

            t.timestamps
        end
        add_index :assignment_cluster_members, [:assignment_cluster_id, :assignment_code_id], :unique => true, :name => 'members'
    end

    def self.down
        drop_table :assignment_cluster_members
    end
end
