SSID::Application.routes.draw do
  root to: "login#login"

  get "users/index"
  get "users/announcement"
  get "users/course_listing"
  get "users/account_edit"
  get "users/guide"
  get "users/assignment_listing"
  get "users/assignment_new"
  get "users/assignment_create"
  post "users/assignment_create"
  get "users/assignment_check_plag_job_delete"
  get "users/assignment_delete"
  get "users/assignment_create_log"
  get "users/assignment_sim_result_view"
  get "users/assignment_clustering_listing"
  get "users/assignment_sim_result_html_view"
  get "users/assignment_report_plagiarism"
  get "users/assignment_decline_plagiarism"
  get "users/assignment_confirm_plagiarism"
  get "users/assignment_clustering_new"
  get "users/assignment_clustering_create"
  post "users/assignment_clustering_create"
  get "users/error"
  get "users/assignment_clustering_delete"
  get "users/graph_clusters"
  get "users/graph_view_groups"
  get "users/graph_view_assignments"
  get "users/sim_log_view"
  get "users/graph_assignments"
  get "users/graph_assignments_left"
  get "users/graph_view_movement"
  get "users/graph_movement"
  get "users/graph_view_ibetween"
  get "users/graph_sims"
  get "users/graph_view_iTopK"
  get "users/graph_top"
  get "users/graph_sim_result_html_view"
  get "users/graph_confirm_plagiarism"
  get "users/graph_view_igroups"
  get "users/graph_groups"
  get "users/course_view"
  get "users/account_edit"
  get "users/account_update"

  get "login/logout"

  get "admins/index"

  resources :accounts
  resources :announcements
  resources :assignment_clusterings
  resources :assignment_cluster_members
  resources :assignment_clusters
  resources :assignment_codes
  resources :assignments
  resources :assignment_sim_results
  resources :check_plag_ids
  resources :courses
  resources :plag_logs
  resources :sim_mappings
  resources :students
  resources :teachings

  # The priority is based upon order of creation:
  # first created -> highest priority.

  # Sample of regular route:
  #   match 'products/:id' => 'catalog#view'
  # Keep in mind you can assign values other than :controller and :action

  # Sample of named route:
  #   match 'products/:id/purchase' => 'catalog#purchase', :as => :purchase
  # This route can be invoked with purchase_url(:id => product.id)

  # Sample resource route (maps HTTP verbs to controller actions automatically):
  #   resources :products

  # Sample resource route with options:
  #   resources :products do
  #     member do
  #       get 'short'
  #       post 'toggle'
  #     end
  #
  #     collection do
  #       get 'sold'
  #     end
  #   end

  # Sample resource route with sub-resources:
  #   resources :products do
  #     resources :comments, :sales
  #     resource :seller
  #   end

  # Sample resource route with more complex sub-resources
  #   resources :products do
  #     resources :comments
  #     resources :sales do
  #       get 'recent', :on => :collection
  #     end
  #   end

  # Sample resource route within a namespace:
  #   namespace :admin do
  #     # Directs /admin/products/* to Admin::ProductsController
  #     # (app/controllers/admin/products_controller.rb)
  #     resources :products
  #   end

  # You can have the root of your site routed with "root"
  # just remember to delete public/index.html.
  # root :to => 'welcome#index'

  # See how all your routes lay out with "rake routes"

  # This is a legacy wild controller route that's not recommended for RESTful applications.
  # Note: This route will make all actions in every controller accessible via GET requests.
  # match ':controller(/:action(/:id))(.:format)'
end
