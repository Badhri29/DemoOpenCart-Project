@EndToEnd @Register
Feature: Register

  Background:
    Given Open Browser "<browser>" and launch url
    When click "register_link" button
    
  Example:
  	|browser|
	|chrome|
  	|edge|
  	|firefox|

  @Positive @Sanity
  Scenario: To check Register with valid credential
    When enter all details
    And click "register_submit" button
    Then system should display "registrationCompleted" message

  @Positive @Smoke @Regerssion
  Scenario: To check Register with mandatroy filed only
    When enter mandatroy filed only
    And click "register_submit" button
    Then system should display "registrationCompleted" message

  @Negative @Sanity @Regerssion
  Scenario: To check Register with invalid credential
    When enter invalid register email
    Then system should display "registerEmail_Error" message

  @Negative @Regerssion
  Scenario: To check Register with invalid credential
    When enter different confirm password
    Then system should display "registerPassword_Error" message
