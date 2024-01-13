# frozen_string_literal: true

require 'rails_helper'
require 'spec_helper'

RSpec.describe 'api v1 assignments requests', type: :request do
  describe 'POST /api/v1/courses/:course_id/assignments/' do
    context 'successful' do
      before do
        init_tests
        course = Course.find_by(name: 'Introduction to Programming')
        post "/api/v1/courses/#{course.id}/assignments/", params:
                          {
                            title: 'assignment',
                            language: 'java',
                            sizeOfNGram: 5,
                            studentSubmissions: fixture_file_upload('minimal_student_submissions.zip',
                                                                    'application/octet-stream')
                          },
                                                          headers: {
                                                            'X-API-KEY' => 'SSID_RSPEC_API_KEY'
                                                          }
      end

      after do
        clear_tests
      end

      it 'returns an ok status' do
        expect(response).to have_http_status(:ok)
      end

      it 'returns an assignmentID' do
        response.body.should include 'assignmentID'
      end
    end

    context 'successful with CSV mapping' do
      before do
        init_tests
        course = Course.find_by(name: 'Introduction to Programming')
        post "/api/v1/courses/#{course.id}/assignments/", params:
                          {
                            title: 'assignment',
                            language: 'java',
                            sizeOfNGram: 5,
                            studentSubmissions: fixture_file_upload('minimal_student_submissions.zip',
                                                                    'application/octet-stream'),
                            mappingFile: fixture_file_upload('minimal_student_submissions_mapping.csv',
                                                             'application/octet-stream')
                          },
                                                          headers: {
                                                            'X-API-KEY' => 'SSID_RSPEC_API_KEY'
                                                          }
      end

      after do
        clear_tests
      end

      it 'returns an ok status' do
        expect(response).to have_http_status(:ok)
      end

      it 'returns an assignmentID' do
        response.body.should include 'assignmentID'
      end
    end

    context 'successful with references' do
      before do
        init_tests
        course = Course.find_by(name: 'Introduction to Programming')
        post "/api/v1/courses/#{course.id}/assignments/", params:
                          {
                            title: 'assignment',
                            language: 'java',
                            sizeOfNGram: 5,
                            studentSubmissions: fixture_file_upload('minimal_student_submissions.zip',
                                                                    'application/octet-stream'),
                            references: fixture_file_upload('minimal_references.zip',
                                                             'application/octet-stream')
                          },
                                                          headers: {
                                                            'X-API-KEY' => 'SSID_RSPEC_API_KEY'
                                                          }
      end

      after do
        clear_tests
      end

      it 'returns an ok status' do
        expect(response).to have_http_status(:ok)
      end

      it 'returns an assignmentID' do
        response.body.should include 'assignmentID'
      end
    end

    context 'with invalid language value' do
      before do
        init_tests
        course = Course.find_by(name: 'Introduction to Programming')
        post "/api/v1/courses/#{course.id}/assignments/", params:
                          {
                            title: 'assignment',
                            language: 'cpp17',
                            sizeOfNGram: 5,
                            studentSubmissions: fixture_file_upload('minimal_student_submissions.zip',
                                                                    'application/octet-stream')
                          },
                                                          headers: {
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
        response.body.should include 'Value of language is not valid'
      end
    end

    context 'with missing title parameter' do
      before do
        init_tests
        course = Course.find_by(name: 'Introduction to Programming')

        post "/api/v1/courses/#{course.id}/assignments/", params:
                          {
                            language: 'java',
                            sizeOfNGram: 5,
                            studentSubmissions: fixture_file_upload('minimal_student_submissions.zip',
                                                                    'application/octet-stream')
                          },
                                                          headers: {
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
        response.body.should include "Missing required parameter 'title'"
      end
    end

    context 'with invalid parameter' do
      before do
        init_tests
        course = Course.find_by(name: 'Introduction to Programming')

        post "/api/v1/courses/#{course.id}/assignments/", params:
                          {
                            title: 'assignment',
                            language: 'java',
                            sizeOfNGram: 5,
                            studentSubmissions: fixture_file_upload('minimal_student_submissions.zip',
                                                                    'application/octet-stream'),
                            sensitivity: 100
                          },
                                                          headers: {
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
        response.body.should include 'Parameter sensitivity is invalid or not yet supported.'
      end
    end

    context 'with missing/ invalid API key' do
      before do
        init_tests
        course = Course.find_by(name: 'Introduction to Programming')

        post "/api/v1/courses/#{course.id}/assignments/", params:
                          {
                            title: 'assignment',
                            language: 'java',
                            sizeOfNGram: 5,
                            studentSubmissions: fixture_file_upload('minimal_student_submissions.zip',
                                                                    'application/octet-stream')
                          },
                                                          headers: {
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
