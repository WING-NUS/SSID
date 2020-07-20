require 'test_helper'

class SubmissionSimilarityProcessesControllerTest < ActionController::TestCase
  setup do
    @submission_similarity_process = submission_similarity_processes(:one)
  end

  test "should get index" do
    get :index
    assert_response :success
    assert_not_nil assigns(:submission_similarity_processes)
  end

  test "should get new" do
    get :new
    assert_response :success
  end

  test "should create submission_similarity_process" do
    assert_difference('SubmissionSimilarityProcess.count') do
      post :create, submission_similarity_process: @submission_similarity_process.attributes
    end

    assert_redirected_to submission_similarity_process_path(assigns(:submission_similarity_process))
  end

  test "should show submission_similarity_process" do
    get :show, id: @submission_similarity_process
    assert_response :success
  end

  test "should get edit" do
    get :edit, id: @submission_similarity_process
    assert_response :success
  end

  test "should update submission_similarity_process" do
    put :update, id: @submission_similarity_process, submission_similarity_process: @submission_similarity_process.attributes
    assert_redirected_to submission_similarity_process_path(assigns(:submission_similarity_process))
  end

  test "should destroy submission_similarity_process" do
    assert_difference('SubmissionSimilarityProcess.count', -1) do
      delete :destroy, id: @submission_similarity_process
    end

    assert_redirected_to submission_similarity_processes_path
  end
end
