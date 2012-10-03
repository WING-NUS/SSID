=begin
This file is part of SSID.

SSID is free software: you can redistribute it and/or modify
it under the terms of the GNU Lesser General Public License as published by
the Free Software Foundation, either version 3 of the License, or
(at your option) any later version.

SSID is distributed in the hope that it will be useful,
but WITHOUT ANY WARRANTY; without even the implied warranty of
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
GNU Lesser General Public License for more details.

You should have received a copy of the GNU Lesser General Public License
along with SSID.  If not, see <http://www.gnu.org/licenses/>.
=end

SSID::Application.routes.draw do
  # Login/Logout routes
  get "login" => "sessions#new"
  post "login" => "sessions#create"
  delete "logout" => "sessions#destroy"

  get "guide" => "users#guide"

  root to: "announcements#index"

  resources :announcements
  resources :courses do
    resources :assignments do
      get "log" => "assignments#show_log"
    end
    resources :users
  end
  resources :assignments do 
    resources :submissions do
      get "log" => "submissions#show_log"
    end
  end
  resources :assignments do
    resources :cluster_groups, controller: "submission_cluster_groups"
  end
  resources :cluster_groups, controller: "submission_cluster_groups" do
    resources :clusters, controller: "submission_clusters"
  end
  get "clusters/:id" => "submission_clusters#show", defaults: { format: 'json' }
  resources :users
  resources :submission_similarities
 #resources :submission_similarity_logs
 #resources :submission_similarity_mappings
 #resources :submission_similarity_processes
 #resources :submission_cluster_memberships
 #resources :user_course_memberships

  # Old routes:
  # -----------
  #
  # get "users/index"
  # get "users/announcement"
  # get "users/course_listing"
  # get "users/account_edit"
  # get "users/guide"
  # get "users/assignment_listing"
  # get "users/assignment_new"
  # get "users/assignment_create"
  # post "users/assignment_create"
  # get "users/assignment_check_plag_job_delete"
  # get "users/assignment_delete"
  # get "users/assignment_create_log"
  # get "users/assignment_sim_result_view"
  # get "users/assignment_clustering_listing"
  # get "users/assignment_sim_result_html_view"
  # get "users/assignment_report_plagiarism"
  # get "users/assignment_decline_plagiarism"
  # get "users/assignment_confirm_plagiarism"
  # get "users/assignment_clustering_new"
  # get "users/assignment_clustering_create"
  # post "users/assignment_clustering_create"
  # get "users/error"
  # get "users/assignment_clustering_delete"
  # get "users/graph_clusters"
  # get "users/graph_view_groups"
  # get "users/graph_view_assignments"
  # get "users/sim_log_view"
  # get "users/graph_assignments"
  # get "users/graph_assignments_left"
  # get "users/graph_view_movement"
  # get "users/graph_movement"
  # get "users/graph_view_ibetween"
  # get "users/graph_sims"
  # get "users/graph_view_iTopK"
  # get "users/graph_top"
  # get "users/graph_sim_result_html_view"
  # get "users/graph_confirm_plagiarism"
  # get "users/graph_view_igroups"
  # get "users/graph_groups"
  # get "users/course_view"
  # get "users/account_edit"
  # get "users/account_update"
  # get "login/logout"
  # get "admins/index"
  # resources :accounts
  # resources :announcements
  # resources :assignment_clusterings
  # resources :assignment_cluster_members
  # resources :assignment_clusters
  # resources :assignment_codes
  # resources :assignments
  # resources :assignment_sim_results
  # resources :check_plag_ids
  # resources :courses
  # resources :plag_logs
  # resources :sim_mappings
  # resources :students
  # resources :teachings
end
