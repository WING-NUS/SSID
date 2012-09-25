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

class Course < ActiveRecord::Base
  has_many :announcements, :as => :announceable
  has_many :assignments, :dependent => :delete_all
  has_many :memberships, class_name: "UserCourseMembership", :dependent => :delete_all
  has_many :student_memberships, class_name: "UserCourseMembership", conditions: { role: UserCourseMembership::ROLE_STUDENT }
  has_many :students, :through => :student_memberships, class_name: "User", :source => UserCourseMembership, uniq: true
  has_many :staff_memberships, class_name: "UserCourseMembership", conditions: { role: UserCourseMembership::ROLE_TEACHING_STAFF }
  has_many :staff, :through => :staff_memberships, class_name: "User", :source => UserCourseMembership, uniq: true
  has_many :teaching_assistant_memberships, class_name: "UserCourseMembership", conditions: { role: UserCourseMembership::ROLE_TEACHING_ASSISTANT }
  has_many :teaching_assistants, :through => :teaching_assistant_memberships, class_name: "User", :source => UserCourseMembership, uniq: true

  validates_presence_of :code
  before_save :upcase_code

  def submission_cluster_groups
    self.assignments.collect { |assignment|
      assignment.submission_cluster_groups.collect { |group|
        group.submission_clusters
      }
    }.flatten
  end

  private

  def upcase_code
    self.code = self.code.upcase
  end
end
