package de.kreth.kata.tictactoe;

import java.io.PrintStream;

import de.kreth.kata.tictactoe.ui.Board;
import de.kreth.kata.tictactoe.ui.ConsoleInputReader;
import de.kreth.kata.tictactoe.ui.InputReader;

class Game {

	private Board board;
	private GameState state;
	private PrintStream out;
	private InputReader reader;
	
	public Game() {
		this(System.out, new ConsoleInputReader());
	}
	
	public Game(PrintStream out, InputReader reader) {
		this.out = out;
		this.reader = reader;
		state = new GameState();
		board = new Board(out, state);
	}
	
	public void start() {
		while (state.isFinished() == false) {
			nextMove();
		}
	}

	private void nextMove() {

		board.paint();
		out.print("Kommando ");
		out.print(state.getNext());
		out.println(": ");
		String input = reader.nextInput();
		state.set(input.toCharArray());
	}

}
