@dev
Feature: Customer Creation

  Background: 
    Given user is logged in to the application
    When user click on tasks and verify the task page

  @acttitimeregression1
  Scenario: Create new customer
    When user create multiple customer and validate success message
      | Syn-BDD-Customer-Mar5 | Syn-BDD-CustomerDesc-Mar5 |
      | Syn-BDD-Customer-Mar6 | Syn-BDD-CustomerDesc-Mar6 |
      | Syn-BDD-Customer-Mar7 | Syn-BDD-CustomerDesc-Mar7 |
      | Syn-BDD-Customer-Mar8 | Syn-BDD-CustomerDesc-Mar8 |
    And logout of the application