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

class Submission < ActiveRecord::Base
  has_many :similarities, class_name: "SubmissionSimilarity"
  has_many :cluster_memberships , class_name: "SubmissionClusterMembership"
  has_many :logs, :dependent => :delete_all, class_name: "SubmissionLog"
  belongs_to :student, class_name: "User"
  belongs_to :assignment

  serialize :lines, Array

  before_save :check_lines

  def course
    self.assignment.course
  end

  # Make sure that lines is an array
  def check_lines
    attr = self.read_attribute("lines")
    unless attr.class == Array
      attr = YAML::load(attr)
      raise unless attr.class == Array
      write_attribute("lines", attr)
    end
  end

  # Auto-(de)serialization does not work with the format written by snakeyaml java library,
  # So we force (de)serialize by overriding accessor methods
  def lines
    attr = self.read_attribute("lines")
    unless attr.class == Array
      attr = YAML::load(attr)
      raise unless attr.class == Array
    end
    attr
  end

  def student_id_string
    self.student.id_string
  end
end
