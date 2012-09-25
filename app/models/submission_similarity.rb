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
  STATUS_NO_PLAGIARISM = 0
  STATUS_UNMARKED_AS_PLAGIARISM = 1
  STATUS_MARKED_AS_PLAGIARISM = 2
  STATUS_SUSPECTED_AS_PLAGIARISM = 3

  belongs_to :assignment
  belongs_to :submission1, class_name: "Submission"
  belongs_to :submission2, class_name: "Submission"
  has_one :course, :through => :assignment
  has_many :mappings, :dependent => :delete_all, :class_name => "SubmissionSimilarityMapping"
  has_many :logs, :dependent => :delete_all, class_name: "SubmissionSimilarityLog"

  def log1
    SubmissionSimilarityLog.where(["submission_id = :s AND submission_similarity_id = :ss", 
                                   { s: self.submission1.id, ss: self.id }])  
  end

  def log2
    SubmissionSimilarityLog.where(["submission_id = :s AND submission_similarity_id = :ss", 
                                   { s: self.submission2.id, ss: self.id }])  
  end
end
