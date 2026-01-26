@EndToEnd @AddToCart
Feature: AddToCart

  Background:
    Given Open Browser and launch url

  Scenario: Add product to cart from product listing page
    When the user enters a valid product name in the search field
    And click "search" button
    And the user selects a product from the listing
    And click "Add to Cart" button
    Then system should show success message

  Scenario: View product in cart after adding
    When the user enters a valid product name in the search field
    And click "search" button
    And click "Add to Cart" button
    Then the cart page should display the added product

  Scenario: Search product using invalid product name
    When the user enters an invalid product name in the search field
    And click "search" button
    Then the no results found message should be displayed

  Scenario: Search product without entering product name
    When click "search" button
    Then system should display alert
