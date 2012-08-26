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

class SubmissionClusterGroup < ActiveRecord::Base
  has_many :submission_clusters, :dependent => :delete_all
  belongs_to :assignment

  validates_presence_of :assignment_id
  validates_numericality_of :cut_off_criterion, allow_nil: false, allow_blank: false, greater_than: 0, less_than_or_equal_to: 100
  validates_uniqueness_of :cut_off_criterion, scope: [:assignment_id, :cut_off_criterion], :message => "has already been created"
end
