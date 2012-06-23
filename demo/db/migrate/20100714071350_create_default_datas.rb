class CreateDefaultDatas < ActiveRecord::Migration
  def self.up

    self.down

    #Create a default admin account
    adminacc = Account.create(
      :login => 'admin',
      :password => 'admin',
      :password_confirmation => 'admin',
      :matric => 'S000001L',
      :name => 'Administrator',
      :expiry => '2020-12-31 23:59:59',
      :role => 0
    )
    adminacc.errors.each{|attr,msg| puts "#{attr} - #{msg}" }

    useracc1 = Account.create(
      :login => 'instructor1',
      :password => 'instructor1',
      :password_confirmation => 'instructor1',
      :matric => 'S000001A',
      :name => 'Instructor 1',
      :expiry => '2020-12-31 23:59:59',
      :role => 1
    )
    useracc1.errors.each{|attr,msg| puts "#{attr} - #{msg}" }
    useracc2 = Account.create(
      :login => 'instructor2',
      :password => 'instructor2',
      :password_confirmation => 'instructor2',
      :matric => 'S000002B',
      :name => 'Instructor 2',
      :expiry => '2020-12-31 23:59:59',
      :role => 1
    )
    useracc2.errors.each{|attr,msg| puts "#{attr} - #{msg}" }
    useracc3 = Account.create(
      :login => 'ta1',
      :password => 'ta1',
      :password_confirmation => 'ta1',
      :matric => 'S000003C',
      :name => 'Assistant 1',
      :expiry => '2020-12-31 23:59:59',
      :role => 1
    )
    useracc3.errors.each{|attr,msg| puts "#{attr} - #{msg}" }
    useracc4 = Account.create(
      :login => 'ta2',
      :password => 'ta2',
      :password_confirmation => 'ta2',
      :matric => 'S000004D',
      :name => 'Assistant 2',
      :expiry => '2020-12-31 23:59:59',
      :role => 1
    )
    useracc4.errors.each{|attr,msg| puts "#{attr} - #{msg}" }
    
    #Create a default annoucement made by default admin
    if adminacc
      adminacc.announcements.create(
        :content => 'Welcome to SSID. A plagiarism detection system developed in NUS.'
      )
    end

    #Create a default module
    mod1 = Course.create(
      :code => 'CS1101',
      :name => 'Programming Methodology',
      :academic_year => '09/10',
      :semester => 2,
      :expiry => '2020-06-31 23:59:59'
    )
    mod1.errors.each{|attr,msg| puts "#{attr} - #{msg}" }
    
    mod2 = Course.create(
      :code => 'CS1102',
      :name => 'Data Structures and Alogrithms',
      :academic_year => '09/10',
      :semester => 2,
      :expiry => '2020-06-31 23:59:59'
    )
    mod2.errors.each{|attr,msg| puts "#{attr} - #{msg}" }

    useracc1.teachings.create(:role => 0, :course => mod1)

    useracc2.teachings.create(:role => 0, :course => mod2)

    useracc3.teachings.create(:role => 1, :course => mod1)

    useracc4.teachings.create(:role => 1, :course => mod2)

    ActiveRecord::Base.connection.execute('create function higherInt(val1 FLOAT, val2 FLOAT) returns INTEGER begin if val1 > val2 then return round(val1 * 100); else return round(val2 * 100); end if; end')
    ActiveRecord::Base.connection.execute('create function higherFloat(val1 FLOAT, val2 FLOAT) returns FLOAT begin if val1 > val2 then return val1; else return val2; end if; end')
    ActiveRecord::Base.connection.execute('create procedure ttable() begin truncate table assignments; truncate table assignment_cluster_members; truncate table assignment_clusterings; truncate table assignment_clusters; truncate table assignment_codes; truncate table assignment_sim_results; truncate table students; truncate table sim_mappings; truncate table plag_logs; end')

  end

  def self.down
    Account.delete_all
    Announcement.delete_all
    Course.delete_all
    Teaching.delete_all
    ActiveRecord::Base.connection.execute('drop function if exists higherInt')
    ActiveRecord::Base.connection.execute('drop function if exists higherFloat')
    ActiveRecord::Base.connection.execute('drop procedure if exists ttable')

  end
end
