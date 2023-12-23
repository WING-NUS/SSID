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

class SubmissionSimilarityProcess < ActiveRecord::Base
  # SubmissionSimilarityProcess#status Constants
  STATUS_ERRONEOUS = 0
  STATUS_RUNNING = 1
  STATUS_COMPLETED = 2
  STATUS_WAITING = 3
  STATUS_STRINGS = %w{erroneous running completed}

  belongs_to :assignment
end
