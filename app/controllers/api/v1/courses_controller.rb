class Api::V1::CoursesController < ApplicationController
    skip_before_action :authenticate_user!

    def sample_get
        if ApiKey.find_by(value: request.headers["X-API-KEY"])
            render json: {"Status": "OK"}, status: :ok
        else
            render json: {"Status": "Can't find API key"}, status: :ok
        end
    end

    def sample_post
        if ApiKey.find_by(value: request.headers["X-API-KEY"])
            render json: {"Status": "OK"}, status: :ok
        else
            render json: {"Status": "Can't find API key"}, status: :ok
        end 
    end
end