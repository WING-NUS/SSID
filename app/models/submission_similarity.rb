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

class SubmissionSimilarity < ActiveRecord::Base
  # SubmissionSimilarity#status Constants
  STATUS_NOT_PLAGIARISM = 0
  STATUS_CONFIRMED_AS_PLAGIARISM = 1
  STATUS_SUSPECTED_AS_PLAGIARISM = 2
  STATUS_STRINGS = [
    "",
    "Confirmed Plagiarism",
    "Suspected of Plagiarism"
  ]

  belongs_to :assignment
  belongs_to :submission1, class_name: "Submission"
  belongs_to :submission2, class_name: "Submission"
  has_one :course, :through => :assignment
  has_many :mappings, :dependent => :delete_all, :class_name => "SubmissionSimilarityMapping"

  def status_string
    STATUS_STRINGS[self.status]
  end

  def average_similarity
    0.5 * (self.similarity_1_to_2 + self.similarity_2_to_1)
  end

  def student1
    # Issue8: Is it where we should add the segment lines? Shall we directly change the submission1 file?
    self.submission1.student
  end

  def student2
    self.submission2.student
  end

  def other_student(student)
    (student == submission1.student) ? submission2.student : submission1.student
  end

  def other_submission(student)
    (student == submission1.student) ? submission2 : submission1
  end
end
