package de.kreth.kata.tictactoe.ui;

import de.kreth.kata.tictactoe.GameState;

public interface Board {

	void paint(GameState state);

	void appendState(String string);

	void nextPlayer(String next);

}