class SubmissionsController < ApplicationController
  def index
    @assignment = Assignment.find(params[:assignment_id])
    @submissions = @assignment.submissions

    respond_to do |format|
      format.json { 
        render json: @submissions.collect { |s| 
          { id: s.id, student_id: s.student.id, student_id_string: s.student_id_string } 
        } 
      }
    end
  end

  def show_log
  end
end
