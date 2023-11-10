# frozen_string_literal: true

require 'rails_helper'
require 'spec_helper'

# Ensures that the routes are correctly set up
# GET /api/v1/assignments/{assignment_id}/submission_similarities/
describe 'api v1 submission_similarities index', type: :routing do
  it 'routes to api/v1/submission_similarities#index' do
    expect(get: 'api/v1/assignments/:assignment_id/submission_similarities/').to route_to(
      :controller => 'api/v1/submission_similarities',
      'action' => 'index',
      'assignment_id' => ':assignment_id'
    )
  end
end

# GET /api/v1/assignments/{assignment_id}/submission_similarities/{submission_similarity_id}
describe 'api v1 submission_similarities show', type: :routing do
  it 'routes to api/v1/submission_similarities#show' do
    expect(get: 'api/v1/assignments/:assignment_id/submission_similarities/:submission_similarity_id').to route_to(
      :controller => 'api/v1/submission_similarities',
      'action' => 'show',
      'assignment_id' => ':assignment_id',
      'id' => ':submission_similarity_id'
    )
  end
end
