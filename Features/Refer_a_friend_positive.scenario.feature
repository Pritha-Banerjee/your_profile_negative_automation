Feature: Test refer a friend positive functionality

  #User must click on the refer a friend and navigated to refer a friend page
  Scenario: Validate that user can able to view Refer a Friend under Home page
    Given launch the URL
    Then verify Tell your friends about Mpowered Health text and logo is displayed

  Scenario: Validate that user can able to click on Refer a Friend button
    When clicks on Refer a Friend
    Then navigated to Refer a Friend landing page
    

  Scenario: Validate that user must be able to view the referral code text
    Given verify referal code text is displayed

  Scenario: Validate that the user should able to see a Pop Up box when clicking on 'Share a link'
    When clicks on 'Share Link' button
    

  Scenario: Validate that the user should able to copy the link
    When clicks on copy the link and send message

  Scenario: Validate that user can view How its works
    Given verify How it work text is displayed

  Scenario: Validate that user can view the text Invite your friends to Mpowered Health by sharing your unique invitation code
    When verify Invite your friends to Mpowered Health is displayed

  Scenario: Validate that user can able to slide the two grids visible under How its works
    When clicks to slide the gird
    Then navigated to next slide

  Scenario: Validate that user can clicks on the link More information & FAQ and navigated to Frequently asked questions page
    When clicks on the link More information & FAQ
    

  Scenario: Validate that the user should able to view list of frequently asked questions
    Given verify list of Frequently asked questions is displayed