class CreateAssignmentClusters < ActiveRecord::Migration
    def self.up
        create_table :assignment_clusters do |t|
            t.integer :assignment_clustering_id
            
            t.timestamps
        end
        add_index :assignment_clusters, [:assignment_clustering_id]
    end

    def self.down
        drop_table :assignment_clusters
    end
end
