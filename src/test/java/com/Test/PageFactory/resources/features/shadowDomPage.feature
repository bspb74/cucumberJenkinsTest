@Shadow @feature_2
Feature: Shadow DOM Page Test

@Test2
Scenario: Test Login for Sauce Labs Web Page
  Given user at shadow dom page
  When user selects encoding
  And user selects view server explorer
  And user deselects view solution explorer
  And user deselects view server explorer
  Then user exits
  