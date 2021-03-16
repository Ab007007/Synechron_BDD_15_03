Feature: Customer Creation

  Background: 
    Given user is logged in to the application

  @actitime
  Scenario: Create new customer
    When user click on tasks and verify the task page
    And user click on new customer button
    Then user enter Syn-BDD-CustMar1 and Syn-BDD-CustMar-Desc1
    And click on create customer
    Then user validate the success message
    And logout of the application

  @actitime
  Scenario: Re-Create existing customer
    When user click on tasks and verify the task page
    And user click on new customer button
    Then user enter Syn-BDD-CustMar1 and Syn-BDD-CustMar-Desc1
    And click on create customer
    Then application throws error message
    And user validate the error message and click on cancel
    And logout of the application
