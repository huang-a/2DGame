package Controllers;

import States.*;
import javafx.animation.AnimationTimer;
import javafx.scene.input.KeyCode;
import javafx.stage.Stage;
import javafx.scene.Scene;

/** The GameController is the over-arching structure in the entire game. It handles
changing game states, displaying the game window, checking input, the game loop, etc. */
public class GameController {

	/********************
	*					*
	*	  VARIABLES		*
	*					*
	*********************/

	/** All of the game states. */
	GameState[] states;

	/** The index in the array of the current game state. */
	int currentState;

	/** The window that the game is being displayed in. */
	Stage window;







	/********************
	*					*
	*	     INIT		*
	*					*
	*********************/

	/** Constructor for the GameController. */
	public GameController(Stage stage) {
		this.window = stage;

		states = new GameState[3];
		states[0] = new MainMenuState(this);
		states[1] = new PlayState(this);
		states[2] = new CreditsState(this);

		currentState = 0;

		startGameLoop();
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


	public Scene getScene() {
		return states[currentState].getScene();
	}



	/** Switches to the game state at the specified index. */
	public void switchState(int to) {
		currentState = to;

		states[currentState].initialize();

		window.setScene(states[currentState].getScene());
	}






	/********************
	*					*
	*	   ABSTRACT		*
	*					*
	*********************/

	/** The game has to be initialized. Anything you want to do before the game starts
	goes here. */
	public void initialize() {
		states[currentState].initialize();
	}

	/** The game updates very quickly. Anytime you want to check something like input,
	for example, put it in here. */
	public void update() {
		states[currentState].update();
	}

	/** This method handles actually drawing things onto the screen. */
	public void draw() {
		states[currentState].draw();
	}








}