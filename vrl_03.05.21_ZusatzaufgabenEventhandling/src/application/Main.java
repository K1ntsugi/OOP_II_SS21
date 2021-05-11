package application;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

public class Main extends Application {

	Scene scene;
	static FlowPane iAmGroth;
	static TextField txt;
	Button add;

	@Override
	public void start(Stage primaryStage) {
		try {
			txt = new TextField();
			txt.setOnKeyPressed(e -> addPerEnter(e));
			add = new Button();
			add.setOnAction(e -> btnAdd());
			add.setPrefSize(80, 10);
			add.setText("add pic");
			iAmGroth = new FlowPane();
			iAmGroth.getChildren().addAll(txt, add);
			iAmGroth.setOnMouseClicked(new EventHandler<MouseEvent>() {

				@Override
				public void handle(MouseEvent event) {
					if (event.getButton() == MouseButton.PRIMARY) {
						iAmGroth.getChildren().remove(event.getTarget());

					}

				}

			});

			scene = new Scene(iAmGroth, 800, 800);
			primaryStage.setScene(scene);
			primaryStage.setTitle("Adding images to a flowpane");
			primaryStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void addPerEnter(KeyEvent e) {
		if (e.getCode().equals(KeyCode.ENTER)) {
			btnAdd();
		}
	}

	public static void main(String[] args) {
		launch(args);
	}

	private static void btnAdd() {
		try {
			Image pic;
			pic = new Image(new FileInputStream(txt.getText()));
			ImageView container = new ImageView(pic);
			container.setPreserveRatio(true);
			container.setFitHeight(200);
			container.setFitWidth(200);
			container.setImage(pic);
			iAmGroth.getChildren().add(container);

			container.addEventHandler(MouseEvent.MOUSE_ENTERED, new EventHandler<MouseEvent>() {

				@Override
				public void handle(MouseEvent event) {
					container.setOpacity(0.5);
				}
			});

			container.addEventHandler(MouseEvent.MOUSE_EXITED, new EventHandler<MouseEvent>() {

				@Override
				public void handle(MouseEvent event) {
					container.setOpacity(100);

				}
			});

			txt.clear();
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}

	}

}
