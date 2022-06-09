module UsersHelper
  private

  def self.validate_password(user, password, confirm_password)
    user.errors.add :password, "cannot be blank" if password.empty?
    user.errors.add :password, "must be at least #{User::MIN_PASSWORD_LENGTH} characters long" if password.length < User::MIN_PASSWORD_LENGTH
    user.errors.add :confirm_password, "does not match password" if password != confirm_password    
  end

  def self.validate_email(user, email)
    user.errors.add :email, "cannot be blank" if email.empty?
    user.errors.add :email, "can contain alphanumeric, _ (underscore), - (hyphen), and . (dot) characters" unless is_valid_email?(email)
  end

  def self.is_valid_email?(email)
    email_pattern = /^[\w\.-]+@([\w-]+\.)+[\w-]{2,4}$/
    is_valid_email = (email =~ email_pattern)
  end

  
end