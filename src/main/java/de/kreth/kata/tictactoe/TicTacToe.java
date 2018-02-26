package de.kreth.kata.tictactoe;

import de.kreth.kata.tictactoe.ui.Board;
import de.kreth.kata.tictactoe.ui.InputReader;
import de.kreth.kata.tictactoe.ui.console.ConsoleBoard;
import de.kreth.kata.tictactoe.ui.console.ConsoleInputReader;
import de.kreth.kata.tictactoe.ui.swing.MainFrame;

public class TicTacToe {

	public static void main(String[] args) {
		GameConfig conf;
		if(args.length>0 && "console".equalsIgnoreCase(args[0])) {
			conf = createConsole();
		} else {
			conf = createSwing();
		}
		new Game(conf.getBoard(), conf.getInputReader()).start();
	}

	private static GameConfig createConsole() {
		return new GameConfig() {
			ConsoleBoard board = new ConsoleBoard(System.out);
			ConsoleInputReader reader = new ConsoleInputReader();
			
			@Override
			public InputReader getInputReader() {
				return reader;
			}
			
			@Override
			public Board getBoard() {
				return board;
			}
		};
	}

	private static GameConfig createSwing() {

		return new GameConfig() {

			final MainFrame frame = new MainFrame();
			
			@Override
			public InputReader getInputReader() {
				return frame;
			}
			
			@Override
			public Board getBoard() {
				return frame;
			}
		};
	}

	interface GameConfig {
		Board getBoard();
		InputReader getInputReader();
	}
}
