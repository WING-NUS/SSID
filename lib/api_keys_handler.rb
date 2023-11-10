# frozen_string_literal: true

# This file is part of SSID.
#
# SSID is free software: you can redistribute it and/or modify
# it under the terms of the GNU Lesser General Public License as published by
# the Free Software Foundation, either version 3 of the License, or
# (at your option) any later version.
#
# SSID is distributed in the hope that it will be useful,
# but WITHOUT ANY WARRANTY; without even the implied warranty of
# MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
# GNU Lesser General Public License for more details.
#
# You should have received a copy of the GNU Lesser General Public License
# along with SSID.  If not, see <http://www.gnu.org/licenses/>.

require 'zip'
require 'open3'

module APIKeysHandler
  class APIKeyError < StandardError
    def initialize(message, status)
      super(message)
      @status = status
    end
    attr_reader :status
  end

  class << self; attr_accessor :api_key, :course; end

  def self.authenticate_api_key
    raise APIKeyError.new('Missing or invalid API key.', :unauthorized) if api_key.nil? || api_key.user_id.nil?

    return if authorized_for_course?(api_key.user_id, course.id)

    raise APIKeyError.new('Your API key is not authorized to access this resource.', :unauthorized)
  end

  def self.authorized_for_course?(user_id, course_id)
    user_course_membership = UserCourseMembership.find_by(user_id: user_id, course_id: course_id)
    user_course_membership.present?
  end
end
