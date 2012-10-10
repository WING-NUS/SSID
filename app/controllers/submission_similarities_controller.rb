class SubmissionSimilaritiesController < ApplicationController
  # GET /students/1/submission_similarities/show_table_partial
  def show_table_partial
    locals = {}
    locals[:student] = User.find(params["student_id"])
    if params["course_id"]
      locals[:assignments] = Course.find(params["course_id"]).assignments
    elsif params["assignment_id"]
      locals[:assignments] = [ Assignment.find(params["assignment_id"]) ]
    end
    locals[:num_display] = params["num_display"].to_i
    render partial: "submission_similarities_table", locals: locals
  end
end
