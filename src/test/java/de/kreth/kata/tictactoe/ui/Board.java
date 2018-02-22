package de.kreth.kata.tictactoe.ui;

import java.io.PrintStream;

import de.kreth.kata.tictactoe.GameState;
import de.kreth.kata.tictactoe.GameState.Player;

public class Board {

	private PrintStream out;
	private GameState state;

	public Board(PrintStream out, GameState state) {
		this.out = out;
		this.state = state;
	}

	public void paint() {
		out.println(" A B C");
		printLine(0);
		out.println(" -+-+-");
		printLine(1);
		out.println(" -+-+-");
		printLine(2);
	}

	private void printLine(int i) {
		Player[][] current = state.currentState();
		out.print(i);
		out.print(current[i][0]==null?' ':current[i][0].getSign());
		out.print('|');
		out.print(current[i][1]==null?' ':current[i][1].getSign());
		out.print('|');
		out.print(current[i][2]==null?' ':current[i][2].getSign());
		out.println();
		
	}
}
