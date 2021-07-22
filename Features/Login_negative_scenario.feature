Feature: Validate login negative functionality

  #User must click on the login and validate validation messages should be displayed
  Scenario: User is not allowed to login when Phone number and Password fields are blank
    Given launch URL
    And clicks on 'Login' button

  Scenario: User enter invalid credentials in the Login Page
    When enters invalid phone no and password
    Then validation message is displayed 

  Scenario: User enter invalid 'Phone number' and valid 'Password'
    When enters invalid phone no and valid password
    Then validation message is displayed

  Scenario: User enter invalid 'Password' and valid 'Phone number'
    When enters invalid password and valid phone no
    Then validation message is displayed

  Scenario: User is not able to login on leaving 'Phone number' field blank and only giving valid 'Password'
    When enters phone no as  blank field
    Then validation message is displayed

  Scenario: User is not able to login on leaving 'Password' field blank and only giving valid 'Phone number'
    When enters password as  blank field
    Then validation message is displayed
