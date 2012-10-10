Models
------

## Announcement (Announcement)
  - title
  - html_content (content)
  - announceable_id
  - announceable_type
  - announceable_category
  - *deprecated* (account_id) - now polymorphic

## Assignment (Assignment)
  - title (title)
  - language (title)
  - course_id (course_id)
  - *deprecated* (status) - moved to SubmissionSimilarityProcess#status
  - min_match_length (Account#min_length)
  - ngram_size (Account#ngram)

## Course (Course)
  - code (code)
  - name (name)
  - academic_year (academic_year)
  - semester (semester)
  - expiry (expiry)

## Submission (AssignmentCode)
  - *deprecated* (code_line) - which is number of lines in code_array
  - lines (code_array)
  - student_id (student_id)
  - is_plagiarism (plagiarism)

## SubmissionCluster (AssignmentCluster)
  - submission_cluster_group_id (assignment_clustering_id)

## SubmissionClusterGroup (AssignmentClustering)
  - assignment_id (assignment_id)
  - description (remark)
  - cut_off_criterion (coc)
  - cut_off_criterion_type (non-db attribute: type)
  - *deprecated* (confirmed) - which is a non-db attribute to store coc
  - *deprecated* (reported) - which is a non-db attribute to store coc
  - *deprecated* (dateTime) - duplicate of created_at

## SubmissionClusterMembership (AssignmentClusterMember)
  - submission_cluster_id (assignment_cluster_id)
  - submission_id (assignment_code_id)

## SubmissionSimilarity (AssignmentSimResult)
  - assignment_id (assignment_id)
  - submission1_id (id1)
  - submission2_id (id2)
  - similarity_1_to_2 (sim1to2)
  - similarity_2_to_1 (sim2to1)
  - similarity (sim)
  - status (status)

## SubmissionLog (PlagLog)
  - submission_id (assignment_code_id)
  - *deprecated* (assignment_sim_result_id) - not needed
  - marker_id (account_id)
  - *deprecated* (student_id) - not needed
  - log_type (log_type)

## SubmissionSimilarityMapping (SimMapping)
  - submission_similarity_id (result_id)
  - start_index1 (startIndex1)
  - end_index1 (endIndex1)
  - start_index2 (startIndex1)
  - end_index2 (endIndex2)
  - start_line1 (startLine1)
  - end_line1 (endLine1)
  - start_line2 (startLine2)
  - end_line2 (endLine2)
  - statement_count (stmtMappedCount)
  - is_plagiarism (isPlagMapping)

## SubmissionSimilarityProcess (CheckPlagId)
  - assignment_id (assignment_pid)
  - pid (pid)
  - status (Assignment#status)

## User (Account, Student)
  - name (login)
  - full_name (name)
  - password_digest (hashed_password)
  - is_admin (role)
  - *deprecated* (min_length) - moved to Assignment#min_match_length
  - *deprecated* (ngram) - moved to Assignment#ngram_size
  - *deprecated* (expiry)
  - id_string (matric)
  - *deprecated* (salt)

## UserCourseMembership (Teaching)
  - user_id (account_id)
  - course_id (course_id)
  - role (role)

