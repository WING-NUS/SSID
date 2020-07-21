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

class VisualizeController < ApplicationController
  before_action { |controller|
    if params[:course_id]
      @course = Course.find(params[:course_id])
      controller.send :authenticate_actions_for_role, UserCourseMembership::ROLE_STUDENT,
                                                      course: @course,
                                                      only: [ ]
    end
  }

  # GET /courses/1/visualize
  def index
  end

  # GET /courses/1/visualize/similarity_cluster_graph
  def similarity_cluster_graph
  end

  # GET /courses/1/visualize/similarity_cluster_table
  def similarity_cluster_table
    @clusters = SubmissionCluster.all
  end

  # GET /courses/1/visualize/top_similar_submissions
  def top_similar_submissions
  end
end
