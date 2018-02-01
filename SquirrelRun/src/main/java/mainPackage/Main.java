package mainPackage;

import Controllers.*;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;


public class Main extends Application {
	
	public static void main(String[] args) {
		Application.launch(args);
	}



	@Override 
    public void start(Stage stage) {
        // The game controller.
        GameController gc = new GameController(stage);
        gc.initialize();


        // Setup the scene.
        StackPane root = new StackPane();
        Scene scene = new Scene(root, 640, 480);

        stage.setOnCloseRequest(e -> { System.exit(0); });
        stage.setScene(scene);
        stage.setTitle("Squirrel Run");
        stage.show(); 
    }


} // End of Main class.