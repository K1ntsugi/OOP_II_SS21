package application;
	
import java.io.FileInputStream;
import java.io.FileNotFoundException;


import javafx.application.Application;
import javafx.event.EventHandler;

import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class uebung07_grothEdition extends Application {

    public static void main(String[] args) {
        launch();
    }

    
    String secretPW = "pass";
    int noOfTries = 0;
    
    
    @Override
    public void start(Stage stage) throws FileNotFoundException {
        Pane pane = new Pane();

        
       
        Label user = new Label("User");
        TextField username = new TextField();
        
        user.relocate(0, 0);
        username.relocate(50, 0);
		
        pane.getChildren().addAll(user, username);
        
        
        
        
    
		Image padlock = new Image(new FileInputStream("/Users/christiangroth/eclipse-workspace/Uebungen/bin/uebung7/padlock.jpg"));
       //Image padlock = new Image("file:/Users/christiangroth/eclipse-workspace/Uebungen/bin/uebung7/padlock.jpg");
        ImageView padlock_imv = new ImageView(padlock);
        
        
        padlock_imv.setFitHeight(50); 
        padlock_imv.setFitWidth(50);
		padlock_imv.relocate(250, 0);
        
		pane.getChildren().add(padlock_imv);
        
        
        PasswordField pw = new PasswordField();
        pw.relocate(50, 50);
        pw.setVisible(false);
        pane.getChildren().add(pw);
     
        Label result = new Label();
        result.relocate(250, 50);

        result.setStyle("-fx-font-weight: bold; -fx-font-size: 40;");
        result.setVisible(false);
        pane.getChildren().add(result);
        
        username.addEventHandler(KeyEvent.KEY_PRESSED, new EventHandler<KeyEvent>() {
			public void handle(KeyEvent event) {
				
				if(event.getCode() == KeyCode.ENTER) {
					//username.setEditable(false);
					username.setVisible(false);
					
					Label l = new Label(username.getText());
					l.relocate(50, 0);
					pane.getChildren().add(l);
					
					//hbox.getChildren().add(l);
					pw.setVisible(true);
				}
			}
			
		});
        
        pw.addEventHandler(KeyEvent.KEY_PRESSED, new EventHandler<KeyEvent>() {
			public void handle(KeyEvent event) {
				//System.out.println("key " + event.getCode());
				
				if(event.getCode()==KeyCode.ENTER) {
					if(pw.getText().equals(secretPW))
					{
						result.setVisible(true);
						result.setText("OK");
						result.setTextFill(Color.GREEN);
						pw.setEditable(false);
					}
					else
					{
						//roter haken
						result.setTextFill(Color.RED);
						result.setVisible(true);
						result.setText("NO");
						pw.clear();
						noOfTries++;
					}
					
					if(noOfTries==3) {
						System.out.println("zu viele Versuche");
						pw.setEditable(false);
						result.setTextFill(Color.RED);
						result.setVisible(true);
						result.setText("LOCKED");
					}
				}
			}
			
		});
        
        
        
        
        Scene scene = new Scene(pane, 400, 400);
    	scene.getStylesheets().add(getClass().getResource("../application.css").toExternalForm());
        stage.setTitle("My Login");
        stage.setScene(scene);
        stage.show();
    }
}