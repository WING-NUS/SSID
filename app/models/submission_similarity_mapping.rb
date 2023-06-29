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

class SubmissionSimilarityMapping < ActiveRecord::Base
  belongs_to :submission_similarity
  has_many :submission_similarity_skeleton_mappings, :dependent => :delete_all, class_name: "SubmissionSimilaritySkeletonMapping"

  def line_range1
    (self.start_line1)..(self.end_line1)
  end

  def line_range2
    (self.start_line2)..(self.end_line2)
  end

  def line_range1_string
    "#{self.start_line1 + 1} &mdash; #{self.end_line1 + 1}".html_safe
  end

  def line_range2_string
    "#{self.start_line2 + 1} &mdash; #{self.end_line2 + 1}".html_safe
  end

  def line_ranges_html_value
    "#{self.start_line1}_#{self.end_line1}_#{self.start_line2}_#{self.end_line2}"
  end
end
