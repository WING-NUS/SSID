=begin
This file is part of SSID.

SSID is free software: you can redistribute it and/or modify
it under the terms of the GNU Lesser General Public License as published by
the Free Software Foundation, either version 3 of the License, or
(at your option) any later version.

SSID is distributed in the hope that it will be useful,
but WITHOUT ANY WARRANTY; without even the implied warranty of
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
GNU Lesser General Public License for more details.

You should have received a copy of the GNU Lesser General Public License
along with SSID.  If not, see <http://www.gnu.org/licenses/>.
=end

require 'zip'

class AssignmentsController < ApplicationController
  
  # Define valid zip mime types as constant variables
  X_ZIP_COMPRESSED_MIME_TYPE = "application/x-zip-compressed"
  ZIP_COMPRESSED_MIME_TYPE = "application/zip-compressed"
  APPLICATION_ZIP_MIME_TYPE = "application/zip"
  MULTIPART_X_ZIP_MIME_TYPE = "multipart/x-zip"
  OCTET_STREAM_MIME_TYPE = "application/octet-stream"

  before_action { |controller|
    if params[:course_id]
      @course = Course.find(params[:course_id])
      controller.send :authenticate_actions_for_role, UserCourseMembership::ROLE_TEACHING_ASSISTANT,
                                                      course: @course,
                                                      only: [ :index, :cluster_students, :new, :create, :edit, :update]
      controller.send :authenticate_actions_for_role, UserCourseMembership::ROLE_STUDENT,
                                                      course: @course,
                                                      only: [ ]
      controller.send :authenticate_actions_for_role, UserCourseMembership::ROLE_GUEST,
                                                      course: @course,
                                                      only: [ :index ]
    end
  }

  # GET /courses/1/assignments
  def index
    # check whether is it a guest user 
    @guest_details = @course.find_guest_user_details(session[:user_id])
    # obtain assignment to be shown if is a guest user
    if @guest_details.length > 0
      @assignment_to_be_shown = @guest_details.map{|detail| detail.assignment_id }
    end
    
    @assignments = @course.assignments
    @empty_assignments = @course.empty_assignments
    @processing_assignments = @course.processing_assignments
    @processed_assignments = @course.processed_assignments
    @erroneous_assignments = @course.erroneous_assignments
  end
  
  # GET /assignments/1/cluster_students
  def cluster_students
    @assignment = Assignment.find(params["assignment_id"])
    respond_to do |format|
      format.json { 
        render json: @assignment.cluster_students.collect { |s| 
          { id: s.id, id_string: s.id_string } 
        } 
      }
    end
  end

  # GET /courses/1/assignments/1/log
  def show_log
    @assignment = Assignment.find(params[:assignment_id])
  end

  # GET /courses/1/assignments/1
  def show
    @assignment = Assignment.find(params[:id])
  end

  # GET /courses/1/assignments/new
  def new
    @assignment = Assignment.new
  end

  # POST /courses/1/assignments
  def create
    @assignment = Assignment.new { |a|
      a.title = params[:assignment]["title"]
      a.language = params[:assignment]["language"]
      a.min_match_length = params[:assignment]["min_match_length"]
      a.ngram_size = params[:assignment]["ngram_size"]
      a.course_id = @course.id
    }

    # Process file if @assignment is valid and file was uploaded
    if @assignment.valid?
 
      # Save assignment to obtain id
      return render action: "new" unless @assignment.save

      isMapEnabled = (params[:assignment]["mapbox"] == "Yes")? true : false;

      # No student submission file was uploaded
      if params[:assignment]["file"].nil?
        # Create asssignment but don't process it
        redirect_to course_assignments_url(@course), notice: 'Assignment was successfully created. Please upload the student submission files and mapping file (if any) to process the assignment'
      # Student submission file is a valid zip
      elsif (is_valid_zip?(params[:assignment]["file"].content_type, params[:assignment]["file"].path))
        # Don't process the file and show error if the mapping was enabled but no mapping file was uploaded
        if (is_valid_map_or_no_map?(isMapEnabled, params[:assignment]["mapfile"])) 
          self.start_upload(@assignment, params[:assignment]["file"], isMapEnabled, params[:assignment]["mapfile"])
        # Don't process the file and show error if the mapping was enabled but no mapping file was uploaded
        elsif (isMapEnabled && params[:assignment]["mapfile"].nil?)
          @assignment.errors.add(:mapfile, "containing mapped student names need to be uploaded if the 'Upload map file' box is ticked")
          return render action: "new"
        # Don't process the file and show error if the mapping was enabled but no mapping file was uploaded
        else 
          @assignment.errors.add :mapfile, "containing mapped student names must be a valid csv file"
          return render action: "new"
        end
      # Student submission file is not a valid zip file
      else
        @assignment.errors.add :file, "containing student submission files must be a valid zip file"
        if (params[:assignment]["mapfile"].nil? && isMapEnabled)
          @assignment.errors.add :mapfile, "containing mapped student names need to be uploaded if the 'Upload map file' box is ticked"
        elsif !(is_valid_map_or_no_map?(isMapEnabled, params[:assignment]["mapfile"])) 
          @assignment.errors.add :mapfile, "containing mapped student names must be a valid csv file"
        end
        return render action: "new"
      end
    else
      render action: "new"
    end
  end
  
  # PUT /courses/1/assignments/1
  def update
    @assignment = Assignment.find(params[:id])

    isMapEnabled = (params[:assignment]["mapbox"] == "Yes")? true : false;

    # No student submission file was uploaded
    if params[:assignment]["file"].nil?
      @assignment.errors.add :file, "containing student submission files need to be uploaded to process the assignment"
        if (params[:assignment]["mapfile"].nil? && isMapEnabled)
          @assignment.errors.add :mapfile, "containing mapped student names need to be uploaded if the 'Upload map file' box is ticked"
        elsif !(is_valid_map_or_no_map?(isMapEnabled, params[:assignment]["mapfile"])) 
          @assignment.errors.add :mapfile, "containing mapped student names must be a valid csv file"
        end
      return render action: "show"
    elsif (is_valid_zip?(params[:assignment]["file"].content_type, params[:assignment]["file"].path))
      # Don't process the file and show error if the mapping was enabled but no mapping file was uploaded
      if (is_valid_map_or_no_map?(isMapEnabled, params[:assignment]["mapfile"])) 
        self.start_upload(@assignment, params[:assignment]["file"], isMapEnabled, params[:assignment]["mapfile"])
      # Don't process the file and show error if the mapping was enabled but no mapping file was uploaded
      elsif (isMapEnabled && params[:assignment]["mapfile"].nil?)
        @assignment.errors.add(:mapfile, "containing mapped student names need to be uploaded if the 'Upload map file' box is ticked")
        return render action: "show"
      # Don't process the file and show error if the mapping was enabled but no mapping file was uploaded
      else 
        @assignment.errors.add :mapfile, "containing mapped student names must be a valid csv file"
        return render action: "show"
      end
    # Student submission file is not a valid zip file
    else
      @assignment.errors.add :file, "containing student submission files must be a valid zip file"
      if (params[:assignment]["mapfile"].nil? && isMapEnabled)
        @assignment.errors.add :mapfile, "containing mapped student names need to be uploaded if the 'Upload map file' box is ticked"
      elsif !(is_valid_map_or_no_map?(isMapEnabled, params[:assignment]["mapfile"])) 
        @assignment.errors.add :mapfile, "containing mapped student names must be a valid csv file"
      end
      return render action: "show"
    end
  end

  # DELETE /courses/1/assignments/1
  def destroy
    @assignment = Assignment.find(params[:id])
    @assignment.destroy
  
    redirect_to course_assignments_url(@course), notice: 'Assignment was successfully deleted.'
  end
  
  def start_upload(assignment, submissionFile, isMapEnabled, mapFile)
      require 'submissions_handler'

      # Process upload file
      submissions_path = SubmissionsHandler.process_upload(submissionFile, isMapEnabled, mapFile, assignment)
      if submissions_path
        # Launch java program to process submissions
        SubmissionsHandler.process_submissions(submissions_path, assignment, isMapEnabled)
        redirect_to course_assignments_url(@course), notice: 'SSID will start to process the assignment now. Please refresh this page after a few minutes to view the similarity results.'
      else
        assignment.errors.add "Submission zip file", ": SSID supports both directory-based and file-based submissions. Please select the submissions you want to evaluate and compress." 
        return render action: "show"
      end

  end

  # Responsible for verifying whether a uploaded file is zip by checking its mime type and/or whether can it be extracted by the zip library.
  # For files with mime type = application/octet-stream, it needs to be further verified by the zip library as it can be a rar file.
  # Params:
  # +mimeType+:: string that contains the file's mimetype
  # +filePath+:: string that contains the file's path which is to be used by the zip library when extracting the file
  def is_valid_zip?(mimeType, filePath)
    # Valid zip file mime types that does not required to be further verified by the zip library
    if mimeType == X_ZIP_COMPRESSED_MIME_TYPE || 
      mimeType == ZIP_COMPRESSED_MIME_TYPE ||
      mimeType == APPLICATION_ZIP_MIME_TYPE ||
      mimeType == MULTIPART_X_ZIP_MIME_TYPE
      return true;
    # Need to be further verified by zip library as it can be a rar file
    elsif mimeType == OCTET_STREAM_MIME_TYPE && is_opened_as_zip?(filePath)
      return true;
    # For other mime types, safe to consider that it is not a zip file
      return false;
    end
  end


  # Responsible for verifying whether a uploaded file is zip by checking whether can it be extracted by the zip library
  # Params:
  # +filePath+:: string that contains the file's path which is to be used by the zip library when extracting the file
  def is_opened_as_zip?(path)
    # File is zip if the zip library is able to extract the file
    zip = Zip::File.open(path)
    true
  rescue => error_msg
    puts error_msg
    false
  ensure
    zip.close if zip
  end

  def is_valid_map_or_no_map?(isMapEnabled, mapFile)
    if (!isMapEnabled)
      return true
    else
      if (mapFile.nil?) 
        return false
      elsif mapFile.content_type == "text/csv" && mapFile.path.split('.').last.to_s.downcase == 'csv'
        return true
      else 
        return false
      end
    end
  end

end


