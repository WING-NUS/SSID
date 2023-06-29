require 'test_helper'

class SubmissionClusterGroupsControllerTest < ActionController::TestCase
  setup do
    @submission_cluster_group = submission_cluster_groups(:one)
  end

  test "should get index" do
    get :index
    assert_response :success
    assert_not_nil assigns(:submission_cluster_groups)
  end

  test "should get new" do
    get :new
    assert_response :success
  end

  test "should create submission_cluster_group" do
    assert_difference('SubmissionClusterGroup.count') do
      post :create, submission_cluster_group: @submission_cluster_group.attributes
    end

    assert_redirected_to submission_cluster_group_path(assigns(:submission_cluster_group))
  end

  test "should show submission_cluster_group" do
    get :show, id: @submission_cluster_group
    assert_response :success
  end

  test "should get edit" do
    get :edit, id: @submission_cluster_group
    assert_response :success
  end

  test "should update submission_cluster_group" do
    put :update, id: @submission_cluster_group, submission_cluster_group: @submission_cluster_group.attributes
    assert_redirected_to submission_cluster_group_path(assigns(:submission_cluster_group))
  end

  test "should destroy submission_cluster_group" do
    assert_difference('SubmissionClusterGroup.count', -1) do
      delete :destroy, id: @submission_cluster_group
    end

    assert_redirected_to submission_cluster_groups_path
  end
end
