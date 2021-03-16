Feature: Tags Demo

	@test1
  Scenario: Demonstrate tags-1
    Given user is testing app
    And he continue to test
	@test2
  Scenario: Demonstrate tags-2
    Given user is testing app
    And he continue to test

	@test1 @test2
  Scenario: Demonstrate tags-3
    Given user is testing app
    And he continue to test

	@test3
  Scenario: Demonstrate tags-3
    Given user is testing app
    And he continue to test
