class CoursesService
  def self.create_guest_membership(course, user)
    membership = UserCourseMembership.new { |m|
      m.role = 3
      m.user = user
      m.course = course
    }
    raise ActiveRecord::RecordNotSaved unless membership.save!    
  end

  def self.create_guest_detail_entry(assignment, user)
    course = assignment.course
    if course
      # create entry under guest user
      guest_detail = GuestUsersDetail.new { |detail|
        detail.user_id = user.id
        detail.course_id = course.id
        detail.hash_string = user.full_name
        detail.assignment_id = assignment.id
      }
      raise ActiveRecord::RecordNotSaved unless guest_detail.save!
    end    
  end
end