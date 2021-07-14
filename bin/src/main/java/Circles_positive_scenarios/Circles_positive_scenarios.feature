Feature: Test Circle positive functionality

  Scenario: Validate that a user is taken to the Circles page when they click on the Circles tab
    Given App is open
    Then check user is taken to the Circles page when they click on the Circles tab

  Scenario: Validate that a user is able to click on Add a Partner and options pop up
    Then check  user is able to click on Add a Partner and options pop up

  Scenario: Validate that when a user clicks on Add a Provider option under Add a Partner drop-down, they are directed to the provider screen
    Then check  user is able to click on Add a Partner then click on Select a partner and select the My Medicare option finally click on Proceed

  Scenario: Validate that the user is able to click on the Forgot username? link
    Then check  user is able to click on the Forgot username? link

  Scenario: Validate that the user is able to click on the Forgot password? link
    Then check  user is able to click on the Forgot password? link

  Scenario: Validate that the user is able to enter  the Username and Password in the USERNAME and PASSWORD field
    Then check  user is able to enter  the Username and Password

  Scenario: Validate that the password should be displayed on clicking the eye
    Then check  user is able to view password on clicking the eye

  Scenario: Validate that the user is able to Login with valid data
    Then check  user is able to Login with valid data

  Scenario: Validate that the user can able to view My Medicare icon in the Circles page and also it should be clickable
    Given My Medicare logo should be present in the Circles page  and it should be clickable