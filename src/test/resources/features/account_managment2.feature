Feature: Automation end2end tests to account management functionality
  scenarios on 'http://automationexercise.com'
  As a user John
  I want to be able create an account on site
  I want to be able login to my account
  I want to be able logout from my account
  I want to be able delete my account

  @smoke
  Scenario: John REGISTERING in shop like new user
    Given John on HomePage
    And   John not logged
    When John press Signup/Login
    Then John move to LoginPage


  Scenario Outline: John fill "New User Signup!" form
    Given John be able to fill signup form
    When John input Name: <Name> and Email Address: <E-mail>
    When John press Signup button
    Then John on SignupPage
    Examples:
      | Name   | E-mail             |
      | "John" | "Wick@mail.com" |

  Scenario Outline: John fill required ACCOUNT INFORMATION
    Given John on SignupPage
    When John select gender
    And John create password:<Password>
    And John input his Date of Birth: <6 June 1977>
    And confirm: Sign up for our newsletter!
    And confirm: Receive special offers from our partners!
    Examples:
      | Password |
      | "qasxdsewr" |

  Scenario Outline: John fill required ADDRESS INFORMATION
    When John input First name: <First name>
    And John input Last name: <Last name>
    And John input Address: <Address>
    And John input Country: <Country>
    And John input State: <State>
    And John input City: <City>
    And John input Zipcode: <Zipcode>
    And John input Mobile Number: <Phone>
    Then John can Create Account
#    Then New John Account was created
    Examples:
      | First name | Last name | Address          | Country         | State   | City     | Zipcode | Phone         |
      | "John"     | "Wick"    | "Any street 5-6" | "United States" | "Texas" | "Dallas" | 13245   | "+1324542542" |

@smoke
  Scenario: John`s Account was CREATED
    When John see Account Created message
    And John press Continue
    Then John back to HomePage
    And John is logged

@smoke
  Scenario:John LOGOUT from shop
    When John is logged
    And John press Logout
    Then John move to LoginPage
    And John not logged
@smoke
  Scenario Outline: John LOGIN to shop
    Given John on HomePage
    And John not logged
    When John press Signup/Login
    When John move to LoginPage
    And John input e-mail <e-mail>
    And John input password <passwd>
    And  John press Login
    Then John on HomePage
    And John is logged
    Examples:
      | e-mail             | passwd   |
      | "Wick@mail.com" | "qasxdsewr" |
@smoke
  Scenario: John DELETE Account
    When John is logged
    And Press DeleteAccount
    And Confirm Account Deleted message
    Then John back to HomePage
    And John not logged
