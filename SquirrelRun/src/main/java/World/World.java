package World;

import javafx.scene.paint.Color;
import mainPackage.*;
import States.*;
import Utilities.*;
import java.util.*;
import GameObjects.*;

public class World {


	/********************
	*					*
	*	  VARIABLES		*
	*					*
	*********************/

	/** A reference to the play state so that this object knows how to draw. */
	PlayState playState;

	/** The position of the game world. */
	Position position;

	/** The width and height of the world. */
	int width, height;

	/** All of the game objects in the world. */
	ArrayList<GameObject> gameObjects;









	/********************
	*					*
	*	  CONSTRUCT		*
	*					*
	*********************/

	public World(PlayState ws) {
		playState = ws;
		position = new Position(0,0);
		width = Main.WIDTH;
		height = Main.HEIGHT;
		gameObjects = new ArrayList<>();
	}




	/********************
	*					*
	*	  FUNCTIONS		*
	*					*
	*********************/

	/** Returns the play state. */
	public PlayState getPlayState() {
		return playState;
	}




	/********************
	*					*
	*	   ABSTRACT		*
	*					*
	*********************/

	public void initialize() {
		// Initialize each game object.
		for(GameObject obj : gameObjects) {
			obj.initialize();
		}
	}

	public void update() {
		// Update each game object.
		for(GameObject obj : gameObjects) {
			obj.update();
		}
	}

	public void draw() {
		// Draw the background of the world.
		playState.graphics.setFill(Color.SKYBLUE);
		playState.graphics.fillRect(position.X, position.Y, Main.WIDTH, Main.HEIGHT);

		// Draw every game object.
		for(GameObject obj : gameObjects) {
			obj.draw();
		}
	}



}