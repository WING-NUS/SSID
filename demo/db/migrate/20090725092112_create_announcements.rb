class CreateAnnouncements < ActiveRecord::Migration
  def self.up
    create_table :announcements, :force => true do |t|
      t.text :content
      t.integer :account_id, :null => false

      t.timestamps
    end
  end

  def self.down
    drop_table :announcements
  end
end
