package de.kreth.kata.tictactoe.ui;

import static org.junit.Assert.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.Test;

public class BoardTest {

	@Test
	public void testEmptyBoard() {
		ByteArrayOutputStream stream = new ByteArrayOutputStream();
		PrintStream out = new PrintStream(stream);
		Board b = new Board(out);
		b.paint();
		String expected = 
				" A B C\n" + 
				"0 | | \n" + 
				" -+-+-\n" + 
				"1 | | \n" + 
				" -+-+-\n" + 
				"2 | | \n";
		String actual = stream.toString();
		assertEquals(expected, actual);
	}

}
