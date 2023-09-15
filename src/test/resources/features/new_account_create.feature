Feature: Automation end2end tests to verify users
          scenarios on 'http://automationexercise.com'
  As a new user
  I want to create an account on the webpage
  I want login to my account
  So that I can access the website's features


  Scenario: User create new account

    Given User on HomePage
    And User not logged
    When User move to login page
    And User correct fill form
    And User press Signup
    Then User move to Signup page
    When User correct fill to registration form
    And User press Create Account
    Then New User Account was created
    When User press Continue
    Then User back to Home Page
    And User is logged
    When User Click Delete Account button
    Then User Account was Deleted

