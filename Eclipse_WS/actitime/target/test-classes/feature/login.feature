@regression
Feature: Login Functionality
	@actitime @testss
  Scenario: Successful Login
    Given user is on login page
    When loginuser enter valid username and password
    And click on login Button
    Then user will be landed in dashboard page
 #   And close the browser
	@acititme @testss @pom
  Scenario: UnSuccessful Login
    Given user is on login page
    When loginuser enter invalid username and password
    And click on login Button
    Then user will be landed in dashboard page
 #   And close the browser
