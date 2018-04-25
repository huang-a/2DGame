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
	double yFallAcc;
	/** Booleans for movement. */
	public boolean up, down;

	public boolean jump, fall;

	public boolean toggleGravity = false;

	public boolean colliding = false;





	/********************
	*					*
	*	  VARIABLES		*
	*					*
	*********************/

	public GameObject(World world) {
		this.world = world;
		this.position = new Position(0, 0);
		this.width = 40;
		this.height = 40;
		this.up = false;
		this.down = false;
		this.jump = false;
		this.fall = false;
		this.xVel = 0;
		this.yVel = 0;
		this.yFallAcc = 1; // gravity acceleration is -.05
		this.collisionBox = new Rectangle2D.Float(position.X,position.Y,width,height);
		this.colliding = false;
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
	public boolean isCollidingWith(GameObject other) {
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

	/** makes game object jump; object is subject to gravitational pull**/
	public void jump() { // how do we apply gravity to this?
		if (jump) {
			yVel = -26;
			toggleGravity = true;
		}
	}

	/** object falls at a constant rate */
	public void glide() {
		toggleGravity = false;
		yVel=2;
	}

	/** object falls with gravitational force */
	public void fall() {
		toggleGravity = true;
	}

	public void animateJump() {
		position.Y += yVel;
		collisionBox.setRect(position.X, position.Y, width, height);
	}

	public void gravity() {
		if (toggleGravity) { // apply gravity when toggleGravity is true
			yVel += yFallAcc; // applies gravity to acceleration
		}
	}
	/********************
	*					*
	*	   ABSTRACT		*
	*					*
	*********************/


	public abstract void initialize();

	public void update() {
		animateJump();
		gravity(); // apply gravity
		if (yVel > 0 && !fall) { // when player starts falling and fall is false
			glide(); // start gliding
		}
		else if (fall) { // if fall is true
			toggleGravity = true;
		}
		if (colliding) {
			yVel = 0; // no longer goes DOWN
			jump = false; // jump=false --> player can jump again
			fall = false;
			toggleGravity = false; // no  more gravity
			colliding = false; // colliding is false
			position.Y = 420; // Reset position
		}
	}

	public abstract void draw();


}
