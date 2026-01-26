@EndToEnd @Checkout
Feature: Checkout

  Background:
    Given Open Browser and launch url
    And the user logs in with valid credentials
    And the user add product to the cart
    
@Regerssion
  Scenario: Navigate to checkout page without accept terms and conditions
    When click "Checkout" button
    Then system should display "termsAndConditionsWarning" message

@Regerssion @Smoke
  Scenario: Verify order confirm details and place order
    Given user accept terms and condition
    When click "Checkout" button
    And process all checkout steps
    Then system should display "orderConfirm" message
