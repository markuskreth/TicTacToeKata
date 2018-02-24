package de.kreth.kata.tictactoe.ui.javafx;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class JavaFxBoard extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		Pane root = (Pane) FXMLLoader.load(getClass().getResource("JavaFxBoard.fxml"));
		Scene scene = new Scene(root);
		primaryStage.setScene(scene);
		primaryStage.show();
	}
    
	public static void main(String[] args) {
        launch(args);
    }
    
}
