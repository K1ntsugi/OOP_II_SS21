package application;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class Main extends Application {

	Pane pane;
	Scene scene;

	EventHandler<MouseEvent> handler = new EventHandler<MouseEvent>() {
		@Override
		public void handle(MouseEvent event) {
			if (event.getButton() == MouseButton.PRIMARY) {
				leftClick(event);
			} else if (event.getButton() == MouseButton.SECONDARY) {
				rightClick(event);
			}
		}
	};

	protected void leftClick(MouseEvent event) {
		Circle dot = new Circle();
		dot.setRadius(10);
		dot.setCenterX(event.getSceneX());
		dot.setCenterY(event.getSceneY());
		dot.setFill(Color.color(Math.random(), Math.random(), Math.random()));
		pane.getChildren().add(dot);
	}

	protected void rightClick(MouseEvent event) {
		pane.getChildren().remove(event.getTarget());
	}

	@Override
	public void start(Stage primaryStage) {
		try {
			pane = new Pane();
			scene = new Scene(pane);
			pane.setOnMouseClicked(handler);
			primaryStage.setTitle("My Painter");
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		launch(args);
	}
}