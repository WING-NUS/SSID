class SubmissionClustersController < ApplicationController
  # GET /submission_clusters
  # GET /submission_clusters.json
  def index
    @submission_clusters = SubmissionCluster.all

    respond_to do |format|
      format.html # index.html.erb
      format.json { render json: @submission_clusters }
    end
  end

  # GET /submission_clusters/1
  # GET /submission_clusters/1.json
  def show
    @submission_cluster = SubmissionCluster.find(params[:id])

    respond_to do |format|
      format.html # show.html.erb
      format.json { render json: @submission_cluster }
    end
  end

  # GET /submission_clusters/new
  # GET /submission_clusters/new.json
  def new
    @submission_cluster = SubmissionCluster.new

    respond_to do |format|
      format.html # new.html.erb
      format.json { render json: @submission_cluster }
    end
  end

  # GET /submission_clusters/1/edit
  def edit
    @submission_cluster = SubmissionCluster.find(params[:id])
  end

  # POST /submission_clusters
  # POST /submission_clusters.json
  def create
    @submission_cluster = SubmissionCluster.new(params[:submission_cluster])

    respond_to do |format|
      if @submission_cluster.save
        format.html { redirect_to @submission_cluster, notice: 'Submission cluster was successfully created.' }
        format.json { render json: @submission_cluster, status: :created, location: @submission_cluster }
      else
        format.html { render action: "new" }
        format.json { render json: @submission_cluster.errors, status: :unprocessable_entity }
      end
    end
  end

  # PUT /submission_clusters/1
  # PUT /submission_clusters/1.json
  def update
    @submission_cluster = SubmissionCluster.find(params[:id])

    respond_to do |format|
      if @submission_cluster.update_attributes(params[:submission_cluster])
        format.html { redirect_to @submission_cluster, notice: 'Submission cluster was successfully updated.' }
        format.json { head :no_content }
      else
        format.html { render action: "edit" }
        format.json { render json: @submission_cluster.errors, status: :unprocessable_entity }
      end
    end
  end

  # DELETE /submission_clusters/1
  # DELETE /submission_clusters/1.json
  def destroy
    @submission_cluster = SubmissionCluster.find(params[:id])
    @submission_cluster.destroy

    respond_to do |format|
      format.html { redirect_to submission_clusters_url }
      format.json { head :no_content }
    end
  end
end
