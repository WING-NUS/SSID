class CreateAccounts < ActiveRecord::Migration
    def self.up
        create_table :accounts, :force => true do |t|
            t.string :login, :unique => true, :null => false
            t.string :hashed_password, :null => false
            t.string :salt, :null => false
            t.string :matric, :null => false, :unique => true
            t.string :name, :null => false
            t.datetime :expiry, :null => true
            t.integer :role, :default => 1
            t.integer :ngram, :null => false, :default => 4
            t.integer :min_length, :null => false, :default => 2
            t.timestamps
        end

        add_index :accounts, :matric
        add_index :accounts, :name
        add_index :accounts, :login
    end

    def self.down
        drop_table :accounts
    end
end
