# frozen_string_literal: true

require 'rails_helper'
require 'spec_helper'

def init_submisision_similarities_tests
  init_tests
  # Creates sample assignment and sample plagiarism detection results
  assignment = Assignment.new do |assignment|
    assignment.course_id = Course.find_by(name: 'Introduction to Programming').id
    assignment.title = 'RSpec Assignment'
    assignment.language = 'java'
    assignment.min_match_length = 2
    assignment.ngram_size = 4
    assignment.upload_log = ''
    assignment.mapbox = false
  end

  assignment.save

  submission_similarity_process = SubmissionSimilarityProcess.new do |process|
    process.assignment_id = assignment.id
    process.status = SubmissionSimilarityProcess::STATUS_COMPLETED
  end

  submission_similarity_process.save
  
  submission1 = Submission.new do |submission1|
    submission1.assignment_id = assignment.id
    submission1.student_id = 999_999_998
    submission1.lines = ['import java.util.*;', '', '/**', ' * Driver class', ' */', '', 'public class CitiesDriver {',
                         '', '    ', '    public static void main(String[] args) {', "\t\tSystem.out.println(\"test\");", '', '    }', '', '}']
    submission1.is_plagiarism = false
  end

  submission1.save

  submission2 = Submission.new do |submission2|
    submission2.assignment_id = assignment.id
    submission2.student_id = 999_999_999
    submission2.lines = ['import java.util.*;', '', '/**', ' * Driver class', ' */', '', 'public class CitiesDriver {',
                         '', '    ', '    public static void main(String[] args) {', "\t\tSystem.out.println(\"test\");", "\t\tSystem.out.println(\"test2\");", '', '    }', '', '}']
    submission2.is_plagiarism = false
  end

  submission2.save

  submission_similarity = SubmissionSimilarity.new do |submission_similarity|
    submission_similarity.assignment_id = assignment.id
    submission_similarity.submission1_id = submission1.id
    submission_similarity.submission2_id = submission2.id
    submission_similarity.similarity_1_to_2 = 0.35751e2
    submission_similarity.similarity_2_to_1 = 0.35257e2
    submission_similarity.similarity = 0.35751e2
    submission_similarity.status = 0
  end

  submission_similarity.save

  submission_similarity_mapping = SubmissionSimilarityMapping.new do |submission_similarity_mapping|
    submission_similarity_mapping.submission_similarity_id = submission_similarity.id
    submission_similarity_mapping.start_index1 = 602
    submission_similarity_mapping.end_index1 = 852
    submission_similarity_mapping.start_index2 = 681
    submission_similarity_mapping.end_index2 = 878
    submission_similarity_mapping.start_line1 = 28
    submission_similarity_mapping.end_line1 = 41
    submission_similarity_mapping.start_line2 = 28
    submission_similarity_mapping.end_line2 = 37
    submission_similarity_mapping.statement_count = 5
    submission_similarity_mapping.is_plagiarism = true
  end

  submission_similarity_mapping.save
end

RSpec.describe 'api v1 submission_similarities requests index', type: :request do
  describe 'GET /api/v1/assignments/:assignment_id/submission_similarities/' do
    context 'successful' do
      before do
        init_submisision_similarities_tests

        course_id = Course.find_by(name: 'Introduction to Programming').id
        assignment = Assignment.find_by(course_id: course_id)
        get "/api/v1/assignments/#{assignment.id}/submission_similarities/", headers: {
          'X-API-KEY' => 'SSID_RSPEC_API_KEY'
        }
      end

      after do
        clear_tests
      end

      it 'returns an ok status' do
        expect(response).to have_http_status(:ok)
      end

      it 'returns assignment processing status' do
        response.body.should include 'status'
      end
    end

    context 'with missing/ invalid API key' do
      before do
        init_submisision_similarities_tests

        course_id = Course.find_by(name: 'Introduction to Programming').id
        assignment = Assignment.find_by(course_id: course_id)
        get "/api/v1/assignments/#{assignment.id}/submission_similarities/", headers: {
          'X-API-KEY' => 'EVIL_API_KEY'
        }
      end

      after do
        clear_tests
      end

      it 'returns a 401 status' do
        expect(response).to have_http_status(:unauthorized)
      end

      it 'returns correct error message' do
        response.body.should include 'Missing or invalid API key.'
      end
    end
  end
end

