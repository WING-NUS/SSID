class UserMailer < ApplicationMailer
  default from: "no-reply@ssid.com"

  def password_reset(user_email)
    mail(to: user_email, subject: "[SSID] Reset your password")
  end
end
