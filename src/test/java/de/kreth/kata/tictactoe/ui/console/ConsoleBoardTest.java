package de.kreth.kata.tictactoe.ui.console;

import static org.junit.Assert.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import de.kreth.kata.tictactoe.GameState;
import de.kreth.kata.tictactoe.GameState.Player;
import de.kreth.kata.tictactoe.ui.Board;
import de.kreth.kata.tictactoe.ui.console.ConsoleBoard;

public class ConsoleBoardTest {

	private GameState state;
	private ByteArrayOutputStream stream;
	private Board b;

	@BeforeEach
	public void initBoard() {
		state = new GameState(Player.PLAYER1);
		stream = new ByteArrayOutputStream();
		PrintStream out = new PrintStream(stream);
		b = new ConsoleBoard(out);
	}

	@Test
	public void testEmptyBoard() {
		b.paint(state);
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

	@Test
	public void testPlayer1OnA1() {
		state.set("A1".toCharArray());
		b.paint(state);
		String expected = 
				" A B C\n" + 
				"0 | | \n" + 
				" -+-+-\n" + 
				"1X| | \n" + 
				" -+-+-\n" + 
				"2 | | \n";
		String actual = stream.toString();
		assertEquals(expected, actual);
	}

	@Test
	public void testPlayer1OnB0() {
		state.set("B0".toCharArray());
		b.paint(state);
		String expected = 
				" A B C\n" + 
				"0 |X| \n" + 
				" -+-+-\n" + 
				"1 | | \n" + 
				" -+-+-\n" + 
				"2 | | \n";
		String actual = stream.toString();
		assertEquals(expected, actual);
	}

}
