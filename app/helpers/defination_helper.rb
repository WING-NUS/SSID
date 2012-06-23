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

module DefinationHelper
  def getDefination(type)
    case type
    when "min_length" then "Mininum Match Length"
    when "ngram" then "The size of N-Gram"
    else raise "getDefination: Invalid type - #{type}"
    end
  end

  def getExplaination(type)
    case type
    when "min_length" then "The least number of contiguous matching statements required to flag a match"
    when "ngram" then "<i>N</i>-gram pattern length.<br/>An N-gram is a contiguous subsequence of N tokens of a given sequence"
    when "statement_matched" then "The number of statements in a match.<br/>Currently, SSID considers a program statement ended with ; as a statement.<br/>Exceptions are the initialization and termination statements in <i>for</i> loops and the <i>import</i> statements."
    when "sim1To2" then "Student 1<br/>(Similarity from student 1 to student 2)<br/>This column shows the matched statements in student 1 submission in the range of lines.<br/>To highlight matched code region in red, click the line range."
    when "sim2To1" then "Student 2<br/>(Similarity from student 2 to student 1)<br/>This column shows the matched statements in student 2 submission in the range of lines.<br/>To highlight matched code region in red, click the line range."
    when "grouping" then "A grouping defines the plagiarism clusters of students<br/>who have the similarity values higher than<br/>a cut off criterion."
    else raise "getExplaination: Invalid type - #{type}"
    end
  end
end
