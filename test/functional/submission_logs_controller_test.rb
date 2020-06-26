require 'test_helper'

class SubmissionLogsControllerTest < ActionController::TestCase
  setup do
    @submission_log = submission_logs(:one)
  end

  test "should get index" do
    get :index
    assert_response :success
    assert_not_nil assigns(:submission_logs)
  end

  test "should get new" do
    get :new
    assert_response :success
  end

  test "should create submission_log" do
    assert_difference('SubmissionLog.count') do
      post :create, submission_log: @submission_log.attributes
    end

    assert_redirected_to submission_log_path(assigns(:submission_log))
  end

  test "should show submission_log" do
    get :show, id: @submission_log
    assert_response :success
  end

  test "should get edit" do
    get :edit, id: @submission_log
    assert_response :success
  end

  test "should update submission_log" do
    put :update, id: @submission_log, submission_log: @submission_log.attributes
    assert_redirected_to submission_log_path(assigns(:submission_log))
  end

  test "should destroy submission_log" do
    assert_difference('SubmissionLog.count', -1) do
      delete :destroy, id: @submission_log
    end

    assert_redirected_to submission_logs_path
  end
end
