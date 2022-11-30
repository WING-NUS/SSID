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

class SubmissionCluster < ActiveRecord::Base
  belongs_to :submission_cluster_group
  has_many :memberships, class_name: "SubmissionClusterMembership", :dependent => :delete_all
  has_many :submissions, -> { distinct }, :through => :memberships
  
  def submission_student_ids
    self.submissions.collect { |s|
      s.student.name
    }
  end

  def assignment
    self.submission_cluster_group.assignment
  end

  def course
    self.assignment.course
  end
end
