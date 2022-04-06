import static org.junit.Assert.assertEquals;

import dtu.roboRally.Game;
import dtu.roboRally.Player;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepsDefinitionPlayer {
	
	Player p;
	Game game = Game.getInstance(4);
	
	@Given("a player")
	public void a_player() {
	    p = new Player();
	}
	@When("the player draws a hand of cards")
	public void the_player_draws_a_hand_of_cards() {
	    p.drawHand();
	}
	@Then("he has {int} random cards")
	public void he_has_random_cards(int numberOfCards) {
	    assertEquals(numberOfCards, p.getHand().size());
	}
}
