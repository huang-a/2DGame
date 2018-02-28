package GameObjects;

import Utilities.*;
import World.*;

public abstract class GameObject {


	/********************
	*					*
	*	  VARIABLES		*
	*					*
	*********************/

	/** A reference to the world so that this object knows how to draw. */
	World world;

	/** Where the game object is located on the screen. */
	Position position;
	
	/** The width and height of the world. */
	int width, height;









	/********************
	*					*
	*	  VARIABLES		*
	*					*
	*********************/

	public GameObject(World world) {
		this.world = world;
		position = new Position(0, 0);
		width = 32;
		height = 32;
	}




	/********************
	*					*
	*	  FUNCTIONS		*
	*					*
	*********************/







	/********************
	*					*
	*	   ABSTRACT		*
	*					*
	*********************/


	public abstract void initialize();
	public abstract void update();
	public abstract void draw();


}