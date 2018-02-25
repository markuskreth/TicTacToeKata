package de.kreth.kata.tictactoe.ui;

import de.kreth.kata.tictactoe.GameState;
import de.kreth.kata.tictactoe.GameState.Player;

public interface Board {

	void paint(GameState state);

	void appendState(String string);

	void nextPlayer(String next);
	
	void gameEnd(Player winner);
	
}