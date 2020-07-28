# Student Submission Integrity Diagnosis

Student Submission Integrity Diagnosis (SSID) is a Ruby on Rails web application suite for managing courses, assignments, staff, teaching assistants, students, and student code submissions and most importantly, to **detect and visualize plagiarism** among student code submissions. 

SSID works with lexers based on [ANTLR4 Grammars](https://github.com/antlr/grammars-v4) so if you can find / write a grammar for it, SSID can detect and visualize plagiarism for it -- The README in lib/antlr/grammars/src and lib/java/PlagiarismDetection lists the steps needed to add a new grammar.  SSID uses the [JavaScript InfoVis Toolkit](http://philogb.github.com/jit/) for its plagiarism visualization. Code display and syntax highlighting is handled by [google-code-prettify](http://code.google.com/p/google-code-prettify/). 

## Installation
1. Install MySQL 8.0, Apache, Ruby (2.6.6), and [bundler](https://rubygems.org/gems/bundler/versions/2.1.4) v2.1.4 

2. Download SSID from [its GitHub repository](https://github.com/WING-NUS/SSID)
	<pre>git clone https://github.com/WING-NUS/SSID.git</pre>
	
3. Download [MySQL Connector/J version 8.0.20](https://dev.mysql.com/downloads/connector/j/) and place the downloaded file *mysql-connector-java-8.0.20.jar* into the directory: *lib/java/jar*

## Configuration

1. Copy *config/database.yml.mysql-template* to
	 *config/database/database.yml* and modify it with your database settings
	 
2. Run bundler to install the necessary gems (including rails) from the root
   directory of SSID:
     <pre>bundle install</pre>
     
3. Execute the following command in the root directory of SSID:
	- Production Mode
	<pre>
	rake db:migrate RAILS_ENV=production
	rake db:seed
	</pre>
	- Development Mode
	<pre>
	rake db:create db:schema db:migrate RAILS_ENV=development
	rake db:seed
	</pre>
 
4. Running SSID
	- Production mode: configure Apache to serve web requests to SSID
	- Development mode:
	<pre>
	RAILS_ENV=development rails server
	</pre>

## License

SSID is licensed under the [GNU Lesser General Public License] [gpl]

[gpl]: http://www.gnu.org/licenses/
