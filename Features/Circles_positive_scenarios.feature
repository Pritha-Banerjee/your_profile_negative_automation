Feature: Test Circle positive functionality

  Scenario: Validate that a user is taken to the Circles page when they click on the Circles tab
    Given launch the app
    When Click on the Circles tab
    Then Validate Circles page

  Scenario: Validate able to click on Add a Partner and options pop up
    When Click on Add a Partner
    Then Validate options pop up

  Scenario: Validate clicks on Add a Provider option under Add a Partner drop-down
    When Click on Add a Partner link
    Then Click on Select a partner

  Scenario: Validate Forgot username? link
    When click on the Forgot username? link
    Then Validate forgot username

  Scenario: Validate Forgot password? link
    When Click on the Forgot password link
    Then Validate the forgot password

  Scenario: Validate USERNAME and PASSWORD field
    When Enter  the Username and Password
   

  Scenario: Validate that the password displayed on clicking the eye
    When Click on eye symbol
    Then View password on clicking the eye

  Scenario: Validate Login with valid data
    When Enter valid username and password
    Then Validate Login with valid data

  Scenario: My Medicare icon in the Circles page and also it should be clickable
    When Navigate to Circles page
    Then My Medicare logo should be present
    And Validate that its clickable
