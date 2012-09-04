# encoding: UTF-8
# This file is auto-generated from the current state of the database. Instead
# of editing this file, please use the migrations feature of Active Record to
# incrementally modify your database, and then regenerate this schema definition.
#
# Note that this schema.rb definition is the authoritative source for your
# database schema. If you need to create the application database on another
# system, you should be using db:schema:load, not running all the migrations
# from scratch. The latter is a flawed and unsustainable approach (the more migrations
# you'll amass, the slower it'll run and the greater likelihood for issues).
#
# It's strongly recommended to check this file into your version control system.

ActiveRecord::Schema.define(:version => 20120826083559) do

  create_table "accounts", :force => true do |t|
    t.string   "login",                          :null => false
    t.string   "hashed_password",                :null => false
    t.string   "salt",                           :null => false
    t.string   "matric",                         :null => false
    t.string   "name",                           :null => false
    t.datetime "expiry"
    t.integer  "role",            :default => 1
    t.integer  "ngram",           :default => 4, :null => false
    t.integer  "min_length",      :default => 2, :null => false
    t.datetime "created_at",                     :null => false
    t.datetime "updated_at",                     :null => false
  end

  add_index "accounts", ["login"], :name => "index_accounts_on_login"
  add_index "accounts", ["matric"], :name => "index_accounts_on_matric"
  add_index "accounts", ["name"], :name => "index_accounts_on_name"

  create_table "announcements", :force => true do |t|
    t.text     "content"
    t.integer  "account_id", :null => false
    t.datetime "created_at", :null => false
    t.datetime "updated_at", :null => false
  end

  create_table "assignment_cluster_members", :force => true do |t|
    t.integer  "assignment_cluster_id", :null => false
    t.integer  "assignment_code_id",    :null => false
    t.datetime "created_at",            :null => false
    t.datetime "updated_at",            :null => false
  end

  add_index "assignment_cluster_members", ["assignment_cluster_id", "assignment_code_id"], :name => "members", :unique => true

  create_table "assignment_clusterings", :force => true do |t|
    t.integer  "assignment_id"
    t.string   "remark"
    t.decimal  "coc",           :precision => 6, :scale => 3
    t.datetime "created_at",                                  :null => false
    t.datetime "updated_at",                                  :null => false
  end

  add_index "assignment_clusterings", ["assignment_id", "coc"], :name => "index_assignment_clusterings_on_assignment_id_and_coc", :unique => true
  add_index "assignment_clusterings", ["assignment_id", "remark"], :name => "index_assignment_clusterings_on_assignment_id_and_remark"
  add_index "assignment_clusterings", ["assignment_id"], :name => "index_assignment_clusterings_on_assignment_id"

  create_table "assignment_clusters", :force => true do |t|
    t.integer  "assignment_clustering_id"
    t.datetime "created_at",               :null => false
    t.datetime "updated_at",               :null => false
  end

  add_index "assignment_clusters", ["assignment_clustering_id"], :name => "index_assignment_clusters_on_assignment_clustering_id"

  create_table "assignment_codes", :force => true do |t|
    t.integer  "code_line"
    t.text     "code_array", :limit => 2147483647
    t.integer  "student_id"
    t.boolean  "plagiarism",                       :default => false, :null => false
    t.datetime "created_at",                                          :null => false
    t.datetime "updated_at",                                          :null => false
  end

  add_index "assignment_codes", ["student_id", "plagiarism"], :name => "index_assignment_codes_on_student_id_and_plagiarism"
  add_index "assignment_codes", ["student_id"], :name => "index_assignment_codes_on_student_id"

  create_table "assignment_sim_results", :force => true do |t|
    t.integer  "assignment_id"
    t.integer  "id1"
    t.integer  "id2"
    t.decimal  "sim1To2",       :precision => 5, :scale => 3
    t.decimal  "sim2To1",       :precision => 5, :scale => 3
    t.decimal  "sim",           :precision => 5, :scale => 3
    t.integer  "status",                                      :default => 0, :null => false
    t.datetime "created_at",                                                 :null => false
    t.datetime "updated_at",                                                 :null => false
  end

  add_index "assignment_sim_results", ["assignment_id", "id1", "id2"], :name => "index_assignment_sim_results_on_assignment_id_and_id1_and_id2"
  add_index "assignment_sim_results", ["assignment_id", "sim"], :name => "index_assignment_sim_results_on_assignment_id_and_sim"
  add_index "assignment_sim_results", ["assignment_id", "sim1To2", "sim2To1"], :name => "index_aId_sims"
  add_index "assignment_sim_results", ["assignment_id", "sim1To2"], :name => "index_assignment_sim_results_on_assignment_id_and_sim1To2"
  add_index "assignment_sim_results", ["assignment_id", "sim2To1"], :name => "index_assignment_sim_results_on_assignment_id_and_sim2To1"
  add_index "assignment_sim_results", ["assignment_id", "status"], :name => "index_a_status"
  add_index "assignment_sim_results", ["assignment_id"], :name => "index_assignment_sim_results_on_assignment_id"

  create_table "assignments", :force => true do |t|
    t.string   "title"
    t.string   "language"
    t.integer  "course_id",                  :null => false
    t.integer  "status",     :default => -1
    t.datetime "created_at",                 :null => false
    t.datetime "updated_at",                 :null => false
  end

  add_index "assignments", ["course_id"], :name => "index_assignments_on_course_id"

  create_table "check_plag_ids", :force => true do |t|
    t.integer "assignment_id"
    t.integer "pid"
  end

  add_index "check_plag_ids", ["assignment_id"], :name => "index_check_plag_ids_on_assignment_id"

  create_table "courses", :force => true do |t|
    t.string   "code"
    t.string   "name"
    t.string   "academic_year"
    t.integer  "semester"
    t.datetime "expiry"
    t.datetime "created_at",    :null => false
    t.datetime "updated_at",    :null => false
  end

  add_index "courses", ["code", "academic_year", "semester"], :name => "index_courses_on_code_and_academic_year_and_semester", :unique => true

  create_table "plag_logs", :force => true do |t|
    t.integer  "student_id"
    t.integer  "account_id"
    t.integer  "assignment_code_id"
    t.integer  "assignment_sim_result_id"
    t.integer  "log_type",                 :null => false
    t.datetime "created_at",               :null => false
    t.datetime "updated_at",               :null => false
  end

  add_index "plag_logs", ["account_id"], :name => "index_plag_logs_on_account_id"
  add_index "plag_logs", ["assignment_code_id"], :name => "index_plag_logs_on_assignment_code_id"
  add_index "plag_logs", ["assignment_sim_result_id"], :name => "index_plag_logs_on_assignment_sim_result_id"
  add_index "plag_logs", ["student_id"], :name => "index_plag_logs_on_student_id"

  create_table "sim_mappings", :force => true do |t|
    t.integer "result_id"
    t.integer "startIndex1"
    t.integer "endIndex1"
    t.integer "startIndex2"
    t.integer "endIndex2"
    t.integer "startLine1"
    t.integer "endLine1"
    t.integer "startLine2"
    t.integer "endLine2"
    t.integer "stmtMappedCount"
    t.boolean "isPlagMapping"
  end

  add_index "sim_mappings", ["result_id"], :name => "index_sim_mappings_on_result_id"

  create_table "students", :force => true do |t|
    t.string "matric"
  end

  add_index "students", ["matric"], :name => "index_students_on_matric", :unique => true

  create_table "submission_cluster_groups", :force => true do |t|
    t.integer  "assignment_id"
    t.string   "description"
    t.decimal  "cut_off_criterion",      :precision => 6, :scale => 3
    t.integer  "cut_off_criterion_type"
    t.datetime "created_at",                                           :null => false
    t.datetime "updated_at",                                           :null => false
  end

  add_index "submission_cluster_groups", ["assignment_id", "cut_off_criterion"], :name => "on_assignment_id_and_cut_off_criterion", :unique => true
  add_index "submission_cluster_groups", ["assignment_id", "description"], :name => "index_submission_cluster_groups_on_assignment_id_and_description"
  add_index "submission_cluster_groups", ["assignment_id"], :name => "index_submission_cluster_groups_on_assignment_id"

  create_table "submission_cluster_memberships", :force => true do |t|
    t.integer  "submission_cluster_id", :null => false
    t.integer  "submission_id",         :null => false
    t.datetime "created_at",            :null => false
    t.datetime "updated_at",            :null => false
  end

  add_index "submission_cluster_memberships", ["submission_cluster_id", "submission_id"], :name => "members", :unique => true

  create_table "submission_clusters", :force => true do |t|
    t.integer  "submission_cluster_group_id"
    t.datetime "created_at",                  :null => false
    t.datetime "updated_at",                  :null => false
  end

  add_index "submission_clusters", ["submission_cluster_group_id"], :name => "index_submission_clusters_on_submission_cluster_group_id"

  create_table "submission_similarities", :force => true do |t|
    t.integer  "assignment_id"
    t.integer  "submission1_id"
    t.integer  "submission2_id"
    t.decimal  "similarity_1_to_2", :precision => 5, :scale => 3
    t.decimal  "similarity_2_to_1", :precision => 5, :scale => 3
    t.decimal  "similarity",        :precision => 5, :scale => 3
    t.integer  "status",                                          :default => 0, :null => false
    t.datetime "created_at",                                                     :null => false
    t.datetime "updated_at",                                                     :null => false
  end

  add_index "submission_similarities", ["assignment_id", "similarity"], :name => "on_assignment_id_and_similarity"
  add_index "submission_similarities", ["assignment_id", "similarity_1_to_2", "similarity_2_to_1"], :name => "on_assignment_id_and_similarity_1_to_2_and_similarity_2_to_1"
  add_index "submission_similarities", ["assignment_id", "similarity_1_to_2"], :name => "on_assignment_id_and_similarity_1_to_2"
  add_index "submission_similarities", ["assignment_id", "similarity_2_to_1"], :name => "on_assignment_id_and_similarity_2_to_1"
  add_index "submission_similarities", ["assignment_id", "status"], :name => "index_submission_similarities_on_assignment_id_and_status"
  add_index "submission_similarities", ["assignment_id", "submission1_id", "submission2_id"], :name => "on_assignment_id_and_submission1_id_and_submission2_id"
  add_index "submission_similarities", ["assignment_id"], :name => "index_submission_similarities_on_assignment_id"

  create_table "submission_similarity_logs", :force => true do |t|
    t.integer  "marker_id"
    t.integer  "submission_similarity_id"
    t.integer  "student_id"
    t.integer  "submission_id"
    t.integer  "log_type",                 :null => false
    t.datetime "created_at",               :null => false
    t.datetime "updated_at",               :null => false
  end

  add_index "submission_similarity_logs", ["marker_id"], :name => "index_submission_similarity_logs_on_marker_id"
  add_index "submission_similarity_logs", ["student_id"], :name => "index_submission_similarity_logs_on_student_id"
  add_index "submission_similarity_logs", ["submission_id"], :name => "index_submission_similarity_logs_on_submission_id"
  add_index "submission_similarity_logs", ["submission_similarity_id"], :name => "index_submission_similarity_logs_on_submission_similarity_id"

  create_table "submission_similarity_mappings", :force => true do |t|
    t.integer  "submission_similarity_id"
    t.integer  "start_index1"
    t.integer  "end_index1"
    t.integer  "start_index2"
    t.integer  "end_index2"
    t.integer  "start_line1"
    t.integer  "end_line1"
    t.integer  "start_line2"
    t.integer  "end_line2"
    t.integer  "statement_count"
    t.boolean  "is_plagiarism"
    t.datetime "created_at",               :null => false
    t.datetime "updated_at",               :null => false
  end

  add_index "submission_similarity_mappings", ["submission_similarity_id"], :name => "index_submission_similarity_mappings_on_submission_similarity_id"

  create_table "submission_similarity_processes", :force => true do |t|
    t.integer  "assignment_id"
    t.integer  "pid"
    t.datetime "created_at",    :null => false
    t.datetime "updated_at",    :null => false
  end

  add_index "submission_similarity_processes", ["assignment_id"], :name => "index_submission_similarity_processes_on_assignment_id"

  create_table "submissions", :force => true do |t|
    t.text     "lines",       :limit => 2147483647
    t.integer  "student_id"
    t.boolean  "plagiarised",                       :default => false, :null => false
    t.datetime "created_at",                                           :null => false
    t.datetime "updated_at",                                           :null => false
  end

  add_index "submissions", ["student_id", "plagiarised"], :name => "index_submissions_on_student_id_and_plagiarised"
  add_index "submissions", ["student_id"], :name => "index_submissions_on_student_id"

  create_table "teachings", :force => true do |t|
    t.integer  "account_id", :null => false
    t.integer  "course_id",  :null => false
    t.integer  "role",       :null => false
    t.datetime "created_at", :null => false
    t.datetime "updated_at", :null => false
  end

  add_index "teachings", ["account_id", "course_id"], :name => "index_teachings_on_account_id_and_course_id", :unique => true

  create_table "user_course_memberships", :force => true do |t|
    t.integer  "user_id",    :null => false
    t.integer  "course_id",  :null => false
    t.integer  "role",       :null => false
    t.datetime "created_at", :null => false
    t.datetime "updated_at", :null => false
  end

  add_index "user_course_memberships", ["user_id", "course_id"], :name => "index_user_course_memberships_on_user_id_and_course_id", :unique => true

  create_table "users", :force => true do |t|
    t.string   "name"
    t.string   "full_name"
    t.string   "password_digest"
    t.boolean  "is_admin"
    t.string   "id_string"
    t.datetime "created_at",      :null => false
    t.datetime "updated_at",      :null => false
  end

end
