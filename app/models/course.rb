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
  has_many :announcements, :as => :announceable, order: "updated_at DESC"
  has_many :assignments, :dependent => :delete_all
  has_many :memberships, class_name: "UserCourseMembership", :dependent => :delete_all
  has_many :users, :through => :memberships
  has_many :student_memberships, class_name: "UserCourseMembership", conditions: { role: UserCourseMembership::ROLE_STUDENT }
  has_many :staff_memberships, class_name: "UserCourseMembership", conditions: { role: UserCourseMembership::ROLE_TEACHING_STAFF }
  has_many :teaching_assistant_memberships, class_name: "UserCourseMembership", conditions: { role: UserCourseMembership::ROLE_TEACHING_ASSISTANT }

  validates_presence_of :code
  validates :code, uniqueness: { :scope => [ :academic_year, :semester ] }
  before_save :upcase_code

  def code_and_name
    [self.code, self.name].join(" ")
  end

  def students
    self.student_memberships.collect { |m| m.user }
  end

  def staff
    self.staff_memberships.collect { |m| m.user }
  end

  def teaching_assistants
    self.teaching_assistant_memberships.collect { |m| m.user }
  end

  def submission_cluster_groups
    self.assignments.collect { |assignment|
      assignment.submission_cluster_groups
    }.flatten
  end

  def submission_clusters
    self.assignments.collect { |assignment|
      assignment.submission_clusters
    }.flatten
  end

  def processing_assignments
    self.assignments.reject { |a|
      a.submission_similarity_process.nil? or 
        a.submission_similarity_process.status != SubmissionSimilarityProcess::STATUS_RUNNING
    }
  end

  def processed_assignments
    self.assignments.reject { |a|
      a.submission_similarity_process.nil? or 
        a.submission_similarity_process.status != SubmissionSimilarityProcess::STATUS_COMPLETED
    }
  end

  def erroneous_assignments
    self.assignments.reject { |a|
      a.submission_similarity_process.nil? or 
        a.submission_similarity_process.status != SubmissionSimilarityProcess::STATUS_ERRONEOUS
    }
  end

  def membership_for_user(user)
    UserCourseMembership.where( course_id: self.id, 
                               user_id: user.id).first
  end

  def role_string_for_user(user)
    self.membership_for_user(user).role_string
  end

  def all_submission_similarity_cluster_groups
    self.assignments.collect { |a|
      a.submission_cluster_groups
    }.flatten
  end

  def cluster_students
    self.assignments.collect { |a|
      a.cluster_students
    }.flatten.uniq.sort
  end

  private

  def upcase_code
    self.code = self.code.upcase
  end
end
