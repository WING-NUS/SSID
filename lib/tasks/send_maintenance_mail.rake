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
    desc "Sends maintenance email with custom start and end date"
    task :send_maintenance_mail => :environment do

    # Ask for starting time input
    print "Enter starting time of maintenance period (e.g. 28 Jan 2023 10:30 PM): "
    start_time_input = STDIN.gets.chomp

    # Ask for ending time input
    print "Enter ending time of maintenance period (e.g. 29 Jan 2023 06:30 AM): "
    end_time_input = STDIN.gets.chomp

    # Confirm the inputs
    puts "You have set the following maintenance period for the maintenance email:"
    puts "  Start time: #{start_time_input}"
    puts "  End time: #{end_time_input}"
    puts "Enter Y or y to proceed with sending the mail, or press any other key to abort..."

    confirmed = STDIN.getch.downcase
    
    if confirmed == 'y'
      courses = Course.all
      courses.each do |course|
        users_in_course = (UserCourseMembership.where(course_id: course.id)).map { |membership| User.find(membership.user_id)}
        users_in_course.each do |user|
          role_of_user = course.membership_for_user(User.find(user.id)).role
          if user.email != nil \
            && (role_of_user == UserCourseMembership::ROLE_TEACHING_STAFF \
              || role_of_user == UserCourseMembership::ROLE_TEACHING_ASSISTANT)
            puts "Maintenance email has been sent to " + user.email.strip
            MaintenanceMailer.maintenance_mailer(user.email, start_time_input, end_time_input).deliver_now
          end
        end
      end
    end
  end
end