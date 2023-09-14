Feature: Automation end2end tests   to verify users
          scenarios on 'http://automationexercise.com'
  As a new user
  I want to create an account on the webpage
  I want login to my account
  So that I can access the website's features

Background: Browser start and navigate to BASE_URL

#  Scenario: Create new account
#    Then  Click on 'Signup / Login' button
#    When Verify 'New User Signup!' is visible
#    Then Enter name
#    And  Enter e-mail address
#    When Verify that 'ENTER ACCOUNT INFORMATION' is visible
#    Then Title fill
#    And Verify: Name like Entered on previous page
#    And Verify: e-mail like Entered on previous page
#    And Enter Password
#    And Enter Date of birth
#    And Select checkbox 'Sign up for our newsletter!'
#    And Select checkbox 'Receive special offers from our partners!'
#    And Enter First name
#    And Enter Last name
#    And Enter Address
#    And Enter Country
#    And Enter State
#    And Enter City
#    And Enter Zipcode
#    And Enter Mobile Number
#    Then Click 'Create Account button'
#    When Verify that 'ACCOUNT CREATED!' is visible
#    Then Click 'Continue' button
#    When  Verify that 'Logged in as username' is visible
#    Then Click 'Delete Account' button
#    When Verify that 'ACCOUNT DELETED!' is visible and click 'Continue' button


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


#    Step launch browser  performed in TestBase.class
#    Given I am on HomePage
#    Then I Click on Signup / Login button for moving to Login page
#    When I am on LoginPage page
#    Then I Enter name
#    And  Enter e-mail address
#    When Click to Signup button to confirm and moving to Singup page
#    Then I am on SingupPage
#    Then I Select radio button title Mr. or Mrs.
#    And Enter Password
#    And Enter Date of birth
#    And Select checkbox Sign up for our newsletter!
#    And Select checkbox Receive special offers from our partners!
#    And Enter First name
#    And Enter Last name
#    And Enter Address
#    And Enter Country
#    And Enter State
#    And Enter City
#    And Enter Zipcode
#    And Enter Mobile Number
#    Then Click Create Account button to confirm and moving to Account_created page
#    When I am on AccountCreatedPage
#    Then I Click Continue button for moving to Home page
#    When I am on HomePage
#    Then I Click Delete Account button for moving to Delete_account page
#    When I am on DeleteAccountPage
#    Then I Click Continue button to confirm and moving to Home page
#    When I am on HomePage then scenario finish
#


#    Given User am on HomePage
#    And User not logged
#    When User Click on Signup / Login button
#    Then User move to Login page
#    Then User Enter name
#    And  Enter e-mail address
#    When User Click to Signup button to confirm
#    Then User moving to Singup page
#    Then User Select radio button title Mr. or Mrs.
#    And Enter Password
#    And Enter Date of birth
#    And Select checkbox Sign up for our newsletter!
#    And Select checkbox Receive special offers from our partners!
#    And Enter First name
#    And Enter Last name
#    And Enter Address
#    And Enter Country
#    And Enter State
#    And Enter City
#    And Enter Zipcode
#    And Enter Mobile Number
#    When User Click Create Account button to confirm
#    Then User move to Account_created page
#    Then New User Accaunt was create
#    When User Click Continue button
#    Then User move to Home page
#    Then User am on HomePage logged like New User
#
#
 Scenario: Delete User Account
#
   Given User am on HomePage
#    And User is logged
   When User Click Delete Account button for moving to Delete_account page
#    When I Click Continue button to confirm and moving to Home page
#    Then User Account was Deleted
#
#
#
#




