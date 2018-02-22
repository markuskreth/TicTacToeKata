package de.kreth.kata.tictactoe;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import de.kreth.kata.tictactoe.GameState.Player;

class WinnerTest {

	private GameState state;
	
	@BeforeEach
	public void initPGamestate() {
		this.state = new GameState();
		this.state.next = Player.PLAYER1;
	}

	@Test
	void testAll1Row() {
		state.state[0][0] = state.next;
		state.state[0][1] = state.next;
		state.set("C0".toCharArray());
		assertTrue(state.isFinished());
	}

	@Test
	void testAll2Row() {
		state.state[1][0] = state.next;
		state.state[1][1] = state.next;
		state.set("C1".toCharArray());
		assertTrue(state.isFinished());
	}

	@Test
	void testAll3Row() {
		state.state[2][0] = state.next;
		state.state[2][1] = state.next;
		state.set("C2".toCharArray());
		assertTrue(state.isFinished());
	}

	@Test
	void testAllACol() {
		state.state[0][0] = state.next;
		state.state[1][0] = state.next;
		state.set("A2".toCharArray());
		assertTrue(state.isFinished());
	}

	@Test
	void testAllBCol() {
		state.state[0][1] = state.next;
		state.state[1][1] = state.next;
		state.set("B2".toCharArray());
		assertTrue(state.isFinished());
	}

	@Test
	void testAllCCol() {
		state.state[0][2] = state.next;
		state.state[1][2] = state.next;
		state.set("C2".toCharArray());
		assertTrue(state.isFinished());
	}

	@Test
	void testDiagonal1() {
		state.state[0][0] = state.next;
		state.state[1][1] = state.next;
		state.set("C2".toCharArray());
		assertTrue(state.isFinished());
	}

	@Test
	void testDiagonal2() {
		state.state[0][2] = state.next;
		state.state[1][1] = state.next;
		state.set("A2".toCharArray());
		assertTrue(state.isFinished());
	}

}
