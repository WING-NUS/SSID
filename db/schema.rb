# This file is auto-generated from the current state of the database. Instead
# of editing this file, please use the migrations feature of Active Record to
# incrementally modify your database, and then regenerate this schema definition.
#
# This file is the source Rails uses to define your schema when running `rails
# db:schema:load`. When creating a new database, `rails db:schema:load` tends to
# be faster and is potentially less error prone than running all of your
# migrations from scratch. Old migrations may fail to apply correctly if those
# migrations use external dependencies or application code.
#
# It's strongly recommended that you check this file into your version control system.

ActiveRecord::Schema.define(version: 2021_06_11_071509) do

  create_table "active_storage_attachments", options: "ENGINE=InnoDB DEFAULT CHARSET=utf8mb3", force: :cascade do |t|
    t.string "name", null: false
    t.string "record_type", null: false
    t.bigint "record_id", null: false
    t.bigint "blob_id", null: false
    t.datetime "created_at", null: false
    t.index ["blob_id"], name: "index_active_storage_attachments_on_blob_id"
    t.index ["record_type", "record_id", "name", "blob_id"], name: "index_active_storage_attachments_uniqueness", unique: true
  end

  create_table "active_storage_blobs", options: "ENGINE=InnoDB DEFAULT CHARSET=utf8mb3", force: :cascade do |t|
    t.string "key", null: false
    t.string "filename", null: false
    t.string "content_type"
    t.text "metadata"
    t.bigint "byte_size", null: false
    t.string "checksum", null: false
    t.datetime "created_at", null: false
    t.index ["key"], name: "index_active_storage_blobs_on_key", unique: true
  end

  create_table "announcements", options: "ENGINE=InnoDB DEFAULT CHARSET=utf8mb3", force: :cascade do |t|
    t.string "title"
    t.text "html_content", null: false
    t.integer "announceable_id", null: false
    t.string "announceable_type", null: false
    t.integer "announceable_category"
    t.datetime "created_at", precision: 6, null: false
    t.datetime "updated_at", precision: 6, null: false
  end

  create_table "assignments", options: "ENGINE=InnoDB DEFAULT CHARSET=utf8mb3", force: :cascade do |t|
    t.string "title", null: false
    t.string "language", null: false
    t.integer "course_id", null: false
    t.integer "min_match_length", default: 2, null: false
    t.integer "ngram_size", default: 4, null: false
    t.datetime "created_at", precision: 6, null: false
    t.datetime "updated_at", precision: 6, null: false
    t.text "upload_log"
    t.boolean "mapbox", default: false
    t.string "file_structure"
    t.string "filesIgnore"
    t.string "filesProcess"
    t.string "email"
    t.index ["course_id"], name: "index_assignments_on_course_id"
  end

  create_table "courses", options: "ENGINE=InnoDB DEFAULT CHARSET=utf8mb3", force: :cascade do |t|
    t.string "code", null: false
    t.string "name", null: false
    t.string "academic_year"
    t.integer "semester"
    t.datetime "expiry"
    t.datetime "created_at", precision: 6, null: false
    t.datetime "updated_at", precision: 6, null: false
    t.index ["code", "academic_year", "semester"], name: "index_courses_on_code_and_academic_year_and_semester", unique: true
  end

  create_table "submission_cluster_groups", options: "ENGINE=InnoDB DEFAULT CHARSET=utf8mb3", force: :cascade do |t|
    t.integer "assignment_id", null: false
    t.string "description"
    t.decimal "cut_off_criterion", precision: 6, scale: 3
    t.integer "cut_off_criterion_type", default: 2
    t.datetime "created_at", precision: 6, null: false
    t.datetime "updated_at", precision: 6, null: false
    t.index ["assignment_id", "cut_off_criterion"], name: "on_assignment_id_and_cut_off_criterion", unique: true
    t.index ["assignment_id"], name: "index_submission_cluster_groups_on_assignment_id"
  end

  create_table "submission_cluster_memberships", options: "ENGINE=InnoDB DEFAULT CHARSET=utf8mb3", force: :cascade do |t|
    t.integer "submission_cluster_id", null: false
    t.integer "submission_id", null: false
    t.datetime "created_at", precision: 6, null: false
    t.datetime "updated_at", precision: 6, null: false
    t.index ["submission_cluster_id", "submission_id"], name: "members", unique: true
  end

  create_table "submission_clusters", options: "ENGINE=InnoDB DEFAULT CHARSET=utf8mb3", force: :cascade do |t|
    t.integer "submission_cluster_group_id", null: false
    t.datetime "created_at", precision: 6, null: false
    t.datetime "updated_at", precision: 6, null: false
    t.index ["submission_cluster_group_id"], name: "index_submission_clusters_on_submission_cluster_group_id"
  end

  create_table "submission_logs", options: "ENGINE=InnoDB DEFAULT CHARSET=utf8mb3", force: :cascade do |t|
    t.integer "submission_id", null: false
    t.integer "submission_similarity_id", null: false
    t.integer "marker_id", null: false
    t.integer "log_type", null: false
    t.datetime "created_at", precision: 6, null: false
    t.datetime "updated_at", precision: 6, null: false
    t.index ["marker_id"], name: "index_submission_logs_on_marker_id"
    t.index ["submission_id"], name: "index_submission_logs_on_submission_id"
    t.index ["submission_similarity_id"], name: "index_submission_logs_on_submission_similarity_id"
  end

  create_table "submission_similarities", options: "ENGINE=InnoDB DEFAULT CHARSET=utf8mb3", force: :cascade do |t|
    t.integer "assignment_id", null: false
    t.integer "submission1_id", null: false
    t.integer "submission2_id", null: false
    t.decimal "similarity_1_to_2", precision: 6, scale: 3
    t.decimal "similarity_2_to_1", precision: 6, scale: 3
    t.decimal "similarity", precision: 6, scale: 3
    t.integer "status", default: 0, null: false
    t.datetime "created_at", precision: 6, null: false
    t.datetime "updated_at", precision: 6, null: false
    t.index ["assignment_id", "similarity"], name: "on_assignment_id_and_similarity"
    t.index ["assignment_id", "similarity_1_to_2", "similarity_2_to_1"], name: "on_assignment_id_and_similarity_1_to_2_and_similarity_2_to_1"
    t.index ["assignment_id", "similarity_1_to_2"], name: "on_assignment_id_and_similarity_1_to_2"
    t.index ["assignment_id", "similarity_2_to_1"], name: "on_assignment_id_and_similarity_2_to_1"
    t.index ["assignment_id", "status"], name: "index_submission_similarities_on_assignment_id_and_status"
    t.index ["assignment_id", "submission1_id", "submission2_id"], name: "on_assignment_id_and_submission1_id_and_submission2_id"
    t.index ["assignment_id"], name: "index_submission_similarities_on_assignment_id"
  end

  create_table "submission_similarity_mappings", options: "ENGINE=InnoDB DEFAULT CHARSET=utf8mb3", force: :cascade do |t|
    t.integer "submission_similarity_id", null: false
    t.integer "start_index1"
    t.integer "end_index1"
    t.integer "start_index2"
    t.integer "end_index2"
    t.integer "start_line1"
    t.integer "end_line1"
    t.integer "start_line2"
    t.integer "end_line2"
    t.integer "statement_count"
    t.boolean "is_plagiarism", default: false, null: false
    t.datetime "created_at", precision: 6, null: false
    t.datetime "updated_at", precision: 6, null: false
    t.index ["submission_similarity_id"], name: "on_submission_similarity_id"
  end

  create_table "submission_similarity_processes", options: "ENGINE=InnoDB DEFAULT CHARSET=utf8mb3", force: :cascade do |t|
    t.integer "assignment_id", null: false
    t.integer "pid"
    t.integer "status", default: 1, null: false
    t.datetime "created_at", precision: 6, null: false
    t.datetime "updated_at", precision: 6, null: false
    t.index ["assignment_id"], name: "index_submission_similarity_processes_on_assignment_id"
  end

  create_table "submissions", options: "ENGINE=InnoDB DEFAULT CHARSET=utf8mb3", force: :cascade do |t|
    t.text "lines", size: :long
    t.integer "assignment_id", null: false
    t.integer "student_id", null: false
    t.boolean "is_plagiarism", default: false, null: false
    t.datetime "created_at", precision: 6, null: false
    t.datetime "updated_at", precision: 6, null: false
    t.index ["student_id", "is_plagiarism"], name: "index_submissions_on_student_id_and_is_plagiarism"
    t.index ["student_id"], name: "index_submissions_on_student_id"
  end

  create_table "user_course_memberships", options: "ENGINE=InnoDB DEFAULT CHARSET=utf8mb3", force: :cascade do |t|
    t.integer "user_id", null: false
    t.integer "course_id", null: false
    t.integer "role", null: false
    t.datetime "created_at", precision: 6, null: false
    t.datetime "updated_at", precision: 6, null: false
    t.index ["user_id", "course_id"], name: "index_user_course_memberships_on_user_id_and_course_id", unique: true
  end

  create_table "users", options: "ENGINE=InnoDB DEFAULT CHARSET=utf8mb3", force: :cascade do |t|
    t.string "name"
    t.string "full_name"
    t.string "password_digest", default: "$2a$12$Ifr1zMyr9ZCydGsN0TGlru/fYL7CA/BXkcIO6W/QPQFzOZdA0.XDO"
    t.boolean "is_admin", default: false, null: false
    t.string "id_string"
    t.datetime "created_at", precision: 6, null: false
    t.datetime "updated_at", precision: 6, null: false
  end

  add_foreign_key "active_storage_attachments", "active_storage_blobs", column: "blob_id"
end
