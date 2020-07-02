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
  # resources :submission_logs

  # Login/Logout routes
  get "login" => "sessions#new"
  post "login" => "sessions#create"
  delete "logout" => "sessions#destroy"

  get "guide" => "users#guide"
  root to: "announcements#index"

  resources :announcements

  resources :courses do
    # missing view
    get 'status' 
    resources :assignments do
      get "log" => "assignments#show_log"
    end

    resources :users

    get "visualize/" => "visualize#index"
    get "visualize/similarity_cluster_graph" => "visualize#similarity_cluster_graph"
    get "visualize/similarity_cluster_table" => "visualize#similarity_cluster_table"
    get "visualize/top_similar_submissions" => "visualize#top_similar_submissions"
    get "cluster_students"
  end

  resources :submission_similarities do
    # /submission_similarities/:id/submissions/:id does not work as expected so why is this resource placed here?
    resources :submissions do
      put "mark_as_guilty" => "submissions#mark_as_guilty"
      put "mark_as_not_guilty" => "submissions#mark_as_not_guilty"
    end
  end
  resources :assignments do 
    # broken
    get "cluster_students"
    resources :submission_similarities do
      put "confirm_as_plagiarism" => "submission_similarities#confirm_as_plagiarism"
      put "suspect_as_plagiarism" => "submission_similarities#suspect_as_plagiarism"
      put "unmark_as_plagiarism" => "submission_similarities#unmark_as_plagiarism"
    end
    resources :cluster_groups, controller: "submission_cluster_groups"
    resources :submissions do
      # missing view
      get "log" => "submission_logs#index"
    end
  end

  # resources :cluster_groups, controller: "submission_cluster_groups" do
  #   resources :clusters, controller: "submission_clusters"
  # end

  get "clusters/ids_and_group_ids_for_student_ids" => "submission_clusters#ids_and_group_ids_for_student_ids", defaults: { format: 'json' }
  get "clusters/show_graph_partial" => "submission_clusters#show_graph_partial"
  get "clusters/show_ranking_partial" => "submission_clusters#show_ranking_partial"
  get "clusters/show_for_submission_ids" => "submission_clusters#show_for_submission_ids", defaults: { format: 'json' }
  get "clusters/:id" => "submission_clusters#show", defaults: { format: 'json' }
  get "clusters/:id/show_graph_partial" => "submission_clusters#show_graph_partial"
  get "clusters/:id/show_table_partial" => "submission_clusters#show_table_partial"

  resources :users
  namespace :admin do
    resources :users
  end
  
  resources :students, controller: "users" do
    get "submission_similarities/show_table_partial" => "submission_similarities#show_table_partial"
  end
end
