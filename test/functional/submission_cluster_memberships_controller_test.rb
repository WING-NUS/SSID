require 'test_helper'

class SubmissionClusterMembershipsControllerTest < ActionController::TestCase
  setup do
    @submission_cluster_membership = submission_cluster_memberships(:one)
  end

  test "should get index" do
    get :index
    assert_response :success
    assert_not_nil assigns(:submission_cluster_memberships)
  end

  test "should get new" do
    get :new
    assert_response :success
  end

  test "should create submission_cluster_membership" do
    assert_difference('SubmissionClusterMembership.count') do
      post :create, submission_cluster_membership: @submission_cluster_membership.attributes
    end

    assert_redirected_to submission_cluster_membership_path(assigns(:submission_cluster_membership))
  end

  test "should show submission_cluster_membership" do
    get :show, id: @submission_cluster_membership
    assert_response :success
  end

  test "should get edit" do
    get :edit, id: @submission_cluster_membership
    assert_response :success
  end

  test "should update submission_cluster_membership" do
    put :update, id: @submission_cluster_membership, submission_cluster_membership: @submission_cluster_membership.attributes
    assert_redirected_to submission_cluster_membership_path(assigns(:submission_cluster_membership))
  end

  test "should destroy submission_cluster_membership" do
    assert_difference('SubmissionClusterMembership.count', -1) do
      delete :destroy, id: @submission_cluster_membership
    end

    assert_redirected_to submission_cluster_memberships_path
  end
end
