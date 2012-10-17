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

class User < ActiveRecord::Base
  MIN_PASSWORD_LENGTH = 6

  has_many :memberships , class_name: "UserCourseMembership", :dependent => :delete_all
  has_many :courses, :through => :memberships, :uniq => true
  has_many :assignments, :through => :courses, :uniq => true
  has_many :submissions, foreign_key: "student_id"

  validates :name, :password_digest, presence: true
  validates :name, :id_string, uniqueness: true
  validates :id_string, presence: true, :unless => :is_admin 

  has_secure_password
end
