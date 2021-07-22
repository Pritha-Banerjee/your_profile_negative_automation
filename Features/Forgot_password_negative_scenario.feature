Feature: User can reset password by clicking on Forgot password link 

Scenario: Validate that the user should get the validation message when phone number field is blank
Given Launch  URL
  When Phone number field is blank
  Then Validate the error message when phone number is blank
 
Scenario: Validate the message on entering less than ten digit phone number in phone number field
When Enter less than ten digit phone number
  Then Validate the error message for less than ten digits
 
Scenario: Validate the message on entering more than ten digit phone number in phone number field
When Enter more than ten digit phone number
  Then Validate the error message for more than ten digits
  
Scenario: Validate  the Send Reset Link button is disabled when Phone number field is blank
When  Reset Link button is disabled
Then validate Phone number field is blank

Scenario: Validate the  message on entering non registered phone number in the phone number field
When  Enter non registered phone number in the phone number field
  Then Validate message on entering non registered number