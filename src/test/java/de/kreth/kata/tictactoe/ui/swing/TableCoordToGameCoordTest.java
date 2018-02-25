package de.kreth.kata.tictactoe.ui.swing;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TableCoordToGameCoordTest {

	@Test
	void testA0() {
		int row = 0;
		int column = 0;
		String actual = TableCoordToGameCoord.fromTable(row, column);
		assertEquals("A0", actual);
	}

	@Test
	void testC2() {
		int row = 2;
		int column = 2;
		String actual = TableCoordToGameCoord.fromTable(row, column);
		assertEquals("C2", actual);
	}

}
