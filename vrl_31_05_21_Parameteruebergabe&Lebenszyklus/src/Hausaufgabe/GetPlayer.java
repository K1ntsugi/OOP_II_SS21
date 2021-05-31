package Hausaufgabe;

import java.util.List;
import java.util.Map;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class GetPlayer extends Application {

	public static void main(String[] args) {
		Application.launch(args);
	}

	@Override
	public void start(Stage primaryStage) {
		Parameters p = this.getParameters();
		Map<String, String> namedParams = p.getNamed();
		List<String> unnamedParams = p.getUnnamed();
		List<String> rawParams = p.getRaw();

		String paramStr = "Named Parameters: " + namedParams + "\n" + "Unnamed Parameters: " + unnamedParams + "\n"
				+ "Raw Parameters: " + rawParams;

		TextArea txtArea = new TextArea(paramStr);
		VBox vbox = new VBox(txtArea);

		namedParams.entrySet().forEach(Übergabeparameter -> {
			Button playerButtons = new Button(Übergabeparameter.getKey() + " " + Übergabeparameter.getValue());
			vbox.getChildren().add(playerButtons);

			playerButtons.setOnAction(e -> {
				Alert popup = new Alert(AlertType.INFORMATION);
				popup.setContentText(Übergabeparameter.getKey() + " " + Übergabeparameter.getValue());
				popup.showAndWait();
			});

		});

		primaryStage.setScene(new Scene(vbox));
		primaryStage.setTitle("PlayerCount spawns Buttons App");
		primaryStage.show();
	}

}
