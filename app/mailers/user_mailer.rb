class UserMailer < ApplicationMailer
  default from: "no-reply@ssid.comp.nus.edu.sg"

  def reset_link(user_email, reset_link)
    @reset_link = reset_link
    mail(to: user_email, subject: "[SSID] Reset your password")
  end

  def password_reset(user_email, reset_time)
    @user_email = user_email
    @reset_time = reset_time
    mail(to: user_email, subject: "[SSID] Your SSID password has been reset.")
  end
end
