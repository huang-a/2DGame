package World;

import javafx.scene.paint.Color;
import mainPackage.*;
import States.*;
import Utilities.*;

public class World {


	/********************
	*					*
	*	  VARIABLES		*
	*					*
	*********************/

	PlayState playState;

	Position position;

	int width, height;






	/********************
	*					*
	*	  VARIABLES		*
	*					*
	*********************/

	public World(PlayState ws) {
		playState = ws;
		position = new Position(0,0);
		width = Main.WIDTH;
		height = Main.HEIGHT;
	}




	/********************
	*					*
	*	  VARIABLES		*
	*					*
	*********************/

	public void initialize() {
		System.out.println("Initialized!");
	}

	public void update() {
		System.out.println("Updating");
	}

	public void draw() {
		playState.graphics.setFill(Color.SKYBLUE);
		playState.graphics.fillRect(position.X, position.Y, Main.WIDTH, Main.HEIGHT);
	}



}