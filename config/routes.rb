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
  
  resources :submission_logs

  get 'assignments/:id/submission_similarities/guest_user' => 'submission_similarities#create_guest_user', :as => 'guest_user_create'
  get 'assignments/:assignment_id/submission_similarities/:submission_similarity_id/guest_user' => 'submission_logs#view_similarity', :as => 'guest_view_similarity'

  # Login/Logout routes
  devise_scope :user do
    get "cover" => "users/sessions#index"
    get "guide" => "users/sessions#guide"

    authenticated :user do
      root to: "announcements#index", as: :authenticated_root
    end
  
    root to: "users/sessions#index"
  end



  devise_for :users, :controllers => { 
    # :registrations => "users/registrations",
    # :sign_in => "users/sessions",
    sessions: 'users/sessions',
    confirmations: 'users/confirmations',
    passwords: 'users/passwords',
    registrations: 'users/registrations',
    omniauth_callbacks: 'users/omniauth_callbacks'
  }, :path => '', :path_names => { :sign_in => 'login', :sign_out => 'logout', :sign_up => 'signup' }

  resources :announcements

  namespace :admin do
    resources :users do
      get 'approve' => 'users#approve', :as => 'approve_user'
      put 'update' => 'users#upgrade_to_admin_account'
    end
  end
  
  resources :courses do
    get 'status'
    get "cluster_students", defaults: { format: "json" }


    resources :user_course_memberships 

  

    resources :assignments do
      get "log" => "assignments#show_log"
      get "list" => "submissions#index"
    end

    get "visualize/" => "visualize#index"
    get "visualize/similarity_cluster_graph" => "visualize#similarity_cluster_graph"
    get "visualize/similarity_cluster_table" => "visualize#similarity_cluster_table"
    get "visualize/top_similar_submissions" => "visualize#top_similar_submissions"
  end

  resources :assignments do 
    get "cluster_students", defaults: { format: "json" }
    get "view_printable_multiple" => "submission_similarities#view_printable_multiple"

    resources :cluster_groups, controller: "submission_cluster_groups"

    resources :submission_similarities do
      put "confirm_as_plagiarism" => "submission_similarities#confirm_as_plagiarism"
      put "suspect_as_plagiarism" => "submission_similarities#suspect_as_plagiarism"
      put "unmark_as_plagiarism" => "submission_similarities#unmark_as_plagiarism"
      get "view_printable" => "submission_similarities#view_printable"
    end

    resources :submissions do
      get "log" => "submission_logs#index"
    end
  end

  # ajax calls
  resources :submission_similarities do
    resources :submissions do
      put "mark_as_guilty" => "submissions#mark_as_guilty"
      put "mark_as_not_guilty" => "submissions#mark_as_not_guilty"
    end
  end
  
  resources :cluster_groups, controller: "submission_cluster_groups" do
    resources :clusters, controller: "submission_clusters"
  end
  
  get "clusters/show_for_submission_ids" => "submission_clusters#show_for_submission_ids", defaults: { format: 'json' }
  get "clusters/ids_and_group_ids_for_student_ids" => "submission_clusters#ids_and_group_ids_for_student_ids", defaults: { format: 'json' }
  get "clusters/show_graph_partial" => "submission_clusters#show_graph_partial"
  get "clusters/show_ranking_partial" => "submission_clusters#show_ranking_partial"
  
  get "clusters/:id" => "submission_clusters#show", defaults: { format: 'json' }
  get "clusters/:id/show_graph_partial" => "submission_clusters#show_graph_partial"
  get "clusters/:id/show_table_partial" => "submission_clusters#show_table_partial"

  resources :students, controller: "users" do
    get "submission_similarities/show_table_partial" => "submission_similarities#show_table_partial"
  end

  namespace :api do
    namespace :v1 do
      get 'sample_get', to: 'courses#sample_get'
      post 'sample_post', to: 'courses#sample_post'
    end
  end
end
