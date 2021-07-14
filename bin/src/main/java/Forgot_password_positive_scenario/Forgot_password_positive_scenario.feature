Feature: Test forgot password page positive functionality

Scenario: Validate that the  user should  able to enter ten digit number in Phone Number field 
  Given App is open 
  Then Click on Login button then click on Forgot Password link and enter phone number in Phone number field 

Scenario: Validate that the user should able to click on the  Send Reset Link button on entering valid phone number in Phone number field
   
  Given Verify that Send Reset Link button gets enabled and user can click on it
  
Scenario: Validate that the user is navigated to sign up page on clicking Sign up link
   Given Click on Sign up link then should be navigated  to  Sign up page
   
