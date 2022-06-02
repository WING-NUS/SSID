class PasswordResetsController < ApplicationController
  HOST = "http://localhost:3000"

  skip_before_action :authorize

  def forget_password
    render 'forget_password'
  end

  def send_password_reset_link
    @user_email = params["user_email"]

    @user = User.find_by_email(@user_email)

    token = PasswordResetsHelper.generate_reset_token()
    if @user
      password_reset = PasswordReset.find_by_user_id(@user.id)

      if password_reset.nil?
        password_reset = PasswordReset.new { |pw|
          pw.user_id = @user.id
          pw.token = token
        }
      else
        # In case user makes another request to reset password, update token and send email again.
        password_reset.token = token
      end

      if password_reset.valid?
        password_reset.save

        reset_link = "#{HOST}/reset_password/#{token}"
        begin
          UserMailer.password_reset(@user_email, reset_link).deliver_now
        rescue => exception
          logger.error("Failed to deliver password reset link to: #{@user_email}")
        end
      end
    end  
    
    
    render 'send_password_reset_link'
  end

  def reset_password
    @valid_token = false

    @user_token = params["token"]
    now = Time.now.getutc

    password_resets = PasswordReset.where(["token = ? AND updated_at > ? AND updated_at < ? ", @user_token, now - 30.minutes, now])
    @valid_token = password_resets.length > 0 ? true : @valid_token
    @user_id = @valid_token ? password_resets.first.user_id : nil   

  end

  def update_password
    @user = User.find_by_id(params["user_id"])

    @user.errors.add :new_password, "cannot be blank" if params["new_password"].empty?
    @user.errors.add :new_password, "must be at least #{User::MIN_PASSWORD_LENGTH} characters long" if params["new_password"].length < User::MIN_PASSWORD_LENGTH
    @user.errors.add :confirm_new_password, "does not match new password" if params["new_password"] != params["confirm_new_password"]

    @user.password_digest = BCrypt::Password.create(params["new_password"]) if @user.errors.empty?

    if @user.errors.empty? && @user.save
      # Remove token record in db upon updating user successfully
      password_reset = PasswordReset.find_by_user_id(@user.id)
      password_reset.destroy
      
      redirect_to login_url, notice: 'User password was successfully reset.'
    else
      redirect_to login_url, alert: 'Failed to reset the password.'
    end
  end
end
