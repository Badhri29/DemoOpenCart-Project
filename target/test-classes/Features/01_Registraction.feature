@EndToEnd @Register
Feature: Register

  Background:
    Given Open Browser and launch url
    When click "register_link" button

	@positive @Sanity @Regerssion
  Scenario: To check Register with valid credential
    When enter all details
    And click "register_submit" button
    Then system should display "registration completed" message

	@positive @Smoke @Regerssion 
  Scenario: To check Register with mandatroy filed only
    When enter mandatroy filed only
    And click "register_submit" button
    Then system should display "registrationCompleted" message

	@negative @Sanity @Regerssion 
  Scenario: To check Register with invalid credential
    When enter invalid email
    Then system should display "registerEmail" message

	@negative @Sanity @Regerssion 
  Scenario: To check Register with invalid credential
    When enter different confirm password
    Then system should display "registerPassword" message
	