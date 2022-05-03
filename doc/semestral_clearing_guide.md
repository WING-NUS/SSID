Guide to configure and re-setup SSID for new semester
=======================

This guide will list the steps required to configure and re-setup SSID in the remote server before a new semester. This guide will be separated into the below sections:

- Archiving and clearing past code files (uploaded by users) and modules from SSID
- Resetting the database and application
- Pulling any new code changes and deploying those changes 

### Logging into the remote server

1. Open a terminal and login to the server with SSH. Enter the password given when required.

    <pre>ssh sadm@ssid-i.comp.nus.edu.sg</pre>


2. Navigate to the directory where the application's code is stored.

    <pre>cd /var/www/SSID/code</pre>

### Archiving and clearing past code files and modules from SSID

1. All the code files uploaded by users are stored under the respective dedicated assignment number under the `upload` folder. In order to extract the files, firstly, create a new terminal and do not login to the server with SSH. Instead simply enter the below command:
    
    <pre> scp -r sadm@ssid-i.comp.nus.edu.sg:/var/www/ssid/code/upload/[ASSIGNMENT_NO]/ [DESTINATION_FOLDER] </pre>
    
    * replace [ASSIGNMENT_NO] with the assignment number and [DESTINATION_FOLDER] with your destination folder. 
   
2. When prompted, enter the password and after the process is completed, you would be able to see the extracted files in the destination folder. 

3. Repeat steps 1 & 2 above to archive any data that need to be stored. 

4. Once the archiving has been completed, if you wish to clear the entire database, you can proceed to the below section. Else, if only certain modules and/or uploaded code files are to be deleted, you can manually delete them in the database or in the SSID app interface. 

### Resetting the database and application

1. Ensure you have no connections to db (rails server, sql client..). Else, the db won't drop.

2. Run the below command to recreate database and the seeds:
    <pre>rake db:drop db:create db:migrate db:seed: loads from migrations </pre>
    
3. Run the below command to see the current state of the database:
    <pre>rake db:schema:dump </pre>

## Pulling any new code changes and deploying those changes 

1. Go to your application's code directory on the server, then use Git to pull the latest code:

    <pre>
    cd /var/www/ssid/code
    git pull</pre>

2. If the application's gem dependencies have changed, install any updated gem dependencies. 

    <pre>bundle install --deployment --without development test</pre>

3. Compile Rails assets and run database migrations.
    <pre>bundle exec rake assets:precompile db:migrate RAILS_ENV=production</pre>

4. Finally, restart application (so that the updates take effect).

    <pre>passenger-config restart-app $(pwd)</pre>
