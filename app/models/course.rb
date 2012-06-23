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
  has_many :teachings, :dependent => :delete_all
  has_many :accounts, :through => :teachings, :uniq => true
  has_many :assignments, :dependent => :delete_all
  
  validates_presence_of :code
  before_save :upcase_code

  def academic_year_start
    @academic_year_start
  end
  def academic_year_start=(ays)
    @academic_year_start = ays
    return if @academic_year_start.blank?
    create_academic_year
  end

  #return the number of clusters in this course
  def clusters
    count = 0
    self.assignments.each { |assignment|
      assignment.clusterings.each { |clustering|
        count += clustering.assignment_clusters.size
      }
    }
    count
  end

  private
  def create_academic_year
    self.academic_year = self.academic_year_start + '/' + (Integer(self.academic_year_start) + 1).to_s
  end
  
  def upcase_code
    self.code = self.code.upcase
  end
end
