# Preview all emails at http://localhost:3000/rails/mailers/maintenance_mailer
class MaintenanceMailerPreview < ActionMailer::Preview
    def maintenance_mailer
        MaintenanceMailer.maintenance_mailer("test@example.com", "Monday, 25 July 2022 13:00:00", "Monday, 25 July 2022 17:00:00")
    end
end
