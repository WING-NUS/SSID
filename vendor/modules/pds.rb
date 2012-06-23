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

def CompareMethods.pds(assignment_id, compare_folder_path, language, min, ngram, host, db, user, pwd)
  jar_path = File.join(JAVA_ROOT, "programs", "PlagiarismDetection.jar")
  #assignment_id, compare_folder_path, language, min_matching_criteria_(statement), n-gram_size

  command = "rake JAR_PATH=#{jar_path} ASSIGNMENT_ID=#{assignment_id} COMPARE_FOLDER_PATH=#{compare_folder_path} LANGUAGE=#{language} MIN=#{min} NGRAM=#{ngram} HOST=#{host} DB=#{db} USER=#{user} PWD=#{pwd} check_plag &"
  #command = "java -Xmx1024M -jar \"#{jar_path}\" #{assignment_id} #{compare_folder_path} #{language} #{min} #{ngram} >> upload_log/#{assignment_id} &"
  system command
  
end
