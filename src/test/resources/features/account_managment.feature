Feature: Automation end2end tests to account management functionality
  scenarios on 'http://automationexercise.com'
  As a user John
  I want to be able create an account on site
  I want to be able login to my account
  I want to be able logout from my account
  I want to be able delete my account


  Scenario: Create new user

#    Given John is not regidstred user
    And John not logged

    When John fill er
    When John move to LoginPage
    Then John be able to fill singup form

  Scenario Outline: Fill signup form
    When John input Name: <name>
    And John input Email Address: <e-mail>
    Then John can singup
    Examples:
      | name   | e-mail             |
      | "John" | "john321@mail.com" |

  Scenario Outline: Fill ACCOUNT INFORMATION form
    When John on SignupPage
    And John select gender
    And John input password:<passwd>
    And John input Date of Birth: <month>
    And confirm: Sign up for our newsletter!
    And confirm: Receive special offers from our partners!
    Examples:
      | passwd   | day | month  | year |
      | "qwerty" | 6  | june| 1977 |

  Scenario Outline: Fill ADDRESS INFORMATION form
    When John input First name: <name>
    And John input Last name: <lname>
    And John input Address: <address>
    And John input Country: <country>
    And John input State: <state>
    And John input City: <city>
    And John input Zipcode: <zipcode>
    And John input Mobile Number: <phone>
    And press Create Account
    Then New John Account was created
    Examples:
      | name   | lname  | address          | country         | state   | city     | zipcode | phone         |
      | "John" | "Wick" | "Any street 5-6" | "United States" | "Texas" | "Dallas" | 13245   | "+1324542542" |

  Scenario: Confirm ACCOUNT CREATED! massage
    When John on Account Created massarge page
    And John press Continue
    Then John back to HomePage
    And John is logged


  Scenario: Logout
    When John is logged
    And John press Logout
    Then John move to LoginPage
    And John not logged

  Scenario Outline: Registered John login
    Given John on HomePage
    And John not logged
    When John move to LoginPage
    And John input e-mail <e-mail>
    And John input password <passwd>
    And  John press Login
    Then John back to HomePage
    And John is logged
    Examples:
      | e-mail             | passwd   |
      | "john321@mail.com" | "qwerty" |

  Scenario: Registered John Delete Account
    When John is logged
    And Press DeleteAccount
    And Confirm Account Deleted masage
    Then John back to HomePage
    And John not logged