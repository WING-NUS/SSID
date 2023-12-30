Set-up guide using Docker
=======================

This guide will list the steps required to setup the application using Docker. 

### Prerequisites

Please ensure that you have downloaded Docker in your local machine. Docker can be installed from https://www.docker.com/products/docker-desktop/. When you open the Docker web application, the application should be displaying a green icon on the bottom left with the hover text, "Running". 

### Set-up commands
1. Clone SSID's source code onto your computer
    <pre>git clone https://github.com/WING-NUS/SSID.git</pre>
2. Copy all the contents from config/database.docker.yml to replace all the contents of config/database.yml.
3. From here on, if any of the commands fail, try adding sudo in front of the commands (for Mac/Linux systems). For Windows systems, try running the commands in an administrator command prompt.
4. Open a terminal and under the application root directory, run the command below:
    <pre>docker build .</pre>
5. Next run the below commands:
    <pre>cd config/
   docker-compose run web bundle install
   docker-compose run web rails db:setup
   docker-compose build 
   docker-compose up</pre>
6. Go to 127.0.0.1:3000 in the browser to see the login interface
7. Login with username `ssidadmin123@example.com` and password `SSIDPassword123!`

### Shutting down the application
1. To shut down the application, press Ctrl+C in the terminal where the application is running.

### Turning on the application
1. To turn on the application, run the command below:
    <pre>docker-compose up</pre>