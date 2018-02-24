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
			return "A";

		case 1:
			return "B";

		case 2:
			return "C";

		default:
			return "###";
		}
	}
	@Override
	public int getColumnCount() {
		return state.currentState()[0].length;
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
		if(state == null) {
			return 0;
		}
		return state.currentState()[row][column];
	}
	
	@Override
	public boolean isCellEditable(int row, int column) {
		return true;
	}
}
