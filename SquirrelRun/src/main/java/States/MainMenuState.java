package States;

import javafx.scene.Scene;
import javafx.scene.layout.StackPane;

public class MainMenuState extends GameState {

	/********************
	*					*
	*	  VARIABLES		*
	*					*
	*********************/
. .y 




	/********************
	*					*
	*	     INIT		*
	*					*
	*********************/

	public MainMenuState() {
		super();




		/* Add stuff to the game state. */





		root = new StackPane();
		scene = new Scene(root, 720, 720);
	}




	/********************
	*					*
	*	  FUNCTIONS		*
	*					*
	*********************/

	public void initialize() {
		System.out.println("Initialized!");
	}

	public void update() {
		System.out.println("Updating");
	}

	public void draw() {
		System.out.println("Drawing");
	}



}