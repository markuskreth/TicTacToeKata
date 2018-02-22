package de.kreth.kata.tictactoe;

import de.kreth.kata.tictactoe.ui.Board;

class Game {

	private Board board;
	
	public Game() {
		board = new Board(System.out);
	}
	
	public void start() {
		board.paint();		
	}

}
