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

    #Create a default annoucement made by default admin
    if adminacc
      adminacc.announcements.create(
        :content => 'Welcome to SSID. A plagiarism detection system developed in NUS.'
      )
    end

    ActiveRecord::Base.connection.execute('create function higherInt(val1 FLOAT, val2 FLOAT) returns INTEGER begin if val1 > val2 then return round(val1 * 100); else return round(val2 * 100); end if; end')
    ActiveRecord::Base.connection.execute('create function higherFloat(val1 FLOAT, val2 FLOAT) returns FLOAT begin if val1 > val2 then return val1; else return val2; end if; end')
    ActiveRecord::Base.connection.execute('create procedure ttable() begin truncate table assignments; truncate table assignment_cluster_members; truncate table assignment_clusterings; truncate table assignment_clusters; truncate table assignment_codes; truncate table assignment_sim_results; truncate table students; truncate table sim_mappings; truncate table plag_logs; end')

  end

  def self.down
    Account.delete_all
    Announcement.delete_all
    ActiveRecord::Base.connection.execute('drop function if exists higherInt')
    ActiveRecord::Base.connection.execute('drop function if exists higherFloat')
    ActiveRecord::Base.connection.execute('drop procedure if exists ttable')
  end
end
