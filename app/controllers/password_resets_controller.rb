class PasswordResetsController < ApplicationController
  skip_before_action :authorize

  def forget_password
  end

  def send_password_reset_link
    host = Rails.application.config.host
    @user_email = params["user_email"]

    user = User.find_by_email(@user_email)

    token = PasswordResetsHelper.generate_reset_token()
    if user
      password_reset = PasswordReset.find_by_user_id(user.id)

      if password_reset.nil?
        password_reset = PasswordReset.new { |pw|
          pw.user_id = user.id
          pw.token = token
        }
      else
        # In case user makes another request to reset password, update token and send email again.
        password_reset.token = token
      end

      if password_reset.valid?
        password_reset.save

        reset_link = "#{host}/reset_password/#{token}"
      end
    end
      
    begin
      if user
        UserMailer.reset_link(@user_email, reset_link).deliver_now
      elsif UsersHelper.is_valid_email?(@user_email)
        UserMailer.reset_link_non_existent_account(@user_email).deliver_now
      else
        # do nothing
      end
    rescue => exception
      logger.error("Failed to deliver password reset link to: #{@user_email} with message: #{exception.message}")
      trace = exception.backtrace.join("\n")
      logger.error(trace)
    end  
        
    render 'send_password_reset_link'
  end

  def reset_password
    @user_token = params["token"]
    @valid_token = is_valid_token(@user_token)
  end

  def update_password
    user_token = params["user_token"]
    @user = User.joins(:password_resets).where(:password_resets => {:token => user_token}).first

    UsersHelper.validate_password(@user, params["new_password"], params["confirm_new_password"])

    @user.password_digest = BCrypt::Password.create(params["new_password"]) if @user.errors.empty?

    if @user.errors.empty? && @user.save
      # Remove token record in db upon updating user successfully
      password_reset = PasswordReset.find_by_user_id(@user.id)
      password_reset.destroy

      reset_time = Time.now
      UserMailer.password_reset(@user.email, reset_time).deliver_now
     
      redirect_to login_url, notice: 'User password was successfully reset.'
    else
      redirect_to login_url, alert: 'User password failed to be reset.'
    end
  end

  private

  def is_valid_token(token)
    now = Time.now.getutc

    # Token will be expired after 30 minutes counting from its creation time
    password_resets = PasswordReset.where(["token = ? AND updated_at > ? AND updated_at < ? ", token, now - 30.minutes, now])
    return password_resets.length > 0
  end

  
end
