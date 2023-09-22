Feature: Verify content on 'http://automationexercise.com' and other features
  As a new user
  I want to verify all products on the webpage

  Background: User don`t logged
    Given  I am on HomePage
    And I am not logged

  Scenario: Verify content on 'http://automationexercise.com'
    When I click to Login '/' SingIn button to create account