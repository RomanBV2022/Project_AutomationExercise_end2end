
Feature: Automation end2end tests   to verify users
  scenarios on 'http://automationexercise.com'
  As a new user
  I want to create an account on the webpage
  I want login to my account
  So that I can access the website's features

  Scenario: Registration new user

    Given  I am on HomePage
    And I am not logged
    When I click to Login '/' Singin button
    Then I create New user
    When I click to Singup button
    Then I fill to registration form
    When I click to Create Account button
    Then New User Account was created
    When I click to Continue button
    Then I am on HomePage logged like New User

# Scenario: Delete User Account
#
#    Given I am on HomePage
#    And I am logged
    When User Click Delete Account button
    Then User Account was Deleted






