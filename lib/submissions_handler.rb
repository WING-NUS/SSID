require 'zip/zip'

module SubmissionsHandler
  def self.process_upload(file, assignment)
    upload_dir = File.join(Rails.root, "upload", assignment.id.to_s)

    # Clear upload dir if exists
    FileUtils.rm_r upload_dir if File.exist? upload_dir

    # Create upload dir
    FileUtils.mkdir_p(upload_dir)

    # Keep log
    upload_log = []
    upload_log << assignment.upload_log if assignment.upload_log
    upload_log << %Q{[#{Time.now.in_time_zone}] Received file: #{file.original_filename}}

    # Rename upload to original file name
    upload_file = File.join(upload_dir, file.original_filename)

    # Move upload into dir
    FileUtils.mv file.tempfile.path, upload_file
    
    # Extract submissions into dir
    Zip::ZipFile.open(upload_file) { |zip_file|
      zip_file.each { |f|
        upload_log << %Q{[#{Time.now.in_time_zone}] Extracting #{f.name}}
        zip_file.extract(f, File.join(upload_dir, f.name))
      }
    }

    # Save log
    upload_log << %Q{[#{Time.now.in_time_zone}] Unzip complete}
    assignment.upload_log = upload_log.join("\n")
    assignment.save

    # Remove zip file
    FileUtils.rm upload_file, force: true

    # Return path to dir
    upload_dir
  end

  def self.process_submissions(path, assignment)
    # Create directory for code comparison, delete first if necessary
    compare_dir = File.join(path, "_compare")
    FileUtils.rm(compare_dir, force: true) if File.exist? compare_dir
    FileUtils.mkdir_p(File.join(path, "_compare"))
    
    # For each student submission, combine the code files into one
    Dir.glob(File.join(path, "*")).each { |subpath|
      next if subpath == compare_dir

      # Combine code files and write into compare dir as new file with same name, remove ext if any
      File.open(File.join(compare_dir, File.basename(subpath, File.extname(subpath))), 'w') { |f|
        f.puts string_from_combined_files(subpath)
      }
    }

    # Read database configuration
	  config   = Rails.configuration.database_configuration
	  host     = config[Rails.env]["host"]
	  database = config[Rails.env]["database"]
	  username = config[Rails.env]["username"]
	  password = config[Rails.env]["password"]

    # Run the java program and get its pid
    command = %Q{java -Xmx1024M -jar "#{Rails.application.config.plagiarism_detection_path}" } + 
              %Q{#{assignment.id} #{compare_dir} #{assignment.language.downcase} } +
              %Q{#{assignment.min_match_length} #{assignment.ngram_size} } +
              %Q{#{host} #{database} #{username} #{password} 2>&1}

    # Fork to run java program in background
    ruby_pid = Process.fork do
      java_log = ""
      IO.popen(command) { |pipe|
        java_log << pipe.gets until pipe.eof?
      }
      java_status = $?

      # Update log
      upload_log = []
      upload_log << assignment.upload_log if assignment.upload_log
      upload_log << java_log
      assignment.upload_log = upload_log.join("\n")
      
      # Update status
      process = assignment.submission_similarity_process
      if java_status.exitstatus == 0
        process.status = SubmissionSimilarityProcess::STATUS_COMPLETED
      else
        process.status = SubmissionSimilarityProcess::STATUS_ERRONEOUS
      end

      # Save
      assignment.transaction do
        assignment.save
        process.save
      end
    end

    # Create process with pid
    SubmissionSimilarityProcess.create do |p|
      p.assignment_id = assignment.id
      p.pid = ruby_pid
      p.status = SubmissionSimilarityProcess::STATUS_RUNNING
    end

    Process.detach(ruby_pid) # Parent will not wait
  end

  def self.process_cluster_group(cluster_group)
    # Get assignment
    assignment = cluster_group.assignment

    # Read database configuration
	  config   = Rails.configuration.database_configuration
	  host     = config[Rails.env]["host"]
	  database = config[Rails.env]["database"]
	  username = config[Rails.env]["username"]
	  password = config[Rails.env]["password"]

    # Run the java program and get its pid
    command = %Q{java -Xmx1024M -jar "#{Rails.application.config.submissions_clustering_path}" } + 
              %Q{#{assignment.id} #{cluster_group.id} #{cluster_group.cut_off_criterion} } +
              %Q{#{host} #{database} #{username} #{password} 2>&1}

    java_log = ""
    IO.popen(command) { |pipe|
      java_log << pipe.gets until pipe.eof?
    }
    java_status = $?

    raise "Submissions clustering error: #{java_log}" unless java_status.exitstatus == 0
  end

  private

  def self.string_from_combined_files(path)
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
