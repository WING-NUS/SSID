# This is a simple string calculator.
# It is used to test the RSpec testing framework and code coverage.
# It is not part of the Rails application.
class StringCalculator
    def self.add(input)
        if input.empty?
          0
        else
          numbers = input.split(",").map { |num| num.to_i }
          numbers.inject(0) { |sum, number| sum + number }
        end
    end
end