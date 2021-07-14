Feature: User must be able to Login to the Homepage

  Scenario: Validate that the user is navigated to Welcome page
    Given Application is open
    And User clicks on Welcome Login button

  Scenario: Validate that the user is able to Login with valid data
    When User enters valid phonenumber and password and User click on login

  Scenario: Validate that the user is in Home page
    When User should be able to click on all the grid tiles and it should be navigated to tile landing page according to that tile

  Scenario: Validate that the user is navigated to the  Refer a friend page on clicking 'Refer a friend' button
    When User should be able to click on the Request for second opinion button and navigated to the Second opinion page successfully

  Scenario: Validate that the user is navigated to the Second Opinion page on clicking 'Request for second opinion' button
    When User should be able to click on Refer a friend button and navigated to the Refer a friend page successfully