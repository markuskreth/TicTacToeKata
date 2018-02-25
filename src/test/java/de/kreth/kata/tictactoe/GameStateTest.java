package de.kreth.kata.tictactoe;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import de.kreth.kata.tictactoe.GameState.Player;

class GameStateTest {

	private GameState state;
	
	@BeforeEach
	public void initPGamestate() {
		this.state = new GameState();
		this.state.next = Player.PLAYER1;
	}
	
	@Test
	void testBeginState() {
		assertEquals(Player.PLAYER1.name(), state.getNext());
		for (Player[] r : state.state) {
			for (Player p: r) {
				assertNull(p);
			}
		}
	}

	@Test
	void testFinishedState() {
		assertFalse(state.isFinished());
		boolean index = false;
		for(int y=0; y<3; y++) {
			for (int x=0; x<3; x++) {
				state.state[y][x] = Player.values()[(index) ? 1 : 0];
				index = !index;
			}
		}
		assertTrue(state.isFinished());
	}

	@Test
	void testSetA1() {
		state.set("A1".toCharArray());
		assertEquals(Player.PLAYER1, state.state[1][0]);
	}
	
	@Test
	void testSetB0() {
		state.set("B0".toCharArray());
		assertEquals(Player.PLAYER1, state.state[0][1]);
	}

	@Test
	void testSetA0() {
		state.set("A0".toCharArray());
		assertEquals(Player.PLAYER1, state.state[0][0]);
	}

	@Test
	void testSetC2() {
		state.set("C2".toCharArray());
		assertEquals(Player.PLAYER1, state.state[2][2]);
	}

	@Test
	void testSetB1() {
		state.set("B1".toCharArray());
		assertEquals(Player.PLAYER1, state.state[1][1]);
	}

	@Test
	void testSetB2() {
		state.set("B2".toCharArray());
		assertEquals(Player.PLAYER1, state.state[2][1]);
	}

	@Test
	void testSetA1Twice() {
		char[] chars = "A1".toCharArray();
		state.set(chars);
		state.set(chars);
		assertEquals(Player.PLAYER1, state.state[1][0]);
	}
	
}
