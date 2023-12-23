class AddApiKeyToUsers < ActiveRecord::Migration[6.0]
  def change
    create_table :api_keys do |t|
      t.belongs_to :user, index: true, foreign_key: true
      t.string :value, index: {unique: true}
      t.timestamps
    end
  end
end
