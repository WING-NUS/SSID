class SubmissionLogsController < ApplicationController
  # GET /submission_logs
  # GET /submission_logs.json
  def index
    @submission_logs = SubmissionLog.all

    respond_to do |format|
      format.html # index.html.erb
      format.json { render json: @submission_logs }
    end
  end

  # GET /submission_logs/1
  # GET /submission_logs/1.json
  def show
    @submission_log = SubmissionLog.find(params[:id])

    respond_to do |format|
      format.html # show.html.erb
      format.json { render json: @submission_log }
    end
  end

  # GET /submission_logs/new
  # GET /submission_logs/new.json
  def new
    @submission_log = SubmissionLog.new

    respond_to do |format|
      format.html # new.html.erb
      format.json { render json: @submission_log }
    end
  end

  # GET /submission_logs/1/edit
  def edit
    @submission_log = SubmissionLog.find(params[:id])
  end

  # POST /submission_logs
  # POST /submission_logs.json
  def create
    @submission_log = SubmissionLog.new(params[:submission_log])

    respond_to do |format|
      if @submission_log.save
        format.html { redirect_to @submission_log, notice: 'Submission log was successfully created.' }
        format.json { render json: @submission_log, status: :created, location: @submission_log }
      else
        format.html { render action: "new" }
        format.json { render json: @submission_log.errors, status: :unprocessable_entity }
      end
    end
  end

  # PUT /submission_logs/1
  # PUT /submission_logs/1.json
  def update
    @submission_log = SubmissionLog.find(params[:id])

    respond_to do |format|
      if @submission_log.update_attributes(params[:submission_log])
        format.html { redirect_to @submission_log, notice: 'Submission log was successfully updated.' }
        format.json { head :no_content }
      else
        format.html { render action: "edit" }
        format.json { render json: @submission_log.errors, status: :unprocessable_entity }
      end
    end
  end

  # DELETE /submission_logs/1
  # DELETE /submission_logs/1.json
  def destroy
    @submission_log = SubmissionLog.find(params[:id])
    @submission_log.destroy

    respond_to do |format|
      format.html { redirect_to submission_logs_url }
      format.json { head :no_content }
    end
  end
end
