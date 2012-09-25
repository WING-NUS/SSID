# Create default admin user
admin = User.new(name: "ssid_admin")
admin.password_digest = BCrypt::Password.create('$$SSIDPassword$$')
admin.save
