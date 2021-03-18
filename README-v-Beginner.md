# A Beginner's Guide for SSID Installation

**Guide in One Sentence**: A sister guide to the [official guide](https://github.com/WING-NUS/SSID/blob/master/README.md) with details on critical steps.

**Guide in One Paragraph**: Yisong has limited knowledge of Linux. He is only fluent with `bash`,  `tmux`, and `conda`. He has spent >6 hours trying to install SSID on his local machine (with external help with Riyas). This guide wishes to save your time by telling you the trick in critical steps. 

Last update: 18th March 2021



## Package Installation

Make sure to install all packages in the version as exactly specified in the guide:

> 1. Ensure you have Java `11` (revision `11` or later) installed in your Computer.
> 2. Ensure that you have installed Ruby (v2.6.6) and [bundler](https://rubygems.org/gems/bundler/versions/2.1.4) (v2.1.4)
> 3. Since the application uses MySQL as its database server, please ensure that you have installed MySQL 8.0.



Yisong's config: a standard Ubuntu 18.04 version Linux.



### Java 11

No difficulty installing `Java 11`. 

I follow the guide from DigitalOcean, it works smoothly:

```
https://www.digitalocean.com/community/tutorials/how-to-install-java-with-apt-on-ubuntu-18-04
```



### Ruby v2.6.6. ; bundler v2.1.4

I had a hard time installing `Ruby v2.6.6`., which is the state-of-the-art version when I tried to install. 

I forgot my specific steps, but these tips are useful:

```
https://stackoverflow.com/questions/61290209/installing-ruby-2-6-on-ubuntu-18-04-bundler-path-error
https://www.ruby-lang.org/en/documentation/installation/#apt
```

TODO Yisong: replicate my own installation and update on this. 



I also had a hard time installing `bundler v2.1.4` since it is also the latest version. 

If my memory is correct, my successful installation follows these steps:

```
https://rubygems.org/gems/bundler/versions/2.1.4
```

Make sure to follow these commands:

```
gem 'bundler', '~> 2.1', '>= 2.1.4'
gem install bundler -v 2.1.4
```



### MySQL 8.0

The last package does not consume the least time. After a few trials, I successfully installed following this tutorial. 

```
https://phoenixnap.com/kb/how-to-install-mysql-on-ubuntu-18-04
```

Step 2 in this tutorial is very critical and new to new Linux users. 



🎉🎉🎉 You have successfully installed all packages!



## MySQL Config

After Yisong has successfully installed all these packages, he still failed to enter the development mode using these commands:

```
 rake db:create db:schema:dump db:migrate RAILS_ENV=development
 rake db:seed
```



Why? After the help from Riyas, we find that the password of the `root` user of MySQL is not consistent with what we key in the SSID config file. 

Please `mysql -u root -p` to try to login into `root` to see if the password is correct. 



🎉🎉🎉 All done!



## Final Words

If you have a problem installing, don't hesitate to ask Yisong or Riyas. One response of ours might save you several hours!

