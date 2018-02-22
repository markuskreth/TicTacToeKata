package de.kreth.kata.tictactoe.ui;

import java.io.PrintStream;

public class Board {

	private PrintStream out;

	public Board(PrintStream out) {
		this.out = out;
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
