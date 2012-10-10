class SubmissionClustersController < ApplicationController
  # GET /clusters/1.json
  def show
    @submission_cluster = SubmissionCluster.find(params[:id])
    @submission_cluster_id = @submission_cluster.id
    @assignment = @submission_cluster.submission_cluster_group.assignment
    @submissions = @submission_cluster.submissions
  end

  # GET /clusters/show_for_submission_ids.json
  def show_for_submission_ids
    @submission_cluster_id = params["ids"].join("_")
    @submissions = params["ids"].collect { |id|
      Submission.find(id)
    }
    @assignment = @submissions.first.assignment
    render "show"
  end

  # GET /clusters/ids_and_group_ids_for_student_ids.json
  def ids_and_group_ids_for_student_ids
    clusters = []
    if params["course_id"]
      @course = Course.find(params["course_id"])
      clusters = @course.submission_clusters
    elsif params["assignment_id"]
      @assignment = Assignment.find(params["assignment_id"])
      clusters = @assignment.submission_clusters
    end
    clusters = clusters.select { |c|
      c.submissions.any? { |s|
        params["student_ids"].include? s.student.id.to_s
      }
    }
    respond_to do |format|
      format.json { 
        render json: clusters.collect { |c| 
          { id: c.id, group_id: c.submission_cluster_group.id } 
        } 
      }
    end
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

  # GET /clusters/1/show_table_partial
  def show_table_partial
    @submission_cluster = SubmissionCluster.find(params[:id])
    render partial: "submission_cluster_table", locals: { cluster: @submission_cluster }
  end

  # GET /clusters/show_ranking_partial
  def show_ranking_partial
    clusters = params["clusterIds"].collect { |id|
      SubmissionCluster.find(id)
    }
    student_assignments = {}
    student_clusters = {}
    locals = {}
    locals[:num_assignments] = {}
    locals[:num_clusters] = {}
    locals[:students] = clusters.collect { |cluster| 
      cluster.submissions.collect { |submission|
        student_assignments[submission.student.id] ||= []
        student_clusters[submission.student.id] ||= []
        unless student_assignments[submission.student.id].include? submission.assignment
          student_assignments[submission.student.id] << submission.assignment
        end
        unless student_clusters[submission.student.id].include? cluster
          student_clusters[submission.student.id] << cluster
        end
        submission.student
      }
    }.flatten.uniq.sort_by { |student|
      1.0 / student_clusters[student.id].size
    }
    student_assignments.each_key { |k| locals[:num_assignments][k] = student_assignments[k].size }
    student_clusters.each_key { |k| locals[:num_clusters][k] = student_clusters[k].size }
    render partial: "submission_cluster_ranking", locals: locals
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
