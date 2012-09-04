require 'test_helper'

class SubmissionClustersControllerTest < ActionController::TestCase
  setup do
    @submission_cluster = submission_clusters(:one)
  end

  test "should get index" do
    get :index
    assert_response :success
    assert_not_nil assigns(:submission_clusters)
  end

  test "should get new" do
    get :new
    assert_response :success
  end

  test "should create submission_cluster" do
    assert_difference('SubmissionCluster.count') do
      post :create, submission_cluster: @submission_cluster.attributes
    end

    assert_redirected_to submission_cluster_path(assigns(:submission_cluster))
  end

  test "should show submission_cluster" do
    get :show, id: @submission_cluster
    assert_response :success
  end

  test "should get edit" do
    get :edit, id: @submission_cluster
    assert_response :success
  end

  test "should update submission_cluster" do
    put :update, id: @submission_cluster, submission_cluster: @submission_cluster.attributes
    assert_redirected_to submission_cluster_path(assigns(:submission_cluster))
  end

  test "should destroy submission_cluster" do
    assert_difference('SubmissionCluster.count', -1) do
      delete :destroy, id: @submission_cluster
    end

    assert_redirected_to submission_clusters_path
  end
end
