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

class AssignmentClustering < ActiveRecord::Base
  has_many :assignment_clusters, :dependent => :delete_all
  belongs_to :assignment

  validates_presence_of :assignment_id
  validates_numericality_of :coc, :allow_nil => false, :allow_blank => false, :greater_than => 0, :less_than_or_equal_to => 100
  validates_uniqueness_of :coc, :scope => [:assignment_id, :coc], :message => " of specified value has previously created"

  attr_accessor :type, :reported, :confirmed, :dateTime
  
  HUMANIZED_COLUMNS = {:coc => "Cut off criterion"}

  def self.human_attribute_name(attribute)
    HUMANIZED_COLUMNS[attribute.to_sym] || super
  end

  # Hack to enable read/write on column "type"
  def category
    attr_reader :type
  end

  # Hack to enable read/write on column "type"
  def category=(type)
    @type = type
  end
end
