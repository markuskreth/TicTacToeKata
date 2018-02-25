package de.kreth.kata.tictactoe.ui.swing;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import de.kreth.kata.tictactoe.GameState;
import de.kreth.kata.tictactoe.GameState.Player;
import de.kreth.kata.tictactoe.ui.Board;
import de.kreth.kata.tictactoe.ui.InputReader;

public class MainFrame extends JFrame implements Board, InputReader {

	private static final long serialVersionUID = -5468293531782414478L;
	private final InputHandler handler = new InputHandler();
	private JTable table;
	private JLabel lblStatus;
	private StateTableModel model;

	public MainFrame() {
		setTitle("Tic Tac Toe");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container contentPane = getContentPane();
		contentPane.setLayout(new BorderLayout(10, 10));
		table = new TicTacToeTable(handler);
		
		contentPane.add(new JScrollPane(table), BorderLayout.CENTER);
		
		lblStatus = new JLabel("");
		lblStatus.setMinimumSize(new Dimension(15, 15));

		contentPane.add(lblStatus, BorderLayout.SOUTH);
		pack();
	}

	@Override
	public void paint(GameState state) {
		if(model == null) {
			model = new StateTableModel(state);
			table.setModel(model);
			setVisible(true);
		}
		model.fireTableDataChanged();
	}

	@Override
	public void appendState(String string) {
		lblStatus.setText(string);
	}

	@Override
	public void nextPlayer(String next) {
		lblStatus.setText("An der Reihe: " + next);
	}

	@Override
	public String nextInput() {
		while (handler.input ==  null) {
			try {
				Thread.sleep(25);
			} catch (InterruptedException e) {
				throw new RuntimeException(e);
			}
		}
		String input = handler.input;
		handler.input = null;
		return input;
	}

	class InputHandler {
		String input;
	}
	
	@Override
	public void gameEnd(Player winner) {
		StringBuilder text = new StringBuilder();
		if(winner == null) {
			text.append("Game ended even!");
		} else {
			text.append("Winner was: ").append(winner.name());
		}
		JOptionPane.showMessageDialog(this, text, "Game end", JOptionPane.INFORMATION_MESSAGE);
	}

	public static void main(String[] args) {
		MainFrame f = new MainFrame();
		f.paint(new GameState());
	}

}
