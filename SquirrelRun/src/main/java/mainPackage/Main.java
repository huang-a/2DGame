package mainPackage;

import Controllers.*;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;


public class Main extends Application {

	public static int WIDTH = 640, HEIGHT = 480;


	
	public static void main(String[] args) {
		Application.launch(args);
	}



	@Override 
    public void start(Stage stage) {
        // The game controller.
        GameController gc = new GameController(stage);
        gc.initialize();


        stage.setOnCloseRequest(e -> { System.exit(0); });
        stage.setScene(gc.getScene());
        stage.setTitle("Squirrel Run");
        stage.show(); 
    }


} // End of Main class.