class SubmissionSimilaritiesController < ApplicationController
  # GET /submission_similarities
  # GET /submission_similarities.json
  def index
    @submission_similarities = SubmissionSimilarity.all

    respond_to do |format|
      format.html # index.html.erb
      format.json { render json: @submission_similarities }
    end
  end

  # GET /submission_similarities/1
  # GET /submission_similarities/1.json
  def show
    @submission_similarity = SubmissionSimilarity.find(params[:id])

    respond_to do |format|
      format.html # show.html.erb
      format.json { render json: @submission_similarity }
    end
  end

  # GET /submission_similarities/new
  # GET /submission_similarities/new.json
  def new
    @submission_similarity = SubmissionSimilarity.new

    respond_to do |format|
      format.html # new.html.erb
      format.json { render json: @submission_similarity }
    end
  end

  # GET /submission_similarities/1/edit
  def edit
    @submission_similarity = SubmissionSimilarity.find(params[:id])
  end

  # POST /submission_similarities
  # POST /submission_similarities.json
  def create
    @submission_similarity = SubmissionSimilarity.new(params[:submission_similarity])

    respond_to do |format|
      if @submission_similarity.save
        format.html { redirect_to @submission_similarity, notice: 'Submission similarity was successfully created.' }
        format.json { render json: @submission_similarity, status: :created, location: @submission_similarity }
      else
        format.html { render action: "new" }
        format.json { render json: @submission_similarity.errors, status: :unprocessable_entity }
      end
    end
  end

  # PUT /submission_similarities/1
  # PUT /submission_similarities/1.json
  def update
    @submission_similarity = SubmissionSimilarity.find(params[:id])

    respond_to do |format|
      if @submission_similarity.update_attributes(params[:submission_similarity])
        format.html { redirect_to @submission_similarity, notice: 'Submission similarity was successfully updated.' }
        format.json { head :no_content }
      else
        format.html { render action: "edit" }
        format.json { render json: @submission_similarity.errors, status: :unprocessable_entity }
      end
    end
  end

  # DELETE /submission_similarities/1
  # DELETE /submission_similarities/1.json
  def destroy
    @submission_similarity = SubmissionSimilarity.find(params[:id])
    @submission_similarity.destroy

    respond_to do |format|
      format.html { redirect_to submission_similarities_url }
      format.json { head :no_content }
    end
  end
end
