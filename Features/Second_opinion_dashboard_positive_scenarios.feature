Feature: Test second opinion dashboard positive functionality
#User must click on the second opinion in home page and navigated to second opinion page
  Scenario: Validate that the user is able to login with valid credentials
    Given browser is open
    When clicks on the 'login' button 
    And  navigated to the login page
    
  Scenario: Validate that the user is able to click on the Second Opinion tab
    When clicks on the second opinion tab
    Then navigated to second opinion page
    
    Scenario: Validate that the user is able to click on Resume Cases and is navigated to uplaod scans page
    When clicks on Resume Cases
    Then navigated to uplaod scans page
    
   Scenario: Validate that user should be able to view the bar with Upload Scans and links are working or not
    When able to view the bar and links
    
    Scenario: Validate that the user should be able to upload scans by clicking on 'Upload my scans' button
    When clicks on 'Upload my scans' button
    Then able to upload scans
    
    Scenario: Validate that the user should be able to view the dialogue box when I do not have a doctors report checkbox
    When 'I do not have a doctors report' is check
    Then able to view the Upload scans page
    
    Scenario: Validate that the user should be able to upload reports by clicking on 'Upload my reports' button
     When clicks on 'Upload my reports' button
     Then able to upload reports
    Scenario: Validate that User is able to click on Requested tab
    When  clicks on the Requested tab
    Then  navigated to Requested page
    
    Scenario: Validate that User is able to click on Reviewed tab
    When  clicks on the Reviewed tab
    Then  navigated to Reviewed  page