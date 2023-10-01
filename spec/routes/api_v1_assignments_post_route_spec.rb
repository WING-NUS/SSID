# frozen_string_literal: true

require 'rails_helper'
require 'spec_helper'

# Ensures that the route is correctly set up
describe 'api v1 assignments post route', type: :routing do
  it 'routes to api/v1/assignments#create' do
    expect(post: 'api/v1/courses/:course_id/assignments').to route_to(
      :controller => 'api/v1/assignments',
      'action' => 'create',
      'course_id' => ':course_id'
    )
  end
end
