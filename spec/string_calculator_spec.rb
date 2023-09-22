# This is a simple string calculator RSpec test.
# It is used to test the RSpec testing framework and code coverage.
# It is not part of the Rails application.
require "string_calculator"

describe StringCalculator do

    describe ".add" do
        context "two numbers" do
          context "given '2,4'" do
            it "returns 6" do
              expect(StringCalculator.add("2,4")).to eql(6)
            end
          end
    
          context "given '17,100'" do
            it "returns 117" do
              expect(StringCalculator.add("17,100")).to eql(117)
            end
          end
        end
      end

  end