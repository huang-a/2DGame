package GameObjects;

import java.awt.geom.Rectangle2D;
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

	/** The collision box for this game object. */
	Rectangle2D.Float collisionBox;

	/** The x and y velocities. */
	float xVel, yVel;

	/** Booleans for movement. */
	public boolean up, down;







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
		this.up = false;
		this.down = false;
		this.xVel = 1;
		this.yVel = 1;
		this.collisionBox = new Rectangle2D.Float(position.X,position.Y,width,height);
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
		collisionBox.setRect(position.X, position.Y, width, height);
	}


	/** Returns the position of this game object. */
	public Position getPosition() {
		return position;
	}


	/** Checks if this game object is colliding with another one. */
	public boolean isCollingWith(GameObject other) {
		if(this.collisionBox.intersects(other.collisionBox)) {
			return true;
		}
		return false;
	}


	/** Moves the game object in a particular direction. */
	public void move() {
		if(up) {
			position.Y -= yVel;
		}
		else if(down) {
			position.Y += yVel;
		}
		collisionBox.setRect(position.X, position.Y, width, height);
	}






	/********************
	*					*
	*	   ABSTRACT		*
	*					*
	*********************/


	public abstract void initialize();
	
	public void update() {
		move();
	}
	
	public abstract void draw();


}