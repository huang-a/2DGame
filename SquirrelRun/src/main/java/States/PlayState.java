package States;

import Controllers.*;
import mainPackage.*;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import World.*;
import States.*;
import Utilities.*;

public class PlayState extends GameState {

	/********************
	*					*
	*	  VARIABLES		*
	*					*
	*********************/

	/** The main game world. */
	World world;





	/********************
	*					*
	*	 CONSTRUCTOR	*
	*					*
	*********************/

	public PlayState(GameController gc) {
		super(gc);
		world = new World(this);




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
		world.initialize();
	}

	public void update() {
		world.update();
	}

	public void draw() {
		clear();

		// These two lines are not necessary. They are just to show that the world
		// is drawn on top of the play state.
		graphics.setFill(Color.PURPLE);
		graphics.fillRect(0, 0, Main.WIDTH, Main.HEIGHT);

		world.draw();
	}



}