@EndToEnd @Checkout
Feature: Checkout

  Background:
    Given Open Browser and launch url
    And the user logs in with valid credentials
    And the user add product to the cart
    And user accept terms and condition
    And click "Checkout" button

  Scenario: Navigate to checkout page from cart
    Then the checkout page should be displayed

  Scenario: Add new billing address during checkout
    When the user selected the Add New Address options
    And the user enters valid Billing address details
    And click "continue" button
    Then user naviate to shipping method

  Scenario: Select existing billing address
    When the user selects an existing billing address
    And click "continue" button
    Then user naviate to shipping method

  Scenario: Verify order confirm details and place order
    When the user completed all methods
    Then verify all product details display shows correctly
    When click "continue" button
    Then order placed successfully
