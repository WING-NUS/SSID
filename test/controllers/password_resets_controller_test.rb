require 'test_helper'

class PasswordResetsControllerTest < ActionDispatch::IntegrationTest
  test "should get forget_password" do
    get password_resets_forget_password_url
    assert_response :success
  end

  test "should get send_password_reset_link_" do
    get password_resets_send_password_reset_link__url
    assert_response :success
  end

  test "should get reset_password" do
    get password_resets_reset_password_url
    assert_response :success
  end

  test "should get update_password" do
    get password_resets_update_password_url
    assert_response :success
  end

end
