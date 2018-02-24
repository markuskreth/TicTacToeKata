package de.kreth.kata.tictactoe;

import de.kreth.kata.tictactoe.ui.console.ConsoleBoard;
import de.kreth.kata.tictactoe.ui.console.ConsoleInputReader;

public class TicTacToe {

	public static void main(String[] args) {
		new Game(new ConsoleBoard(System.out), new ConsoleInputReader()).start();
	}

}
