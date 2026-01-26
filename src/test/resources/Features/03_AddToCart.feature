@EndToEnd @AddToCart
Feature: AddToCart

  Background:
    Given Open Browser and launch url

  @Regerssion @Sanity
  Scenario: Add product to cart from product listing page
    When the user enters a "validProductName" in the search field
    And click "search" button
    And the user selects a product from the listing
    And click "Add to Cart" button
    Then system should display "success" message

  @Regerssion @Smoke
  Scenario: View product in cart after adding
    When the user enters a "validProductName" in the search field
    And click "search" button
    And click "Add to Cart" button
    And click "shopping Cart" button
    And check added product should present in the cart page

  @Regerssion
  Scenario: Search product using invalid product name
    When the user enters a "invalidProductName" in the search field
    And click "search" button
    Then "No products were found" message should be displayed

  Scenario: Search product without entering product name
    When click "search" button
    Then system should display "alert" message
