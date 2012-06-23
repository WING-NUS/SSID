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

require 'digest/sha1'
class Account < ActiveRecord::Base
  
  has_many :announcements, :dependent => :delete_all

  has_many :teachings, :dependent => :delete_all
  has_many :courses, :through => :teachings, :uniq => true
  has_many :assignments, :through => :courses, :uniq => true

  attr_accessor :password_confirmation
  
  validates_presence_of :name
  validates_presence_of :login
  validates_presence_of :matric
  validates_numericality_of :min_length, :only_integer => true, :greater_than => 0
  validates_numericality_of :ngram, :only_integer => true, :greater_than => 0

  validates_uniqueness_of :login
  validates_uniqueness_of :matric

  validate :pwd_confirmation
  validate :matric_validation

  #to confirm password and password_confirmation are the same
  #validates_confirmation_of :password

  validate :password_non_blank

  public

  HUMANIZED_COLUMNS = {:min_length => "Mininum Match Length", :ngram => "The size of N-Gram"}

  def self.human_attribute_name(attribute)
    HUMANIZED_COLUMNS[attribute.to_sym] || super
  end

  def self.find_all_accounts
    find(:all, :order => "name")
  end

  def self.authenticate(login, password)
    account = self.find_by_login(login)
    if account
      expected_password = encrypted_password(password, account.salt)
      if account.hashed_password != expected_password
        account = nil
      end    
    end
    
    account
  end

  def password
    @password
  end

  def password=(pwd)
    @password = pwd
    return if pwd.blank?
    create_new_salt
    create_new_hashed_password
  end

  private
  def password_non_blank
    errors.add(:password, "is missing") if hashed_password.blank?
  end

  def pwd_confirmation
    if (password_confirmation != password)
      errors.add(:password, "doesn't match with password confirmation")
    end
  end

  def matric_validation

    unless errors[:matric]
      tmp = matric.upcase
      return if tmp[0, 1] == "S"
    end

    unless errors[:matric]
#      reg = /[A-Z]{1,2}[0-9]{6}[A-Z]/
#      if (!reg.match(matric))
#        errors.add(:matric, "is invalid (Num)")
#      end
    end

    unless errors[:matric]
#      tmp = matric.gsub(/[A-Z]/, '')

#      result = 2 * tmp[1, 1].to_i + 6 * tmp[2, 1].to_i + 2 * tmp[3, 1].to_i + 4 * tmp[4, 1].to_i + tmp[5, 1].to_i
#      result = result % 13
#      result = 13 - result

#      char = case result
#      when 1 then 'M'
#      when 2 then 'B'
#      when 3 then 'N'
#      when 4 then 'A'
#      when 5 then 'R'
#      when 6 then 'E'
#      when 7 then 'U'
#      when 8 then 'H'
#      when 9 then 'W'
#      when 10 then 'J'
#      when 11 then 'X'
#      when 12 then 'L'
#      when 13 then 'Y'
#      else '?'
#      end

#      errors.add(:matric, "is invalid (Checksum)") if !matric.end_with? char
    end
  end

  def create_new_salt
    self.salt = self.object_id.to_s + rand.to_s
  end

  def create_new_hashed_password
    self.hashed_password = Account.encrypted_password(self.password, self.salt)
  end

  def self.encrypted_password(password, salt)
    string_to_hash = password + "wibble" + salt
    Digest::SHA1.hexdigest(string_to_hash)
  end

end
