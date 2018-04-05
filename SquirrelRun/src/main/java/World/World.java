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
	public ArrayList<GameObject> gameObjects;









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

		addRocksToWorld();
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


	/** Loads all of the rocks from a separate file, makes GameObjects out
	of them, and adds them to the world. */
	public void addRocksToWorld() {
		Rock rock = new Rock(this);
		rock.setPosition(100, 84);

		Rock rock2 = new Rock(this);
		rock2.setPosition(10, 30);


		gameObjects.add(rock);
		gameObjects.add(rock2);
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
		Rock r = (Rock)gameObjects.get(0);

		// Update each game object.
		for(GameObject obj : gameObjects) {
			obj.update();

			if(r != null) {
				if(r.isCollingWith(obj)) {
					System.out.println("Colliding!!!");
				}
			}			
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