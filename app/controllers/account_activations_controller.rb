class AccountActivationsController < ApplicationController
    skip_before_action :authorize
    def edit
        user = User.find_by(email: params[:email])
        if user && !user.activated? && user.authenticated?(:activation, params[:id])
            user.update_attribute(:activated,    true)
            user.update_attribute(:activated_at, Time.zone.now)
            flash[:notice] = "Account activated! Wait for the administrator to approve your account."
            redirect_to root_url
        else
            flash[:alert] = "Invalid activation link"
            redirect_to root_url
        end
    end
end
