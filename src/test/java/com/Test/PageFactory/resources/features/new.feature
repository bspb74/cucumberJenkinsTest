@New_Features
Feature: Testing Branching strategy

  @New_Feature
  Scenario Outline: This is a new feature
    Given user is at Google Search Page
    When user searches for <search_text>
    Then select results for <select_text>
    And user returns to search page

    Examples:
      | search_text   | select_text     |
      | weather       | AccuWeather     |
      | stock market  | Financial News  |
      | health trends | Top Health News |