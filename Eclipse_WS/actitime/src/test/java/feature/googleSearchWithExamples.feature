@regression @bg
Feature: Printing Google Search results

	Background:
	 Given user is on google page
   
	@google 
	  Scenario Outline: User Search for Synechron
    When guser enter <company>
    And click on search button
    Then user prints the search results for 5 pages

    Examples: 
      | company   |
      | synechron |
      | IBM       |
      | Wipro     |
