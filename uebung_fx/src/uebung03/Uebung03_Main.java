package uebung03;

import java.awt.Button;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class Uebung03_Main extends Application {

	public static void main(String[] args) {
		launch(args);
	}

	Button btn1;
	Button btn2;
	Button btn3;
	Label lbl;

	int btn_count = 0;

	public void start(Stage primaryStage) {
		// setting buttons and event handling
		/*
		 * btn1 = new Button(); btn2 = new Button(); btn3 = new Button(); lbl = new
		 * Label();
		 * 
		 * btn1.setText("Button 1 "); btn2.setText("Button 2 ");
		 * btn3.setText("Button 3 "); lbl.setText(" " + btn_count);
		 * 
		 * btn1.setOnAction(e -> button1Click()); btn2.setOnAction(e -> button2Click());
		 * btn3.setOnAction(e -> button3Click());
		 */

		// setting pane, placing buttons
		BorderPane pane = new BorderPane();
		// pane.setLeft(btn1);
		// pane.setBottom(btn2);
		// pane.setRight(btn3);
		// pane.setCenter(lbl);

		// setting scene, naming app
		Scene scene = new Scene(pane, 500, 500);
		primaryStage.setScene(scene);
		primaryStage.setTitle("My 3 button game");
		primaryStage.show();
	}

	public void button1Click() {
		btn_count++;
		checkCounter();
	}

	public void button2Click() {
		btn_count /= 2;
		checkCounter();
	}

	public void button3Click() {
		btn_count -= 2;
		checkCounter();
	}

	public void checkCounter() {
		lbl.setText(Integer.toString(btn_count));
		if (btn_count <= 1) {
			// btn3.setDisable(true);
		} else {
			// btn3.setDisable(false);
		}

	}

}
