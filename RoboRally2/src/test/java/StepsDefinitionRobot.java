import static org.junit.Assert.assertEquals;

import dtu.roboRally.Robot;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepsDefinitionRobot {
	
	Robot robot;

	@Given("A robot with {int} lives")
	public void a_robot_with_lives(int lives) {
	    robot = new Robot(1, 1, 1);
	    robot.setLives(lives);
	}
	@When("the robot takes {int} damage")
	public void the_robot_takes_damage(int damage) {
	    robot.damage(damage);
	}
	@Then("it has {int} lives")
	public void it_has_lives(int lives) {
	    assertEquals(lives, robot.getLives());
	}

	
	@Given("A robot with {int} life and start position \\({int}, {int}, {int})")
	public void a_robot_with_life_and_start_position(int lives, int o, int x, int y) {
	    robot = new Robot(o, x, y);
	    robot.setLives(lives);
	}
	@Then("it respawns at the starting point \\({int}, {int}, {int})")
	public void it_respawns_at_the_starting_point(int o, int x, int y) {
	    assertEquals(o, robot.getPosition().getOrientation());
	    assertEquals(x, robot.getPosition().getX());
	    assertEquals(y, robot.getPosition().getY());
	}

}
