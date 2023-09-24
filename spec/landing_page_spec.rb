require "spec_helper"

describe "landing page", type: :feature do
  before(:all) do
    Capybara.current_driver = :selenium_chrome_headless
  end

  it "click on Log In" do
    visit '/' 
    click_button "Log In"
    expect(page).to have_content 'Remember me'
  end
end

describe "landing page", type: :feature do
  before(:all) do
    Capybara.current_driver = :selenium_chrome_headless
    window = Capybara.current_session.driver.browser.manage.window
    window.resize_to(1920, 1080)
  end

  it "click on logo" do
    visit '/'
    click_link "Student Submissions Integrity Diagnosis System"
    expect(page).to have_content 'Hear from our instructors'
  end
end

describe "landing page", type: :feature do
  before(:all) do
    Capybara.current_driver = :selenium_chrome_headless
  end

  it "click on Get started" do
    visit '/'
    click_button "Get started"
    expect(page).to have_content '(8 characters minimum)'
  end
end

describe "landing page", type: :feature do
  before(:all) do
    Capybara.current_driver = :selenium_chrome_headless
  end

  it "click on Sign Up" do
    visit '/' 
    click_button "Sign Up"
    expect(page).to have_content '(8 characters minimum)'
  end
end

describe "landing page", type: :feature do
  before(:all) do
    Capybara.current_driver = :selenium_chrome_headless
  end

  it "click on Create account" do
    visit '/'
    click_button "Create account"
    expect(page).to have_content '(8 characters minimum)'
  end
end