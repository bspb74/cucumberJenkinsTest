@Login
Feature: Login Page Test

  @Login
  Scenario: Test Login for Sauce Labs Web Page
    Given user at login page
    When user enters username
    And user enters password
    And user clicks login button
    Then user is directed to homepage
