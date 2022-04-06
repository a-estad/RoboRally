
@tag
Feature: Robot
		      
		  @tag1
			  Scenario: Damaging robot
			    Given A robot with 5 lives
			    When the robot takes 1 damage
			    Then it has 4 lives
			
		  @tag2
			  Scenario: Death of robot
			    Given A robot with 1 life and start position (1, 1, 1)
			    When the robot takes 1 damage
			    Then it respawns at the starting point (1, 1, 1)
			    And it has 5 lives

