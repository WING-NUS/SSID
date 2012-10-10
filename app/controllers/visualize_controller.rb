class VisualizeController < ApplicationController
  before_filter :find_course

  # GET /courses/1/visualize
  def index
  end

  # GET /courses/1/visualize/similarity_cluster_graph
  def similarity_cluster_graph
  end

  # GET /courses/1/visualize/similarity_cluster_table
  def similarity_cluster_table
    @clusters = SubmissionCluster.all
  end

  # GET /courses/1/visualize/top_similar_submissions
  def top_similar_submissions
  end

  private

  def find_course
    @course = Course.find(params[:course_id])
  end
end
