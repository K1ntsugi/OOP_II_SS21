package application;

import java.io.FileInputStream;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Main extends Application {

	VBox vbox;
	HBox hboxLoginScreen;
	static HBox hboxPwScreen;
	TextField txtUser;
	PasswordField txtPw;
	Label lblUser;
	Image lock, correct, incorrect;
	ImageView lockViewer;
	static ImageView correctViewer;
	static ImageView incorrectViewer;
	static int loginCount = 0;
	final static String pin = "test123";

	@Override
	public void start(Stage primaryStage) {
		try {

			String lockURL = "C:\\Dev\\JavaProjects\\OOP_II_SS21\\uebung07\\src\\application\\icons\\lock_icon.png";
			// String lockURL = "C:\\lock_icon.png";
			lock = new Image(new FileInputStream(lockURL));
			lockViewer = new ImageView(lock);

			String correctURL = "C:\\Dev\\JavaProjects\\OOP_II_SS21\\uebung07\\src\\application\\icons\\correct.png";
			// String correctURL = "C:\\correct.png";
			correct = new Image(new FileInputStream(correctURL));
			correctViewer = new ImageView(correct);

			String incorrectURL = "C:\\Dev\\JavaProjects\\OOP_II_SS21\\uebung07\\src\\application\\icons\\false.png";
			// String incorrectURL = "C:\\false.jpg";
			incorrect = new Image(new FileInputStream(incorrectURL));
			incorrectViewer = new ImageView(incorrect);

		} catch (Exception e) {
			e.printStackTrace();
			return;
		}

		// Inner Layer
		hboxLoginScreen = new HBox();
		lblUser = new Label("User");
		txtUser = new TextField();
		HBox.setMargin(txtUser, new Insets(15, 15, 15, 15));
		HBox.setMargin(lblUser, new Insets(15, 15, 15, 15));
		HBox.setMargin(lockViewer, new Insets(15, 15, 15, 15));
		hboxLoginScreen.getChildren().addAll(lblUser, txtUser, lockViewer);
		hboxPwScreen = new HBox();
		txtPw = new PasswordField();
		HBox.setMargin(txtPw, new Insets(15, 15, 15, 70));
		HBox.setMargin(correctViewer, new Insets(15, 15, 15, 15));
		HBox.setMargin(incorrectViewer, new Insets(15, 15, 15, 15));
		hboxLoginScreen.setOnKeyPressed(new EventHandler<KeyEvent>() {

			@Override
			public void handle(KeyEvent event) {
				if (event.getCode() == KeyCode.ENTER) {
					txtUser.setDisable(true);
					hboxPwScreen.getChildren().add(txtPw);
				}
			}

		});

		hboxPwScreen.setOnKeyPressed(new EventHandler<KeyEvent>() {

			@Override
			public void handle(KeyEvent event) {
				if (event.getCode() == KeyCode.ENTER) {
					passwordCheck(txtPw);
				}

			}

		});

		// Outer Layer
		vbox = new VBox();
		vbox.setBackground(
				new Background(new BackgroundFill(Color.rgb(250, 250, 250), CornerRadii.EMPTY, Insets.EMPTY)));
		vbox.getChildren().addAll(hboxLoginScreen, hboxPwScreen);

		Scene scene = new Scene(vbox, 500, 200);
		primaryStage.setScene(scene);
		primaryStage.setTitle("Login");
		primaryStage.show();

	}

	public static void main(String[] args) {
		launch(args);
	}

	public static void passwordCheck(TextField pw) {

		String check = pw.getText();
		if (check.equals(pin) && loginCount < 3) {
			hboxPwScreen.getChildren().add(correctViewer);
			pw.setDisable(true);
		} else {
			loginCount++;
		}

		if (loginCount >= 3) {
			hboxPwScreen.getChildren().add(incorrectViewer);
			pw.setDisable(true);
		}

	}

}
