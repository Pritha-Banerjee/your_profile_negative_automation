Feature: Validation on Bills page

  #User must click on the Bills and navigated to the Bills page
  Scenario: Validate navigation to bills page
     Given Launch the application
    When Click on 'Bills'

  Scenario: Verify the scenario to view Total bills due
    When 'Total bills due' visible on the page
    And 'Amount' visible on the page

  Scenario: Validate by selecting Newest option from the dropdown
    When Click on dropdown
    Then Select 'Newest'

  Scenario: Validate view bills as two sections
    When Click on 'Due' section
    And Click on 'Paid' section

  Scenario: Validate slide the grid below the Bills page title.
    When Slide through 'Total bills due'
    Then Validate  'Your expenses' grid is visible

  Scenario: Validate'Pay a Bill' button
    When Click on 'Pay a Bill' button
    Then Validate navigation to bill due section

  Scenario: Validate the message when expense is $0
    When Shows validation message 'you have no expenditures yet'
