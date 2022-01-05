source 'https://rubygems.org'
git_source(:github) { |repo| "https://github.com/#{repo}.git" }

ruby '2.6.6'

# Bundle edge Rails instead: gem 'rails', github: 'rails/rails'
gem 'rails', '~> 6.0.3', '>= 6.0.3.2'
# Use mysql as the database for Active Record
gem 'mysql2', '~> 0.5.3'
# Use Puma as the app server
gem 'puma', '~> 4.3'
# Use SCSS for stylesheets
# gem 'sass-rails', '>= 6'
# Transpile app-like JavaScript. Read more: https://github.com/rails/webpacker
# Turbolinks makes navigating your web application faster. Read more: https://github.com/turbolinks/turbolinks
gem 'turbolinks', '~> 5'
# Build JSON APIs with ease. Read more: https://github.com/rails/jbuilder
gem 'jbuilder', '~> 2.7'
# Use Redis adapter to run Action Cable in production
# gem 'redis', '~> 4.0'
# Use Active Model has_secure_password
gem 'bcrypt', '~> 3.1.7'

gem 'actionmailer', '~> 6.0', '>= 6.0.3.2'

# handles zip files, older version: zip-zip
gem 'rubyzip', '~> 2.3'

gem 'sprockets-rails', :require => 'sprockets/railtie'

# extends :File methods
# gem 'win32-file', '~> 0.8.2'
# gem 'ptools', '~> 1.3', '>= 1.3.7'

# gem 'filemaigc'

# Use Active Storage variant
# gem 'image_processing', '~> 1.2'

# pagination
gem 'will_paginate', '~> 3.3'

# pretty print

gem 'jquery-rails', '~> 4.4'

gem 'bootstrap', '~> 5.1.3'

group :assets do
  gem 'sass-rails', '~> 6.0'
  gem 'coffee-rails', '~> 5.0'
  gem 'uglifier', '~> 4.2'
end

# Reduces boot times through caching; required in config/boot.rb
gem 'bootsnap', '>= 1.4.2', require: false

group :development, :test do
  # Call 'byebug' anywhere in the code to stop execution and get a debugger console
  gem 'byebug', platforms: [:mri, :mingw, :x64_mingw]
end

group :development do
  # Access an interactive console on exception pages or by calling 'console' anywhere in the code.
  gem 'web-console', '>= 3.3.0'
end

group :test do
  # Adds support for Capybara system testing and selenium driver
  gem 'capybara', '>= 2.15'
  gem 'selenium-webdriver'
  # Easy installation and use of web drivers to run system tests with browsers
  gem 'webdrivers'
end

# Windows does not include zoneinfo files, so bundle the tzinfo-data gem
gem 'tzinfo-data', platforms: [:mingw, :mswin, :x64_mingw, :jruby]
