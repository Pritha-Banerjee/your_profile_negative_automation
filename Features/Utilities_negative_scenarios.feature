Feature: Validation on Utilities page negative test cases

  #User should be able to click on the Utilities tab and able to use all the services under Utilities
  Scenario: Navigate to Utilities screen
    Given User is on home page
    When Clicks on Utilities tab

  Scenario: Verify the scenario when 'Add Card' fields is blank
    When Leave Add card field as blank
    Then Verify the message on leaving Add Card fields as blank

  Scenario: Verify the message on entering invalid details in the Add Card page
    When Enter invalid card details
    

  Scenario: Verify the scenario when 'Add Bank' fields is blank
    When Leave Add Bank field as blank
    Then Verify the message on leaving Add Bank fields as blank

  Scenario: Verify the message on entering invalid details in the 'Add Bank' page
    When Enter invalid bank details
    Then Verify the message on entering invalid bank details

  Scenario: Verify the redeem button when the balance is less than 2000
    When Verify the redeem button is disabled
