class UserMailer < ApplicationMailer
  default from: "no-reply@ssid.comp.nus.edu.sg"

  def password_reset(user_email, reset_link)
    @reset_link = reset_link
    mail(to: user_email, subject: "[SSID] Reset your password")
  end
end
