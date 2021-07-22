Feature: Test forgot password page positive functionality

Scenario: Validate by entering ten digit number in Phone Number field 
  Given Launch the browser
  When Click on Login button
  Then click on Forgot Password link
  And enter phone number in Phone number field

Scenario: Validate Reset Link button on entering valid phone number in Phone number field
  When Send Reset Link button gets enabled
  Then Validate on click of reset link
  
Scenario: Validate sign up page on clicking Sign up link
   When Click on Sign up link
  Then Verify navigation to Sign up page