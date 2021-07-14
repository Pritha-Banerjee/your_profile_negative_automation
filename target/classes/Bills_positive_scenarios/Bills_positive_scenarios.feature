Feature: Test Bills positive functionality

  Scenario: Validate that user can able to click on Bills tile from the home page tiles
    Given App is open
    When Click on Bills and verify that the user should be navigated to bills page

  Scenario: Validate that the user can able to view Total bills due below the Bills title
    Given Total bills due and amount should be visible on the page

  Scenario: Validate that the user can able to select Newest option from the dropdown
    Given Click on dropdown and select Newest

  Scenario: Validate that the user can view bills as two sections such as Due and Paid
    Given Click on Due section and click on Paid section

  Scenario: Validate that user can slide the grid below the Bills page title.
    Given Slide through Total bills due Verify that Your expenses grid is visible

  Scenario: Validate that the user will get validation message when expense is $0
    Given you have no expenditures yet. Use a service or upload a bill to pay message should be displayed on the page