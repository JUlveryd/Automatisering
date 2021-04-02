#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template
@tag
Feature: Title of your feature
  I want to use this template for my feature file

   Scenario: Login with valid username
    Given I have navigated to the website
    And I have accepted cookies
    Given I have input an <email>
    And I have entered it into the email field
    And I have input a <username>
    And I have entered it into the username field
    And I have input a <password>
    And I have entered it into the password field
    When I press Sign Up
    #   Then I verify the <status> in step
    And I close the driver

  Scenario: Login with long username
    Given I have navigated to the website
    Given I have input a long <email>
    And I have entered it into the email field
    And I have input a long <username>
    And I have entered it into the username field
    And I have input a <password>
    And I have entered it into the password field
    When I press Sign Up
    #   Then I verify the <status> in step
    And I close the driver

  Scenario: Login with taken username
    Given I have navigated to the website
    Given I have input an <email>
    And I have entered it into the email field
    And I have input a taken <username>
    And I have entered it into the username field
    And I have input a <password>
    And I have entered it into the password field
    When I press Sign Up
    #   Then I verify the <status> in step
    And I close the driver