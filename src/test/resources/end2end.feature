Feature: Automation end2end tests   to verify users
  scenarios on 'http://automationexercise.com'
  As a new user
  I want to create an account for "Robert" on the webpage
  I want login to "Robert`s" account
  So that I can access the website's features

  Background: User don`t logged

  Scenario: Registration new account for "Robert"

    Given  I am on HomePage
    And I am not logged
    When I click to Login '/' SingIn button to create account
    And I create <Robert`s> account
    And I fill registration form and submit
    And I verify that account created
    Then I am on HomePage logged in <Robert> account

  Scenario: Logout  from <Robert`s> account
    Given : I am on HomePage and I am not logged
    When :  I click login  for moving to Login page and login to <Robert`s> account
    And :   I click  Logout link for logout from <Robert`s> account
    Then :  I logout from <Robert`s> account


  Scenario: Login to <Robert> account with correct email and Delete account

    Given I am on HomePage and not logged
    When I click login link for moving to Login page and login to <Robert`s> account
    And  I click Delete button to delete account
    Then <Robert> Account was Deleted


















#  Scenario Outline: Login to <Robert> account with Incorrect email and Delete account
#
#    Given I am on HomePage and not logged yet
#    When I click login and try to login  to "Robert`s" account
#    And  Type <email> and <password>
#    Then result is <result>
#    Examples:
#      |email|password|result|
#      |emwe@we.pl|1111|ok   |
#      |ert@wp.pl |1222|ok   |