require_relative '20220524040659_create_password_resets.rb'

class RemovePasswordResets < ActiveRecord::Migration[6.0]
  def change
    revert CreatePasswordResets
  end
end
