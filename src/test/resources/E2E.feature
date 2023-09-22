Feature: End2End tests for  'http://automationexercise.com'
  As a new user
  I want to create account, login, add products to cart and create order

  Background: User don`t logged
    Given  I am on HomePage
    And I am not logged
    When I click to Login '/' SingIn button to create account

  Scenario: Registration new account for "Robert"
    And I create <Robert`s> account
    And I fill registration form and submit
    And I verify that account created
    Then I am on HomePage logged in <Robert> account

  Scenario: Logout  from <Robert`s> account
    And   I verify  accounts holder name
    And   I am login to <Robert`s> account
    And   I click  Logout link for logout from <Robert`s> account
    Then  I logout from <Robert`s> account











  Scenario: Login to <Robert> account with correct email and Delete account
    And  I am login to <Robert`s> account
    And  I click Delete button to delete account
    Then <Robert> Account was Deleted

#
#












  Scenario: Login to <Robert> account with correct email and Delete account
    And  I am login to <Robert`s> account
    And  I click Delete button to delete account
    Then <Robert> Account was Deleted







