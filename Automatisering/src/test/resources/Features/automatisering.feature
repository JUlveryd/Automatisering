Feature: Mailchimp sign-up

  Background:
   Given I have navigated to the website
 
  Scenario Outline: Account creation   
   Given I have input a username "<username>"
   And I have input an email "<email>"
   And I have input a <password>
   And I have accepted cookies
   And I have checked No Emails box
   When I press Sign Up "<signup>"
   Then the "<result>" should be

    Examples: 
      | username  | email     | signup    | result                  |
      | name      | blank	    | normal    | No email error          |
      | name      | @sit.com  | normal    | Account created         |
      | longName  | @rom.com  | normal    | Username too long error |
      | name      | @tele.com | nameTaken | Username taken error    |