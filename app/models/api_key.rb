# frozen_string_literal: true

class ApiKey < ApplicationRecord
  belongs_to :user

  validates :value, uniqueness: true # , presence: true

  # before_validation :generate_value

  # private

  # def generate_value
  #     self.value ||= SecureRandom.hex(32)
  # end
end
