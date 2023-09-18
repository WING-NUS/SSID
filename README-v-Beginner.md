# A Beginner's Guide for SSID Installation

**Guide in One Sentence**: A sister guide to the [official guide](https://github.com/WING-NUS/SSID/blob/master/README.md) with details on critical steps.

**Guide in One Paragraph**: This is an installation guide for those who have limited knowledge of Linux. This guide assumes only limited fluency with `bash`,  `tmux`, and `conda`.  This guide wishes to save your time by telling you the trick in critical steps. 

Last update: 18th September 2023 (pre-dockerized configuration)

## Package Installation

Make sure to install all packages in the version as **exactly** specified in the guide.  Other versions may cause signficant problems and deviation from what is known to work.

> 1. Ensure you have Java `11` (revision `11` or later) installed in your Computer.
> 2. Ensure that you have installed Ruby (v2.6.6) and [bundler](https://rubygems.org/gems/bundler/versions/2.1.4) (v2.1.4)
> 3. Since the application uses MySQL as its database server, please ensure that you have installed MySQL 8.0.


Yisong's config: a standard Ubuntu 18.04 version Linux.

## WSL Support

For Windows Users who are not planning to do a dual-boot on their computer, WSL works just as well for most of the SSID operations. You can refer to the following link on how to setup Ubuntu with WSL on your computer.

https://learn.microsoft.com/en-us/windows/wsl/install

Our recommended method is to activate WSL and then install an Ubuntu distribution from the Microsoft Store. Current SSID supports Ubuntu 22.04 (LTS).

For those who are using WSL, you might find that some of the commands provided in the below tutorials are rather Linux specific (e.g. `sudo systemctl start <SERVICE_NAME>`). On our case, if you are using WSL, you might find that the syntax might be different (e.g. `sudo service <SERVICE_NAME> start`). Do adjust accordingly.

### Java 11

No difficulty installing `Java 11`. 

Follow the guide from DigitalOcean at the below URL.  It works smoothly:

```
https://www.digitalocean.com/community/tutorials/how-to-install-java-with-apt-on-ubuntu-18-04
```

### Ruby v2.6.6. ; bundler v2.1.4

(Newer Update): If you are using Ubuntu 22.04 (LTS), you may benefit from following the steps specified in the following link:

```
https://www.digitalocean.com/community/tutorials/how-to-install-ruby-on-rails-with-rbenv-on-ubuntu-22-04
```

Complete the installation up to the following step: `echo "gem: --no-document" > ~/.gemrc`, then proceed to the "installing bundler" section.

(Older Update: Ubuntu 18.04)

I had a hard time installing `Ruby v2.6.6`., which was the current version at the time of writing this installation guide. 

I forgot my specific steps, but these tips are useful:

```
https://stackoverflow.com/questions/61290209/installing-ruby-2-6-on-ubuntu-18-04-bundler-path-error
https://www.ruby-lang.org/en/documentation/installation/#apt
```

TODO Yisong: replicate my own installation and update on this. 

Sometimes `ruby` version 2.6.6 is not found in `rbenv` list.  If this is the case, you may try installing it manually:
```
wget http://ftp.ruby-lang.org/pub/ruby/2.6/ruby-2.6.6.tar.gz
tar -xzvf ruby-2.6.6.tar.gz
cd ruby-2.6.6/
./configure
sudo make install
```

If you take this approach, you may need to manually restart the system to check whether the correct version is installed.

```
ruby --version
```

I also had a hard time installing `bundler v2.1.4` since it is also the latest version. 

A successful installation may follow these steps:

```
https://rubygems.org/gems/bundler/versions/2.1.4
```

### Installing Bundler

Make sure to follow these commands:

```
gem 'bundler', '~> 2.1', '>= 2.1.4'
gem install bundler -v 2.1.4
```

Note: `bundler` install may fail due to several reasons. If it does, please try the following steps directly:

```
sudo install bundler -v 2.1.4
```

Afterwards, please check the installed `bundler` version:

```
bundle version
```

### MySQL 8.0

The last package actually takes a significant time to properly install and configure. Follow this tutorial for installation:

```
https://phoenixnap.com/kb/how-to-install-mysql-on-ubuntu-18-04
```

Alternatively, you may also want to refer to the following instruction:

https://www.digitalocean.com/community/tutorials/how-to-install-mysql-on-ubuntu-22-04

This will provide a better instruction for Ubuntu 22.04 (LTS) users.


Step 2 in this tutorial is very critical for Linux users. 

🎉🎉🎉 Congratulations! You have successfully installed all packages!

## MySQL Config

Installation needs to be followed by proper configuration of the development environment.  Follow the following commands in your `rails` directory.

```
 rake db:create db:schema:dump db:migrate RAILS_ENV=development
 rake db:seed
```

The `root` MySQL user password is different from what we key in the SSID config file.

Please `mysql -u root -p` to try to login into `root` to see if the password is correct. 

🎉🎉🎉 All done!

## TroubleShooting

### libmysqlclient.so error

This error occurs when doing `bundle install`, specifically with installing the `rugged` gem.

Exact Error Message:

```
LoadError: libmysqlclient.so.21: cannot open shared object file: No such file or directory - /root/.rbenv/versions/2.6.6/lib/ruby/gems/2.6.0/gems/mysql2-0.5.3/lib/mysql2/mysql2.so
/mnt/c/Users/Jason C/Code/SSID/config/application.rb:7:in `<top (required)>'
/mnt/c/Users/Jason C/Code/SSID/rakefile:4:in `require_relative'
/mnt/c/Users/Jason C/Code/SSID/rakefile:4:in `<top (required)>'
(See full trace by running task with --trace)
```

Suggested solution:

Install the `libmysqlclient.so` MySQL Client Library by running the following command:

```
sudo apt-get install libmysqlclient-dev
```

Then re-run `bundle install`. This should do the trick.


### MySQL: Error 1045

You might encounter the following error when using MySQL:

```
ERROR 1045 (28000): Access denied for user 'root'@'localhost' (using password: YES)
```

In this case, most likely you have entered a wrong password that is different from what you set during the MySQL installation for the root user.

If you have forgotten the password, you may follow the instruction below:

### MySQL: Update Password

You can refer to the following instruction to change the root password:

```
https://docs.rackspace.com/docs/reset-a-mysql-root-password
```

Alternatively, if everything else fails, you can remove MySQL DB and install it again, should you don't have any crucial data that is stored in MySQL (noting that you have recently installed...)

You can refer to the following guide:

```
https://linuxgenie.net/uninstall-mysql-from-ubuntu/
```

## Final Words

If you have a problem installing, don't hesitate to ask our team, Yisong and Riyas. One response of ours may save you hours!

