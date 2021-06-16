# Student Submission Integrity Diagnosis

Student Submission Integrity Diagnosis (SSID) is a Ruby on Rails web application suite for managing courses, assignments, staff, teaching assistants, students, and student code submissions and most importantly, to **detect and visualize plagiarism** among student code submissions. 

SSID works with lexers based on [ANTLR4 Grammars](https://github.com/antlr/grammars-v4) so if you can find / write a grammar for it, SSID can detect and visualize plagiarism for it (scroll down and click on the guide on "Adding support for new language in SSID" to learn the steps needed to add a new grammar).  SSID uses the [JavaScript InfoVis Toolkit](http://philogb.github.com/jit/) for its plagiarism visualization. Code display and syntax highlighting is handled by [google-code-prettify](http://code.google.com/p/google-code-prettify/). 

## Table Of Contents

- [Prerequisites](#prerequisites)
- [Setup & Configuration](#setup-and-configuration)
- [Site Map](#site-map)
- [License](#license)

## Prerequisites

- Machine with a working version of Docker (tested with 19.03.8 and 20.10.7 on macOS). Make sure your version meets one of the following minimum requirements:
	+ Docker for Mac/Windows 18.03+
	+ Docker for Linux 20.10.0+
		* _TODO: Test this_

## Setup and Configuration

### MySQL Section

Under development.

### Development

Clone SSID's source code onto your computer.
<pre>git clone https://github.com/WING-NUS/SSID.git</pre>

Open your terminal and navigate to the code directory. Then, build the development docker image.
<pre>docker build --target development -t ssid-development:latest .</pre>

_At this stage, IFF you're running Docker for Linux, edit line #14 of `docker-compose.yaml` to your local network IP. This is because the Docker alias it uses doesn't work on Linux. See in-line comments for moret details._

Once the image is built, go ahead and run the container using the handy `docker-compose`.
<pre>docker-compose run --service-ports development</pre>

After you're finished developing, shutdown the container.
<pre>docker-compose down</pre>

Note that because of a quirk with how `docker-compose` works, the following is the correct way to restart the container.
<pre>docker-compose down && docker-compose run --service-ports development</pre>

### Production

Notes:
- This guide assumes MySQL has already been setup on the local machine. If it's being hosted remotely, edit the IP in `docker-compose.yaml` accordingly.
- Currently, the password is stored in plaintext in `docker-compose.yaml`. **Do not push the production database password.** Edit the config on the server locally using `nano` or `vim`.
- Ruby on Rails requires you to have a `credentials.yml` file in `config/`. This should already exist on the actual production server. If you're testing it locally, you can generate your own by running `rails credentials:edit` in the repo's root folder.


SSH into the production server. Clone SSID's source code.
<pre>git clone https://github.com/WING-NUS/SSID.git</pre>

Navigate to the code directory. Then, build the production docker image.
<pre>docker build --target production -t ssid-production:latest .</pre>

Once the image is built, go ahead and run the container using the handy `docker-compose`.
<pre>docker-compose run --service-ports production</pre>

When you need to, shutdown the container.
<pre>docker-compose down</pre>

Note that because of a quirk with how `docker-compose` works, the following is the correct way to restart the container.
<pre>docker-compose down && docker-compose run --service-ports development</pre>

#### Upgrading the container

With our current setup, there will be some minimal amount of downtime during upgrades. 

First, shutdown the container.
<pre>docker-compose down</pre>

Next, pull the latest version from the GitHub repo. 
<pre>git pull</pre>

Finally, start the container again.
<pre>docker-compose run --service-ports development</pre>


## Site Map
- [Adding support for new language in SSID](doc/add_support_for_new_language.md)
- [Deploying SSID app on a Linux/Unix production server](doc/deploying_rails_on_linux.md)
- [User Guide](doc/SSID_User%20Guide_V1.pdf)

## License

SSID is licensed under the [GNU Lesser General Public License] [gpl]

[gpl]: http://www.gnu.org/licenses/
