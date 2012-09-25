class SubmissionClusterGroupsController < ApplicationController
  # GET /submission_cluster_groups
  # GET /submission_cluster_groups.json
  def index
    @submission_cluster_groups = SubmissionClusterGroup.all

    respond_to do |format|
      format.html # index.html.erb
      format.json { render json: @submission_cluster_groups }
    end
  end

  # GET /submission_cluster_groups/1
  # GET /submission_cluster_groups/1.json
  def show
    @submission_cluster_group = SubmissionClusterGroup.find(params[:id])

    respond_to do |format|
      format.html # show.html.erb
      format.json { render json: @submission_cluster_group }
    end
  end

  # GET /submission_cluster_groups/new
  # GET /submission_cluster_groups/new.json
  def new
    @submission_cluster_group = SubmissionClusterGroup.new

    respond_to do |format|
      format.html # new.html.erb
      format.json { render json: @submission_cluster_group }
    end
  end

  # GET /submission_cluster_groups/1/edit
  def edit
    @submission_cluster_group = SubmissionClusterGroup.find(params[:id])
  end

  # POST /submission_cluster_groups
  # POST /submission_cluster_groups.json
  def create
    # Assign description based on cut_off_criterion_type
    params[:submission_cluster_group]["description"] = SubmissionClusterGroup::DESCRIPTIONS[params[:submission_cluster_group]["cut_off_criterion_type"]]

    # Create
    @submission_cluster_group = SubmissionClusterGroup.new(params[:submission_cluster_group])

    # If save, we need to run DBSCAN. DBSCAN currently writes directly into the database via MySQL
    # We should change this to a rake task

    respond_to do |format|
      if @submission_cluster_group.save
        format.html { redirect_to @submission_cluster_group, notice: 'Submission cluster group was successfully created.' }
        format.json { render json: @submission_cluster_group, status: :created, location: @submission_cluster_group }
      else
        format.html { render action: "new" }
        format.json { render json: @submission_cluster_group.errors, status: :unprocessable_entity }
      end
    end
  end

  # PUT /submission_cluster_groups/1
  # PUT /submission_cluster_groups/1.json
  def update
    @submission_cluster_group = SubmissionClusterGroup.find(params[:id])

    respond_to do |format|
      if @submission_cluster_group.update_attributes(params[:submission_cluster_group])
        format.html { redirect_to @submission_cluster_group, notice: 'Submission cluster group was successfully updated.' }
        format.json { head :no_content }
      else
        format.html { render action: "edit" }
        format.json { render json: @submission_cluster_group.errors, status: :unprocessable_entity }
      end
    end
  end

  # DELETE /submission_cluster_groups/1
  # DELETE /submission_cluster_groups/1.json
  def destroy
    @submission_cluster_group = SubmissionClusterGroup.find(params[:id])
    @submission_cluster_group.destroy

    respond_to do |format|
      format.html { redirect_to submission_cluster_groups_url }
      format.json { head :no_content }
    end
  end
end
