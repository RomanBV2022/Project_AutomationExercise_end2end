#Feature: End2End tests for  'http://automationexercise.com'
#  As a new user
#  I want to create account, login, add products to cart and create order
#
#  Background: User don`t logged
#    Given  I am on HomePage
#    And I am not logged
#
#  Scenario: Search product
#    And I click to 'Products' button
#    And I verify Product page and product list are visible
#    And I enter product name and click search button
#    And I verify that searched products are visible
#
#  Scenario: Add products in cart
#    And I click to 'Products' button
#    And I hover over first product and click 'Add to cart'
#    And I click 'Add to cart' button
#    And I click 'Continue shopping' button
#    And I hover over second product and click 'Add to cart'
#    And I click 'View cart' button
#    And I verify that product is displayed in Cart page
#    Then I verify  exact quantity in cart
#
#  Scenario: Remove Products from cart
#    And I click to 'Products' button
#    And I click 'Add to cart' button
#    And I click 'View cart' button
#    And I verify that product is displayed in Cart page
#    And I click 'X' button for remove product from cart
#    And I verify that product removed from cart
#
#  Scenario: Order Product: Register and Login  before purchase
#    When I click to Login '/' SingIn button to create account
#    And I create <Robert`s> account
#    And I fill registration form and submit
#    And I verify that account created
#    Then I am on HomePage logged in <Robert> account
#    And I click 'Add to cart' button
#    And I click 'View cart' button
#    And I verify that product is displayed in Cart page
#    And I click Proceed to checkout
#    And I verify Address Details and Review my Order
#    And I enter description in comment text area and click 'Place Order'
#    And I  enter payment details: Name on Card, Card Number, CVC, Expiration date
#    And I  click 'Pay and Confirm Order' button
#    And I verify success message 'Your order has been placed successfully!'
#    And  I click Delete button to delete account
#    Then <Robert> Account was Deleted
#
#
#
#
#
#
#
#
#
#
#
#
#
#
#
#
#
#
