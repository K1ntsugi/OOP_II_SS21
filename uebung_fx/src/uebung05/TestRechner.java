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
	Label displayResult;
	// Belongs to TilePane
	Button plus;
	Button minus;
	Button equals;
	// Belongs to hbox
	Button digit;

	int input1 = 0, input2 = 0;
	public static boolean firstSet, secondSet;

	enum Calcmode {
		keiner, plus, minus
	};

	Calcmode mode = Calcmode.keiner;

	@Override
	public void start(Stage primaryStage) throws Exception {

		displayResult = new Label();
		displayResult.setPrefSize(100, 50);
		displayResult.setText("__________________________");
		plus = new Button();
		plus.setPrefSize(50, 50);
		plus.setText(" + ");
		minus = new Button();
		minus.setPrefSize(50, 50);
		minus.setText(" - ");
		equals = new Button();
		equals.setPrefSize(50, 50);
		equals.setText(" = ");

		// Alles klar ich kann alle Buttons anlegen
		Button[] buttonArr = new Button[10];
		for (int i = 0; i < 10; i++) {
			digit = new Button();
			digit.setPrefSize(50, 50);
			digit.setText(Integer.toString(i));
			buttonArr[i] = digit;

		}

		// aber muss die labdas alle einzeln aufrufen
		// wie geht das besser? ich steh auf dem Schlauch
		buttonArr[0].setOnAction(e -> addNum(0));
		buttonArr[1].setOnAction(e -> addNum(1));
		buttonArr[2].setOnAction(e -> addNum(2));
		buttonArr[3].setOnAction(e -> addNum(3));
		buttonArr[4].setOnAction(e -> addNum(4));
		buttonArr[5].setOnAction(e -> addNum(5));
		buttonArr[6].setOnAction(e -> addNum(6));
		buttonArr[7].setOnAction(e -> addNum(7));
		buttonArr[8].setOnAction(e -> addNum(8));
		buttonArr[9].setOnAction(e -> addNum(9));

		plus.setOnAction(e -> setOp(Calcmode.plus));
		minus.setOnAction(e -> setOp(Calcmode.keiner));
		equals.setOnAction(e -> calcResult());

		// ToDo: enventhandling

		// Panes
		// Ergebnis.Box
		VBox vbox = new VBox();
		vbox.getChildren().add(displayResult);
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

	public void addNum(int i) {

		if (firstSet && secondSet) {
			reset();
		}

		if (!firstSet) {
			firstSet = true;
			input1 = i;
			displayResult.setText(String.valueOf(i));
		} else if (!secondSet) {
			secondSet = true;
			input2 = i;
			displayResult.setText(String.valueOf(i));
		}

	}

	private void reset() {
		firstSet = false;
		secondSet = false;
		mode = Calcmode.keiner;
		displayResult.setText("__________________________");

	}

	public void setOp(Calcmode m) {
		mode = m;
		displayResult.setText(String.valueOf(m));
	}

	public void calcResult() {
		int result;

		if (!(firstSet && secondSet) || mode == Calcmode.keiner)
			return;

		if (mode == Calcmode.plus) {
			result = input1 + input2;
		} else {
			result = input1 - input2;
		}
		displayResult.setText(String.valueOf(result));
	}

}
