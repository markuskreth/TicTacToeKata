package de.kreth.kata.tictactoe;

import java.util.Arrays;

public class GameState {

	Player next;
	boolean finished = false;
	Player[][] state = new Player[3][3];
	Player winner = null;

	public GameState() {
		this(Player.values()[(int) Math.round(Math.random())]);
	}

	public GameState(Player player) {
		next = player;
	}

	public String getNext() {
		return next.name();
	}

	public Player[][] currentState() {
		return state;
	}
	
	public boolean isFinished() {
		if (!finished) {
			finished = true;
			for (Player[] r : state) {
				for (Player p : r) {
					if (p == null) {
						finished = false;
						break;
					}
				}
			}
		}
		return finished;
	}

	public enum Player {
		PLAYER1('X'), 
		PLAYER2('O');
		char sign;
		public char getSign() {
			return sign;
		}
		private Player(char sign) {
			this.sign = sign;
		}
		@Override
		public String toString() {
			return String.valueOf(sign);
		}
	}

	public void set(char[] charArray) {
		if (charArray.length != 2) {
			throw new IllegalArgumentException("Two chars nedded for one move.");
		}
		Player[] row;
		switch (charArray[1]) {
		case '0':
			row = state[0];
			break;
		case '1':
			row = state[1];
			break;
		case '2':
			row = state[2];
			break;
		default:
			throw new IllegalArgumentException("First Argument must be letter of 0, 1 or 2, was: " + Arrays.toString(charArray));
		}
		int index;
		switch (charArray[0]) {
		case 'A':
			index = 0;
			break;
		case 'B':
			index = 1;
			break;
		case 'C':
			index = 2;
			break;
		default:
			throw new IllegalArgumentException("Second Argument must be letter of A, B or C, was: " + Arrays.toString(charArray));
		}
		if(row[index] == null) {

			row[index] = next;
			checkWinner();
			if(winner == null) {
				next = next == Player.PLAYER1 ? Player.PLAYER2 : Player.PLAYER1;
			}
		}
	}

	private void checkWinner() {
		for (int i=0; i<3; i++) {
			if(next.equals(state[i][0])&&next.equals(state[i][1])&&next.equals(state[i][2])) {
				winner = next;
				finished = true;
				return;
			}
			if(next.equals(state[0][i])&&next.equals(state[1][i])&&next.equals(state[2][i])) {
				winner = next;
				finished = true;
				return;
			}
		}

		if(next.equals(state[0][0])&&next.equals(state[1][1])&&next.equals(state[2][2])) {
			winner = next;
			finished = true;
			return;
		}
		
		if(next.equals(state[0][2])&&next.equals(state[1][1])&&next.equals(state[2][0])) {
			winner = next;
			finished = true;
			return;
		}
	}
}
