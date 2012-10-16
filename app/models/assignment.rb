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

class Assignment < ActiveRecord::Base
  has_many :submission_similarities, :dependent => :delete_all
  has_many :submission_cluster_groups, :dependent => :delete_all, order: "cut_off_criterion DESC"
  has_one :submission_similarity_process, :dependent => :delete
  has_many :suspected_plagiarism_cases, class_name: "SubmissionSimilarity", conditions: "status = #{SubmissionSimilarity::STATUS_SUSPECTED_AS_PLAGIARISM}"
  has_many :confirmed_or_suspected_plagiarism_cases, class_name: "SubmissionSimilarity", conditions: "status = #{SubmissionSimilarity::STATUS_CONFIRMED_AS_PLAGIARISM} OR status = #{SubmissionSimilarity::STATUS_SUSPECTED_AS_PLAGIARISM}"
  has_many :confirmed_plagiarism_cases, class_name: "SubmissionSimilarity", conditions: "status = #{SubmissionSimilarity::STATUS_CONFIRMED_AS_PLAGIARISM}"
  has_many :submissions
  belongs_to :course

  validates :title, :language, :min_match_length, :ngram_size, presence: true
  validates_numericality_of :min_match_length, only_integer: true, greater_than: 0
  validates_numericality_of :ngram_size, only_integer: true, greater_than: 0

  LANGUAGES = {
    java: "Java",
    c: "C (Experimental)",
    cpp: "C++",
    python3: "Python 3"
  }

  PRETTIFY_LANGUAGES = {
    java: "java",
    c: "c",
    cpp: "cpp",
    python3: "py"
  }

  def self.options_for_languages
    LANGUAGES.to_a.collect { |pair| pair.reverse }
  end

  def prettify_js_lang
    "lang-#{PRETTIFY_LANGUAGES[self.language]}"
  end

  def language_string
    LANGUAGES[language.intern]
  end

  def cluster_students
    self.submission_cluster_groups.collect { |g|
      g.clusters.collect { |c|
        c.submissions.collect { |s|
          s.student
        }
      }
    }.flatten.uniq.sort
  end

  def submission_clusters
    self.submission_cluster_groups.collect { |g|
      g.clusters
    }.flatten
  end

  def submission_similarities_for_student(student)
    self.submission_similarities.select { |ss|
      ss.submission1.student == student or ss.submission2.student == student
    }
  end
end
