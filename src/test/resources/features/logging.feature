
Feature: Automation end2end tests to verify users
  scenarios on 'http://automationexercise.com'
  As a registered user
  I want login to my account
  So that I can access the website's features


Scenario: User move to login page
  Given User on HomePage
  And User not logged
  When User press in NavBar login/signup
  Then User move to LoginPage

Scenario: Logging
  Given User on LoginPage
  When User input name and email in Login form
  And Confirm
  Then User come to HomePage
  And User logged