namespace :SSID do
  desc "Sets the status of a submission similarity process instance for a given assignment id"
  task :set_submission_similarity_process_status, [:status, :assignment_id] => :environment do |t, args|
    require 'pp'

    # Parse arguments
    if args[:status].nil? or args[:assignment_id].nil? or 
        not SubmissionSimilarityProcess::STATUS_STRINGS.include? args[:status].downcase or
        args[:assignment_id].match(/^\d+$/).nil?
      $stderr.puts  "Error parsing arguments\n\n" + 
                    "Usage: rake SSID:set_submission_similarity_process_status[status,assignment_id]\n" + 
                    "For valid status strings, see the SubmissionSimilarityProcess model."
      exit
    end

    # Extract args
    status = SubmissionSimilarityProcess::STATUS_STRINGS.index args[:status].downcase
    assignment_id = args[:assignment_id].to_i

    # Find the assignment
    assignment = Assignment.find(assignment_id)
    unless assignment
      $stderr.puts "Error: cannot find assignment with id: #{assignment_id}"
      exit
    end

    # Find the submission similarity process
    ss = assignment.submission_similarity_process
    unless ss
      $stderr.puts "Error: assignment with id: #{assignment_id} has no submission_similarity_process"
      exit
    end
    
    # Change the status and save
    ss.status = status
    unless ss.save
      $stderr.puts "Error saving submission_similarity_process for assignment with id: #{assignment_id}"
      exit
    end
  end
end
