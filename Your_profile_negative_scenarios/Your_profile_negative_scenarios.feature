Feature: Your profile page negative scenarios

Scenario: Validate that the user is able to navigate to Your profile screen
    When User is on home page and clicks on your profile
  
Scenario: Validate that Send Code button is disabled when they do not check the phone number
   When User should not be able to click on Send Code
   
Scenario: Validate that the user is not allowed to verify when Security code and Re-enter password fields are blank
   When Validation msgs should be displayed when user leaves security code and reenter password fields blank
   
Scenario: Validate that the user should get a validation message on entering invalid Security code  and Re-enter password
   When Validation msgs should be displayed when user enters invalid security code and  password
   
Scenario: Validate that the user is not allowed leave the Security code or Re-enter password field blank.
  When User is not allowed to leave security code and password field blank
  
Scenario: Validate that the user is unable to  Edit the primary and deactivate email
  When User is unable to  edit the primary and deactivate email
  
Scenario: Validate that user gets validation message on leaving the fields blank in the Your profile Page
  When Validation msgs should be displayed when user leaves firstname and lastname fields blank
  
Scenario: Validate that the user should get a validation message on entering invalid First name, Last name  or  Preferred name
  When Validation msgs should be displayed when user enters invalid firstname,lastname and preferred name
  
Scenario: Validate that the user is unable to  Edit the User ID
  When User should not be able to edit User ID
  
Scenario: Validate that the user is not allowed to add email id when Email ID fields are blank
  When Validation msgs should be displayed when user leaves email id field blank
  
Scenario: Validate that the user should get a validation message on entering invalid Email ID  or  already exist Email ID
  When Validation msgs should be displayed when user enters invalid email id
  
Scenario: Validate that the user is unable to  Edit the primary and deactivate phone number
  When User is unable to Edit the primary and deactivate phone number
  
Scenario: Validate that the user should get a validation message on entering invalid Phone number  or  Phone number fields are blank
  When Validation msgs should be displayed when user enters invalid phone number
  
Scenario: Validate that the user is unable to  Edit the primary and deactivate address
  When User is unable to Edit the primary and deactivate address
  
Scenario: Validate that user gets validation message on leaving the fields blank in the Add new address Page
  When Validation msgs should be displayed when user leaves fields blank
  
Scenario: Validate that the user should get a validation message on entering invalid Zip code in Add new address page
  When Validation msgs should be displayed when user enters invalid zip code
  
Scenario: Validate that user gets validation message on leaving the fields blank in the Add plan Page
  When Validation msgs should be displayed when user leave fields blank in add plan page
  
Scenario: Validate that the user should get a validation message on entering invalid First name of policy holder or Last name of policy holder  in Add plan page
  When Validation msgs should be displayed when user enters invalid firstname and lastname fields in add plan page
  
Scenario: Validate that user gets validation message on leaving the fields blank in the Change password page
  When Validation msgs should be displayed when user leave fields blank in Change password page
  
Scenario: Validate that the user should get a validation message on entering wrong Old password in Change password page
  When Validation msgs should be displayed when user enter wrong passwords

Scenario: Validate that the user should get a validation message on entering invalid New password in Change password page
  When Validation msgs should be displayed when user enter invalid new password
  
Scenario: Validate that the user should get a validation message on entering same data in Old password and New password fields in Change password page
  When Validation msgs should be displayed when user enters same data in Old password and New password fields

Scenario: Validate that the user should get a  validation message on entering different data in New password and Confirm new password fields 
  When Validation msgs should be displayed when user enters different data in New password and Confirm new password fields
  
Scenario: Validate that the user get a  dialogue box when fail to upload the profile picture
  When User should not be able to upload profile picture





