# Need this specific version
FROM ruby:2.6.6

# Need this specific version
RUN gem install bundler:2.2.17

# Need a Javascript environment
RUN chmod 1777 /tmp
RUN apt-get update
RUN apt-get install -y nodejs

# Copy just enough to run the bundle installation
COPY Gemfile .
COPY Gemfile.lock .

# Install all gems -- this takes the longest amount of time
RUN bundle install

# Add docker-compose-wait tool to wait for DB (during docker-compose) before starting
ENV WAIT_VERSION 2.7.2
ADD https://github.com/ufoscout/docker-compose-wait/releases/download/$WAIT_VERSION/wait /wait
RUN chmod +x /wait

# Install OpenJDK-11
RUN apt-get update && \
    apt-get install -y openjdk-11-jre-headless && \
    apt-get clean;

# Finally copy all files
COPY . .

# Development mode
EXPOSE 3000
CMD ["rake db:create db:schema:dump db:migrate RAILS_ENV=development && rake db:seed && RAILS_ENV=development rails server"]
