package de.kreth.kata.tictactoe.ui;

import static org.junit.Assert.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import de.kreth.kata.tictactoe.GameState;

public class BoardTest {

	private GameState state;
	private ByteArrayOutputStream stream;
	private Board b;

	@BeforeEach
	public void initBoard() {
		state = new GameState();

		stream = new ByteArrayOutputStream();
		PrintStream out = new PrintStream(stream);
		b = new Board(out, state);
	}
	
	@Test
	public void testEmptyBoard() {
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
