package Controllers;

import javafx.animation.AnimationTimer;
import javafx.scene.input.KeyCode;
import javafx.stage.Stage;

/** The GameController is the over-arching structure in the entire game. It handles
changing game states, displaying the game window, checking input, the game loop, etc. */
public class GameController {

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

	/** Constructor for the GameController. */
	public GameController(Stage stage) {

	}





	/********************
	*					*
	*	  FUNCTIONS		*
	*					*
	*********************/

	/** Starts the game loop. */
	void startGameLoop() {
		// Start the game loop.
		new AnimationTimer() {
			public void handle(long now) {
				update();
	            draw();
			}
		}.start();
	}



	/********************
	*					*
	*	   ABSTRACT		*
	*					*
	*********************/

	/** The game has to be initialized. Anything you want to do before the game starts
	goes here. */
	public void initialize() {
		
	}

	/** The game updates very quickly. Anytime you want to check something like input,
	for example, put it in here. */
	public void update() {
		
	}

	/** This method handles actually drawing things onto the screen. */
	public void draw() {
		
	}








}