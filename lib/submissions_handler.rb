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
require 'open3'

class ReorgBot

  attr_accessor :path
  attr_accessor :dir

  def initialize(path)
    raise ArgumentError, "path '#{path}' does not exist!" unless File.exist?(path)
    raise ArgumentError, "path '#{path} is not a directory you dolt!" unless File.directory?(path)
    @path = path
    @dir = Dir.new(path)
  end

  def dirs
    @dir.select { |f| File.directory?(File.join(@path, f)) }
  end

  def empty_dirs
    dirs.select { |d| Dir[File.join(@path, d, '*')].empty? }
  end

  def non_empty_dirs
    dirs - empty_dirs
  end

  def remove_empty_dirs
    log = [];
    empty_dirs.each do |d|
      FileUtils.rm_rf(File.join(@path, d))
      log << %Q{[#{Time.now.in_time_zone}] Deleting directory: #{File.join(@path, d)}}
    end
    log
  end
end

module SubmissionsHandler
  def self.process_upload(file, assignment)
    upload_dir = File.join(".", "upload", assignment.id.to_s)

    # Clear upload dir if exists
    FileUtils.remove_dir upload_dir if File.exist? upload_dir

    # Create upload dir
    FileUtils.mkdir_p(upload_dir)

    # Keep log
    upload_log = []
    upload_log << assignment.upload_log if assignment.upload_log
    upload_log << %Q{[#{Time.now.in_time_zone}] Received file: #{file.original_filename}}


    # Rename upload to original file name
    upload_file = File.join(upload_dir, file.original_filename)

    # Move upload into dir
    FileUtils.copy_entry(file.path, upload_file)

    # Add filters for file types
    accepted_formats = [".py",".java", ".cpp", ".c", ".h", ".scala", ".ml", ".mli"]

    # Extract submissions into dir
    Zip::File.open(upload_file) { |zip_file|
      zip_file.each { |f|
      # isdirectory or filter by accepted file extension
      if !f.file? or accepted_formats.include? File.extname(f.name)
        upload_log << %Q{[#{Time.now.in_time_zone}] Extracting #{f.name}}
        # Obtain File Path
        f_path = File.join(upload_dir, f.name)
        # Create Directory
        FileUtils.mkdir_p(File.dirname(f_path))
        # Extract files into the file path
        zip_file.extract(f, f_path) unless File.exist?(f_path)

        # Reject files that passed the extension test but might be a binary file in disguise
        # if f.file? filepath
        #   upload_log << %Q{[#{Time.now.in_time_zone}] Detected binary file, deleting #{f.name}}
        #   FileUtils.rm filepath
        # end
      else
        upload_log << %Q{[#{Time.now.in_time_zone}] Invalid file type, Ignoring #{f.name} with extension #{File.extname(f.name)}}
      end
      }
    }
    
    upload_log << %Q{[#{Time.now.in_time_zone}] Checking for empty directories}
    bot = ReorgBot.new(upload_dir)
    upload_log << bot.remove_empty_dirs

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
              %Q{#{host} #{database} #{username} #{password}}
    # Fork to run java program in background
    ruby_pid = Process.fork do
      java_log = ""
      java_status = nil
      Open3.popen2e({ "LD_LIBRARY_PATH" => Rails.application.config.ld_library_path }, command) { |i,o,t|
        java_log << o.gets until o.eof?
        java_status = t.value
      }

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
