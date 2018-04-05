package GameObjects;

import javafx.geometry.Rectangle2D;
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
	public Position position;
	
	/** The width and height of the world. */
	int width, height;

	/** The collision box for this game object. */
	Rectangle2D collisionBox;








	/********************
	*					*
	*	  VARIABLES		*
	*					*
	*********************/

	public GameObject(World world) {
		this.world = world;
		this.position = new Position(0, 0);
		this.width = 32;
		this.height = 32;
		this.collisionBox = new Rectangle2D(position.X,position.Y,width,height);
	}




	/********************
	*					*
	*	  FUNCTIONS		*
	*					*
	*********************/

	/** Sets the position of a game object to a specific location. */
	public void setPosition(int x, int y) {
		position.X = x;
		position.Y = y;
		collisionBox = new Rectangle2D(x,y,width,height);
	}



	/** Checks if this game object is colliding with another one. */
	public boolean isCollingWith(GameObject other) {
		if(this.collisionBox.intersects(other.collisionBox)) {
			return true;
		}
		return false;
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