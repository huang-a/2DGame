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

	/** The counter for when a new item should be spawned. */
	int spawnCounter;

	/** The longest time to take before spawning. */
	int low = 10;


	// Delete later.
	int timer = 0;





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
		spawnCounter = 10;
		gameObjects = new ArrayList<>();

		addPlayerToWorld();
		addFloorToWorld();
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


	/** Loads player from a separate file, makes GameObjects out
	of them, and adds them to the world. */
	public void addPlayerToWorld() {
		Player p = new Player(this);
		p.setPosition(100, 420);

		gameObjects.add(p);
	}


	/** Adds the floor to the game world. */
	public void addFloorToWorld() {
		Floor f = new Floor(this);
		f.setPosition(0, 460);

		gameObjects.add(f);
	}


	/** Generate random obstacle. */
	public void generateRandomObstacle() {

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

		// position.X -= 3.5;

		// Update the spawn counter.
		if(spawnCounter > 0) {
			spawnCounter -= 1;
		} else {
			Random rand = new Random();
			int randomNumber = rand.nextInt(4)+low;
			spawnCounter = randomNumber;
			timer += 1;

			System.out.println("RANDOM NUMBER: "+randomNumber);
			System.out.println("LOW: "+low);
		}

		if(timer >= 20) {
			if(low - 1 > 0) low -= 1;
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
