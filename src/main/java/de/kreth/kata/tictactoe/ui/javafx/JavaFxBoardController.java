package de.kreth.kata.tictactoe.ui.javafx;

import de.kreth.kata.tictactoe.GameState.Player;
import javafx.beans.InvalidationListener;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.util.Callback;

public class JavaFxBoardController {

	private final ObservableList<Player> data = FXCollections.observableArrayList();

	@FXML
	private TableView<Player[]> table;

	@FXML
	private TextField status;

	@FXML
	private TableColumn<Player[], Player> columnA;

	@FXML
	private TableColumn<Player[], Player> columnB;

	@FXML
	private TableColumn<Player[], Player> columnC;

    @FXML
    protected void initialize() {
		columnA.setCellFactory(column -> {
			return new PlayerTableCell();
		});
		columnA.setCellValueFactory(new Callback<CellDataFeatures<Player[], Player>, 
				  ObservableValue<Player>>() {
		     public ObservableValue<Player> call(CellDataFeatures<Player[], Player> p) {
		         return null;
		     }
		  });
		columnB.setCellFactory(column -> {
			return new PlayerTableCell();
		});
		columnC.setCellFactory(column -> {
			return new PlayerTableCell();
		});

    }
    
    class PlayerTableCell extends TableCell<Player[], Player> {

		@Override
        protected void updateItem(Player item, boolean empty) {
			super.updateItem(item, empty);

            if (item == null || empty) {
                setText(null);
                setStyle("");
            } else {
                // Format date.
                setText(String.valueOf(item.getSign()));
            }
		}
    }
    private class PlayerRow {
    	private Player[] row;
    	public PlayerRow(Player[] row) {
    		this.row = row;
		}
    	
    	public ObservableValue<Player> colA(){
    		return null;
    	}
    	
    }
}
