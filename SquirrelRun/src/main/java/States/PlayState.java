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
		Rock r = (Rock)world.gameObjects.get(0);

		scene.setOnKeyPressed(e -> {
			KeyCode keyCode = e.getCode();

			switch(keyCode) {
				case LEFT:
					r.setPosition(r.position.X - 1, r.position.Y);
					break;
				case RIGHT:
					r.setPosition(r.position.X + 1, r.position.Y);
					break;
				case DOWN:
					r.setPosition(r.position.X, r.position.Y + 1);
					break;
				case UP:
					r.setPosition(r.position.X, r.position.Y - 1);
					break;
			}
		});
		scene.setOnKeyReleased(e -> {
			
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

		world.draw();
	}



}