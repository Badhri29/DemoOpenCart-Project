@EndToEnd @Login
Feature: Login

  Background:
    Given Open Browser and launch url
    When click "login_link" button

  @Positive @Smoke  @Sanity @Regerssion
  Scenario: To check Login with valid credential
    When enter email and password
    And click "login_submit" button
    Then user should navigate to home page

  @Negative @Sanity @Regerssion
  Scenario: To check Login with invalid credential
    When enter invalid login email
    Then system should display "loginEmail_Error" message
	
  @Negative @Regerssion
  Scenario: To check Login with invalid credential
    When enter invalid login password
    And click "login_submit" button
    Then system should display "loginFail" message

  @Negative @Regerssion
  Scenario: To check Login with invalid credential
    When leave empty email and password
    And click "login_submit" button
    Then system should display "loginFail" message
