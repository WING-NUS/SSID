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

  require 'submissions_handler'

  before_action { |controller|
    if params[:course_id]
      @course = Course.find(params[:course_id])
      controller.send :authenticate_actions_for_role, UserCourseMembership::ROLE_TEACHING_ASSISTANT,
                                                      course: @course,
                                                      only: [ :index, :cluster_students, :new, :create, :edit, :update]
      controller.send :authenticate_actions_for_role, UserCourseMembership::ROLE_STUDENT,
                                                      course: @course,
                                                      only: [ ]
    end
  }

  # GET /courses/1/assignments
  def index
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

      #@change = false

      #gon.mychange = false

      # Get all the parameters
      isOptionalOptionsEnabled = (params[:assignment]["mapbox"] == "Yes")? true : false;
      isCodeFileUploaded = (params[:assignment]["file"].nil? == true)? false : true;
      isMapFileUploaded = (params[:assignment]["mapfile"].nil? == true)? false : true;
      isRefFileUploaded = (params[:assignment]["refDir"].nil? == true)? false : true;
      isCodeFileStructureAllFiles = (params[:assignment]["file_structure"] == "all")? true : false;
      codeFile = params[:assignment]["file"];
      mapFile = (isOptionalOptionsEnabled)? params[:assignment]["mapfile"] : nil; 
      refFile = (isOptionalOptionsEnabled)? params[:assignment]["refDir"] : nil;
      isPreviewButtonClicked = params[:preview]

      @assignment.filesIgnore = (isOptionalOptionsEnabled)? params[:assignment]["filesIgnore"] : "";
      @assignment.filesProcess = (isOptionalOptionsEnabled)? params[:assignment]["filesProcess"] : ""
      @assignment.email = (isOptionalOptionsEnabled)? params[:assignment]["email"] : ""
  
      # determine whether valid code file
      isValidCodeFile = false
      # determine whether valid map file
      isValidMapFile = false
      # determine whether valid ref dir file
      isValidRefDir = false
      # submitted code files or dir size (depending on which code file structure was selected)
      @codeFilesOrDirSize = 0
      # dir hash to display contents inside dir (applicable if code file structure is 'By Dir')
      @dirHash = {}
      # determine whether any params has error and prevent assignment from processing
      hasErrorParams = false
      # file path of extracted code file
      codeFilePath = ""
      # file path of extracted ref file
      refFilePath = "" 
      @dirSize = 0
      @dirHash = {}

      # no student submission file was uploaded
      if !(isCodeFileUploaded)
        # Create asssignment but don't process it
        redirect_to course_assignments_url(@course), notice: 'Assignment was successfully created. Please upload the student submission files to preview files and/or process the assignment'
      # ascertain that all the fields are valid
      else
        # verify codeFile, mapFile (if uploaded) and refFile (if uploaded)
        isValidCodeFile = is_valid_zip?(codeFile.content_type, codeFile.path)
        isValidMapFile = is_valid_map_or_no_map?(isOptionalOptionsEnabled, mapFile)
        isValidRefFile = isRefFileUploaded && is_valid_zip?(refFile.content_type, refFile.path)
        codeFile_path = ""
        refFile_path = ""

        if (!isValidCodeFile)
          @assignment.errors.add :file, "containing student submission files must be a valid zip file"
          hasErrorParams = true
        end
        
        if (isMapFileUploaded && !isValidMapFile) 
          @assignment.errors.add :mapfile, "containing mapped student names must be a valid csv file"
          hasErrorParams = true
        end

        if (isRefFileUploaded && !isValidRefFile) 
          @assignment.errors.add :refDir, "containing referenced student submission files must be a valid zip file"
          hasErrorParams = true
        end

        refFile_path = ""
        codeFile_path = ""

        if (!hasErrorParams) 

          require 'submissions_handler'

          # extract ref file (if uploaded)
          if (isRefFileUploaded && isValidRefFile) 
            refFile_path = SubmissionsHandler.extract_upload(
              refFile, false, mapFile, @assignment, false, "ref"
            )
          end

          # extract codefile and mapfile (if uploaded)
          codeFile_path = SubmissionsHandler.extract_upload(
            codeFile, isMapFileUploaded, mapFile, @assignment, true, "code"
          )
        
        else
          return render action: "new"
        end

        extract_uploaded_files(
          @assignment, isRefFileUploaded, isCodeFileStructureAllFiles, isPreviewButtonClicked, 
          refFile_path, codeFile_path, isValidRefFile, isMapFileUploaded
        )
      end
    else
      render action: "new"
    end
  end

  def extract_uploaded_files(
      assignment, isRefFileUploaded, isCodeFileStructureAllFiles, isPreviewButtonClicked, 
      refFile_path, codeFile_path, isValidRefFile, isMapEnabled
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
        @dirHash[File.basename(file, File.extname(file))] = arr
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
        @dirHash[foldname] = files
      end

      File.open(File.join(code_compare_dir, File.basename(subpath, File.extname(subpath))), 'w') { |f|
        f.puts string_from_combined_files(subpath)
      }
    
    }
    end

    if (isRefFileUploaded && isValidRefFile) 
      
      # Create directory for code comparison, delete first if necessary
      ref_compare_dir = File.join(refFile_path, "_compare")
      FileUtils.rm(ref_compare_dir, force: true) if File.exist? ref_compare_dir
      FileUtils.mkdir_p(File.join(refFile_path, "_compare"))
      
      if (isCodeFileStructureAllFiles)
        
        Dir.glob(File.join(refFile_path, "**/*")).each do |file|
          next if File.directory?(file) # skip the loop if the file is a directory
          # `git log -1 -r -n 1 --pretty=format:"%cd [%h]" -- #{file}`
          dest_folder = ref_compare_dir + "/" + File.basename(file, File.extname(file)) + File.extname(file)
            FileUtils.cp(file, dest_folder)
      end

        
      # For folder comparision, combine code files and write into compare dir as new file with same name, remove ext if any  
      else 
        Dir.glob(File.join(refFile_path, "*")).each { |subpath|
        next if subpath == ref_compare_dir || (File.file?(subpath) && subpath.split('.').last.to_s.downcase == 'csv')

        File.open(File.join(ref_compare_dir, File.basename(subpath, File.extname(subpath))), 'w') { |f|
          f.puts string_from_combined_files(subpath)
        }
      }
      end
    end

    @previewStatement = (isCodeFileStructureAllFiles)? "SSID detected " + @dirSize.to_s + " file(s) for code comparision in your uploaded zip file"
      : "SSID detected " + @dirSize.to_s + " root directories/ student folder(s) for code comparision in your uploaded zip file"
    @column1Title = (isCodeFileStructureAllFiles)? "Filename" : "Root Directory"
    @column2Title = (isCodeFileStructureAllFiles)? "Filepath After Extraction" : "Contents Inside Root Directory"
    # Check the contents size inside zip
    if (@dirSize == 0)
      @statusStatement = "SSID cannot process the assignment due to empty/insufficient files to compare"
      @assignment.errors.add :file, "containing student submission files cannot be empty"
      return render action: "preview_files"
    elsif (@dirSize == 1)
      @statusStatement = "SSID cannot process the assignment due to empty/insufficient files to compare"
      @assignment.errors.add :file, "containing student submission files must have more than 1 student folder/file"
      return render action: "preview_files"
    elsif (isPreviewButtonClicked)  
      return render action: "preview_files"
    end

    #SubmissionsHandler.process_submissions(su_path, assignment, isMapEnabled)
    #self.start_upload(@assignment, params[:assignment]["file"], isMapEnabled, params[:assignment]["mapfile"])
    
    require 'submissions_handler'
    SubmissionsHandler.process_submissions(code_compare_dir, @assignment, isMapEnabled)
 
    redirect_to course_assignments_url(@course), notice: 'Assignment was successfully created. Please refresh this page after a few minutes to view the similarity results.'
   
  end
  
  # PUT /courses/1/assignments/1
  def update
    @assignment = Assignment.find(params[:id])

    # Get all the parameters
    isOptionalOptionsEnabled = (params[:assignment]["mapbox"] == "Yes")? true : false;
    isCodeFileUploaded = (params[:assignment]["file"].nil? == true)? false : true;
    isMapFileUploaded = (params[:assignment]["mapfile"].nil? == true)? false : true;
    isRefFileUploaded = (params[:assignment]["refDir"].nil? == true)? false : true;
    isCodeFileStructureAllFiles = (params[:assignment]["file_structure"] == "all")? true : false;
    codeFile = params[:assignment]["file"];
    mapFile = (isOptionalOptionsEnabled)? params[:assignment]["mapfile"] : nil; 
    refFile = (isOptionalOptionsEnabled)? params[:assignment]["refDir"] : nil;
    isPreviewButtonClicked = params[:preview]

    @assignment.filesIgnore = (isOptionalOptionsEnabled)? params[:assignment]["filesIgnore"] : "";
    @assignment.filesProcess = (isOptionalOptionsEnabled)? params[:assignment]["filesProcess"] : ""
    @assignment.email = (isOptionalOptionsEnabled)? params[:assignment]["email"] : ""

    # determine whether valid code file
    isValidCodeFile = false
    # determine whether valid map file
    isValidMapFile = false
    # determine whether valid ref dir file
    isValidRefDir = false
    # submitted code files or dir size (depending on which code file structure was selected)
    @codeFilesOrDirSize = 0
    # dir hash to display contents inside dir (applicable if code file structure is 'By Dir')
    @dirHash = {}
    # determine whether any params has error and prevent assignment from processing
    hasErrorParams = false
    # file path of extracted code file
    codeFilePath = ""
    # file path of extracted ref file
    refFilePath = "" 
    @dirSize = 0
    @dirHash = {}

    # no student submission file was uploaded
    if !(isCodeFileUploaded)
      @assignment.errors.add :file, "containing student submission files need to be uploaded"
      hasErrorParams = true
      # ascertain that all the fields are valid
    else
      # verify codeFile, mapFile (if uploaded) and refFile (if uploaded)
      isValidCodeFile = is_valid_zip?(codeFile.content_type, codeFile.path)
      isValidMapFile = is_valid_map_or_no_map?(isOptionalOptionsEnabled, mapFile)
      isValidRefFile = isRefFileUploaded && is_valid_zip?(refFile.content_type, refFile.path)
      codeFile_path = ""
      refFile_path = ""

      if (!isValidCodeFile)
        @assignment.errors.add :file, "containing student submission files must be a valid zip file"
        hasErrorParams = true
      end
      
      if (isMapFileUploaded && !isValidMapFile) 
        @assignment.errors.add :mapfile, "containing mapped student names must be a valid csv file"
        hasErrorParams = true
      end

      if (isRefFileUploaded && !isValidRefFile) 
        @assignment.errors.add :refDir, "containing referenced student submission files must be a valid zip file"
        hasErrorParams = true
      end

      refFile_path = ""
      codeFile_path = ""

      if (!hasErrorParams) 

        require 'submissions_handler'

        # extract ref file (if uploaded)
        if (isRefFileUploaded && isValidRefFile) 
          refFile_path = SubmissionsHandler.extract_upload(
            refFile, false, mapFile, @assignment, false, "ref"
          )
        end

        # extract codefile and mapfile (if uploaded)
        codeFile_path = SubmissionsHandler.extract_upload(
          codeFile, isMapFileUploaded, mapFile, @assignment, true, "code"
        )
      
      else
        return render action: "show"
      end

      extract_uploaded_files(
        @assignment, isRefFileUploaded, isCodeFileStructureAllFiles, isPreviewButtonClicked, 
        refFile_path, codeFile_path, isValidRefFile, isMapFileUploaded
      )
    end
  end




  # DELETE /courses/1/assignments/1
  def destroy
    @assignment = Assignment.find(params[:id])
    @assignment.destroy
  
    redirect_to course_assignments_url(@course), notice: 'Assignment was successfully deleted.'
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
    elsif (!mapFile.nil?) 
      if (mapFile.content_type == "text/csv" && mapFile.path.split('.').last.to_s.downcase == 'csv')
        return true
      else 
        return false
      end
    end
    return true
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


