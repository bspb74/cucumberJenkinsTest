@Handles
  Feature: Get Handles and navigate between pages

    @GetHandles
    Scenario: Open Multiple Pages and get handles
      Given user has opened multiple pages
        | search_txt             | match_txt                   |
        | selenium test websites | Sample Webpage for Selenium |
        | candymapper            | CandyMapper.Com |
        | demoblaze              | STORE                       |
      When user gets a list of handles
      Then user navigates from page to page
        | website      | substring    |
        | candymapper  | Sandbox      |
        | demoblaze    | STORE        |
        | artOfTesting | ArtOfTesting |
      And user closes all tabs
        | website      | substring    |
        | candymapper  | Sandbox      |
        | demoblaze    | STORE        |
        | artOfTesting | ArtOfTesting |
