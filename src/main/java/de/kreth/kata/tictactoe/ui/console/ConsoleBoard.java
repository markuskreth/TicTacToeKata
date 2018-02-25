package de.kreth.kata.tictactoe.ui.console;

import java.io.PrintStream;

import de.kreth.kata.tictactoe.GameState;
import de.kreth.kata.tictactoe.GameState.Player;
import de.kreth.kata.tictactoe.ui.Board;

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

	@Override
	public void appendState(String text) {
		out.println(text);		
	}

	@Override
	public void nextPlayer(String playerName) {
		out.print("Kommando ");
		out.print(playerName);
		out.println(": ");
	}

	@Override
	public void gameEnd(Player winner) {
		out.println("Finisched!");
		if(winner == null) {
			out.println("Game ended even.");
		} else {
			out.println("Winner: " + winner.name());
		}
	}
}
