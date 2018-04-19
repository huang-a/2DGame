package GameObjects;

import javafx.scene.paint.Color;
import World.*;
import javafx.scene.input.KeyCode;

public class Player extends GameObject {

	/********************
	*					*
	*	  VARIABLES		*
	*					*
	*********************/










	/********************
	*					*
	*	  VARIABLES		*
	*					*
	*********************/

	public Player(World world) {
		super(world);
	}




	/********************
	*					*
	*	  FUNCTIONS		*
	*					*
	*********************/

	public void detectKey(KeyCode keyCode) {
		switch(keyCode) {
			case UP: // sets jump to true when player presses UP
				this.jump = true;
				this.fall = false;
				break;
			case DOWN: // sets fall to true when player presses down
				this.jump = false;
				this.fall = true;
				break;
		}
	}





	/********************
	*					*
	*	   ABSTRACT		*
	*					*
	*********************/

	public void initialize() {

	}

	public void update() {
		super.update();
	}

	public void draw() {
		world.getPlayState().graphics.setFill(Color.GREEN);
		world.getPlayState().graphics.fillRect(position.X, position.Y, width, height);

		// Show the collision box.
		world.getPlayState().graphics.setStroke(Color.RED);
		world.getPlayState().graphics.strokeRect(collisionBox.getMinX(),
												collisionBox.getMinY(),
												collisionBox.getWidth(),
												collisionBox.getHeight());
	}




}
