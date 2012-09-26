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
