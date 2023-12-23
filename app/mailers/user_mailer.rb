class UserMailer < ApplicationMailer
  default from: ApplicationHelper::EMAIL_DEFAULT_SENDER
  
  def admin_approved(user)
    @user = user
    mail(to: @user.email, subject: "[SSID] Your account has been approved.")
  end
end
