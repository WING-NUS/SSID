class MaintenanceMailer < ApplicationMailer
    default from: ApplicationHelper::EMAIL_DEFAULT_SENDER

    def maintenance_mailer(user_email, start_time, end_time)
        @start_time = start_time
        @end_time = end_time
        mail(to: user_email, subject: "Scheduled maintenance for SSID")
      end
end