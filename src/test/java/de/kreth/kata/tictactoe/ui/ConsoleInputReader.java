package de.kreth.kata.tictactoe.ui;

import java.util.Scanner;

public class ConsoleInputReader implements InputReader {

	Scanner in = new Scanner(System.in);
	
	@Override
	public String nextInput() {
		return in.nextLine();
	}

}
