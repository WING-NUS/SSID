class CreateAssignmentClusterings < ActiveRecord::Migration
    def self.up
        create_table :assignment_clusterings do |t|
            t.integer :assignment_id
            t.string :remark
            t.decimal :coc, :precision => 6, :scale => 3

            t.timestamps
        end
        add_index :assignment_clusterings, [:assignment_id]
        add_index :assignment_clusterings, [:assignment_id, :coc], :unique => true
        add_index :assignment_clusterings, [:assignment_id, :remark]
    end

    def self.down
        drop_table :assignment_clusterings
    end
end
