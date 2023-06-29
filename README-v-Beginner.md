# A Beginner's Guide for SSID Installation

**Guide in One Sentence**: A sister guide to the [official guide](https://github.com/WING-NUS/SSID/blob/master/README.md) with details on critical steps.

**Guide in One Paragraph**: This is an installation guide for those who have limited knowledge of Linux. This guide assumes only limited fluency with `bash`,  `tmux`, and `conda`.  This guide wishes to save your time by telling you the trick in critical steps. 

Last update: 18th March 2021 (pre-dockerized configuration)

## Package Installation

Make sure to install all packages in the version as **exactly** specified in the guide.  Other versions may cause signficant problems and deviation from what is known to work.

> 1. Ensure you have Java `11` (revision `11` or later) installed in your Computer.
> 2. Ensure that you have installed Ruby (v2.6.6) and [bundler](https://rubygems.org/gems/bundler/versions/2.1.4) (v2.1.4)
> 3. Since the application uses MySQL as its database server, please ensure that you have installed MySQL 8.0.


Yisong's config: a standard Ubuntu 18.04 version Linux.

### Java 11

No difficulty installing `Java 11`. 

Follow the guide from DigitalOcean at the below URL.  It works smoothly:

```
https://www.digitalocean.com/community/tutorials/how-to-install-java-with-apt-on-ubuntu-18-04
```

### Ruby v2.6.6. ; bundler v2.1.4

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

## Final Words

If you have a problem installing, don't hesitate to ask our team, Yisong and Riyas. One response of ours may save you hours!

