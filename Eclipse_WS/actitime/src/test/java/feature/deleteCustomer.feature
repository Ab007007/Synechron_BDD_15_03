Feature: Customer Deletion

  Background: 
    Given user is logged in to the application

  Scenario: Delete customer
    When user click on tasks and verify the task page
    Then user search for a customer Customer-TestngDec-2020-3 and click on settings button
    And click on Actions and delete button
    Then user will confirm by clicking on delete button
    And user validate the success message
    And logout of the application

  @acttitimeregression
  Scenario Outline: Delete customer
    When user click on tasks and verify the task page
    Then user search for a customer <customername> and click on settings button
    And click on Actions and delete button
    Then user will confirm by clicking on delete button
    And user validate the success message
    And logout of the application

    Examples: 
      | customername          |
      | Syn-BDD-Customer-Mar5 |
      | Syn-BDD-Customer-Mar6 |
      | Syn-BDD-Customer-Mar7 |
      | Syn-BDD-Customer-Mar8 |
