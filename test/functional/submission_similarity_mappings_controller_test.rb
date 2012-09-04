require 'test_helper'

class SubmissionSimilarityMappingsControllerTest < ActionController::TestCase
  setup do
    @submission_similarity_mapping = submission_similarity_mappings(:one)
  end

  test "should get index" do
    get :index
    assert_response :success
    assert_not_nil assigns(:submission_similarity_mappings)
  end

  test "should get new" do
    get :new
    assert_response :success
  end

  test "should create submission_similarity_mapping" do
    assert_difference('SubmissionSimilarityMapping.count') do
      post :create, submission_similarity_mapping: @submission_similarity_mapping.attributes
    end

    assert_redirected_to submission_similarity_mapping_path(assigns(:submission_similarity_mapping))
  end

  test "should show submission_similarity_mapping" do
    get :show, id: @submission_similarity_mapping
    assert_response :success
  end

  test "should get edit" do
    get :edit, id: @submission_similarity_mapping
    assert_response :success
  end

  test "should update submission_similarity_mapping" do
    put :update, id: @submission_similarity_mapping, submission_similarity_mapping: @submission_similarity_mapping.attributes
    assert_redirected_to submission_similarity_mapping_path(assigns(:submission_similarity_mapping))
  end

  test "should destroy submission_similarity_mapping" do
    assert_difference('SubmissionSimilarityMapping.count', -1) do
      delete :destroy, id: @submission_similarity_mapping
    end

    assert_redirected_to submission_similarity_mappings_path
  end
end
