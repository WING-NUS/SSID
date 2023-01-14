# frozen_string_literal: true

class Users::SessionsController < Devise::SessionsController
  # before_action :configure_sign_in_params, only: [:create]

  # GET /resource/sign_in
  # def new
  #   super
  # end

  # POST /resource/sign_in
  # def create
  #   super
  # end

  # DELETE /resource/sign_out
  # def destroy
  #   super
  # end

  
  skip_before_action :authenticate_user!, only: [:new, :create, :index]

  def index
    render "layouts/cover"
  end

  def new
    super
  end
  #orRgKyGUs7cz
  def create
    user = User.find_by_email(params[:user][:email])
    # byebug
    if user and user.valid_password?(params[:user][:password]) and user.is_admin_approved
      if user.confirmed?
        sign_in user
        redirect_to root_url
      else
        redirect_to new_user_session_url, alert: "Your account is not confirmed. Please check your email for the confirmation link."
      end
    else
      redirect_to new_user_session_url, alert: "Invalid user/password combination or user account is still being processed."
    end
  end


  def destroy
    sign_out current_user
    redirect_to root_url
  end

  # protected

  # # If you have extra params to permit, append them to the sanitizer.
  # def configure_sign_in_params
  #   devise_parameter_sanitizer.permit(:sign_in, keys: [:email, :password, :remember_me])
  # end
end
