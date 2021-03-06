package dtu.roboRally;

import java.util.Random;

public class Board {

	//initialize class attributes
	private int rows;
	private int cols;
	
	//initializing a matrix consisting of elements of 'Tile' type
	private Tile[][] board;
	
	//boolean for checking if board is running in StepsDefinition
//	private boolean isRunning = false;
	private Random rnd = new Random();
	
	//Board constructor
	public Board(int newRows, int newCols, int numberOfPlayers) {
//		this.isRunning = true;
		this.rows = newRows;
		this.cols = newCols;
		this.board = new Tile[rows][cols];
		
		loadObstacles();
		loadStartPosition(numberOfPlayers);
		loadEndPosition();
	}
	
	//parse through the empty matrix and assign random tile types
	public void loadObstacles() {
		Tile t;
		for (int j = 0; j < rows; j++) {
			for (int i = 0; i < cols;i++) {
				t = getRandomTileType();
				board[j][i] = t;
			}
		}
	}
	
	public void loadStartPosition(int numberOfPlayers) {
		for(int i=0; i<numberOfPlayers; i++) {
			int x,y;
			do {
				x = (int) Math.floor(Math.random()*3);
				y = (int) Math.floor(Math.random()*rows);
			} while(! (board[y][x] instanceof Floor));
			
			board[y][x] = new StartPosition();
		}
	}
	
	public void loadEndPosition() {
		int x,y;
		do {
			x = (int) Math.floor(rows - Math.random()*3);
			y = (int) Math.floor(Math.random()*rows);
		} while(! (board[y][x] instanceof Floor));
		
		board[y][x] = new EndPosition();
	}
	
	// return random tile type method
	public Tile getRandomTileType() {
		double val = rnd.nextDouble();
		if (val < 0.80) {
			return new Floor();
		} else if (val < 0.84) {
			return new Repair();
		} else if (val < 0.88) {
			return new Wall((int)Math.floor(Math.random()*4));
		} else if (val < 0.92) {
			return new Pit();
		} else if (val < 0.96) {
			return new Acid();
		} else {
			return new Radiation();
		}
	}
	
	//getter for board
	public Tile[][] getBoard() {
		return board;
	}
	
	public Tile getTile(int x, int y) {
		return board[y][x];
	}
	
	//prints the board, parses through the Tile matrix
	public void printBoard() {
		for (Tile[] row : board) {
			for (Tile col : row) {
				System.out.print(" " + col);
			}
			System.out.println("");
		}
	}
}
