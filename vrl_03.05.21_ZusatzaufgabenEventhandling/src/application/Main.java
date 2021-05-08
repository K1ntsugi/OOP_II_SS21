package application;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

public class Main extends Application {

	FlowPane iAmGroth;
	TextField txt;
	Button add;

	@Override
	public void start(Stage primaryStage) {
		try {
			txt = new TextField();
			add = new Button();
			add.setOnAction(e -> btnAdd(e));
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
			Scene scene = new Scene(iAmGroth, 800, 800);
			primaryStage.setScene(scene);
			primaryStage.setTitle("Adding images to a flowpane");
			primaryStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		launch(args);
	}

	private void btnAdd(ActionEvent e) {
		try {
			Image pic;
			pic = new Image(new FileInputStream(txt.getText()));
			ImageView container = new ImageView(pic);
			container.setImage(pic);
			iAmGroth.getChildren().add(container);
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}

	}
}
