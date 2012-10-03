Controllers
-----------

## SessionsController
  - create (login#login)
  - destroy (login#logout)

##  UsersController
  - index (admins#account_index)
  - show (admins#account_show)
  - new (admins#account_new)
  - edit (admins#account_edit, users#account_edit)
  - create (admins#account_create)
  - update (admins#account_update, users#account_update)
  - destroy (admins#account_delete)
  - guide (users#guide)

## AnnouncementsController
  - index (admins#announcement_index, users#announcement, users#index, admins#index)
  - show (admins#announcement_show)
  - new (admins#announcement_new)
  - edit (admins#announcement_edit)
  - create (admins#announcement_create)
  - update (admins#announcement_update)
  - destroy (admins#announcement_delete)

## CoursesController
  - index (admins#module_index, users#course_listing)
  - show (admins#module_show, users#course_view)
  - new (admins#module_new)
  - edit (admins#module_edit)
  - create (admins#module_create)
  - update (admins#module_update)
  - destroy (admins#module_delete)

## VisualizeController
  - index (users#graph_view_assignments, users#graph_view_groups, users#graph_view_movement, users#graph_view_ibetween, users#graph_view_iTopK, users#graph_view_igroups)
  - all_submission_clusters (users#graph_assignments, users#graph_assignments_left)
  - submission_clusters (users#graph_clusters)
  - similar_submission_clusters (users#graph_movement)
  - student_similarities (users#graph_sims)
  - similar_submissions (users#graph_top)
  - submission_cluster_memberships (users#graph_groups)

## AssignmentsController
  - index (users#assignment_listing)
  - show
  - show_log (users#assignment_create_log)
  - new (users#assignment_new)
  - edit
  - create (users#assignment_create)
  - update
  - destroy (users#assignment_delete)

## SubmissionSimilaritiesController
  - index (users#assignment_sim_result_view)
  - show (users#assignment_sim_result_html_view, users#graph_sim_result_html_view)
  - new
  - edit
  - create
  - update
  - destroy
  - confirm_as_plagiarism (users#assignment_confirm_plagiarism, users#graph_confirm_plagiarism)
  - unmark_as_plagiarism (users#assignment_decline_plagiarism, users#graph_decline_plagiarism)
  - suspect_as_plagiarism (users#assignment_report_plagiarism, users#graph_report_plagiarism)

## SubmissionSimilarityLogsController
  - index
  - show (users#sim_log_view)
  - new
  - edit
  - create
  - update
  - destroy

## SubmissionClusterGroupsController
  - index (users#assignment_clustering_listing)
  - show
  - new (users#assignment_clustering_new)
  - edit
  - create (users#assignment_clustering_create)
  - update
  - destroy (users#assignment_clustering_delete)

## SubmissionSimilarityProcessesController
  - index
  - show
  - new
  - edit
  - create
  - update
  - *BUG* destroy (users#assignment_check_plag_job_delete)

