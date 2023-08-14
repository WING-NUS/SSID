module ApplicationHelper
  # mailer constants
  SSID_MAINTAINER = "The SSID Team"
  SSID_MAINTAINER_EMAIL = "wing.nus@gmail.com"
  EMAIL_DEFAULT_SENDER = "no-reply@ssid.comp.nus.edu.sg"

  # copyright
  COPYRIGHT_DATE_RANGE = "2009–2022"
  COPYRIGHT_HOLDER = "Web Information Retrieval and Natural Language Processing Group"

  def self.is_application_healthy
    begin
      check_memory = `free`
      if check_memory
        memory_stats = check_memory.split("\n")[1].split(/\s+/)
        total_memory, available_memory = Integer(memory_stats[1]), Integer(memory_stats[6])
        return available_memory * 100.0 / total_memory > Rails.application.config.critical_available_memory
      end
    rescue Errno::ENOENT
      # If the 'free' command is not found, fall back to reading /proc/meminfo
    end

    meminfo_path = '/proc/meminfo'
    if File.exist?(meminfo_path)
      meminfo = File.read(meminfo_path)
      total_memory = meminfo.match(/^MemTotal:\s+(\d+)/)[1].to_i
      free_memory = meminfo.match(/^MemFree:\s+(\d+)/)[1].to_i
      available_memory = total_memory - free_memory # Adjust as needed

      return available_memory * 100.0 / total_memory > Rails.application.config.critical_available_memory
    else
      puts "Memory information not available"
      return false
    end
  end
end
