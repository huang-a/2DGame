package States;

import Controllers.*;
import mainPackage.*;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.input.*;
import World.*;
import States.*;
import Utilities.*;
import GameObjects.*;

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

		handleInput();
	}




	/********************
	*					*
	*	  FUNCTIONS		*
	*					*
	*********************/

	/** Handles all the input in the game. */
	public void handleInput() {
		Player p = (Player)world.gameObjects.get(0);

		scene.setOnKeyPressed(e -> {
			KeyCode keyCode = e.getCode();

			switch (keyCode) {
				case UP:
					if (!p.jump) { // if jump has not been pressed yet
						p.jump = true;
						p.jump(); // player jumps
					}
					break;
				case DOWN:
					if (!p.fall && p.jump) {
						p.fall = true;
						p.fall();
					}
			}
		});
	}


	public void initialize() {
		world.initialize();
	}

	public void update() {
		world.update();
	}

	public void draw() {
		clear();
		graphics.setFill(Color.RED);
		graphics.fillRect(0, 0, Main.WIDTH, Main.HEIGHT);

		world.draw();
	}



}
