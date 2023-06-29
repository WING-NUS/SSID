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

module SubmissionClustersHelper
  LEGEND_SIMILARITY_VALUES = (40..90).step(10).to_a.reverse
  LEGEND_COLORS_FOR_SIMILARITY_VALUES = Hash[
    LEGEND_SIMILARITY_VALUES.zip(
      %w{#dc3545 #fd7e14 #ffc107 #0d6efd #0dcaf0 #01A64D}
    )
  ]
  LEGEND_WEIGHTS_FOR_SIMILARITY_VALUES = Hash[
    LEGEND_SIMILARITY_VALUES.zip(
      %w{5 5 5 5 5 5}
    )
  ]

  private

  def self.color_for_similarity(val)
    val = val.to_f
    legend_index = LEGEND_SIMILARITY_VALUES.index { |legend_value|
      val >= legend_value
    }
    legend_index = LEGEND_SIMILARITY_VALUES.size - 1 unless legend_index
    legend_value = LEGEND_SIMILARITY_VALUES[legend_index]
    LEGEND_COLORS_FOR_SIMILARITY_VALUES[legend_value]
  end

  def self.weight_for_similarity(val)
    val = val.to_f
    legend_index = LEGEND_SIMILARITY_VALUES.index { |legend_value|
      val >= legend_value
    }
    legend_index = LEGEND_SIMILARITY_VALUES.size - 1 unless legend_index
    legend_value = LEGEND_SIMILARITY_VALUES[legend_index]
    LEGEND_WEIGHTS_FOR_SIMILARITY_VALUES[legend_value]
  end
end
