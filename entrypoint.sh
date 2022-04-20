#!/bin/bash
set -e

# Remove a potentially pre-existing server.pid for Rails.
rm -f /ssid/tmp/pids/server.pid

exec "$@" 