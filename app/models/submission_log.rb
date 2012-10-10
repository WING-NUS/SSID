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

class SubmissionLog < ActiveRecord::Base
  # SubmissionLog#log_type Constants
  TYPE_PAIR_SUSPECT_AS_PLAGIARISM = 0
  TYPE_PAIR_UNSUSPECT_AS_PLAGIARISM = 1
  TYPE_PAIR_CONFIRM_AS_PLAGIARISM = 2
  TYPE_PAIR_UNCONFIRM_AS_PLAGIARISM = 3
  TYPE_STUDENT_MARK_AS_GUILTY = 4
  TYPE_STUDENT_MARK_AS_NOT_GUILTY = 5
  TYPE_TEMPLATE_STRINGS = [
    "Suspect as plagiarism with submission by ",
    "Remove suspicion of plagiarism with submission by ",
    "Confirmed plagiarism with submission by ",
    "Remove confirmation of plagiarism with submission by ",
    "Marked as guilty of plagiarism of submission by ",
    "Unmarked as guilty of plagiarism of submission by "
  ]

  belongs_to :marker, class_name: "User"
  belongs_to :submission
  belongs_to :submission_similarity

  def log_string
    TYPE_TEMPLATE_STRINGS[self.log_type] + self.submission_similarity.other_student(self.submission.student).id_string
  end
end
