package de.kreth.kata.tictactoe.ui.swing;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
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
				URL xImage = getClass().getResource("../x.png");
				URL oImage = getClass().getResource("../o.png");
				
				@Override
				public Component getTableCellRendererComponent(JTable table, Object value
						, boolean isSelected, boolean hasFocus
						, int row, int column) {
					ImageIcon image;
					if(value == null) {
						image = new ImageIcon();
					} else {
						Player p = (Player) value;
						if(p==Player.PLAYER1) {
							image = new ImageIcon(xImage);
						} else {
							image = new ImageIcon(oImage);
						}
					}
					String action = "A1";
					JButton btn = new JButton(image);
					btn.setSize(25, 25);
					btn.setPreferredSize(new Dimension(25, 25));
					btn.setActionCommand(action);
					btn.addActionListener(new ActionListener() {
						
						@Override
						public void actionPerformed(ActionEvent e) {
							handler.input = e.getActionCommand();
						}
					});
					if(isSelected) {
						btn.setBackground(Color.BLUE);
					}
					
					return btn;
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
		getContentPane().add(table, BorderLayout.CENTER);
		
		lblStatus = new JLabel("");
		lblStatus.setMinimumSize(new Dimension(15, 15));
		getContentPane().add(lblStatus, BorderLayout.SOUTH);
		pack();
	}

	@Override
	public void paint(GameState state) {
		if(model == null) {
			model = new StateTableModel(state);
			table.setModel(model);
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

	private class InputHandler {
		private String input;
	}
	
	public static void main(String[] args) {
		MainFrame f = new MainFrame();
		f.setVisible(true);
		f.paint(new GameState());
	}
}
