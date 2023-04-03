Set-up guide using Docker
=======================

This guide will list the steps required to setup the application using Docker. 

### Prerequisites

Please ensure that you have downloaded Docker in your local machine. When you open the Docker web application, the application should be displaying a green icon on the bottom left with the hover text, "Running". 

### Set-up commands
1. Clone SSID's source code onto your computer
    <pre>git clone https://github.com/WING-NUS/SSID.git</pre>
2. Copy config/database.docker.yml to config/database.yml
3. Open a terminal and under the application root directory, run the below command:
    <pre>docker build .</pre>
4. Next run the below commands:
    <pre>cd config/
   docker-compose run web bundle install
   docker-compose run web rails db:setup
   docker-compose build 
   docker-compose up</pre>
5. Go to 127.0.0.1:3000 in the browser to see the login interface
6. Login with username `admin` and password `$$SSIDPassword$$`