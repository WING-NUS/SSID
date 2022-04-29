class SubmissionSimilaritiesService
  def self.create_guest_entry(assignment, user)
    # putting log to log out @user
    byebug
    course = assignment.course
    if course
      membership = UserCourseMembership.new { |m|
        m.role = 3
        m.user = user
        m.course = course
      }
      raise ActiveRecord::RecordNotSaved unless membership.save!  

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