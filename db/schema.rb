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

ActiveRecord::Schema.define(:version => 20121010131232) do

  create_table "announcements", :force => true do |t|
    t.string   "title"
    t.text     "html_content",          :null => false
    t.integer  "announceable_id",       :null => false
    t.string   "announceable_type",     :null => false
    t.integer  "announceable_category"
    t.datetime "created_at",            :null => false
    t.datetime "updated_at",            :null => false
  end

  create_table "assignments", :force => true do |t|
    t.string   "title",                           :null => false
    t.string   "language",                        :null => false
    t.integer  "course_id",                       :null => false
    t.integer  "min_match_length", :default => 2, :null => false
    t.integer  "ngram_size",       :default => 4, :null => false
    t.datetime "created_at",                      :null => false
    t.datetime "updated_at",                      :null => false
    t.text     "upload_log"
  end

  add_index "assignments", ["course_id"], :name => "index_assignments_on_course_id"

  create_table "courses", :force => true do |t|
    t.string   "code",          :null => false
    t.string   "name",          :null => false
    t.string   "academic_year"
    t.integer  "semester"
    t.datetime "expiry"
    t.datetime "created_at",    :null => false
    t.datetime "updated_at",    :null => false
  end

  add_index "courses", ["code", "academic_year", "semester"], :name => "index_courses_on_code_and_academic_year_and_semester", :unique => true

  create_table "submission_cluster_groups", :force => true do |t|
    t.integer  "assignment_id",                                                       :null => false
    t.string   "description"
    t.decimal  "cut_off_criterion",      :precision => 6, :scale => 3
    t.integer  "cut_off_criterion_type",                               :default => 2
    t.datetime "created_at",                                                          :null => false
    t.datetime "updated_at",                                                          :null => false
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
    t.integer  "submission_cluster_group_id", :null => false
    t.datetime "created_at",                  :null => false
    t.datetime "updated_at",                  :null => false
  end

  add_index "submission_clusters", ["submission_cluster_group_id"], :name => "index_submission_clusters_on_submission_cluster_group_id"

  create_table "submission_logs", :force => true do |t|
    t.integer  "submission_id",            :null => false
    t.integer  "submission_similarity_id", :null => false
    t.integer  "marker_id",                :null => false
    t.integer  "log_type",                 :null => false
    t.datetime "created_at",               :null => false
    t.datetime "updated_at",               :null => false
  end

  add_index "submission_logs", ["marker_id"], :name => "index_submission_logs_on_marker_id"
  add_index "submission_logs", ["submission_id"], :name => "index_submission_logs_on_submission_id"
  add_index "submission_logs", ["submission_similarity_id"], :name => "index_submission_logs_on_submission_similarity_id"

  create_table "submission_similarities", :force => true do |t|
    t.integer  "assignment_id",                                                  :null => false
    t.integer  "submission1_id",                                                 :null => false
    t.integer  "submission2_id",                                                 :null => false
    t.decimal  "similarity_1_to_2", :precision => 6, :scale => 3
    t.decimal  "similarity_2_to_1", :precision => 6, :scale => 3
    t.decimal  "similarity",        :precision => 6, :scale => 3
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

  create_table "submission_similarity_mappings", :force => true do |t|
    t.integer  "submission_similarity_id",                    :null => false
    t.integer  "start_index1"
    t.integer  "end_index1"
    t.integer  "start_index2"
    t.integer  "end_index2"
    t.integer  "start_line1"
    t.integer  "end_line1"
    t.integer  "start_line2"
    t.integer  "end_line2"
    t.integer  "statement_count"
    t.boolean  "is_plagiarism",            :default => false, :null => false
    t.datetime "created_at",                                  :null => false
    t.datetime "updated_at",                                  :null => false
  end

  add_index "submission_similarity_mappings", ["submission_similarity_id"], :name => "index_submission_similarity_mappings_on_submission_similarity_id"

  create_table "submission_similarity_processes", :force => true do |t|
    t.integer  "assignment_id",                :null => false
    t.integer  "pid"
    t.integer  "status",        :default => 1, :null => false
    t.datetime "created_at",                   :null => false
    t.datetime "updated_at",                   :null => false
  end

  add_index "submission_similarity_processes", ["assignment_id"], :name => "index_submission_similarity_processes_on_assignment_id"

  create_table "submissions", :force => true do |t|
    t.text     "lines",         :limit => 2147483647
    t.integer  "assignment_id",                                          :null => false
    t.integer  "student_id",                                             :null => false
    t.boolean  "is_plagiarism",                       :default => false, :null => false
    t.datetime "created_at",                                             :null => false
    t.datetime "updated_at",                                             :null => false
  end

  add_index "submissions", ["student_id", "is_plagiarism"], :name => "index_submissions_on_student_id_and_is_plagiarism"
  add_index "submissions", ["student_id"], :name => "index_submissions_on_student_id"

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
    t.string   "password_digest", :default => "$2a$10$7PVWaJGKLVmn4ATsmMrVNeFmPP3THRnJ.Z85zSl3cUwSmmfuBJc0i"
    t.boolean  "is_admin",        :default => false,                                                          :null => false
    t.string   "id_string"
    t.datetime "created_at",                                                                                  :null => false
    t.datetime "updated_at",                                                                                  :null => false
  end

end
