Feature: Login page validation

Scenario: Login Page title
Given user is on Login page
When user gets the title of the page
Then page title should be "OrangeHRM"

Scenario: Forgot your Password link
Given user is on Login page
Then forgot password link should display

Scenario: Login with valid credentials
Given user is on Login page
And user entered valid Username "Admin"
And user entered valid password "admin123"
When user click on login button
Then message should contains "welcome"