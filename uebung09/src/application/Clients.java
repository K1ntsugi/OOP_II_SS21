package application;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/*
 * Aufgabe 9.1 SimpleChat
 * Schreiben Sie ein JavaFX Programm, das aus zwei Fenstern besteht. Beide haben ein 
 * Eingabefeld und einen Senden-Button. Wenn ein Text in Fenster A eingegeben wird und auf 
 * Senden geklickt wird, wird dies in Fenster B angezeigt und umgekehrt. Auch die Nachrichten, 
 * die das Fenster selbst verschickt, sollen angezeigt werden. Dabei sollen neue Nachrichten 
 * jeweils „unten“ angefügt werden. Achten Sie darauf dass man in beiden Fenstern 
 * unterscheiden kann, von welcher Partei die Nachricht stammt (Farbe und/oder 
 * Positionierung). 
 * Hinweis: Sie brauchen keine Scrollbalken implementieren. Eine links-rechts Positionierung 
 * erreichen Sie beispielsweise durch die Verwendung von Insets.
 */

public class Clients extends Application {

	TextField txtClient01;
	Button btn01;
	VBox vbox01;

	TextField txtClient02;
	Button btn2;
	VBox vbox02;

	Scene scene01;
	Scene scene02;

	Stage client02;

	@Override
	public void start(Stage client01) throws Exception {

		txtClient01 = new TextField();
		btn01 = new Button("send");
		btn01.setOnMouseClicked(e -> sendMsgToClient02());
		vbox01 = new VBox();
		VBox.setMargin(btn01, new Insets(5, 0, 20, 0));
		vbox01.getChildren().addAll(txtClient01, btn01);
		scene01 = new Scene(vbox01, 220, 400);
		client01.setScene(scene01);
		client01.setTitle("Client1");
		client01.show();

		txtClient02 = new TextField();
		btn2 = new Button("send");
		VBox.setMargin(btn2, new Insets(5, 0, 20, 0));
		btn2.setOnMouseClicked(e -> sendMsgToClient01());
		vbox02 = new VBox();
		vbox02.getChildren().addAll(txtClient02, btn2);
		scene02 = new Scene(vbox02, 220, 400);
		client02 = new Stage();
		client02.setScene(scene02);
		client02.setTitle("Client 2");
		client02.show();

	}

	private void sendMsgToClient02() {

		if (txtClient01.getText().isEmpty()) {
			// return null;
			return;
		}

		Label msg_to_client01 = new Label();
		msg_to_client01.setTextFill(Color.RED);
		msg_to_client01.setStyle("-fx-border-color: red;");
		msg_to_client01.setText(txtClient01.getText());
		VBox.setMargin(msg_to_client01, new Insets(5, 0, 0, 70));
		vbox02.getChildren().add(msg_to_client01);
		Label msg_to_client02 = new Label();
		msg_to_client02.setTextFill(Color.GREEN);
		msg_to_client02.setStyle("-fx-border-color: green;");
		msg_to_client02.setText(txtClient01.getText());
		vbox01.getChildren().add(msg_to_client02);
		txtClient01.clear();

		// return null;
	}

	private void sendMsgToClient01() {

		if (txtClient02.getText().isEmpty()) {
			return;
		}

		Label msg_to_client02 = new Label();
		msg_to_client02.setTextFill(Color.RED);
		msg_to_client02.setStyle("-fx-border-color: red;");
		msg_to_client02.setText(txtClient02.getText());
		VBox.setMargin(msg_to_client02, new Insets(5, 0, 0, 70));
		vbox01.getChildren().add(msg_to_client02);

		Label msg_to_client01 = new Label();
		msg_to_client01.setTextFill(Color.GREEN);
		msg_to_client01.setStyle("-fx-border-color: green;");
		msg_to_client01.setText(txtClient02.getText());
		vbox02.getChildren().add(msg_to_client01);
		txtClient01.clear();
		txtClient02.clear();
	}

	public static void start(String[] args) {
		launch(args);
	}
}
