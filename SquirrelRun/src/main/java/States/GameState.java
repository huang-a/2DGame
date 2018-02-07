package States;

import javafx.scene.Scene;
import javafx.scene.layout.StackPane;


/** A GameState is an instance of what the game is doing. :) */
public abstract class GameState {

	/********************
	*					*
	*	  VARIABLES		*
	*					*
	*********************/

	Scene scene;
	StackPane root;






	/********************
	*					*
	*	     INIT		*
	*					*
	*********************/

	public GameState() {

	}




	/********************
	*					*
	*	  FUNCTIONS		*
	*					*
	*********************/

	public abstract void initialize();
	public abstract void update();
	public abstract void draw();


	public Scene getScene() { return scene; }



}