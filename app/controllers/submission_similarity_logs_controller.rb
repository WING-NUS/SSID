class SubmissionSimilarityLogsController < ApplicationController
  # GET /submission_similarity_logs
  # GET /submission_similarity_logs.json
  def index
    @submission_similarity_logs = SubmissionSimilarityLog.all

    respond_to do |format|
      format.html # index.html.erb
      format.json { render json: @submission_similarity_logs }
    end
  end

  # GET /submission_similarity_logs/1
  # GET /submission_similarity_logs/1.json
  def show
    @submission_similarity_log = SubmissionSimilarityLog.find(params[:id])

    respond_to do |format|
      format.html # show.html.erb
      format.json { render json: @submission_similarity_log }
    end
  end

  # GET /submission_similarity_logs/new
  # GET /submission_similarity_logs/new.json
  def new
    @submission_similarity_log = SubmissionSimilarityLog.new

    respond_to do |format|
      format.html # new.html.erb
      format.json { render json: @submission_similarity_log }
    end
  end

  # GET /submission_similarity_logs/1/edit
  def edit
    @submission_similarity_log = SubmissionSimilarityLog.find(params[:id])
  end

  # POST /submission_similarity_logs
  # POST /submission_similarity_logs.json
  def create
    @submission_similarity_log = SubmissionSimilarityLog.new(params[:submission_similarity_log])

    respond_to do |format|
      if @submission_similarity_log.save
        format.html { redirect_to @submission_similarity_log, notice: 'Submission similarity log was successfully created.' }
        format.json { render json: @submission_similarity_log, status: :created, location: @submission_similarity_log }
      else
        format.html { render action: "new" }
        format.json { render json: @submission_similarity_log.errors, status: :unprocessable_entity }
      end
    end
  end

  # PUT /submission_similarity_logs/1
  # PUT /submission_similarity_logs/1.json
  def update
    @submission_similarity_log = SubmissionSimilarityLog.find(params[:id])

    respond_to do |format|
      if @submission_similarity_log.update_attributes(params[:submission_similarity_log])
        format.html { redirect_to @submission_similarity_log, notice: 'Submission similarity log was successfully updated.' }
        format.json { head :no_content }
      else
        format.html { render action: "edit" }
        format.json { render json: @submission_similarity_log.errors, status: :unprocessable_entity }
      end
    end
  end

  # DELETE /submission_similarity_logs/1
  # DELETE /submission_similarity_logs/1.json
  def destroy
    @submission_similarity_log = SubmissionSimilarityLog.find(params[:id])
    @submission_similarity_log.destroy

    respond_to do |format|
      format.html { redirect_to submission_similarity_logs_url }
      format.json { head :no_content }
    end
  end
end
