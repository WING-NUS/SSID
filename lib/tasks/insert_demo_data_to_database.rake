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

namespace :SSID do
  desc "Inserts data for demonstration into the database"
  task :insert_demo_data_to_database => :environment do
    # Create new course
    course = Course.where( code: "CS1101", academic_year: "2011/2012", semester: 2 ).first
    course = Course.create { |c|
      c.code = "CS1101"
      c.name = "Introduction to Programming Languages"
      c.academic_year = "2011/2012"
      c.semester = 2
      c.expiry = 1.year.from_now
    } unless course

    # Create announcement for course
    if course.announcements.empty?
      course.announcements.create(html_content: "Welcome to SSID. A plagiarism detection system developed in NUS.")
    end

    # Create teaching staff for course
    staff = User.find_by_id_string("SSID01")
    unless staff
      staff = User.create { |user|
        user.name = "demo_staff"
        user.full_name = "SSID Demo Staff"
        user.id_string = "SSID01"
        user.password_digest = BCrypt::Password.create('$$SSIDPassword$$')
      }
      membership = UserCourseMembership.create { |m|
        m.role = UserCourseMembership::ROLE_TEACHING_STAFF
        m.user = staff
        m.course = course
      }
    end
  end
end
