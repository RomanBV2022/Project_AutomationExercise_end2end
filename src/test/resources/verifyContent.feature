Feature: Verify content on 'http://automationexercise.com' and other features
  As a new user
  I want to verify all products on the webpage

  Background: User don`t logged
    Given  I am on HomePage
    And I am not logged

#  Scenario: Verify all products and product detail page
#    When I click to 'Products' button
#    And I verify Product page and product list are visible
#    And I click view product of first product
#    Then I am on detail page and verify ':' product name, price, availability, condition, brand

  Scenario: Verify products quantity in cart
    And I click view product of first product
    And I increase quantity to 4
    And I click 'Add to cart' button
    And I click 'View cart' button
    And I verify that product is displayed in Cart page
    Then I verify  exact quantity in cart

#  Scenario: Verify Test Cases page
#    When I click on 'Test Cases' button
#    Then I verify that Test Cases page is displayed





