@regression
Feature: Login Functionality

  @pom
  Scenario: Successful Login1
    Given pomuser is on login page
    When pomuser enter valid username and password
    And pomuser click on login Button
    Then pomuser will be landed in dashboard page
    And pomuser will logout and close browser

  @pom
  Scenario: Successful Login2
    Given pomuser is on login page
    When pomuser enter valid username and password
    And pomuser click on login Button
    Then pomuser will be landed in dashboard page
    And pomuser will logout and close browser

  