package States;

import Controllers.*;
import mainPackage.*;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class CreditsState extends GameState {

	/********************
	*					*
	*	  VARIABLES		*
	*					*
	*********************/





	/********************
	*					*
	*	     INIT		*
	*					*
	*********************/

	public CreditsState(GameController gc) {
		super(gc);




		/* Add stuff to the game state. */





		root.getChildren().addAll(canvas);
		scene = new Scene(root, Main.WIDTH, Main.HEIGHT);
	}




	/********************
	*					*
	*	  FUNCTIONS		*
	*					*
	*********************/

	public void initialize() {
		// System.out.println("Initialized!");
	}

	public void update() {
		// System.out.println("Updating");
	}

	public void draw() {
		clear();

		graphics.setFill(Color.BLUE);
		graphics.fillRect(0, 0, Main.WIDTH, Main.HEIGHT);
	}



}