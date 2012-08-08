# This file is part of SSID.
# 
# SSID is free software: you can redistribute it and/or modify
# it under the terms of the GNU Lesser General Public License as published by
# the Free Software Foundation, either version 3 of the License, or
# (at your option) any later version.
# 
# SSID is distributed in the hope that it will be useful,
# but WITHOUT ANY WARRANTY; without even the implied warranty of
# MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
# GNU Lesser General Public License for more details.
# 
# You should have received a copy of the GNU Lesser General Public License
# along with SSID.  If not, see <http://www.gnu.org/licenses/>. 

#This task is designed to serve as a background thread.
#This is used to check assignment for plagiarism when the assignment is first created

task :check_plag => :environment do

  jar_path = ENV["JAR_PATH"]
  assignment_id = ENV["ASSIGNMENT_ID"]
  compare_folder_path = ENV["COMPARE_FOLDER_PATH"]
  language = ENV["LANGUAGE"]
  min = ENV["MIN"]
  ngram = ENV["NGRAM"]
  host = ENV["HOST"]
  name = ENV["DB"]
  user = ENV["USER"]
  pwd = ENV["PWD"]
    
  CheckPlagId.transaction do
    process = CheckPlagId.find_by_assignment_id(assignment_id, :lock => true)
    if (process == nil)
      puts "~~~~~~~~~~~~~~~~~~~~~~~Check Plag 1: Process == nil~~~~~~~~~~~~~~~~~~~~~~~"
      raise ActiveRecord::Rollback 
      return
    end
    process.update_attribute(:pid, Process.pid)
  end
    
  assignment = Assignment.find(assignment_id)
  
  success = system "java -Xmx1024M -jar \"#{jar_path}\" #{assignment_id} #{compare_folder_path} #{language} #{min} #{ngram} #{host} #{name} #{user} #{pwd} >> upload_log/#{assignment_id}"

  CheckPlagId.transaction do
    process = CheckPlagId.find_by_pid(Process.pid, :lock => true)
    if (process == nil)
      puts "~~~~~~~~~~~~~~~~~~~~~~~Process is deleted~~~~~~~~~~~~~~~~~~~~~~~"
      raise ActiveRecord::Rollback 
      return
    end
    if (!success)
      puts "Assignment #{assignment_id} has checked with error(s)"
      assignment.update_attribute(:status, -2)
    else
      puts "Assignment #{assignment_id} has checked successfully"
      assignment.update_attribute(:status, 0)
    end
    process.delete
  end
  
  
  
end
