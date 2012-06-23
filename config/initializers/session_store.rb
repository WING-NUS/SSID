# Be sure to restart your server when you modify this file.

# Your secret key for verifying cookie session data integrity.
# If you change this key, all old sessions will become invalid!
# Make sure the secret is at least 30 characters and all random, 
# no regular words or you'll be exposed to dictionary attacks.
ActionController::Base.session = {
  :key         => '_PDS_session',
  :secret      => '456636400cdb9f7a228b8a16a464a9c55cbd914f0243ac739dc79b6e85636911373161f09f324a77a8b8b7a46ef65b46af23bfbcc36979105539f7c93707d37f'
}

# Use the database for sessions instead of the cookie-based default,
# which shouldn't be used to store highly confidential information
# (create the session table with "rake db:sessions:create")
# ActionController::Base.session_store = :active_record_store
