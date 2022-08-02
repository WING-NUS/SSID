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
  MIN_PASSWORD_LENGTH = 8

  has_many :memberships , class_name: "UserCourseMembership", :dependent => :delete_all
  has_many :guest_users_detail, class_name: "GuestUsersDetail", :dependent => :delete_all
  has_many :courses, -> { distinct }, :through => :memberships
  has_many :assignments, -> { distinct }, :through => :courses
  has_many :submissions, foreign_key: "student_id"
  has_many :password_resets, class_name: "PasswordReset"

  validates :username, :password_digest, presence: true
  validates :username, :id_string, uniqueness: true
  validates :id_string, presence: true, if: -> {is_admin == false}
  validates :email, presence: true
  # This method is used to validate the user's password during account creation and and modification.
  # The if -> {password.present?} allows skipping of this validation other fields are chaned but the password is unchanged
  validate :validate_password, if: -> {password.present?}
  # This method is used to validate the user's email during account creation and and modification.
  # The if -> {email.present?} allows skipping of this validation other fields are chaned but the email is unchanged
  validate :validate_email, if: -> {email.present?}

  has_secure_password
  before_destroy :ensure_an_admin_remains

  def is_some_staff?
    self.courses.any? { |c| c.membership_for_user(self).role == UserCourseMembership::ROLE_TEACHING_STAFF }
  end

  def is_staff_or_ta?
    UserCourseMembership.where(["user_id = ? AND role IN (?, ?)", self.id, 0, 1])
  end

  def full_name
    the_full_name = self.read_attribute(:full_name) || ""
    the_full_name.strip.empty? ? nil : the_full_name
  end

  

  private

  def ensure_an_admin_remains
    if self.is_admin and User.where(is_admin: true).count == 1
      errors.add :base, "Cannot delete last admin"
      false
    else
      true
    end
  end

  def validate_password
    errors.add :password, "cannot be blank" if password.empty?
    errors.add :password, "must be at least #{User::MIN_PASSWORD_LENGTH} characters long" if password.length < User::MIN_PASSWORD_LENGTH
    errors.add :password, "must contain at least 1 lower case character" if (password =~ /[a-z]+/).nil?
    errors.add :password, "must contain at least 1 upper case character" if (password =~ /[A-Z]+/).nil?
    errors.add :password, "must contain at least 1 digit or special character" if (password =~ /[0-9~!@#$%^&*()+=|]+/).nil?
  end

  def validate_email
    errors.add :email, "cannot be blank" if email.empty?
    errors.add :email, "can contain alphanumeric, _ (underscore), - (hyphen), and . (dot) characters" unless is_valid_email?(email)
  end

  def is_valid_email?(email)
    email_pattern = /^[\w\.-]+@([\w-]+\.)+[\w-]{2,4}$/
    is_valid_email = (email =~ email_pattern)
  end  

end