RSpec.describe 'api v1 submission_similarities requests show', type: :request do
  describe 'GET /api/v1/assignments/:assignment_id/submission_similarities/:submission_similarity_id' do
    context 'successful' do
      before do
        init_submisision_similarities_tests

        assignment = Assignment.find_by(title: 'RSpec Assignment')
        submission_similarity = assignment.submission_similarities.first
        get "/api/v1/assignments/#{assignment.id}/submission_similarities/#{submission_similarity.id}", headers: {
          'X-API-KEY' => 'SSID_RSPEC_API_KEY'
        }
      end

      after do
        clear_tests
      end

      it 'returns an ok status' do
        expect(response).to have_http_status(:ok)
      end

      it 'returns maxSimilaryPercentage and matches' do
        response.body.should include 'matches'
        response.body.should include 'similarity'
      end
    end

    context 'submission similarities requested do not exist' do
      before do
        init_submisision_similarities_tests
        course_id = Course.find_by(name: 'Introduction to Programming').id
        assignment = Assignment.find_by(course_id: course_id)

        get "/api/v1/assignments/#{assignment.id}/submission_similarities/99999999", headers: {
          'X-API-KEY' => 'SSID_RSPEC_API_KEY'
        }
      end

      after do
        clear_tests
      end

      it 'returns a 400 status' do
        expect(response).to have_http_status(:bad_request)
      end

      it 'returns correct error message' do
        response.body.should include 'Submission similarities requested do not exist.'
      end
    end

    context 'with missing/ invalid API key' do
      before do
        init_submisision_similarities_tests

        course_id = Course.find_by(name: 'Introduction to Programming').id
        assignment = Assignment.find_by(course_id: course_id)
        submission_similarity = assignment.submission_similarities.first
        get "/api/v1/assignments/#{assignment.id}/submission_similarities/#{submission_similarity.id}", headers: {
          'X-API-KEY' => 'EVIL_API_KEY'
        }
      end

      after do
        clear_tests
      end

      it 'returns a 401 status' do
        expect(response).to have_http_status(:unauthorized)
      end

      it 'returns correct error message' do
        response.body.should include 'Missing or invalid API key.'
      end
    end
  end
end


RSpec.describe 'api v1 submission_similarities requests view_pdf', type: :request do
  describe 'GET /api/v1/assignments/:assignment_id/submission_similarities/:submission_similarity_id/view_pdf' do
    context 'successful PDF generation' do
      before do
        init_submisision_similarities_tests

        assignment = Assignment.find_by(title: 'RSpec Assignment')
        @submission_similarity = assignment.submission_similarities.first
        get "/api/v1/assignments/#{assignment.id}/submission_similarities/#{@submission_similarity.id}/view_pdf", headers: {
          'X-API-KEY' => 'SSID_RSPEC_API_KEY'
        }
      end

      after do
        clear_tests
      end

      it 'returns an ok response' do
        expect(response).to have_http_status(:ok)
      end

      it 'sets the content type to PDF' do
        expect(response.headers['Content-Type']).to eq 'application/pdf'
      end

      it 'prompts to download the file' do
        expect(response.headers['Content-Disposition']).to include 'attachment'
      end

      it 'includes the correct filename' do
        expect(response.headers['Content-Disposition']).to include "filename=\"#{@submission_similarity.id}.pdf\""
      end
    end

    context 'submission similarities requested do not exist' do
      before do
        init_submisision_similarities_tests
        course_id = Course.find_by(name: 'Introduction to Programming').id
        assignment = Assignment.find_by(course_id: course_id)

        get "/api/v1/assignments/#{assignment.id}/submission_similarities/99999999/view_pdf", headers: {
          'X-API-KEY' => 'SSID_RSPEC_API_KEY'
        }
      end

      after do
        clear_tests
      end

      it 'returns a 400 status' do
        expect(response).to have_http_status(:bad_request)
      end

      it 'returns correct error message' do
        response.body.should include 'Submission similarities requested do not exist.'
      end
    end

    context 'with missing/ invalid API key' do
      before do
        init_submisision_similarities_tests

        course_id = Course.find_by(name: 'Introduction to Programming').id
        assignment = Assignment.find_by(course_id: course_id)
        submission_similarity = assignment.submission_similarities.first
        get "/api/v1/assignments/#{assignment.id}/submission_similarities/#{submission_similarity.id}/view_pdf", headers: {
          'X-API-KEY' => 'EVIL_API_KEY'
        }
      end

      after do
        clear_tests
      end

      it 'returns a 401 status' do
        expect(response).to have_http_status(:unauthorized)
      end

      it 'returns correct error message' do
        response.body.should include 'Missing or invalid API key.'
      end
    end
  end
end