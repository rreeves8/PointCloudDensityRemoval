package application;
	
import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;


public class Main extends Application {
	
	@Override
	public void start(Stage primaryStage) throws IOException {	
		 Parent root = FXMLLoader.load(getClass().getResource("Interface.fxml"));
	     Scene scene = new Scene(root);
	     primaryStage.setScene(scene);
	     primaryStage.setTitle("Version 3: By Magnus Reeves");
	     primaryStage.show();
	}
	
	public Main(String[] args) {
		launch(args);
	}
}
