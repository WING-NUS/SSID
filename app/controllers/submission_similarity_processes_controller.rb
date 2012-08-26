class SubmissionSimilarityProcessesController < ApplicationController
  # GET /submission_similarity_processes
  # GET /submission_similarity_processes.json
  def index
    @submission_similarity_processes = SubmissionSimilarityProcess.all

    respond_to do |format|
      format.html # index.html.erb
      format.json { render json: @submission_similarity_processes }
    end
  end

  # GET /submission_similarity_processes/1
  # GET /submission_similarity_processes/1.json
  def show
    @submission_similarity_process = SubmissionSimilarityProcess.find(params[:id])

    respond_to do |format|
      format.html # show.html.erb
      format.json { render json: @submission_similarity_process }
    end
  end

  # GET /submission_similarity_processes/new
  # GET /submission_similarity_processes/new.json
  def new
    @submission_similarity_process = SubmissionSimilarityProcess.new

    respond_to do |format|
      format.html # new.html.erb
      format.json { render json: @submission_similarity_process }
    end
  end

  # GET /submission_similarity_processes/1/edit
  def edit
    @submission_similarity_process = SubmissionSimilarityProcess.find(params[:id])
  end

  # POST /submission_similarity_processes
  # POST /submission_similarity_processes.json
  def create
    @submission_similarity_process = SubmissionSimilarityProcess.new(params[:submission_similarity_process])

    respond_to do |format|
      if @submission_similarity_process.save
        format.html { redirect_to @submission_similarity_process, notice: 'Submission similarity process was successfully created.' }
        format.json { render json: @submission_similarity_process, status: :created, location: @submission_similarity_process }
      else
        format.html { render action: "new" }
        format.json { render json: @submission_similarity_process.errors, status: :unprocessable_entity }
      end
    end
  end

  # PUT /submission_similarity_processes/1
  # PUT /submission_similarity_processes/1.json
  def update
    @submission_similarity_process = SubmissionSimilarityProcess.find(params[:id])

    respond_to do |format|
      if @submission_similarity_process.update_attributes(params[:submission_similarity_process])
        format.html { redirect_to @submission_similarity_process, notice: 'Submission similarity process was successfully updated.' }
        format.json { head :no_content }
      else
        format.html { render action: "edit" }
        format.json { render json: @submission_similarity_process.errors, status: :unprocessable_entity }
      end
    end
  end

  # DELETE /submission_similarity_processes/1
  # DELETE /submission_similarity_processes/1.json
  def destroy
    @submission_similarity_process = SubmissionSimilarityProcess.find(params[:id])
    @submission_similarity_process.destroy

    respond_to do |format|
      format.html { redirect_to submission_similarity_processes_url }
      format.json { head :no_content }
    end
  end
end
