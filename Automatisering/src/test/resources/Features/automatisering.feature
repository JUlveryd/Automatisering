Feature: Mailchimp sign-up

  Background:
  Given I have navigated to the website
   And I have accepted cookies  
 
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
      | username  | email | result                  |
      | name  | blank	| No email error          |
#      | name  | @gmail.com | Account created         |
#      | nameTaken | @gmail.com | Username taken error    |
      | longName  | @gmail.com | Username too long error |