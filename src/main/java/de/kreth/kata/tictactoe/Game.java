package de.kreth.kata.tictactoe;

import de.kreth.kata.tictactoe.ui.Board;
import de.kreth.kata.tictactoe.ui.InputReader;

class Game {

	private Board board;
	private GameState state;
	private InputReader reader;
	
	public Game(Board board, InputReader reader) {
		this.reader = reader;
		state = new GameState();
		this.board = board;
	}
	
	public void start() {
		while (state.isFinished() == false) {
			nextMove();
		}
		board.paint(state);
		board.appendState("finished!");
		if(state.winner != null) {
			board.appendState(state.winner.name() + " has won!");
		}
	}

	private void nextMove() {

		board.paint(state);
		board.nextPlayer(state.getNext());
		String input = reader.nextInput();
		state.set(input.toCharArray());
	}

}
