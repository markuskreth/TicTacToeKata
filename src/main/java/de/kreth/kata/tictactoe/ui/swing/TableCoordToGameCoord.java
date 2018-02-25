package de.kreth.kata.tictactoe.ui.swing;

public class TableCoordToGameCoord {

	private TableCoordToGameCoord() {
	}
	public static String fromTable(int row, int column) {
		StringBuilder result = new StringBuilder();
		result.append((char) (row+65));
		result.append(column);
		return result.toString();
	}
}
