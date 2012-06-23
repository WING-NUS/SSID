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
    has_many :sim_results, :dependent => :delete_all, :class_name => "AssignmentSimResult"
    has_many :clusterings, :dependent => :delete_all, :class_name => "AssignmentClustering", :order => "coc DESC"
    has_many :reported_plagiarism, :class_name => "AssignmentSimResult", :conditions => "status = 3"
    has_many :confirmed_plagiarism, :class_name => "AssignmentSimResult", :conditions => "status = 2"
    has_many :plagiarism, :class_name => "AssignmentSimResult", :conditions => "status = 2 OR status = 3"
    belongs_to :course

    validates_presence_of :title

    attr_accessor :min, :ngram
    validate :verification

    def language
        @lanugage
    end

    private
    def verification
      begin
        raise if Integer(min) <= 0
      rescue
        errors.add("Minimum matching criterion must be an integer and greater than 0")
      end
      begin
        raise if Integer(ngram) <= 0
      rescue
        errors.add("N-Gram index size must be an integer and greater than 0")
      end
    end
end
