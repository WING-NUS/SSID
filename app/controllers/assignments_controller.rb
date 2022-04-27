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
    @user = User.find_by_id(session[:user_id]) 
    @guest_user = GuestUsersDetail.find_by_user_id(@user.id)
    # obtain assignment to be shown if is a guest user
    #@assignment_to_be_shown = @guest_user.assignment_id
    
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
      
      # to check whether user clicked on optional options
      isOptionalOptionsEnabled = (params[:assignment]["mapbox"] == "Yes")? true : false;
      
      # to check whether user uploaded the students code zip file
      isCodeFileUploaded = (params[:assignment]["file"].nil? == true)? false : true;
      codeFile = params[:assignment]["file"];
      isValidCodeFile = false # to determine whether valid code file
      
      # to check whether user uploaded a map file
      isMapFileUploaded = (params[:assignment]["mapfile"].nil? == true)? false : true;
      mapFile = (isOptionalOptionsEnabled)? params[:assignment]["mapfile"] : nil;
      isValidMapFile = false  # to determine whether valid map file
      
      # to check whether the uploaded students code zip file is structured by ...
      isCodeFileStructureAllFiles = (params[:assignment]["fileStructure"] == "all")? true : false;
      
      # no student submission file was uploaded
      if !(isCodeFileUploaded)
        # create asssignment but don't process it
        redirect_to course_assignments_url(@course), notice: 'Assignment was successfully created. Please upload the student submission files to preview files and/or process the assignment'
    
      # ascertain that all the fields are valid
      else
        # verify codeFile and mapFile (if uploaded)
        isValidCodeFile = is_valid_zip?(codeFile.content_type, codeFile.path)
        isValidMapFile = is_valid_map_or_no_map?(isOptionalOptionsEnabled, mapFile)

        # uploaded student code file was not valid
        if (!isValidCodeFile)
          @assignment.errors.add :file, "Containing student submission files must be a valid zip file"
          hasErrorParams = true
        end
        
        # uploaded map file was not valid
        if (isMapFileUploaded && !isValidMapFile) 
          @assignment.errors.add :mapfile, "Containing mapped student names must be a valid CSV file"
          hasErrorParams = true
        end

        codeFile_path = ""

        # if there are no errors with the uploaded files
        if (!hasErrorParams) 
          
          require 'submissions_handler'

          # extract codefile and mapfile (if uploaded)
          codeFile_path = SubmissionsHandler.process_upload(
            codeFile, isMapFileUploaded, mapFile, @assignment
          )
        
        # if there are errors with the uploaded files, display error in the UI
        else
          return render action: "new"
        end

        extract_uploaded_files(
          @assignment, isCodeFileStructureAllFiles, codeFile_path, isMapFileUploaded
        )

      end
    else
      render action: "new"
    end
  end

  # PUT /courses/1/assignments/1
  def update
    @assignment = Assignment.find(params[:id])

    # Get all the parameters
    
    # to check whether user clicked on optional options
    isOptionalOptionsEnabled = (params[:assignment]["mapbox"] == "Yes")? true : false;
      
    # to check whether user uploaded the students code zip file
    isCodeFileUploaded = (params[:assignment]["file"].nil? == true)? false : true;
    codeFile = params[:assignment]["file"];
    isValidCodeFile = false # to determine whether valid code file
    
    # to check whether user uploaded a map file
    isMapFileUploaded = (params[:assignment]["mapfile"].nil? == true)? false : true;
    mapFile = (isOptionalOptionsEnabled)? params[:assignment]["mapfile"] : nil;
    isValidMapFile = false  # to determine whether valid map file
    
    # to check whether the uploaded students code zip file is structured by ...
    isCodeFileStructureAllFiles = (params[:assignment]["fileStructure"] == "all")? true : false;
    
    # no student submission file was uploaded
    if !(isCodeFileUploaded)
      @assignment.errors.add :file, "containing student submission files need to be uploaded"
      hasErrorParams = true
      # ascertain that all the fields are valid
    else
      # verify codeFile, mapFile (if uploaded) and refFile (if uploaded)
      isValidCodeFile = is_valid_zip?(codeFile.content_type, codeFile.path)
      isValidMapFile = is_valid_map_or_no_map?(isOptionalOptionsEnabled, mapFile)
      codeFile_path = ""

      if (!isValidCodeFile)
        @assignment.errors.add :file, "containing student submission files must be a valid zip file"
        hasErrorParams = true
      end
      
      if (isMapFileUploaded && !isValidMapFile) 
        @assignment.errors.add :mapfile, "containing mapped student names must be a valid csv file"
        hasErrorParams = true
      end

      if (!hasErrorParams) 

        require 'submissions_handler'

        # extract codefile and mapfile (if uploaded)
        codeFile_path = SubmissionsHandler.process_upload(
          codeFile, isMapFileUploaded, mapFile, @assignment
        )
      
      else
        return render action: "show"
      end

      extract_uploaded_files(
        @assignment, isCodeFileStructureAllFiles, codeFile_path, isMapFileUploaded
      )
    end
  end

  def extract_uploaded_files(
    assignment, isCodeFileStructureAllFiles, codeFile_path, isMapEnabled
  )

  @dirSize = 0
  
  # Create directory for code comparison, delete first if necessary
  code_compare_dir = File.join(codeFile_path, "_compare")
  FileUtils.rm(code_compare_dir, force: true) if File.exist? code_compare_dir
  FileUtils.mkdir_p(File.join(codeFile_path, "_compare"))

  # For each student submission, combine the code files into one
  # Only match files in the current directory
  # For file based comparision, no need to combine code files
  if (isCodeFileStructureAllFiles)
    
    Dir.glob(File.join(codeFile_path, "**/*")).each do |file|
      next if File.directory?(file) # skip the loop if the file is a directory
      if (File.basename(file, File.extname(file)) != 'skeleton')
        @dirSize += 1
      end
      arr = []
      split_str = file.split('/')
      filepath = split_str[split_str.count - 1]
      arr.push(filepath)
      dest_folder = code_compare_dir + "/" + File.basename(file, File.extname(file)) + File.extname(file)
        FileUtils.cp(file, dest_folder)
    end

  # For folder comparision, combine code files and write into compare dir as new file with same name, remove ext if any  
  else 

    Dir.glob(File.join(codeFile_path, "*")).each { |subpath|
    next if subpath == code_compare_dir || (File.file?(subpath) && subpath.split('.').last.to_s.downcase == 'csv')
    
    if (Dir.exist?(subpath))
      split_str = subpath.split('/')
      foldname = split_str[split_str.count - 1]
      if (foldname != 'skeleton')
        @dirSize += 1
      end
      files = Dir.entries(subpath).reject!{|file_name| [".","..",".gitignore"].include?(file_name)}
    end

    File.open(File.join(code_compare_dir, File.basename(subpath, File.extname(subpath))), 'w') { |f|
      f.puts string_from_combined_files(subpath)
    }
  
  }
  end

  # Check the contents size inside zip
  if (@dirSize == 0)
    @assignment.errors.add :file, "Containing student submission files cannot be empty"
    return render action: "show"
  elsif (@dirSize == 1)
    @assignment.errors.add :file, "Containing student submission files must have at least 2 student folders/files"
    return render action: "show"
  end

  require 'submissions_handler'
  SubmissionsHandler.process_submissions(code_compare_dir, @assignment, isMapEnabled)

  redirect_to course_assignments_url(@course), notice: 'Assignment was successfully created. Please refresh this page after a few minutes to view the similarity results.'
 
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

      # Launch java program to process submissions
      SubmissionsHandler.process_submissions(submissions_path, assignment, isMapEnabled)
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

  def string_from_combined_files(path)
    strings = []
    if File.directory? path
      Dir.glob(File.join(path, "*")).sort.each { |subpath|
        strings << string_from_combined_files(subpath)
      }
    else
      strings << File.open(path).readlines.join
    end

    strings.join("\n")
  end

end


