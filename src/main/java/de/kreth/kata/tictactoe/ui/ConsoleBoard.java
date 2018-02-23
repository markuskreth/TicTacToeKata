package de.kreth.kata.tictactoe.ui;

import java.io.PrintStream;

import de.kreth.kata.tictactoe.GameState;
import de.kreth.kata.tictactoe.GameState.Player;

public class ConsoleBoard implements Board {

	private PrintStream out;

	public ConsoleBoard(PrintStream out) {
		this.out = out;
	}

	/* (non-Javadoc)
	 * @see de.kreth.kata.tictactoe.ui.Board#paint(de.kreth.kata.tictactoe.GameState)
	 */
	@Override
	public void paint(GameState state) {
		out.println(" A B C");
		printLine(0, state.currentState());
		out.println(" -+-+-");
		printLine(1, state.currentState());
		out.println(" -+-+-");
		printLine(2, state.currentState());
	}

	private void printLine(int i, Player[][] current) {
		out.print(i);
		out.print(current[i][0]==null?' ':current[i][0].getSign());
		out.print('|');
		out.print(current[i][1]==null?' ':current[i][1].getSign());
		out.print('|');
		out.print(current[i][2]==null?' ':current[i][2].getSign());
		out.println();
		
	}
}
