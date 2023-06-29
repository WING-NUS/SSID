=begin
This file is part of SSID.

SSID is free software: you can redistribute it and/or modify
it under the terms of the GNU Lesser General Public License as published by
the Free Software Foundation, either version 3 of the License, or
(at your option) any later version.

SSID is distributed in the hope that it will be useful,
but WITHOUT ANY WARRANTY; without even the implied warranty of
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
GNU Lesser General Public License for more details.

You should have received a copy of the GNU Lesser General Public License
along with SSID.  If not, see <http://www.gnu.org/licenses/>.
=end

# Create default admin user
admin = User.new do |user|
  user.name = "admin"
  user.full_name = "SSID Administrator"
  user.password_digest = BCrypt::Password.create('$$SSIDPassword$$')
  user.email = "ssidadmin@example.com"
  user.is_admin = true
  user.is_admin_approved = true
  user.activated = true
  user.activated_at = Time.zone.now
end
admin.save
