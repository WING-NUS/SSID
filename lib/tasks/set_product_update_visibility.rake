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

require 'yaml'

namespace :SSID do
  desc "Sets whether product update message is visible"
  task :set_product_update_visibility, [:is_visible] => :environment do |t, args|
    require 'pp'

    # Parse arguments
    if (args[:is_visible].nil?) or (not ['Y', 'N'].include?(args[:is_visible]))
        $stderr.puts  "Error parsing arguments\n\n" + 
        "Usage:\n" +
        "rake SSID:set_product_update_visibility['Y'] if you wish to show product update message\n" +
        "rake SSID:set_product_update_visibility['N'] otherwise."
      exit
    end

    path = SSID::Application.config.product_update_config_path
    config = YAML.load_file(path)

    config = YAML.load_file(path)
    config['is_visible'] = args[:is_visible]

    File.open(path,'w') do |h| 
      h.write config.to_yaml
    end

    if (args[:is_visible] == 'Y')
      puts "Successfully made product message visible"
    else
      puts "Successfully made product message invisible"
    end
  end
end
