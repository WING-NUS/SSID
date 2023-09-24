module ApplicationHelper
  # mailer constants
  SSID_MAINTAINER = "The SSID Team"
  SSID_MAINTAINER_EMAIL = "wing.nus@gmail.com"
  EMAIL_DEFAULT_SENDER = "no-reply@ssid.comp.nus.edu.sg"

  # copyright
  COPYRIGHT_DATE_RANGE = '2009–2023'.freeze
  COPYRIGHT_HOLDER = "Web Information Retrieval and Natural Language Processing Group"

  def self.is_application_healthy
    check_memory = `free` 

    # Mem: total used free shared buff/cache available
    if check_memory
      memory_stats = check_memory.split("\n")[1].split("\s")
      puts "Output: #{check_memory}"
      puts "Memory: #{memory_stats}"  
      total_memory, available_memory = Integer(memory_stats[1]), Integer(memory_stats[6])
      return available_memory * 100.0 / total_memory > Rails.application.config.critical_available_memory
    else
      return false
    end
  end

end
