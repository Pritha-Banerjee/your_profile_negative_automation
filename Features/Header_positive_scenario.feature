Feature: Test header in home page positive functionality

Scenario: Validate that the mpowered health logo in the header
Given Site is available
 When Navigated to welcome screen
Then  Check the mpowered health logo in the header

Scenario: Validate the navigation to the help page on clicking Help icon
When Click on Help icon
Then Verify navigation to the help page

Scenario: Validate the navigation to the alerts page on clicking Your alerts icon
When Click on Your alerts icon
Then Verify navigation to the alerts page

Scenario: Validate the Drop down tab
When Click on Drop down tab
Then Verify the drop down options

Scenario: Validate the navigation to the  profile page on clicking  Your profile tab
When Click on Drop down tab
Then Click on  Your profile
 And Verify navigation to the profile page.

Scenario: Validate  the  navigation to the ratings dashboard page on clicking Your ratings tab
When Click on Drop down tab
Then Click on  Your ratings
Then Verify navigation to the ratings dashboard page.

Scenario: Validate the navigation to the Feedback Port   page  on clicking Feedback
When Click on Drop down tab
Then Click on  Feedback
Then  Verify the navigation to the Feedback Port.

Scenario: Validate  the navigation to the Contact Us page  on clicking  Contact us
 When  Click on Drop down tab
Then Click on  Contact Us
 And Verify the navigation to the Contact Us.
 
Scenario:  Validate the  Privacy Policy dialogue box on clicking on the Privacy Policy
 When  Click on Drop down tab
Then Click on  Privacy Policy
Then Verify the dialogue box on privacy page
 
Scenario:   Validate  the  Terms & Conditions dialogue box on clicking on the Terms & Conditions
When Click on Drop down tab
Then click on  Terms & Conditions
And Verify the dialogue box on Terms and condition page

 Scenario: Validate the navigation to the Landing page on clicking Log out icon
  When Click on Log out icon
  Then Verify navigation to the Landing  page