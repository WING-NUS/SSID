# frozen_string_literal: true

class Users::RegistrationsController < Devise::RegistrationsController
  before_action :configure_sign_up_params, only: [:create]
  before_action :configure_account_update_params, only: [:update]

  # GET /resource/sign_up
  def new
    super
  end

  # POST /resource
  # def create
  #   super
  # end

  # GET /resource/edit
  # def edit
  #   super
  # end

  # PUT /resource
  # def update
  #   super
  # end

  # DELETE /resource
  # def destroy
  #   super
  # end

  def index
    @admins = User.where(is_admin: true)
    @signups = User.joins(:courses, :memberships).where(users: { is_admin_approved: false}).where(user_course_memberships: { role: [UserCourseMembership::ROLE_TEACHING_STAFF, UserCourseMembership::ROLE_TEACHING_ASSISTANT, UserCourseMembership::ROLE_GUEST]})

    # users don't belong to any course
    @loners = User.all - User.joins(:memberships) - @admins - @signups
  end  

  def approve
  end

  def upgrade_to_admin_account

  end

  # GET /resource/cancel
  # Forces the session data which is usually expired after sign
  # in to be expired now. This is useful if the user wants to
  # cancel oauth signing in/up in the middle of the process,
  # removing all OAuth session data.
  # def cancel
  #   super
  # end

  def update_resource(resource, params)
    if resource.provider == 'google_oauth2'
      params.delete('current_password')
      resource.password = params['password']
      resource.update_without_password(params)
    else
      resource.update_with_password(params)
    end
  end

  protected

  # If you have extra params to permit, append them to the sanitizer.
  def configure_sign_up_params
    devise_parameter_sanitizer.permit(:sign_up, keys: [ :name, :full_name])
  end

  # If you have extra params to permit, append them to the sanitizer.
  def configure_account_update_params
    # devise_parameter_sanitizer.permit(:account_update, keys: [:name, :full_name])

    if current_user.is_admin && current_user.id != resource.id
      devise_parameter_sanitizer.permit(:account_update) do |user_params| 
        user_params.permit(:email, :password, :password_confirmation, :name, :full_name)
      end
    else
      devise_parameter_sanitizer.permit(:account_update) do |user_params| 
        user_params.permit(:email, :password, :password_confirmation, :current_password, :name, :full_name)
      end
    end
  end

  # The path used after sign up.
  # def after_sign_up_path_for(resource)
  #   super(resource)
  # end

  # The path used after sign up for inactive accounts.
  # def after_inactive_sign_up_path_for(resource)
  #   super(resource)
  # end
end
