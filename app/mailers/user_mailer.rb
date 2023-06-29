class UserMailer < ApplicationMailer
  default from: ApplicationHelper::EMAIL_DEFAULT_SENDER

  def reset_link(user_email, reset_link)
    @reset_link = reset_link
    mail(to: user_email, subject: "[SSID] Reset your password")
  end

  def reset_link_non_existent_account(user_email)
    mail(to: user_email, subject: "[SSID] Reset your password")
  end

  def password_reset(user_email, reset_time)
    @user_email = user_email
    @reset_time = reset_time
    mail(to: user_email, subject: "[SSID] Your SSID password has been reset.")
  end

  def account_activation(user)
    @user = user
    @user_email = user.email
    @user_name = user.name
    mail(to: @user_email, subject: "[SSID] Activate your account")
  end
  
  def admin_approved(user)
    @user = user
    mail(to: @user.email, subject: "[SSID] Your account has been approved.")
  end
end
