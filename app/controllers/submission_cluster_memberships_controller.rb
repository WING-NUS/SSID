class SubmissionClusterMembershipsController < ApplicationController
  # GET /submission_cluster_memberships
  # GET /submission_cluster_memberships.json
  def index
    @submission_cluster_memberships = SubmissionClusterMembership.all

    respond_to do |format|
      format.html # index.html.erb
      format.json { render json: @submission_cluster_memberships }
    end
  end

  # GET /submission_cluster_memberships/1
  # GET /submission_cluster_memberships/1.json
  def show
    @submission_cluster_membership = SubmissionClusterMembership.find(params[:id])

    respond_to do |format|
      format.html # show.html.erb
      format.json { render json: @submission_cluster_membership }
    end
  end

  # GET /submission_cluster_memberships/new
  # GET /submission_cluster_memberships/new.json
  def new
    @submission_cluster_membership = SubmissionClusterMembership.new

    respond_to do |format|
      format.html # new.html.erb
      format.json { render json: @submission_cluster_membership }
    end
  end

  # GET /submission_cluster_memberships/1/edit
  def edit
    @submission_cluster_membership = SubmissionClusterMembership.find(params[:id])
  end

  # POST /submission_cluster_memberships
  # POST /submission_cluster_memberships.json
  def create
    @submission_cluster_membership = SubmissionClusterMembership.new(params[:submission_cluster_membership])

    respond_to do |format|
      if @submission_cluster_membership.save
        format.html { redirect_to @submission_cluster_membership, notice: 'Submission cluster membership was successfully created.' }
        format.json { render json: @submission_cluster_membership, status: :created, location: @submission_cluster_membership }
      else
        format.html { render action: "new" }
        format.json { render json: @submission_cluster_membership.errors, status: :unprocessable_entity }
      end
    end
  end

  # PUT /submission_cluster_memberships/1
  # PUT /submission_cluster_memberships/1.json
  def update
    @submission_cluster_membership = SubmissionClusterMembership.find(params[:id])

    respond_to do |format|
      if @submission_cluster_membership.update_attributes(params[:submission_cluster_membership])
        format.html { redirect_to @submission_cluster_membership, notice: 'Submission cluster membership was successfully updated.' }
        format.json { head :no_content }
      else
        format.html { render action: "edit" }
        format.json { render json: @submission_cluster_membership.errors, status: :unprocessable_entity }
      end
    end
  end

  # DELETE /submission_cluster_memberships/1
  # DELETE /submission_cluster_memberships/1.json
  def destroy
    @submission_cluster_membership = SubmissionClusterMembership.find(params[:id])
    @submission_cluster_membership.destroy

    respond_to do |format|
      format.html { redirect_to submission_cluster_memberships_url }
      format.json { head :no_content }
    end
  end
end
