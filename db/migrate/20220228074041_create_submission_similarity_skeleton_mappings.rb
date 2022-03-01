class CreateSubmissionSimilaritySkeletonMappings < ActiveRecord::Migration[6.0]
  def change
    create_table :submission_similarity_skeleton_mappings do |t|
      t.bigint :submission_similarity_mapping_id
      t.integer :start_line1
      t.integer :end_line1
      t.integer :start_line2
      t.integer :end_line2

      t.timestamps
    end

    add_index :submission_similarity_skeleton_mappings, :submission_similarity_mapping_id, name: "on_submission_similarity_mapping_id"
  end
end
