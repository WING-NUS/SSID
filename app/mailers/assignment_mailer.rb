class AssignmentMailer < ApplicationMailer
    
    def assignment_email
        @email_title = params[:email_title]
        mail(to: '', subject: email_title)
    end
      
end

