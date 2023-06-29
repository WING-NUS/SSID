require 'test_helper'

class VisualizeControllerTest < ActionController::TestCase
  test "should get index" do
    get :index
    assert_response :success
  end

  test "should get all_submission_clusters" do
    get :all_submission_clusters
    assert_response :success
  end

  test "should get submission_clusters" do
    get :submission_clusters
    assert_response :success
  end

  test "should get similar_submission_clusters" do
    get :similar_submission_clusters
    assert_response :success
  end

  test "should get student_similarities" do
    get :student_similarities
    assert_response :success
  end

  test "should get similar_submissions" do
    get :similar_submissions
    assert_response :success
  end

  test "should get submission_cluster_memberships" do
    get :submission_cluster_memberships
    assert_response :success
  end

end
