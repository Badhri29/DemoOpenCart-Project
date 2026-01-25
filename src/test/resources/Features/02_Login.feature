@EndToEnd @Login
Feature: Login

  Background:
    Given Open Browser and launch url
    When click "login_link" button

  Scenario: To check Login with valid credential
    When enter email and password
    And click "login_submit" button
    Then user should navigate to home page

  Scenario: To check Login with invalid credential
    When enter invalid details
    Then system should display "loginEmail" message
