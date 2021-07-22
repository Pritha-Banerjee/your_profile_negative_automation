Feature: Validation Services Pages

  #User should click on the Services tab and  navigates to Services page
  Scenario: Validate that the user is navigated to the Services page on clicking Services tab  
	Given User is on home page and clicks on Services tab
    Then User should be navigated to services page

Scenario: Validate that the user is navigated to the Second Opinion page on clicking Second Opinions
    Given User is on Services page
    Then User should be navigated to Second opinions page on clicking Second opinions tab
    
Scenario: Validate that the user is navigated to the Conditions page on clicking Conditions
    Given User is on Services page
    Then User should be navigated to Conditions page on clicking conditions tab
    
 Scenario:  Validate that the user is navigated to the Medications page on clicking Medications
    Given User is on Services page
    Then User should be navigated to Medications page on clicking Medications tab
    
 Scenario: Validate that the user is navigated to the Bills page on clicking Bills 
    Given User is on Services page
    Then User should be navigated to Bills page on clicking Bills tab
    
 Scenario: Validate that the user is navigated to the Claims page on clicking Claims 
 	Given User is on Services page
    Then User should be navigated to Claims page on clicking Claims tab