Feature: User must click on the Award Point and navigated to the Reddemed award points page

  Scenario: Validate that the user is able to navigated to Utilities screen
    Given Application is open
    When User should click on Utilities tab and navigated to Utilities Dashboard
    
  Scenario: Validate that user gets validation message on entering amount more than the available amount in "Redeem Award Points" page
    When User should get validation message on entering amount more than the available amount in the Enter Amount field

  Scenario: Validate that user gets validation message on entering amount less than the available amount in "Redeem Award Points" page
    When User should get validation message on entering amount less than the available amount in the Enter Amount field

 Scenario: Validate that user is not able to click on the 'Redeem' button on leaving the field 'Select a gift card' blank"
    When User should get validation message clicking on the Redeem button on leaving the field Select a gift card blank

  Scenario: Validate that user is not able to click on the 'Redeem' button on leaving the field 'Enter Amount' blank on "Redeem Award Points" page
    When User should get validation message clicking on the Redeem button on leaving the field Enter Amount blank