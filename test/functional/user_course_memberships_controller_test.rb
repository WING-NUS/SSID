require 'test_helper'

class UserCourseMembershipsControllerTest < ActionController::TestCase
  setup do
    @user_course_membership = user_course_memberships(:one)
  end

  test "should get index" do
    get :index
    assert_response :success
    assert_not_nil assigns(:user_course_memberships)
  end

  test "should get new" do
    get :new
    assert_response :success
  end

  test "should create user_course_membership" do
    assert_difference('UserCourseMembership.count') do
      post :create, user_course_membership: @user_course_membership.attributes
    end

    assert_redirected_to user_course_membership_path(assigns(:user_course_membership))
  end

  test "should show user_course_membership" do
    get :show, id: @user_course_membership
    assert_response :success
  end

  test "should get edit" do
    get :edit, id: @user_course_membership
    assert_response :success
  end

  test "should update user_course_membership" do
    put :update, id: @user_course_membership, user_course_membership: @user_course_membership.attributes
    assert_redirected_to user_course_membership_path(assigns(:user_course_membership))
  end

  test "should destroy user_course_membership" do
    assert_difference('UserCourseMembership.count', -1) do
      delete :destroy, id: @user_course_membership
    end

    assert_redirected_to user_course_memberships_path
  end
end
