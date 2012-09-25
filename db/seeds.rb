# Create default admin user
admin = User.new { |user|
  user.name = "admin"
  user.full_name = "SSID Administrator"
  user.password_digest = BCrypt::Password.create('$$SSIDPassword$$')
}
admin.save
