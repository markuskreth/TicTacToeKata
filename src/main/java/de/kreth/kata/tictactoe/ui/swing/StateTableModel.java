package de.kreth.kata.tictactoe.ui.swing;

import javax.swing.table.DefaultTableModel;

import de.kreth.kata.tictactoe.GameState;

public class StateTableModel extends DefaultTableModel {

	private static final long serialVersionUID = -7121246932088563106L;
	private GameState state;

	public StateTableModel(GameState state) {
		this.state = state;
	}
	
	@Override
	public String getColumnName(int column) {
		switch (column) {
		case 0:
			return "";

		case 1:
			return "A";

		case 2:
			return "B";

		case 3:
			return "C";

		default:
			return "###";
		}
	}
	
	@Override
	public int getColumnCount() {
		return state.currentState()[0].length + 1;
	}
	
	@Override
	public int getRowCount() {
		if(state == null) {
			return 0;
		}
		return state.currentState().length;
	}
	
	@Override
	public Object getValueAt(int row, int column) {
		if(column == 0) {
			return row;
		}
		if(state == null) {
			return null;
		}
		return state.currentState()[row][column-1];
	}
	
	@Override
	public boolean isCellEditable(int row, int column) {
		return true;
	}
}
