class SubmissionSimilarityMappingsController < ApplicationController
  # GET /submission_similarity_mappings
  # GET /submission_similarity_mappings.json
  def index
    @submission_similarity_mappings = SubmissionSimilarityMapping.all

    respond_to do |format|
      format.html # index.html.erb
      format.json { render json: @submission_similarity_mappings }
    end
  end

  # GET /submission_similarity_mappings/1
  # GET /submission_similarity_mappings/1.json
  def show
    @submission_similarity_mapping = SubmissionSimilarityMapping.find(params[:id])

    respond_to do |format|
      format.html # show.html.erb
      format.json { render json: @submission_similarity_mapping }
    end
  end

  # GET /submission_similarity_mappings/new
  # GET /submission_similarity_mappings/new.json
  def new
    @submission_similarity_mapping = SubmissionSimilarityMapping.new

    respond_to do |format|
      format.html # new.html.erb
      format.json { render json: @submission_similarity_mapping }
    end
  end

  # GET /submission_similarity_mappings/1/edit
  def edit
    @submission_similarity_mapping = SubmissionSimilarityMapping.find(params[:id])
  end

  # POST /submission_similarity_mappings
  # POST /submission_similarity_mappings.json
  def create
    @submission_similarity_mapping = SubmissionSimilarityMapping.new(params[:submission_similarity_mapping])

    respond_to do |format|
      if @submission_similarity_mapping.save
        format.html { redirect_to @submission_similarity_mapping, notice: 'Submission similarity mapping was successfully created.' }
        format.json { render json: @submission_similarity_mapping, status: :created, location: @submission_similarity_mapping }
      else
        format.html { render action: "new" }
        format.json { render json: @submission_similarity_mapping.errors, status: :unprocessable_entity }
      end
    end
  end

  # PUT /submission_similarity_mappings/1
  # PUT /submission_similarity_mappings/1.json
  def update
    @submission_similarity_mapping = SubmissionSimilarityMapping.find(params[:id])

    respond_to do |format|
      if @submission_similarity_mapping.update_attributes(params[:submission_similarity_mapping])
        format.html { redirect_to @submission_similarity_mapping, notice: 'Submission similarity mapping was successfully updated.' }
        format.json { head :no_content }
      else
        format.html { render action: "edit" }
        format.json { render json: @submission_similarity_mapping.errors, status: :unprocessable_entity }
      end
    end
  end

  # DELETE /submission_similarity_mappings/1
  # DELETE /submission_similarity_mappings/1.json
  def destroy
    @submission_similarity_mapping = SubmissionSimilarityMapping.find(params[:id])
    @submission_similarity_mapping.destroy

    respond_to do |format|
      format.html { redirect_to submission_similarity_mappings_url }
      format.json { head :no_content }
    end
  end
end
