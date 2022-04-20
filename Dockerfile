FROM ruby:2.6.6

# install java & set path
RUN apt-get update && \
    apt-get -y install -y sudo

RUN apt-get install -y openjdk-11-jdk
RUN sudo update-alternatives --config java

ENV JAVA_HOME /usr/lib/jvm/java-11-openjdk-amd64/
RUN export JAVA_HOME
RUN javac -version

# install ant
RUN apt update
RUN apt -y install ant
RUN ant -version

# install antlr
WORKDIR /usr/local/lib
RUN mkdir -p /usr/java/lib
RUN wget http://www.antlr.org/download/antlr-4.8-complete.jar -P /usr/local/lib
RUN echo '#!/bin/bash\njava -jar /usr/local/lib/antlr-4.8-complete.jar' > /usr/bin/antlr4
RUN chmod +x /usr/bin/antlr4
RUN echo '#!/bin/bash\njava org.antlr.v4.gui.TestRig' > /usr/bin/grun
RUN chmod +x /usr/bin/grun
ENV CLASSPATH .:/usr/local/lib/antlr-4.8-complete.jar:$CLASSPATH
WORKDIR /

# install mysql client
RUN apt update
RUN apt-get install default-mysql-client -y

# install rails dependencies
RUN apt-get clean all && apt-get update -qq && apt-get install -y build-essential libpq-dev \
    curl gnupg2 apt-utils default-libmysqlclient-dev git libcurl3-dev cmake \
    libssl-dev pkg-config openssl imagemagick file nodejs yarn

RUN mkdir /ssid
WORKDIR /ssid

# Adding gems
COPY Gemfile Gemfile
COPY Gemfile.lock Gemfile.lock
RUN gem install bundler -v 2.2.17
RUN bundle install

COPY . /ssid

# Add a script to be executed every time the container starts.
COPY entrypoint.sh /usr/bin/
RUN chmod +x /usr/bin/entrypoint.sh
ENTRYPOINT ["entrypoint.sh"]