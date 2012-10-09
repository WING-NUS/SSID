class SubmissionClustersController < ApplicationController
  # GET /clusters/1.json
  def show
    @submission_cluster = SubmissionCluster.find(params[:id])
    @submission_cluster_id = @submission_cluster.id
    @assignment = @submission_cluster.submission_cluster_group.assignment
    @submissions = @submission_cluster.submissions
  end

  # Get /clusters/show_for_submission_ids.json
  def show_for_submission_ids
    @submission_cluster_id = params["ids"].join("_")
    @submissions = params["ids"].collect { |id|
      Submission.find(id)
    }
    @assignment = @submissions.first.assignment
    render "show"
  end

  # GET /clusters/1/show_graph_partial
  # GET /clusters/show_graph_partial
  def show_graph_partial
    if params[:id]
      @submission_cluster = SubmissionCluster.find(params[:id])
      render partial: "submission_cluster_graph", locals: { cluster_id: @submission_cluster.id, submission_student_ids: @submission_cluster.submission_student_ids }
    else
      render partial: "submission_cluster_graph"
    end
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
