package de.kreth.kata.tictactoe.ui.swing;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableCellRenderer;

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
		getContentPane().setLayout(new BorderLayout(10, 10));
		table = new JTable() {

			private static final long serialVersionUID = -1189303878222667257L;
			
			DefaultTableCellRenderer renderer = new DefaultTableCellRenderer() {

				private static final long serialVersionUID = -3437518017534130933L;
				
				@Override
				public Component getTableCellRendererComponent(JTable table, Object value
						, boolean isSelected, boolean hasFocus
						, int row, int column) {
					Player p = (Player) value;
					return TicTacToeComponent.createClickComponent(p);
				}
			};
			
			@Override
			public TableCellRenderer getCellRenderer(int row, int column) {
				return renderer;
			}
		};
		
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.setPreferredSize(new Dimension(200, 200));
		table.setRowHeight(75);
		table.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mouseClicked(MouseEvent e) {
				int row=table.rowAtPoint(e.getPoint());
				int col= table.columnAtPoint(e.getPoint());
				String value = TableCoordToGameCoord.fromTable(row, col);
				System.out.println("row=" + row + "; col=" + col + "; value: " + value);
				handler.input = value;
			}
		});
		getContentPane().add(table, BorderLayout.CENTER);
		
		lblStatus = new JLabel("");
		lblStatus.setMinimumSize(new Dimension(15, 15));
		lblStatus.setText("STATUS");
		getContentPane().add(lblStatus, BorderLayout.SOUTH);
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
	
	public static void main(String[] args) {
		MainFrame f = new MainFrame();
		f.paint(new GameState());
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
}
