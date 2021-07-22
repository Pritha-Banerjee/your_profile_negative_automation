Feature: Validation on Your profile page negative test cases

  #User should be able to click on the your profile and edit profile details
  Scenario: Verify clicking on profile will navigates to Your profile screen
    Given Launch the URL and open login page
    When Enter login details
    Then Click on your profile

  Scenario: Validate that Send Code button is disabled when they do not check the phone number
  When Phone number check box is Unchecked
  Then Verify Send Code button is disabled

  Scenario: Verify the scenario when blank 'security code and Re-enter password' fields
    When Enter 'security code and Re-enter password' as blank
    Then verify the validation messages

  Scenario: Verify the scenario when entering invalid Security code  and Re-enter password
    When Enter invalid 'security code and Re-enter password'
    Then Verify the validation message for invalid data

  Scenario: Verify the scenario when blank 'security code or Re-enter password' fields
    When Enter 'security code or Re-enter password' as blank
    Then Verify the validation blank message

  Scenario: Verify the scenario when unable to  Edit the primary and deactivate email
  When Click on edit contact details
    Then Not able to edit primary and deactivate email

  Scenario: Verify the scenario when blank Your profile Page fields
    When Enter firstname and lastname fields as blank
    Then Verify the validation message for blank fields

  Scenario: Verify the scenario when entering invalid First name, Last name  or  Preferred name
    When Enters invalid firstname,lastname and preferred name
    Then Verify the validation for invalid first name, last name or preferred name

  Scenario: Verify the scenario unable to  Edit the User ID
  When Verify 'User ID' is displayed
   Then verify 'User ID' is disabled for edit

  Scenario: Verify the scenario when Email ID fields are blank
  When click on contact details
    Then Leave email id field as blank

  Scenario: Verify the scenario when entering invalid Email ID  or  already exist Email ID
    When Enter invalid email id
    Then Verify the validation for invalid email id

  Scenario: Verify the scenario when unable to  Edit the primary and deactivate phone number
  When Click on phone number
    Then primary and deactivate phone number is disabled for edit
    
  Scenario: Verify the scenario when entering invalid Phone number  or  Phone number fields are blank
    When Enter invalid Phone number  or  Phone number fields
    Then Verify the validation message for Phone number  or  Phone number fields

  Scenario: Verify the scenario when unable to  Edit the primary and deactivate address
  When Click on Address
    Then primary and deactivate address are disbled for edit

  Scenario: Verify the scenario when leaving the fields blank in the Add new address Page
  When Click on add new address '+' symbol
    Then Leaves fields blank

  Scenario: Verify the scenario when entering invalid Zip code in Add new address page
    When Enters invalid zip code
    Then Verify the Invalid zip code message

  Scenario: Verify the scenario when leaving the fields blank in the Add plan Page
  When click on plan coverage
    When Enter add plan page feilds blank

  Scenario: Verify the scenario when entering invalid First name of policy holder or Last name of policy holder  in Add plan page
    When Enters invalid firstname and lastname fields in add plan page
    Then Verify the error message on invalid firstname and lastname

  Scenario: Verify the scenario when leaving the fields blank in the Change password page
    When Enter blank fields in Change password page
    Then Verify the blank field message

  Scenario: Verify the scenario when entering wrong Old password in Change password page
    When Enter wrong passwords
    Then Verify wrong password message

  Scenario: Verify the scenario when invalid New password in Change password page
    When Enter invalid new password
    Then Verify invalid password message

  Scenario: Verify the scenario when entering same data in Old password and New password fields in Change password page
    When Enter same data in Old password and New password fields
    Then verify the validation message

  Scenario: Verify the scenario when entering different data in New password and Confirm new password fields
    When Enter different data in New password and Confirm new password fields
    Then Verify the different password message

  Scenario: Verify the scenario when a dialogue box appears dur to the failure of profile picture
    When Not able to upload profile picture
    Then Verify the message on unsuccessful upload
