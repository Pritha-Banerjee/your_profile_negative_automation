Feature: Test login page positive functionality

Scenario: Validate that the Phone number' field is prefixed with +1 country code 
  Given App is open 
  Then check  the  Phone number  field is prefixed with country code

Scenario: Validate that the user is able to click on the Forgot password? link
  Given User click on Forgot password
  
Scenario: Validate that the user is able click on the Sign up link
   Given User click on Sign up
   
Scenario: Validate that the user is able to enter  the Password in the Password field
   Given User enter  the Password  
   
Scenario: Validate that the user is able to Login with valid data
   When User enters valid phonenumber and password and User click on login
   
  Scenario: Validate that the user is navigated to Landing page on clicking the Log out option  
   Given User click on Logout