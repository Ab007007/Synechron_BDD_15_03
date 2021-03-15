Feature: Printing Google Search results

  Scenario: User Search for Synechron
    Given guser is on google page
    When user enter synechron
    And click on search button
    Then user prints the search results for 5 pages

  Scenario: User Search for IBM
    Given user is on google page
    When guser enter "IBM"
    And click on search button
    Then user prints the google results for 2 pages

  Scenario: User Search for Wipro
    Given user is on google page
    When guser enter "Wipro"
    And click on search button
    Then user prints the search results for 1 page

  Scenario: User Search for Number
    Given user is on google page
    When guser enter 12334
    And click on search button
    Then user prints the search results for 1 page
