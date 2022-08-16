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

namespace :SSID do
    desc "Sends maintenance email with custom start and end date"
    task :send_maintenance_mail, [:start_time, :end_time] => :environment do |t, args|
        
    if args[:start_time].nil? or args[:end_time].nil? 
      $stderr.puts  "Error parsing arguments\n\n" + 
                    "Usage: rake SSID:send_maintenance_mail[start_time,end_time]\n"
      exit
    end

    @recipients = User.all
    @recipients.each do |r|
        if r.email != nil
          MaintenanceMailer.maintenance_mailer(r.email, args[:start_time], args[:end_time]).deliver_now
        end
    end
  end
end