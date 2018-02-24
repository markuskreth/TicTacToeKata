package de.kreth.kata.tictactoe;

import de.kreth.kata.tictactoe.ui.swing.MainFrame;

public class TicTacToe {

	public static void main(String[] args) {
		MainFrame frame = new MainFrame();
		frame.setVisible(true);
		new Game(frame, frame).start();
	}

}
