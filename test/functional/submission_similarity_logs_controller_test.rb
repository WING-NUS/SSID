require 'test_helper'

class SubmissionSimilarityLogsControllerTest < ActionController::TestCase
  setup do
    @submission_similarity_log = submission_similarity_logs(:one)
  end

  test "should get index" do
    get :index
    assert_response :success
    assert_not_nil assigns(:submission_similarity_logs)
  end

  test "should get new" do
    get :new
    assert_response :success
  end

  test "should create submission_similarity_log" do
    assert_difference('SubmissionSimilarityLog.count') do
      post :create, submission_similarity_log: @submission_similarity_log.attributes
    end

    assert_redirected_to submission_similarity_log_path(assigns(:submission_similarity_log))
  end

  test "should show submission_similarity_log" do
    get :show, id: @submission_similarity_log
    assert_response :success
  end

  test "should get edit" do
    get :edit, id: @submission_similarity_log
    assert_response :success
  end

  test "should update submission_similarity_log" do
    put :update, id: @submission_similarity_log, submission_similarity_log: @submission_similarity_log.attributes
    assert_redirected_to submission_similarity_log_path(assigns(:submission_similarity_log))
  end

  test "should destroy submission_similarity_log" do
    assert_difference('SubmissionSimilarityLog.count', -1) do
      delete :destroy, id: @submission_similarity_log
    end

    assert_redirected_to submission_similarity_logs_path
  end
end
