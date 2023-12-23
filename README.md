# Student Submission Integrity Diagnosis

Student Submission Integrity Diagnosis (SSID) is a Ruby on Rails web application suite for managing courses, assignments, staff, teaching assistants, students, and student code submissions and most importantly, to **detect and visualize plagiarism** among student code submissions. 

SSID works with lexers based on [ANTLR4 Grammars](https://github.com/antlr/grammars-v4) so if you can find / write a grammar for it, SSID can detect and visualize plagiarism for it (scroll down and click on the guide on "Adding support for new language in SSID" to learn the steps needed to add a new grammar).  SSID uses the [JavaScript InfoVis Toolkit](http://philogb.github.com/jit/) for its plagiarism visualization. Code display and syntax highlighting is handled by [google-code-prettify](http://code.google.com/p/google-code-prettify/). The file upload preview feature makes use of [JSZip](https://github.com/Stuk/jszip). 

## Table Of Contents

- [Prerequisites](#prerequisites)
- [Setup & Configuration](#setup-and-configuration)
- [Site Map](#site-map)
- [License](#license)

## Prerequisites

---
**NOTE**: If you are using a Windows OS, please ensure that you have a linux environment to make changes to the code and run it in either the development or production mode. This is because some functions like fork are not supported by the Windows OS. To run a linux environment on Windows, you can either
- [Dual boot linux on Windows](https://itsfoss.com/install-ubuntu-1404-dual-boot-mode-windows-8-81-uefi/) (Recommended)
- [Install Cygwin](https://www.cygwin.com/)
---
  
1. Ensure you have Java `11` (revision `11` or later) installed in your Computer.
2. Ensure that you have installed Ruby (v2.6.6) and [bundler](https://rubygems.org/gems/bundler/versions/2.1.4) (v2.1.4) 
3. Since the application uses MySQL as its database server, please ensure that you have installed MySQL 8.0.

## Setup and Configuration

Before following the below instructions, please ensure that you have met all the prerequesties listed below. Alternatively, you can also setup the application via docker by clicking on the docker setup documentation all the way below.

1. Clone SSID's source code onto your computer
	<pre>git clone https://github.com/WING-NUS/SSID.git</pre>
	
2. Go to *config/database.yml* and modify the file by changing the username and password fields with your MySQL database settings (Please do it for all the 3 listed databases in the file)
	
3. Now, go to *config/environments/* and add the respective line to the respective file(s)
   -  Under *config/environments/development.rb* & *config/environments/test.rb*, add the below line:
   <pre>config.eager_load = false</pre>

   -  Under *config/environments/production.rb* add the below line:
   <pre>config.eager_load = true</pre>
     
4. Open your terminal and navigate to the code directory. Run bundler to install the necessary gems (including rails) from the root directory of SSID:
     <pre>bundle install</pre>
     #Use the following solution if you have problem "Your bundle is locked to mimemagic (0.3.5)"
     <pre>https://stackoverflow.com/questions/66919504/your-bundle-is-locked-to-mimemagic-0-3-5-but-that-version-could-not-be-found</pre>
        
5. Execute the following command in the root directory of SSID depending on which mode you wish to run the app:
	- Production Mode
	<pre>
	rake db:migrate RAILS_ENV=production
	rake db:seed
	</pre>

	- Development Mode
	<pre>
	rake db:create db:schema:dump db:migrate RAILS_ENV=development
	rake db:seed
	</pre>
 
6. Running SSID: Execute the following command in the root directory of SSID depending on which mode you wish to run the app:

	- Production mode: configure Apache to serve web requests to SSID
	
    - Development mode:
	<pre>
	RAILS_ENV=development rails server
	</pre>

## Site Map
- [Setting up using Docker] (doc/docker.md)
- [Adding support for new language in SSID](doc/add_support_for_new_language.md)
- [Deploying SSID app on a Linux/Unix production server](doc/deploying_rails_on_linux.md)
- [Guide for semestral clearing of courses and submissions](doc/semestral_clearing_guide.md)
- [User Guide](doc/SSID_User%20Guide_V2.pdf)

## Contact

To request features, you may want to log an issue on [Github](https://github.com/WING-NUS/SSID/issues).

For other inquiries, please [contact us](mailto:wing.nus@gmail.com) with subject starting with `[SSID]`

## License

SSID is licensed under the [GNU Lesser General Public License] [gpl]

[gpl]: http://www.gnu.org/licenses/
