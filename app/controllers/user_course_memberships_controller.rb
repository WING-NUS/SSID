class UserCourseMembershipsController < ApplicationController
  # GET /user_course_memberships
  # GET /user_course_memberships.json
  def index
    @user_course_memberships = UserCourseMembership.all

    respond_to do |format|
      format.html # index.html.erb
      format.json { render json: @user_course_memberships }
    end
  end

  # GET /user_course_memberships/1
  # GET /user_course_memberships/1.json
  def show
    @user_course_membership = UserCourseMembership.find(params[:id])

    respond_to do |format|
      format.html # show.html.erb
      format.json { render json: @user_course_membership }
    end
  end

  # GET /user_course_memberships/new
  # GET /user_course_memberships/new.json
  def new
    @user_course_membership = UserCourseMembership.new

    respond_to do |format|
      format.html # new.html.erb
      format.json { render json: @user_course_membership }
    end
  end

  # GET /user_course_memberships/1/edit
  def edit
    @user_course_membership = UserCourseMembership.find(params[:id])
  end

  # POST /user_course_memberships
  # POST /user_course_memberships.json
  def create
    @user_course_membership = UserCourseMembership.new(params[:user_course_membership])

    respond_to do |format|
      if @user_course_membership.save
        format.html { redirect_to @user_course_membership, notice: 'User course membership was successfully created.' }
        format.json { render json: @user_course_membership, status: :created, location: @user_course_membership }
      else
        format.html { render action: "new" }
        format.json { render json: @user_course_membership.errors, status: :unprocessable_entity }
      end
    end
  end

  # PUT /user_course_memberships/1
  # PUT /user_course_memberships/1.json
  def update
    @user_course_membership = UserCourseMembership.find(params[:id])

    respond_to do |format|
      if @user_course_membership.update_attributes(params[:user_course_membership])
        format.html { redirect_to @user_course_membership, notice: 'User course membership was successfully updated.' }
        format.json { head :no_content }
      else
        format.html { render action: "edit" }
        format.json { render json: @user_course_membership.errors, status: :unprocessable_entity }
      end
    end
  end

  # DELETE /user_course_memberships/1
  # DELETE /user_course_memberships/1.json
  def destroy
    @user_course_membership = UserCourseMembership.find(params[:id])
    @user_course_membership.destroy

    respond_to do |format|
      format.html { redirect_to user_course_memberships_url }
      format.json { head :no_content }
    end
  end
end
