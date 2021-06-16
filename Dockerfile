# BASE LAYER
FROM exoplatform/jdk:openjdk-11-ubuntu-1804 AS base

RUN apt-get update && apt-get install -y git curl build-essential libssl-dev libreadline-dev zlib1g-dev sqlite3 libsqlite3-dev mysql-client libmysqlclient-dev
RUN adduser --gecos '' --disabled-password app
USER app
ENV HOME /home/app
ENV PATH $HOME/.rbenv/shims:$HOME/.rbenv/bin:$HOME/.rbenv/plugins/ruby-build/bin:$PATH
RUN git clone git://github.com/sstephenson/rbenv.git ~/.rbenv
RUN git clone git://github.com/sstephenson/ruby-build.git ~/.rbenv/plugins/ruby-build
WORKDIR /src
ADD Gemfile Gemfile.lock .ruby-version ./

RUN rbenv install 2.6.6
RUN rbenv global 2.6.6

RUN gem install bundler:2.1.4


# git clone https://github.com/WING-NUS/SSID.git /home/app/SSID

RUN mkdir /home/app/SSID

WORKDIR /home/app/SSID

COPY --chown=app:app Gemfile* /home/app/SSID/
RUN bundle install
RUN gem install rails

USER root
RUN apt-get install nodejs -y
USER app

COPY --chown=app:app . /home/app/SSID


# DEVELOPMENT BUILD
FROM base AS development
ENV RAILS_ENV development 
ENTRYPOINT ["rails", "server", "-b", "0.0.0.0"]


# PRODUCTION BUILD
FROM base AS production
RUN bundle exec rake assets:precompile
ENV RAILS_ENV production
USER root
ENTRYPOINT ["bundle", "exec", "passenger", "start"]