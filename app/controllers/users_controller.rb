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

class UsersController < ApplicationController

  layout 'users', :except => [
    :assignment_sim_result_html_view,
    :graph_assignments,
    :graph_assignments_left,
    :graph_assignments_right,
    :graph_sim_result_html_view,
    :graph_clusters,
    :graph_movement,
    :graph_sims,
    :graph_top,
    :graph_groups
  ]

  #  layout 'users', :except => [
  #    :assignment_sim_result_html_view
  #  ]
  
  #before_filter :verify_teaching_on_course_id, :only => ["course"]

  def guide
  
  end

  def index
    redirect_to :action => "announcement"
  end
  def announcement
    @announcements = Announcement.all(:order=>'updated_at desc')
  end

  def account_edit
    @account = @user_account
  end
  def account_update
    @account = @user_account

    respond_to do |format|
      if @account.update_attributes(params[:account])
        flash[:notice] = 'Profile is successfully updated.'
        format.html { redirect_to( :action => 'announcement' ) }
      else
        format.html { render :action => 'account_edit' }
      end
    end
  end

  def course_listing
    @courses = retrieve_courses
  end
  def course_view
    @course = retrieve_course(params[:course_id])
    raise ("Course is nil") if (!@course)
    @course_role = @course.teachings.find(:first, :conditions => "account_id = #{@user_account.id}").role
  rescue
    flash[:notice] = "Invalid course selection"
    redirect_to :action => "course_listing"
  end

  def sim_log_view
    begin
      course = retrieve_course(params[:course_id])
      raise "Course is nil" if !course
    rescue Exception => exec
      flash[:notice] = "Invalid course selection"
      redirect_to :action => "error"
    end

    begin
      raise "Student is nil" if !params[:student_id]
      @student = Student.find(params[:student_id])
      raise "Student is nil" if !@student
    rescue
      flash[:notice] = "Invalid student selection"
      redirect_to :action => "error"
    end
    
    #Select logs base on course role, ts can see all logs, ta only selected course
    course_role = course.teachings.find(:first, :conditions => "account_id = #{@user_account.id}").role
    case course_role
    when 0 then
      #@logs = PlagLog.find_all_by_student_id(params[:student_id], :order => "updated_at DESC, log_type DESC")
      sql_query = "SELECT DISTINCT * FROM plag_logs WHERE student_id = ? ORDER BY updated_at DESC, log_type DESC"
      @logs = PlagLog.find_by_sql([sql_query, @student.id])
    else
      sql_query = "SELECT DISTINCT logs.* FROM plag_logs as logs, assignment_sim_results as asr, assignments as a WHERE logs.student_id = ? AND logs.assignment_sim_result_id = asr.id AND asr.assignment_id = a.id AND a.course_id = ? ORDER BY updated_at DESC, log_type DESC"
      @logs = PlagLog.find_by_sql([sql_query, @student.id, course.id])
    end

    #render :layout => 'log_blank' if params[:blank] == "true"
  end

  def assignment_listing
    @course = retrieve_course(params[:course_id])
    raise ("Course is nil") if (!@course)
    @assignments = @course.assignments.all
  rescue
    flash[:notice] = "Invalid course selection"
    redirect_to :action => "course_listing"
  end
  def assignment_new
    @course = retrieve_course(params[:course_id])
    raise ("Course is nil") if (!@course)
    @assignment = Assignment.new
  rescue
    flash[:notice] = "Invalid course selection"
    redirect_to :action => "course_listing"
  end

  def assignment_create
    #check if course is avaliable
    begin
      course = retrieve_course(params[:course][:course_id])
      raise "course is nil" if !course
    rescue Exception => exc
      logger.error("Messge for the log file #{exc.message}")
      flash[:notice] = "Invalid course selection : Nas"
      redirect_to :action => "course_listing"
      return
    end

    #[1, 2, 3, 4].each { |n|

    #Create dummy assignment
    begin
      assignment = Assignment.new(params[:assignment])
      course.assignments << assignment
    rescue Exception => exc
      logger.error("Message for the log file #{exc.message}")
      flash[:notice] = "Assignment Creation Error"
      redirect_to :action => 'assignment_new', :course_id => course.id
      return
    end

    #check if any data field is missing in the assignment by saving
    if (assignment.save)
      min = assignment.min
      ngram = assignment.ngram
      #ngram = n

      #download the zipped file from client and unzip the file
      begin
        directory_path, file_path = localize_upload_file(assignment.id)
        unzip_localized_file(directory_path, file_path, assignment.id) #unzip the client zip file
        remove_localized_file(file_path) #remove the downloaded client zip file
      rescue Exception => exc
        logger.error("Message for the log file #{exc.message}")
        flash[:notice] = "File Upload Error"
        assignment.destroy
        redirect_to :action => 'assignment_new', :course_id => course.id
        return
      end

      begin
        case params[:assignment][:language]
        when "c"
          language = "c"
        else
          language = "java"
        end
        #if (!compute_similarity(directory_path, assignment.id, language, "pds", min, ngram))
        #raise ("Analysis Error in program")
        #end
        check_plag_process = CheckPlagId.new({:assignment_id => assignment.id})
        check_plag_process.save

        compute_similarity(directory_path, assignment.id, language, "pds", min, ngram)
      rescue Exception => exc
        puts exc.message
        puts exc.backtrace
        logger.error("Message for the log file #{exc.message}")
        assignment.delete
        flash[:notice] = "Analysis error"
        redirect_to :action => 'assignment_new', :course_id => course.id
        return
      end
    else
      @assignment = assignment
      @course = course
      render :action => "assignment_new"
      return
    end
    #}
    
    #    (50.0..90.0).step(10) { |limit|
    #      clustering = AssignmentClustering.new(:assignment_id => assignment.id, :limit => limit, :remark => "System generated")
    #      assignment.clusterings << clustering
    #
    #      if (clustering.save)
    #        jar_path = File.join(JAVA_ROOT, "programs", "DBSCAN.jar")
    #        if (!system("java -jar \"#{jar_path}\" #{assignment.id} #{clustering.id} #{clustering.limit}"))
    #          flash[:notice] = "Clustering program error"
    #          render :action => "assignment_clustering_new"
    #          return
    #        end
    #      else
    #        puts "Save error"
    #      end
    #    } # end of system auto generate clusterings

    #redirect_to :action => 'assignment_sim_result_view', :assignment_id => assignment.id
    redirect_to :action => 'assignment_listing', :course_id => course.id
  end
  def assignment_delete
    begin
      @assignment = retrieve_assignment(params[:assignment_id])
      raise ("Assignment is nil") if (!@assignment)
      @assignment.destroy
      redirect_to :action => "assignment_listing", :course_id => params[:course_id]
    rescue
      flash[:notice] = "Invalid assignment selection"
      redirect_to :action => "assignment_listing", :course_id => params[:course_id]
    end
  end
  def assignment_create_log
    begin
      @assignment = retrieve_assignment(params[:assignment_id])
      raise ("Assignment id is nil") if (@assignment == nil)
    rescue Exception => exec
      puts exec
      flash[:notice] = "Invalid selection"
      redirect_to :action => "assignment_listing"
      return
    end

    begin
      raise "Assignment is still processing" if @assignment.status != 0 && @assignment.status != -2
    rescue Exception => exec
      puts exec
      flash[:notice] = exec
      redirect_to :action => "assignment_listing", :course_id => @assignment.course_id
      return
    end
  end

  #Not working, due to dead lock and unpeaceful termination (may terminate the thread during sql transaction without peacefully closing the transaction)
  def assignment_check_plag_job_delete

    assignment = retrieve_assignment(params[:assignment_id])
    
    if assignment == nil
      redirect_to :action => "assignment_listing", :course_id => assignment.course_id 
      return
    end
    
    CheckPlagId.transaction do
      process = CheckPlagId.find_by_assignment_id(assignment.id, :lock => true)
      
      if process == nil
        puts "~~~~~~~~~~~~~~~~~~~~~~~ Controller: process not found ~~~~~~~~~~~~~~~~~~~~~~~"
        raise ActiveRecord::Rollback 
        redirect_to :action => "assignment_listing", :course_id => assignment.course_id
        return
      end

      if (process.pid != nil)
        puts "~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~Killing Process~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~"
        system ("kill #{process.pid.to_s}")
      end
      process.delete
      assignment.delete
    end
    redirect_to :action => "assignment_listing", :course_id => assignment.course_id
  end

  def assignment_sim_result_view
    begin
      @assignment = retrieve_assignment(params[:assignment_id])
      raise ("Assignment id is nil") if (@assignment == nil)

      @page = params[:page]
      @page = 1 if @page == nil
      @page = @page.to_i

      @resultsPerPage = params[:rpp]
      @resultsPerPage = 15 if @resutlsPerPage == nil
      @resultsPerPage = @resultsPerPage.to_i

      @sortType = params[:sort]
      @sortType = "max" if @sortType == nil

      @sortDirection = params[:sortDirection]
      @sortDirection = "desc" if @sortDirection == nil

      @showOnlyStudents = [params[:fs1], params[:fs2]];
      @showOnlyStudents = @showOnlyStudents.compact.uniq

      while @showOnlyStudents.size < 2
        @showOnlyStudents.push("")
      end

      @showOnlyStudents.collect! { |item| "%" + item + "%" }
      
    rescue Exception => exec
      puts exec
      flash[:notice] = "Invalid selection"
      redirect_to :action => "error"
      return
    end
  end
  def assignment_sim_result_html_view
    begin
      @asr = retrieve_assignment_sim_result(params[:assignment_sim_result_id])
      raise ("ASR is nil") if (@asr == nil)
    rescue Exception => exc
      puts exc
      flash[:notice] = "Invalid selection"
      redirect_to :action => "error"
    end
  end

  def assignment_report_plagiarism
    begin
      @asr = retrieve_assignment_sim_result(params[:assignment_sim_result_id])
      raise ("ASR is nil") if (@asr == nil)
      if @asr.status == 0 || @asr.status == 1
        @asr.status = 3
        @asr.save
        create_plag_log(@asr.code1.student.id, @asr.code1.id, @asr.id, 0)
        create_plag_log(@asr.code2.student.id, @asr.code2.id, @asr.id, 0)
      end
      redirect_to :action => "assignment_sim_result_html_view", :assignment_sim_result_id => params[:assignment_sim_result_id], :page => params[:page], :rpp => params[:rpp], :sort => params[:sort], :sortDirection => params[:sortDirection], :fs1 => params[:fs1], :fs2 => params[:fs2]
    rescue Exception => exc
      puts exc
      flash[:notice] = "Invalid selection"
      redirect_to :action => "error"
    end
    
  end
  def assignment_confirm_plagiarism
    begin
      @asr = retrieve_assignment_sim_result(params[:assignment_sim_result_id])
      raise ("ASR is nil") if (@asr == nil)
      @code = retrieve_assignment_code(params[:assignment_code_id])
      raise ("Code is nil") if (@code == nil)
      
      @asr.status = 2 if @asr.status == 3
      @asr.save
      create_plag_log(@asr.code1.student.id, @asr.code1.id, @asr.id, 2)
      create_plag_log(@asr.code2.student.id, @asr.code2.id, @asr.id, 2)

      if @asr.status == 2
        @code.plagiarism = true 
        @code.save
        create_plag_log(@code.student.id, @code.id, @asr.id, 3)
      end

      redirect_to :action => "assignment_sim_result_html_view", :assignment_sim_result_id => params[:assignment_sim_result_id], :page => params[:page], :rpp => params[:rpp], :sort => params[:sort], :sortDirection => params[:sortDirection], :fs1 => params[:fs1], :fs2 => params[:fs2]
    rescue Exception => exc
      puts exc
      flash[:notice] = "Invalid selection"
      redirect_to :action => "error"
    end
  end
  def assignment_decline_plagiarism
    begin
      @asr = retrieve_assignment_sim_result(params[:assignment_sim_result_id])
      raise ("ASR is nil") if (@asr == nil)

      if (@asr.status == 3)
        @asr.status = 1
        @asr.save
        create_plag_log(@asr.code1.student.id, @asr.code1.id, @asr.id, 1)
        create_plag_log(@asr.code2.student.id, @asr.code2.id, @asr.id, 1)
      end
      
      redirect_to :action => "assignment_sim_result_html_view", :assignment_sim_result_id => params[:assignment_sim_result_id], :page => params[:page], :rpp => params[:rpp], :sort => params[:sort], :sortDirection => params[:sortDirection], :fs1 => params[:fs1], :fs2 => params[:fs2]
    rescue Exception => exc
      puts exc
      flash[:notice] = "Invalid selection"
      redirect_to :action => "error"
    end
  end
  def assignment_clear_plagiarism
    begin
      @asr = retrieve_assignment_sim_result(params[:assignment_sim_result_id])
      raise ("ASR is nil") if (@asr == nil)
      @code = retrieve_assignment_code(params[:assignment_code_id])
      raise ("Code is nil") if (@code == nil)

      @code.plagiarism = false
      @code.save
      create_plag_log(@code.student.id, @code.id, @asr.id, 4)

      if (!@asr.code1.plagiarism && !@asr.code2.plagiarism && @asr.status == 2)
        @asr.status = 1
        @asr.save
        create_plag_log(@asr.code1.student.id, @asr.code1.id, @asr.id, 1)
        create_plag_log(@asr.code2.student.id, @asr.code2.id, @asr.id, 1)
      end      
      
      redirect_to :action => "assignment_sim_result_html_view", :assignment_sim_result_id => params[:assignment_sim_result_id], :page => params[:page], :rpp => params[:rpp], :sort => params[:sort], :sortDirection => params[:sortDirection], :fs1 => params[:fs1], :fs2 => params[:fs2]
    rescue Exception => exc
      puts exc
      flash[:notice] = "Invalid selection"
      redirect_to :action => "error"
    end
  end

  def assignment_clustering_delete
    begin
      @clustering = retrieve_clustering(params[:clustering_id])
      raise ("Clustering is nil") if (!@clustering)
      @clustering.destroy
      redirect_to :action => "assignment_clustering_listing", :assignment_id => params[:assignment_id]
    rescue Exception => exc
      puts (exc)
      flash[:notice] = "Invalid clustering selection"
      redirect_to :action => "assignment_clustering_listing", :assignment_id => params[:assignment_id]
    end
  end
  def assignment_clustering_listing
    begin
      @assignment = retrieve_assignment(params[:assignment_id])
      raise "assignment is nil" if (@assignment == nil)
      @acs = @assignment.clusterings

    rescue Exception => exc
      puts exc
      flash[:notice] = "Invalid selection"
      redirect_to :action => "error"
    end
  end
  def assignment_clustering_new
    @assignment = retrieve_assignment(params[:assignment_id])
    raise "assignment is nil" if (@assignment == nil)
    @clustering = AssignmentClustering.new

    @clustering.dateTime = Time.now
    min = 101
    @assignment.plagiarism.each { | result |
      min = result.sim if (min > result.sim)
    }
    @clustering.reported =  min

    min = 101
    @assignment.confirmed_plagiarism.each { | result |
      min = result.sim if (min > result.sim)
    }
    @clustering.confirmed = min

  rescue Exception => exc
    puts exc
    flash[:notice] = "Invalid selection"
    redirect_to :action => "error"
  end
  def assignment_clustering_create
    begin
      @assignment = retrieve_assignment(params[:assignment_clustering][:assignment_id])
      raise "assignment is nil" if (@assignment == nil)
    rescue Exception => exc
      flash[:notice] = "Invalid selection"
      redirect_to :action => "error"
      return
    end

    begin
      case params[:assignment_clustering][:type]
      when "confirmed"
        params[:assignment_clustering][:coc] = params[:assignment_clustering][:confirmed]
        params[:assignment_clustering][:remark] = "Based on confirmed plagiarism cases"
      when "reported"
        params[:assignment_clustering][:coc] = params[:assignment_clustering][:reported]
        params[:assignment_clustering][:remark] = "Based on suspicious and confirmed plagiarism cases"
      else
        params[:assignment_clustering][:coc] = params[:assignment_clustering][:coc]
        params[:assignment_clustering][:remark] = "Based on user defined cut off criterion"
      end
      
      
      @clustering = AssignmentClustering.new(params[:assignment_clustering])

    rescue Exception => exc
      puts exc.message
      puts exc.backtrace
      logger.error("Message for the log file #{exc.message}")
      flash[:notice] = "Clustering creation error"
      redirect_to :action => 'error'
      return
    end

    if (@clustering.save)
      @clustering.created_at = params[:assignment_clustering][:dateTime]
      @assignment.clusterings << @clustering
      
      jar_path = File.join(JAVA_ROOT, "programs", "DBSCAN.jar")
	  config   = Rails.configuration.database_configuration
	  host     = config[Rails.env]["host"]
	  database = config[Rails.env]["database"]
	  username = config[Rails.env]["username"]
	  password = config[Rails.env]["password"]

      if (!system("java -jar \"#{jar_path}\" #{@clustering.assignment_id} #{@clustering.id} #{@clustering.coc} #{host} #{database} #{username} #{password} > upload_log/log.txt"))
        flash[:notice] = "Clustering program error"
        render :action => "assignment_clustering_new"
        return
      end
    else
      @clustering.errors.each { |k, v|
        if k == "coc" && v == " of specified value has previously created" &&
            (params[:assignment_clustering][:type] == "confirmed" || params[:assignment_clustering][:type] == "reported")
          @clustering.errors.clear
          @clustering.errors.add_to_base("Cut off criterion of specified value has previously created")
          @clustering.coc = nil          
        end
        @clustering.type = params[:assignment_clustering][:type]
      }
      render :action => "assignment_clustering_new"
      return
    end
    redirect_to :action => 'assignment_clustering_listing', :assignment_id => @assignment.id
  end
    
  def graph_view_groups
    @course = retrieve_course(params[:course_id])
    raise ("Course is nil") if (@course == nil)
    @view = "groups"
    render :layout => 'graph'
  rescue Exception => exec
    puts exec
    flash[:notice] = "Invalid course selection"
    redirect_to :action => "error"
  end
  def graph_view_movement
    @course = retrieve_course(params[:course_id])
    raise ("Course is nil") if (@course == nil)
    @view = "movement"
    render :layout => 'graph'
  rescue Exception => exec
    puts exec
    flash[:notice] = "Invalid course selection"
    redirect_to :action => "error"
  end
  def graph_view_assignments
    @course = retrieve_course(params[:course_id])
    raise ("Course is nil") if (@course == nil)
    @view = "assignments"
    render :layout => 'graph'
  rescue Exception => exec
    puts exec
    flash[:notice] = "Invalid course selection"
    redirect_to :action => "error"
  end
  def graph_view_ibetween
    @course = retrieve_course(params[:course_id])
    raise ("Course is nil") if (@course == nil)
    sql_query = "select DISTINCT codes.* FROM assignments as a, assignment_sim_results as asr, assignment_codes as codes WHERE a.course_id = ? AND asr.assignment_id = a.id AND (codes.id = asr.id1 OR codes.id = asr.id2)"
    codes = AssignmentCode.find_by_sql([sql_query, @course.id])
    allCoders = {}
    codes.each { |code|
      coder = code.student.matric
      if (!allCoders.has_key?(coder))
        allCoders[coder] = true
      end
    }
    @allCoders = allCoders.keys.sort!
    @view = "ibetween"
    render :layout => 'graph'
  rescue Exception => exec
    puts exec
    flash[:notice] = "Invalid course selection"
    redirect_to :action => "error"
  end
  def graph_view_iTopK
    @course = retrieve_course(params[:course_id])
    raise ("Course is nil") if (@course == nil)
    sql_query = "select DISTINCT codes.* FROM assignments as a, assignment_sim_results as asr, assignment_codes as codes WHERE a.course_id = ? AND asr.assignment_id = a.id AND (codes.id = asr.id1 OR codes.id = asr.id2)"
    codes = AssignmentCode.find_by_sql([sql_query, @course.id])
    allCoders = {}
    codes.each { |code|
      coder = code.student.matric
      if (!allCoders.has_key?(coder))
        allCoders[coder] = true
      end
    }
    @allCoders = allCoders.keys.sort!
    @view = "iTopK"
    render :layout => 'graph'
  rescue Exception => exec
    puts exec
    flash[:notice] = "Invalid course selection"
    redirect_to :action => "error"
  end
  def graph_view_igroups
    @course = retrieve_course(params[:course_id])
    raise ("Course is nil") if (@course == nil)
    sql_query = "select DISTINCT codes.* FROM assignments as a, assignment_sim_results as asr, assignment_codes as codes WHERE a.course_id = ? AND asr.assignment_id = a.id AND (codes.id = asr.id1 OR codes.id = asr.id2)"
    codes = AssignmentCode.find_by_sql([sql_query, @course.id])
    allCoders = {}
    codes.each { |code|
      coder = code.student.matric
      if (!allCoders.has_key?(coder))
        allCoders[coder] = true
      end
    }
    @allCoders = allCoders.keys.sort!
    @view = "igroups"
    render :layout => 'graph'
  rescue Exception => exec
    puts exec
    flash[:notice] = "Invalid course selection"
    redirect_to :action => "error"
  end

  def graph_assignments
    @assignments = []
    params[:assignment].keys.sort!.each { |id|
      assignment = retrieve_assignment(id)
      raise ("Assignment is nil") if (assignment == nil)
      @assignments << assignment
    }
    @assignments.sort! { |a, b|
      a.created_at <=> b.created_at
    }
  rescue Exception => exec
    puts exec
    flash[:notice] = "Invalid selection"
    redirect_to :action => "error"
  end
  def graph_assignments_left
    @assignments = []
    params[:assignment].keys.sort!.each { |id|
      assignment = retrieve_assignment(id)
      raise ("Assignment is nil") if (assignment == nil)
      @assignments << assignment
    }
    @assignments.sort! { |a, b|
      a.created_at <=> b.created_at
    }
  rescue Exception => exec
    puts exec
    flash[:notice] = "Invalid selection"
    redirect_to :action => "error"
  end
  def graph_clusters
    @clusters = []
    params[:clusters].sort!.each { |id|
      cluster = retrieve_cluster(id)
      raise ("Cluster " + id + " is nil") if (cluster == nil)
      @clusters << cluster
    }
  rescue Exception => exec
    puts exec
    flash[:notice] = "Invalid selection"
    redirect_to :action => "error"
  end
  def graph_movement
    cluster_id = params[:clusters].first
    raise("Cluster Id is nil") if (cluster_id == nil)
    cluster = retrieve_cluster(cluster_id)
    raise ("Cluster " + cluster_id.to_s + "is nil") if (cluster == nil)
    @course = cluster.assignment_clustering.assignment.course

    @students = []
    codes = cluster.assignment_codes
    for i in (0...codes.length)
      @students << codes[i].student
    end

  rescue Exception => exec
    puts exec
    flash[:notice] = "Invalid selection"
    redirect_to :action => "error"
  end
  def graph_sims
    course_id = params[:courseId]
    raise ("Course Id is nil") if (course_id == nil)
    @course = retrieve_course(course_id)
    raise ("Course " + course_id + " is nil") if (@course == nil)
        
    @students = []
    for i in (0...params[:programmers].length)
      @students << params[:programmers][i]
    end
    raise ("Less than 2 students is selected") if (@students.length < 2)
  rescue Exception => exec
    puts exec
    flash[:notice] = "Invalid selection"
    redirect_to :action => "error"
  end
  def graph_top
    course_id = params[:courseId]
    raise ("Course Id is nil") if (course_id == nil)
    @course = retrieve_course(course_id)
    raise ("Course " + course_id + " is nil") if (@course == nil)

    matric = params[:programmer]
    raise ("Programmer is nil") if (matric == nil)
    
    @student = Student.find_by_matric(matric)
    
    raise ("K is nil") if (params[:k] == nil || params[:k] =~ /\D/)
    @k = params[:k].to_i
  rescue Exception => exec
    puts exec
    flash[:notice] = "Invalid selection"
    redirect_to :action => "error"
  end
  def graph_groups
    course_id = params[:courseId]
    raise ("Course Id is nil") if (course_id == nil)
    @course = retrieve_course(course_id)
    raise ("Course " + course_id + " is nil") if (@course == nil)

    studentMatric = params[:programmer]
    raise ("Student is nil") if (studentMatric == nil)
    
    @student = Student.find_by_matric studentMatric
    raise ("Student not found") if (@student == nil)

  rescue Exception => exec
    puts exec
    flash[:notice] = "Invalid selection"
    redirect_to :action => "error"
  end
  def graph_sim_result_html_view
    asr_id = params[:assignment_sim_result_id]
    raise("Assignmet sim result id is nil") if (asr_id == nil)

    @asr = retrieve_assignment_sim_result(asr_id)
    @course = @asr.assignment.course
    @matric = params[:matric]
    raise("matric is nil") if (@matric == nil)

    @k = params[:k]
    raise("k is nil") if (@k == nil)
    @k = @k.to_i
    
  rescue Exception => exec
    puts exec
    flash[:notice] = "Invalid selection"
    redirect_to :action => "error"
  end

  def graph_report_plagiarism
    begin
      @asr = retrieve_assignment_sim_result(params[:assignment_sim_result_id])
      raise ("ASR is nil") if (@asr == nil)
      if @asr.status == 0 || @asr.status == 1
        @asr.status = 3
        @asr.save
        create_plag_log(@asr.code1.student.id, @asr.code1.id, @asr.id, 0)
        create_plag_log(@asr.code2.student.id, @asr.code2.id, @asr.id, 0)
      end
      redirect_to :action => "graph_sim_result_html_view", :assignment_sim_result_id => params[:assignment_sim_result_id], :matric => params[:matric], :k => params[:k]
    rescue Exception => exc
      puts exc
      flash[:notice] = "Invalid selection"
      redirect_to :action => "error"
    end

  end
  def graph_confirm_plagiarism
    begin
      @asr = retrieve_assignment_sim_result(params[:assignment_sim_result_id])
      raise ("ASR is nil") if (@asr == nil)
      @code = retrieve_assignment_code(params[:assignment_code_id])
      raise ("Code is nil") if (@code == nil)

      @asr.status = 2 if @asr.status == 3
      @asr.save
      create_plag_log(@asr.code1.student.id, @asr.code1.id, @asr.id, 2)
      create_plag_log(@asr.code2.student.id, @asr.code2.id, @asr.id, 2)

      if @asr.status == 2
        @code.plagiarism = true
        @code.save
        create_plag_log(@code.student.id, @code.id, @asr.id, 3)
      end
      redirect_to :action => "graph_sim_result_html_view", :assignment_sim_result_id => params[:assignment_sim_result_id], :matric => params[:matric], :k => params[:k]
    rescue Exception => exc
      puts exc
      flash[:notice] = "Invalid selection"
      redirect_to :action => "error"
    end
  end
  def graph_decline_plagiarism
    begin
      @asr = retrieve_assignment_sim_result(params[:assignment_sim_result_id])
      raise ("ASR is nil") if (@asr == nil)

      if (@asr.status == 3)
        @asr.status = 1
        @asr.save
        create_plag_log(@asr.code1.student.id, @asr.code1.id, @asr.id, 1)
        create_plag_log(@asr.code2.student.id, @asr.code2.id, @asr.id, 1)
      end
      redirect_to :action => "graph_sim_result_html_view", :assignment_sim_result_id => params[:assignment_sim_result_id], :matric => params[:matric], :k => params[:k]
    rescue Exception => exc
      puts exc
      flash[:notice] = "Invalid selection"
      redirect_to :action => "error"
    end
  end
  def graph_clear_plagiarism
    begin
      @asr = retrieve_assignment_sim_result(params[:assignment_sim_result_id])
      raise ("ASR is nil") if (@asr == nil)
      @code = retrieve_assignment_code(params[:assignment_code_id])
      raise ("Code is nil") if (@code == nil)

      @code.plagiarism = false
      @code.save
      create_plag_log(@code.student.id, @code.id, @asr.id, 4)

      if (!@asr.code1.plagiarism && !@asr.code2.plagiarism && @asr.status == 2)
        @asr.status = 1
        @asr.save
        create_plag_log(@asr.code1.student.id, @asr.code1.id, @asr.id, 1)
        create_plag_log(@asr.code2.student.id, @asr.code2.id, @asr.id, 1)
      end

      redirect_to :action => "graph_sim_result_html_view", :assignment_sim_result_id => params[:assignment_sim_result_id], :matric => params[:matric], :k => params[:k]
    rescue Exception => exc
      puts exc
      flash[:notice] = "Invalid selection"
      redirect_to :action => "error"
    end
  end

  def error
        
  end

  private
  #Retrieve all courses which the user has the right to access
  def retrieve_courses
    sql_query = "SELECT c.* FROM courses as c, teachings as t WHERE t.course_id = c.id AND t.account_id = ? AND (c.expiry >= Now() || t.role = 0)"
    Course.find_by_sql([sql_query, @user_account.id])
  end
  #Given the course Id, retrieve the course from the database provided the user has the right to access the course
  def retrieve_course(course_id)
    sql_query = "SELECT c.* FROM courses as c, teachings as t WHERE c.id = ? AND t.course_id = c.id AND t.account_id = ? AND (c.expiry >= Now() || t.role = 0)"
    Course.find_by_sql([sql_query, course_id, @user_account.id]).first
  end
  #Given the assignment Id, retrieve the assignment from the database provided the user has the right to access the assignment
  def retrieve_assignment(assignment_id)
    sql_query = "SELECT a.* FROM courses as c, assignments as a, teachings as t WHERE a.id = ? AND a.course_id = t.course_id AND a.course_id = c.id AND t.account_id = ? AND (c.expiry >= Now() || t.role = 0)"
    Assignment.find_by_sql([sql_query, assignment_id, @user_account.id]).first
  end
  #Given the assignment similiar result id, retrieve the similiar result from the database provided the user has the right to access the result
  def retrieve_assignment_sim_result(assignment_sim_result_id)
    sql_query = "SELECT asr.* FROM assignment_sim_results as asr, assignments as a, teachings as t, courses as c WHERE asr.id = ? AND asr.assignment_id = a.id AND a.course_id = t.course_id AND c.id = t.course_id AND t.account_id = ? AND (c.expiry >= Now() || t.role = 0)"
    AssignmentSimResult.find_by_sql([sql_query, assignment_sim_result_id, @user_account.id]).first
  end
  def retrieve_assignment_code(assignment_code_id)
    sql_query = "SELECT code.* FROM assignment_codes as code, assignment_sim_results as asr, assignments as a, teachings as t, courses as c WHERE code.id = ? AND (asr.id1 = code.id OR asr.id2 = code.id) AND asr.assignment_id = a.id AND a.course_id = t.course_id AND c.id = t.course_id AND t.account_id = ? AND (c.expiry >= Now() || t.role = 0)"
    AssignmentCode.find_by_sql([sql_query, assignment_code_id, @user_account.id]).first
  end
  #Given the clustering id, retrive the clustering from the database provided the user has the right to access the clustering
  def retrieve_clustering(clustering_id)
    sql_query = "SELECT ac.* FROM courses as c, assignment_clusterings as ac, assignments as a, teachings as t WHERE ac.id = ? AND ac.assignment_id = a.id AND a.course_id = t.course_id AND c.id = t.course_id AND t.account_id = ? AND (c.expiry >= Now() || t.role = 0)"
    AssignmentClustering.find_by_sql([sql_query, clustering_id, @user_account.id]).first
  end
  #Given the cluster Id, retrieve the cluster from the database provided the user has the right to access the cluster
  def retrieve_cluster(cluster_id)
    sql_query = "SELECT ac.* FROM courses as c, assignment_clusters as ac, assignment_clusterings as acs, assignments as a, teachings as t WHERE ac.id = ? AND ac.assignment_clustering_id = acs.id AND c.id = t.course_id AND acs.assignment_id = a.id AND a.course_id = t.course_id AND t.account_id = ? AND (c.expiry >= Now() || t.role = 0)"
    AssignmentCluster.find_by_sql([sql_query, cluster_id, @user_account.id]).first
  end

  def create_plag_log(student_id, assignment_code_id, assignment_sim_result_id, log_type)
    PlagLog.create(
      :student_id => student_id,
      :account_id => @user_account.id,
      :assignment_code_id => assignment_code_id,
      :assignment_sim_result_id => assignment_sim_result_id,
      :log_type => log_type
    )
  end

  COMPARE_FOLDER = "_compare"
  LANGUAGE_FILES = { "c" => "cpp, c, h", "java" => "java" }

  def localize_upload_file(id)
    # Create the upload folder if not exists
    verify_create_upload_folder

    # Create / Remove contents of the assignment specific upload folder
    directory = "upload/#{id}"
    directory_path = File.join(RAILS_ROOT, directory)

    verify_create_assignment_delicated_folder(directory_path)

    file_name = params[:upload][:zipfile].original_filename
    file_path = File.join(directory_path, file_name)

    upload_file = params[:upload][:zipfile]

    platform = determine_os

    case platform
      #if (platform == "windows")
    when "windows"
      File.open(file_path, "wb") { |f| f.write(upload_file.read) }
      #else
    when "linux"
      File.open(file_path, "w") { |f| f.write(upload_file.read) }
    end
   
    upload_file.rewind
    
    return directory_path, file_path
  end
  def unzip_localized_file(directory_path, file_path, assignment_id)
    
    platform = determine_os

    case platform
    when "windows"
      #command = "\"C:/program files/winrar/winrar\" x -o+ \"#{file_path}\" \"#{directory_path}\""
      command = "\"C:/program files/7-Zip/7z.exe\" x -o\"#{directory_path}\" \"#{file_path}\" -y >> \"upload_log/#{assignment_id}\""
      command = command.gsub("/" , "\\")
    when "linux"
      #command = "unzip \"#{file_path}\" -d \"#{directory_path}\" > \"#{directory_path}/unzip.log\""
      command = "unzip \"#{file_path}\" -d \"#{directory_path}\" >> \"upload_log/#{assignment_id}\""
    end

    system "echo \"==== Start of Unzip Section ====\" > \"upload_log/#{assignment_id}\""

    if (system(command))
      system "echo \"==== End of Unzip Section ====\" >> \"upload_log/#{assignment_id}\""
      system "echo \"\" >> \"upload_log/#{assignment_id}\""
    end

    return
  end
  def verify_create_upload_folder
    directory_path = File.join(RAILS_ROOT, "upload")
    if (!File.directory?(directory_path))
      Dir.mkdir(directory_path)
    end
  end
  def verify_create_assignment_delicated_folder(directory_path)
    if (!File.directory?(directory_path))
      Dir.mkdir(directory_path)
    else
      FileUtils.rm_r Dir.glob(directory_path + "/*"), :force => true
    end
  end
  def remove_localized_file(file_path)
    FileUtils.rm file_path, :force => true
  end
  def determine_os
    if (RUBY_PLATFORM.index("mswin"))
      "windows"
    else
      "linux"
    end
  end
  def compute_similarity(directory_path, assignment_id, language, method, min, ngram)

    create_compare_directory(directory_path)

    combine_codings(directory_path, language)

    combined_folder = File.join(directory_path, COMPARE_FOLDER)

	config   = Rails.configuration.database_configuration
	host     = config[Rails.env]["host"]
	database = config[Rails.env]["database"]
	username = config[Rails.env]["username"]
	password = config[Rails.env]["password"]
	
    CompareMethods.send(method, assignment_id, combined_folder, language, min, ngram, host, database, username, password)
  end
  def combine_codings(directory_path, language)
    Dir.glob(directory_path + "/*").collect { |target|
      #Directory Path = D:/My Documents/NUS/Course/FYP/PDS/upload/1
      #Target = D:/My Documents/NUS/Course/FYP/PDS/upload/1/u0805421
      #Local Directory = u0805421

      local_directory = File.basename(target)
      if (local_directory != COMPARE_FOLDER)
        combined_filename = File.join(directory_path, COMPARE_FOLDER, local_directory)

        if (File.directory?(target)) #target is a directory
          combine_folder_codings(target, combined_filename, language)
        else #the target is a file
          copy_coding(target, combined_filename, language)
        end
      end
    }
  end
  def create_compare_directory(directory_path)
    directory_path = File.join(directory_path, COMPARE_FOLDER)
    if (!File.directory?(directory_path))
      Dir.mkdir(directory_path)
    end
  end
  def copy_coding(source_path, target_filename, language)
    if (determine_os == "windows")
      append_type = "ab"
    else
      append_type = "a"
    end

    target_filename.chomp!(File.extname(target_filename))
    LANGUAGE_FILES[language].each { |lang|
      if (File.extname(source_path) == ("." + lang))
        File.open(target_filename, append_type) { |f|
          File.open(source_path, "r") do |infile|
            while (line = infile.gets)
              f.write(line)
            end
          end
          f.write("\n");
        }
      end
    }
  end
  def combine_folder_codings(source_directory_path, target_filename, language)
    if (determine_os == "windows")
      append_type = "ab"
    else
      append_type = "a"
    end

    LANGUAGE_FILES[language].each { |lang|
      Dir.glob(source_directory_path + "/*.{#{lang}}").collect { |file|
        if (File.file?(file))
          File.open(target_filename, append_type) { |f|
            File.open(file, "r") do |infile|
              while (line = infile.gets)
                f.write(line)
              end
            end
            f.write("\n")
          }
        end
      }
    }
    
  end
end
