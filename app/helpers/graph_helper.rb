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

module GraphHelper
    def get_color(sim)
        sim_percentage = sim
        if (sim_percentage < 50)
            "#01A46D"
        elsif (sim_percentage < 60)
            "#00ECEC"
        elsif (sim_percentage < 70)
            "#377FC7"
        elsif (sim_percentage < 80)
            "#F5D800"
        elsif (sim_percentage < 90)
            "#FF6501"
        else
            "#CB0034"
        end
    end

    def get_weight(sim)
        sim_percentage = sim
        if (sim_percentage < 50)
            1
        elsif (sim_percentage < 60)
            3
        elsif (sim_percentage < 70)
            5
        elsif (sim_percentage < 80)
            7
        elsif (sim_percentage < 90)
            9
        else
            11
        end
    end

    def legend_height
      "200"
    end

    def legend_height_px
      legend_height + "px"
    end
    
    def legend_width
      "180"
    end

    def legend_width_px
      legend_width + "px"
    end
end