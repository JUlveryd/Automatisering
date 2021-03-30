@tag
Feature: Logging into Mailchimp

  Scenario: Login with valid username
  	Given I have navigated to the website
  	Given I have generated an <email>
    And I have entered it into the email field
    And I have generated a <username>
    And I have entered it into the username field
    And I have generated a <password>
    And I have entered it into the password field
  #  When I press Sign Up
#    Then I verify the <status> in step
    
    

#  @tag2
#  Scenario Outline: Logging in with valid username
#  	Given I have logged in with "browser"
#    And I have entered <name>
#    When I check for the <value> in step
#    Then I verify the <status> in step
#
#    Examples: 
#      | browser | value | status  |
#      | chrome 	|     5 | success |
#      | firefox |     7 | Fail    |
#      | edge  	| value | status  |
