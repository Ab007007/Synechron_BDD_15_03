@regression
Feature: Printing Google Search results

Background:
	 Given user is on google page
	 
	@google
  Scenario: User Search for Synechron
    When user enter synechron
    And click on search button
    Then user prints the search results for 5 pages

  Scenario: User Search for IBM
    When guser enter "IBM"
    And click on search button
    Then user prints the google results for 2 pages

  Scenario: User Search for Wipro
    When guser enter "Wipro"
    And click on search button
    Then user prints the search results for 1 page

  Scenario: User Search for Number
    When guser enter 12334
    And click on search button
    Then user prints the search results for 1 page
