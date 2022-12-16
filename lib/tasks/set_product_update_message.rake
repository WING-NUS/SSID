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
  desc "Sets product update message"
  task :set_product_update_message, [:msg] => :environment do |t, args|
    require 'pp'

    # Parse arguments
    if args[:msg].nil?
        $stderr.puts  "Error parsing arguments\n\n" + 
        "Usage: rake SSID:set_product_update_message[msg]\n"
      exit
    end

    path = 'config/product_update/update_msg.yml'

    config = YAML.load_file(path)

    old_msg = config['msg']
    config['msg'] = args[:msg]

    File.open(path,'w') do |h| 
      h.write config.to_yaml
    end

    puts "Successfully updated product announcement message"
    puts "Old message: " + old_msg
    puts "Updated message: " + config['msg']


  end
end
