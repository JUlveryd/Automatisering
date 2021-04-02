Feature: Mailchimp sign-up

  Background:
  Given I have navigated to the website
   And I have accepted cookies
  
@tag2   
  Scenario Outline: Account creation   
   Given I have input a username "<username>"
    And I have input an email "<email>"    
    And I have input a <password>
    And I have checked No Emails box
    When I press Sign Up
       Then the "<result>" should be
#       @After
       #		Then I close the driver


    Examples: 
      | username      | email      | result                  |
     | username      | blank		   | No email error          |
#     | username      | valid      | Account created         |
#      | usernameTaken | valid      | Username taken error    |
#     | longUsername  | valid      | Username too long error |