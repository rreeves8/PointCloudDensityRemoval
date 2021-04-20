package application;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class InterfaceController{

	@FXML
	TextField Path;

	@FXML
	TextField lines;

	@FXML
	TextField FileName;

	@FXML
	Text complete_text;

	@FXML
	Text progress;

	@FXML
	Button startButton;

	@FXML
	public void button_event (ActionEvent event){
		try {
			Algorithim_controller controller = new Algorithim_controller(Path.getText(), FileName.getText(), Integer.parseInt(lines.getText()));
			progress.setText("Reading file");
			controller.run();	
			complete_text.setText("COMPLETED");
			resetWindow();
		} 
		catch (NumberFormatException e) {		
			alertBox("ERROR", "Wrong number value");
		}
		
		catch (IOException e) {
			alertBox("ERROR", "Invalid file");
		}
	}

	public void resetWindow() {
		Path.setText("");
		lines.setText("");
		FileName.setText("");
	}

	public void alertBox(String title, String message) {
		Stage window = new Stage();
		window.initModality(Modality.APPLICATION_MODAL);
		window.setTitle(title);
		window.setMinWidth(150);
		window.setMinHeight(100);

		Label label = new Label();
		label.setText(message);
		label.setTextFill(Color.web("#FF0000"));
		Button closeButton = new Button("Close");
		closeButton.setOnAction(e -> window.close());

		VBox layout = new VBox(10);
		layout.getChildren().addAll(label, closeButton);
		layout.setAlignment(Pos.CENTER);

		Scene scene = new Scene(layout);
		window.setScene(scene);
		window.showAndWait();
	}

}
