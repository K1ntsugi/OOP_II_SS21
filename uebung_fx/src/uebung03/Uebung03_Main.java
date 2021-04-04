package uebung03;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class Uebung03_Main extends Application {

	public static void main(String[] args) {
		launch(args);
	}

	Button btn1;
	Button btn2;
	Button btn3;

	int btn_count = 0;

	public void start(Stage primaryStage) {
		// setting buttons and event handling
		btn1 = new Button();
		btn2 = new Button();
		btn3 = new Button();

		btn1.setText("Button 1 " + "[ " + btn_count + " ]");
		btn2.setText("Button 2 " + "[ " + btn_count + " ]");
		btn3.setText("Button 3 " + "[ " + btn_count + " ]");

		btn1.setOnAction(e -> button1Click());
		btn2.setOnAction(e -> button2Click());
		btn3.setOnAction(e -> button3Click());

		// setting pane, placing buttons
		BorderPane pane = new BorderPane();
		pane.setLeft(btn1);
		pane.setCenter(btn2);
		pane.setRight(btn3);

		// setting scene, naming the app
		Scene scene = new Scene(pane, 500, 500);
		primaryStage.setScene(scene);
		primaryStage.setTitle("My 3 button game");
		primaryStage.show();
	}

	public void button1Click() {

		if (!btn1.isPressed()) {
			++btn_count;
		}

		btn1.setText("Button 1 " + "[ " + btn_count + " ]");
	}

	public void button2Click() {
		btn2.setText("Button 2 " + "[ " + btn_count + " ]");
		if (!btn2.isPressed()) {
			btn_count /= 2;
		}
	}

	public void button3Click() {
		btn3.setText("Button 3 " + "[ " + btn_count + " ]");
		if (btn_count > 2) {
			if (!btn3.isPressed()) {
				btn_count -= 2;
			}
		} else {
			btn3.setDisable(true);
		}

	}

}
