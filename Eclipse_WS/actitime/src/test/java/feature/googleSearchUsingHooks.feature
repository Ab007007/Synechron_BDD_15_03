Feature: Printing Google Search results

  @hooks 
  Scenario: User Search and print the company realated search
    Given hookuser is on google page
    When data table user search company name and print the search results
      | synechron |
      | ibm       |
      | wipro     |
 
  @hooks
  Scenario: User Search and print the company realated search
    Given hookuser is on google page
    When guser enter IBMMMM
    And click on search button
    Then user prints the search results for 5 pages
