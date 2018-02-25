package de.kreth.kata.tictactoe.ui.swing;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableCellRenderer;

import de.kreth.kata.tictactoe.GameState.Player;
import de.kreth.kata.tictactoe.ui.swing.MainFrame.InputHandler;

public class TicTacToeTable  extends JTable {

	private static final long serialVersionUID = 5258702256484686280L;

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

	private InputHandler localTicTacToeHandler;
	
	public TicTacToeTable(InputHandler handler) {
		this.localTicTacToeHandler = handler;
		setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		setPreferredSize(new Dimension(250, 250));
		setRowHeight(75);
		addMouseListener(new MouseAdapter() {
			
			@Override
			public void mouseClicked(MouseEvent e) {
				Point point = e.getPoint();
				int row=rowAtPoint(point);
				int col= columnAtPoint(point);
				String value = TableCoordToGameCoord.fromTable(row, col);
				System.out.println("row=" + row + "; col=" + col + "; value: " + value);
				localTicTacToeHandler.input = value;
			}
		});
	}
	
	@Override
	public TableCellRenderer getCellRenderer(int row, int column) {
		return renderer;
	}
}