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

class Assignment < ActiveRecord::Base
  has_many :submission_similarities, :dependent => :delete_all
  has_many :submission_cluster_groups, :dependent => :delete_all, order: "cut_off_criterion DESC"
  has_many :submission_similarity_processes
  has_many :suspicious_submission_similarities, class_name: "SubmissionSimilarities", conditions: "status = #{SubmissionSimilarity::STATUS_SUSPECTED_AS_PLAGIARISM}"
  has_many :plagiarism_marked_submission_similarities, class_name: "SubmissionSimilarities", conditions: "status = #{SubmissionSimilarity::STATUS_MARKED_AS_PLAGIARISM}"
  belongs_to :course

  validates_presence_of :title
  validates_numericality_of :min_match_length, only_integer: true, greater_than: 0
  validates_numericality_of :ngram_size, only_integer: true, greater_than: 0
end
