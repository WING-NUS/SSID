require "spec_helper"

describe "landing page", type: :feature do
  before(:all) do
    Capybara.current_driver = :selenium_chrome
  end

  it "click on Log In" do
    visit BASE_URL 
    click_button "Log In"
    expect(page).to have_content 'Remember me'
  end
end

describe "landing page", type: :feature do
  before(:all) do
    Capybara.current_driver = :selenium_chrome
  end

  it "click on logo" do
    visit BASE_URL
    click_link "Student Submissions Integrity Diagnosis System"
    expect(page).to have_content 'Hear from our instructors'
  end
end

describe "landing page", type: :feature do
  before(:all) do
    Capybara.current_driver = :selenium_chrome
  end

  it "click on Get started" do
    visit BASE_URL
    click_button "Get started"
    expect(page).to have_content '(8 characters minimum)'
  end
end

describe "landing page", type: :feature do
  before(:all) do
    Capybara.current_driver = :selenium_chrome
  end

  it "click on Sign Up" do
    visit BASE_URL
    click_button "Sign Up"
    expect(page).to have_content '(8 characters minimum)'
  end
end

describe "landing page", type: :feature do
  before(:all) do
    Capybara.current_driver = :selenium_chrome
  end

  it "click on Create account" do
    visit BASE_URL
    click_button "Create account"
    expect(page).to have_content '(8 characters minimum)'
  end
end