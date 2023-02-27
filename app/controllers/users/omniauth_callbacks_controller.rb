# frozen_string_literal: true

class Users::OmniauthCallbacksController < Devise::OmniauthCallbacksController
  # You should configure your model like this:
  # devise :omniauthable, omniauth_providers: [:twitter]

  # You should also create an action method in this controller like this:
  # def twitter
  # end

  # More info at:
  # https://github.com/heartcombo/devise#omniauth

  # GET|POST /resource/auth/twitter
  # def passthru
  #   super
  # end

  # GET|POST /users/auth/twitter/callback
  # def failure
  #   super
  # end

  # protected

  # The path used when OmniAuth fails
  # def after_omniauth_failure_path_for(scope)
  #   super(scope)
  # end

  def google_oauth2
    user = User.from_omniauth(auth)
    # byebug
    if user.present?
      found_user = User.find_by(email: auth.info.email)
      if found_user.present?
        if found_user.is_admin_approved?
          sign_out_all_scopes
          flash[:success] = t 'devise.omniauth_callbacks.success', kind: 'Google'
          sign_in_and_redirect user, event: :authentication
        else
          redirect_to new_user_session_url, alert: "Your account is still being processed."
        end
      else
        user.name = user.full_name
        user.confirm
        user.save
        redirect_to root_url, notice: "Welcome to SSID! Your account is being processed. An email will be sent to you once your account is approved."
      end
    else
      flash[:alert] =
        t 'devise.omniauth_callbacks.failure', kind: 'Google', reason: "#{auth.info.email} is not authorized."
      redirect_to new_user_session_path
    end
  end
  protected
  def after_omniauth_failure_path_for(_scope)
    new_user_session_path
  end
  def after_sign_in_path_for(resource_or_scope)
    stored_location_for(resource_or_scope) || root_path
  end
  private
  def auth
    @auth ||= request.env['omniauth.auth']
  end
end
