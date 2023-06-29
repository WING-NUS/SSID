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
require 'submissions_handler'

namespace :SSID do
  desc "Process waiting assignments"
  task :process_waiting_assignment => :environment do
    if ApplicationHelper.is_application_healthy() 
      waiting_process = SubmissionSimilarityProcess.where(status: SubmissionSimilarityProcess::STATUS_WAITING).order(created_at: :asc).first
      if waiting_process
        waiting_assignment = Assignment.find_by_id(waiting_process.assignment_id)

        compare_dir = File.join(".", "upload", waiting_assignment.id.to_s, "_compare")
        puts "Process waiting assignment: #{waiting_assignment.id.to_s}"
        SubmissionsHandler.fork_Java_process(compare_dir, waiting_assignment, waiting_assignment.mapbox)
      end
    end
  end
end