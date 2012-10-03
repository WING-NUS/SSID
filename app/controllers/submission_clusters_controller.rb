class SubmissionClustersController < ApplicationController
  # GET /cluster_groups/1/cluster/1.json
  def show
    @submission_cluster = SubmissionCluster.find(params[:id])
    @assignment = @submission_cluster.submission_cluster_group.assignment
    @submissions = @submission_cluster.submissions
  end

  # GET /cluster_groups/1/clusters
  def index
    @submission_cluster_group = SubmissionClusterGroup.find(params[:cluster_group_id])
    @assignment = @submission_cluster_group.assignment
    @course = @assignment.course
    @submission_clusters = @submission_cluster_group.clusters.sort_by { |sc|
      1.0 / sc.submissions.size
    }
  end
end
