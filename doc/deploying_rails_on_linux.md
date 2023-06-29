Deploying app on Linux/Unix production server
=======================
In this guide, you will learn how you can run the app on a linux server together with Passenger and deploy code changes or updates.

## Table Of Contents

- [Deploying app to linux server](#deploying-app-to-linux-server)
- [Accessing app code on the server](#accessing-app-code-on-the-server)
- [Deploying code changes or updates in the server](#deploying-code-changes-or-updates) 

## Deploying app to linux server

1. Ensure that "passenger" is in the Gemfile.

2. Login to the server with SSH with your account.

<pre>
ssh adminuser@yourserver.com
</pre>
> Replace adminuser with the name of an account with administrator privileges or sudo privileges.

3. Install Git on the server if not installed yet.

<pre>
sudo apt-get install -y git
</pre>

4. Create a directory in which to permanently store your application's code. In this guide, the code will be placed in `/var/www/SSID/code`.

<pre>
sudo mkdir -p /var/www/SSID/code
</pre>

5. Once done, now pull the code from Git.

<pre>
cd /var/www/SSID/code
git clone https://github.com/WING-NUS/SSID.git
</pre>

6. Install the app dependencies. Since most of these dependencies are gems in your Gemfile, managed by Bundler, you can install them by running:
<pre>
bundle install
</pre>

7. Setup the mysql database inside the server and configure database.yml 

8. Compile Rails assets and run database migrations.

<pre>
bundle exec rake assets:precompile db:migrate RAILS_ENV=production
</pre>

9. Now that we are done with transferring the app's code to the server and setting up an environment for the app, we can start configuring Passenger. Create a Passenger config file

<pre>
cd /var/www/ssid/code
nano Passengerfile.json
</pre>

10. Inside the Passengerfile.json, insert the following:

<pre>
{
  // Run the app in a production environment. The default value is "development".
  "environment": "production",
  // Run Passenger on port 80, the standard HTTP port.
  "port": 80,
  // Tell Passenger to daemonize into the background.
  "daemonize": true,
  // Tell Passenger to run the app as the given user. Only has effect
  // if Passenger was started with root privileges.
  "user": "appuser"
}
</pre>

> Replace appuser with your app's user account name.

11. You can now start Passenger. As configured, it will start on port 80 and will daemonize into the background.

<pre>
cd /var/www/ssid/code
sudo bundle exec passenger start
</pre>

12. To ensure that the Passenger Standalone runs on system boot, 

<pre>
sudo chmod +x /etc/rc.local
sudo nano /etc/rc.local
</pre>

13. Inside `/etc/rc.local`, insert the following:

<pre>
#!/bin/sh
cd /var/www/ssid/code

# Start Passenger Standalone in daemonized mode. 
bundle exec passenger start
</pre>

14. You are done. Now, you should be able to access your server.


## Accessing app code on the server
1. Login to the server with SSH. Enter the password given when required.

<pre>
ssh sadm@ssid-i.comp.nus.edu.sg
</pre>


2. Navigate to the directory where the application's code is stored.

<pre>
cd /var/www/SSID/code
</pre>


## Deploying code changes or updates

Note that unless stated otherwise, all commands should be run on the server, not on your local computer!

1. Go to your application's code directory on the server, then use Git to pull the latest code:

<pre>
cd /var/www/ssid/code
git pull
</pre>

2. If the application's gem dependencies have changed, install any updated gem dependencies. 

<pre>
bundle install --deployment --without development test
</pre>

3. Compile Rails assets and run database migrations.
<pre>
bundle exec rake assets:precompile db:migrate RAILS_ENV=production
</pre>

4. Finally, restart application (so that the updates take effect).

<pre>
bundle exec passenger-config restart-app $(pwd)
</pre>
