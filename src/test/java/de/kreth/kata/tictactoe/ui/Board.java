package de.kreth.kata.tictactoe.ui;

import java.io.PrintStream;

import de.kreth.kata.tictactoe.GameState;

public class Board {

	private PrintStream out;
	private GameState state;

	public Board(PrintStream out, GameState state) {
		this.out = out;
		this.state = state;
	}

	public void paint() {
		out.println(" A B C");
		out.println("0 | | ");
		out.println(" -+-+-");
		out.println("1 | | ");
		out.println(" -+-+-");
		out.println("2 | | ");
	}
}
