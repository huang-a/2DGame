package States;

import Controllers.*;
import mainPackage.*;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;


/** A GameState is an instance of what the game is doing. :) */
public abstract class GameState {

	/********************
	*					*
	*	  VARIABLES		*
	*					*
	*********************/

	Scene scene;
	StackPane root;
	public GameController gc;


	public Canvas canvas;
	public GraphicsContext graphics;




	/********************
	*					*
	*	     INIT		*
	*					*
	*********************/

	public GameState(GameController gc) {
		this.gc = gc;
		this.root = new StackPane();

		this.canvas = new Canvas(Main.WIDTH, Main.HEIGHT);
		this.graphics = canvas.getGraphicsContext2D();
	}



	/********************
	*					*
	*	   GETTERS		*
	*					*
	*********************/

	public Scene getScene() { return scene; }

	public StackPane getRoot() { return root; }



	/********************
	*					*
	*	   SETTERS		*
	*					*
	*********************/

	/** Clears the drawing area. */
	protected void clear() {
		graphics.clearRect(0,0,Main.WIDTH,Main.HEIGHT);
	}





	/********************
	*					*
	*	   ABSTRACT		*
	*					*
	*********************/

	public abstract void initialize();
	public abstract void update();
	public abstract void draw();


}