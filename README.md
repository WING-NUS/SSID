# Student Submission Integrity Diagnosis

Student Submission Integrity Diagnosis (SSID) is a Ruby on Rails web application suite for managing courses, assignments, staff, teaching assistants, students, and student code submissions and most importantly, to **detect and visualize plagiarism** among student code submissions. 

SSID works with lexers based on [ANTLR Grammars](http://www.antlr.org/grammar/list) so if you can find / write a grammar for it, SSID can detect and visualize plagiarism for it. SSID uses the [JavaScript InfoVis Toolkit](http://philogb.github.com/jit/) for its plagiarism visualization. Code display and syntax highlighting is handled by [google-code-prettify](http://code.google.com/p/google-code-prettify/). 

## Installation
1. Install MySQL, Apache, Ruby (1.9.2), and [bundler](http://gembundler.com) v1.1.2 

2. Download SSID from [its GitHub repository](https://github.com/WING-NUS/SSID)
	<pre>git clone https://github.com/WING-NUS/SSID.git</pre>
	
3. Download [MySQL Connector/J version 5.1.13](http://dev.mysql.com/downloads/connector/) and place the downloaded file *mysql-connector-java-5.1.13-bin.jar* into the directory: *lib/java/jar*

## Configuration

1. Copy *config/database.yml.mysql-template* to
	 *config/database/database.yml* and modify it with your database settings
	 
2. Run bundler to install the necessary gems (including rails) from the root
   directory of SSID:
     <pre>bundle install</pre>
     
3. Execute the following command in the root directory of SSID:
	 <pre>
	rake db:migrate RAILS_ENV="production"
	rake db:seed
	</pre>
	 
4. Configure Apache to serve web requests to SSID

## License

SSID is licensed under the [GNU Lesser General Public License] [gpl]

[gpl]: http://www.gnu.org/licenses/
