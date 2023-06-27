class UserMailer < ApplicationMailer
  default from: ApplicationHelper::EMAIL_DEFAULT_SENDER

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
