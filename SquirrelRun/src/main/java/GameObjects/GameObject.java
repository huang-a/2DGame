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

	/** the y glid acceleration and fall acceleration. */
	float yGlideAcc, yFallAcc;
	/** Booleans for movement. */
	public boolean up, down;

	public boolean jump, fall;







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
		this.jump = false;
		this.fall = false;
		this.xVel = 1;
		this.yVel = 1;
		this.yFallAcc = -2; // gravity acceleration is -9.8
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
			position.X += xVel;
		collisionBox.setRect(position.X, position.Y, width, height);
	}

	/** makes game object jump**/
	public void jump() {
		if(jump) {
			yVel = -10;
			position.Y += yVel;
		}
		collisionBox.setRect(position.X, position.Y, width, height);
	}

	public void glid() {
		yVel=1;
		position.Y += yVel;

		collisionBox.setRect(position.X, position.Y, width, height);
	}

	public void fall() {
		if(fall) {
			yVel = 3;
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
		jump();
		if (yVel=0) {
			glide();
		}
		fall();
	}

	public abstract void draw();


}
