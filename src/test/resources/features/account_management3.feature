Feature: Automation end2end tests to account management functionality
  scenarios on 'http://automationexercise.com'
  As a user John
  I want to be able create an account on site
  I want to be able login to my account
  I want to be able logout from my account
  I want to be able delete my account

  Scenario Outline: John REGISTERING in shop like new user
    Given John on HomePage
    And   John not logged
    When John press Signup/Login
    And John put <NickName> and  <E-mail> in Signup form
    And John put required data in ACCOUNT INFORMATION form: <Password> ,<DateOfBirth>
    And John put required data in ADDRESS INFORMATION form: <First name>, <Last name>, <Address>,  <Country>, <State>, <City>, <Zipcode>,<Phone>
    Then John back to HomePage
    And John is logged
    Examples:
      | NickName | E-mail          | First name | Last name | Password    | DateOfBirth | Address          | Country         | State   | City     | Zipcode | Phone         |
      | "John"   | "Wick@mail.com" | "John"     | "Wick"    | "qasxdsewr" | ""          | "Any street 5-6" | "United States" | "Texas" | "Dallas" | 13245   | "+1324542542" |

  Scenario:John LOGOUT from shop
    When John is logged
    And John press Logout
    Then John move to LoginPage
    And John not logged

  Scenario Outline: John LOGIN to shop
    Given John on HomePage
    And John not logged
    When John press Signup/Login
    And John put <E-mail> and <Password> in Login form
    Then John back to HomePage
    And John is logged
    Examples:
      | E-mail          | Password    |
      | "Wick@mail.com" | "qasxdsewr" |

  Scenario: John DELETE Account
    When John is logged
    And Press DeleteAccount
    And Confirm Account Deleted message
    Then John back to HomePage
    And John not logged