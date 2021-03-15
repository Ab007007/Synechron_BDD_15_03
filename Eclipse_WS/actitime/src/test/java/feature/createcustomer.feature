Feature: Customer Creation

  Scenario: Create new customer
    Given user is logged in to the application
    When user click on tasks and verify the task page
    And user click on new customer button
    Then user enter customername and customerdesc
    And click on create customer
    Then user validate the success message
    And logout of the application
