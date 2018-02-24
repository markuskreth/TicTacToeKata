package de.kreth.kata.tictactoe.ui.console;

import java.util.Scanner;

import de.kreth.kata.tictactoe.ui.InputReader;

public class ConsoleInputReader implements InputReader {

	Scanner in = new Scanner(System.in);
	
	@Override
	public String nextInput() {
		return in.nextLine();
	}

}
