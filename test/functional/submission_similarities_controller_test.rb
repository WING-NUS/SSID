require 'test_helper'

class SubmissionSimilaritiesControllerTest < ActionController::TestCase
  setup do
    @submission_similarity = submission_similarities(:one)
  end

  test "should get index" do
    get :index
    assert_response :success
    assert_not_nil assigns(:submission_similarities)
  end

  test "should get new" do
    get :new
    assert_response :success
  end

  test "should create submission_similarity" do
    assert_difference('SubmissionSimilarity.count') do
      post :create, submission_similarity: @submission_similarity.attributes
    end

    assert_redirected_to submission_similarity_path(assigns(:submission_similarity))
  end

  test "should show submission_similarity" do
    get :show, id: @submission_similarity
    assert_response :success
  end

  test "should get edit" do
    get :edit, id: @submission_similarity
    assert_response :success
  end

  test "should update submission_similarity" do
    put :update, id: @submission_similarity, submission_similarity: @submission_similarity.attributes
    assert_redirected_to submission_similarity_path(assigns(:submission_similarity))
  end

  test "should destroy submission_similarity" do
    assert_difference('SubmissionSimilarity.count', -1) do
      delete :destroy, id: @submission_similarity
    end

    assert_redirected_to submission_similarities_path
  end
end
