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

  
  skip_before_action :authenticate_user!, only: [:new, :create, :check_hash, :index]

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

  def check_hash
    # obtain the hash
    input_hash = params[:id]
    # verify the hash
    guest_user = GuestUsersDetail.find_by_hash_string(params[:user][:id])
    # allow access if the hash is verified and else redirect to login page
    if guest_user
      session[:user_id] = guest_user.user_id
      redirect_to root_url
    else
      redirect_to login_url, alert: "The hash is not valid. Please use a valid sharable link or log in with your credientals."
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
