package uebung05;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.TilePane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class TestRechner extends Application {

	public static void main(String[] args) {
		launch(args);
	}

	// Belongs to vbox
	Label result;
	// Belongs to TilePane
	Button plus;
	Button minus;
	Button equals;
	// Belongs to hbox
	Button digit;

	@Override
	public void start(Stage primaryStage) throws Exception {

		result = new Label();
		result.setPrefSize(100, 50);
		plus = new Button();
		plus.setPrefSize(50, 50);
		plus.setText(" + ");
		minus = new Button();
		minus.setPrefSize(50, 50);
		minus.setText(" - ");
		equals = new Button();
		equals.setPrefSize(50, 50);
		equals.setText(" = ");
		Button[] buttonArr = new Button[10];
		for (int i = 0; i < 10; i++) {
			digit = new Button();
			digit.setPrefSize(50, 50);
			digit.setText(Integer.toString(i));
			buttonArr[i] = digit;
		}
		// ToDo: enventhandling

		// Panes
		// Ergebnis.Box
		VBox vbox = new VBox();
		vbox.getChildren().add(result);
		// Operator.Box
		VBox buttonBox = new VBox();
		buttonBox.getChildren().addAll(plus, minus, equals);
		// Ziffern.Box
		TilePane tilePane = new TilePane();
		tilePane.setPrefColumns(3);
		tilePane.getChildren().addAll(buttonArr);

		// Root-pane
		BorderPane bp = new BorderPane();
		bp.setTop(vbox);
		bp.setRight(buttonBox);
		bp.setLeft(tilePane);

		// Scene
		Scene scene1 = new Scene(bp);
		primaryStage.setScene(scene1);
		primaryStage.setTitle("Taschenrechner");
		primaryStage.show();

	}

}
