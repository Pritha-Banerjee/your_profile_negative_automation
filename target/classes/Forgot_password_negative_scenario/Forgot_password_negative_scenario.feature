Feature: User can reset password by clicking on Forgot password link 

Scenario: Validate that the user should get the validation message when phone number field is blank
Given App is open 
Then User get the validation message when Phone number field is blank
 
Scenario: Validate that the user should get a validation message on entering less than ten digit phone number in phone number field  
Given User get the validation message on entering less than ten digit phone number
 
Scenario: Validate that the user should get a validation message on entering more than ten digit phone number in phone number field 
Given User get the validation message on entering more than ten digit phone number
  
Scenario: Validate that the Send Reset Link button is disabled when Phone number field is blank  
Then Send Reset Link button is disabled when Phone number field is blank

Scenario: Validate that the user should able to get a validation message on entering non registered phone number in the phone number field 
Then User should able to get a validation message on entering non registered phone number in the phone number field
