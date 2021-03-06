package dtu.roboRally;


import java.util.ArrayList;

public class Game {

	private ArrayList<Player> players = new ArrayList<>();
	private static Game instance;
	private final Board board;
	
	private Game(int numberOfPlayers) {
		board = new Board(10, 10, numberOfPlayers); //maybe change size
	}
	
	
	public static Game getInstance() {
		if (instance == null) {
			System.out.println("Game not initialised, call getInstance(int)");
		}
		return instance;
	}
	
	public static Game getInstance(int nbPlayers) {
		if(instance==null) {
			instance = new Game(nbPlayers);
		}
		//setNumberPlayers(nbPlayers);
		return instance;
	}
	
	public void setNumberPlayers(int i) {
		for(int j=0;j<i;j++) {
			players.add(new Player());
		}
	}
	
	public void phase1() {
		for(Player p:instance.getPlayers()) {
			p.drawHand();
			p.showHand();
			p.pickCardsInPlay();
		}
	}
	
	public void phase2() {
		// number of cards in play
		int nbOfCards = instance.getPlayers().get(0).getCardsInPlay().size();		
		
		// loop for each player to program their robot with their cards
		for (int round=0; round < nbOfCards; round++) {
			
			ArrayList<Integer> priorities = new ArrayList<>();
			
			// creates list of n'th card priorities according to each player index
			for(Player p:instance.getPlayers()) {
				priorities.add(p.getCardsInPlay().get(0).getPriority());
			}
			// loop for robot to move according to the n'th card of each player
			for(int playerIndex=0; playerIndex<numberOfPlayers(); playerIndex++) {
				// loop for getting max priority and index of max priority
				int maxPriority = 0;
				int indexMaxPriority = 0;
				for (int i=0; i < priorities.size(); i++) {
					if (priorities.get(i) > maxPriority) {
						maxPriority = priorities.get(i);
						indexMaxPriority = i;
					}
				}
				// use of card (robot behaves accordingly)
				Player currPlayer = instance.getPlayers().get(indexMaxPriority);
				currPlayer.use(currPlayer.getCardsInPlay().remove(0));
				priorities.set(indexMaxPriority, 0);
				
				//check if player won
				Position positionRobot = currPlayer.getRobot().getPosition();
				if(board.getTile(positionRobot.getX(), positionRobot.getY()) instanceof EndPosition) {
					instance.hasWon(indexMaxPriority);
				}
			}
		}
	}
	
	public void hasWon(int playerIndex) {
		//TODO: exit game or smth
		System.out.println("Congratulations! Player " + playerIndex + " won the game!");
	}
	
	public int numberOfPlayers() {
		return players.size();
	}
	
	public ArrayList<Player> getPlayers() {
		return players;
	}

	public Board getBoard() {
		return board;
	}
}