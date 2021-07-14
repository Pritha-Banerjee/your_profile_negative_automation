Feature: User should be able to click on the Utilities tab and able to use all the services under Utilities

  Scenario: Validate that the user is able to navigate to Utilities screen
    When User is on home page
    Then User should redirect to Utilities Dashboard when clicks on Utilities tab
    
  Scenario: Validate that user gets validation message on leaving fields blank in the Add Card page
    Then User should get validation message on leaving fields blank
    
  Scenario: Validate that user gets validation message on entering invalid details in the Add Card page
    Then User should get validation message on entering invalid details
    
  Scenario: Validate that user gets validation message on leaving fields blank in the Add Bank page
    Then User should get validation message on leaving fields blank in Add Bank page
    
  Scenario: Validate that user gets validation message on entering invalid details in the Add Bank page
    Then User should get validation message on entering invalid details in Add Bank page
    
  Scenario: Validate that user is not able to redeem when the balance is less than 2000
    Then User is not able to click on redeem