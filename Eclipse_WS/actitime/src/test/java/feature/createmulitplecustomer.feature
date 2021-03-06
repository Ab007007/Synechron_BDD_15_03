Feature: Create Mulitple customers

  Background: 
    Given user is logged in to the application

  @actitime
  Scenario Outline: Create new customer
    When user click on tasks and verify the task page
    And user click on new customer button
    Then user enter <customername> and <customerdesc>
    And click on create customer
    Then user validate the success message
    And logout of the application

    Examples: 
      | customername          | customerdesc              |
      | Syn-BDD-Customer-Mar1 | Syn-BDD-CustomerDesc-Mar1 |
      | Syn-BDD-Customer-Mar2 | Syn-BDD-CustomerDesc-Mar2 |
      | Syn-BDD-Customer-Mar3 | Syn-BDD-CustomerDesc-Mar3 |
      | Syn-BDD-Customer-Mar4 | Syn-BDD-CustomerDesc-Mar4 |
