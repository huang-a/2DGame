package GameObjects;

import javafx.scene.paint.Color;
import World.*;

public class Floor extends GameObject {

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

	public Floor(World world) {
		super(world);
		this.width = 640;
		this.height = 20;
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

	public void initialize() {

	}

	public void update() {
		super.update();
		move();
	}

	public void draw() {
		world.getPlayState().graphics.setFill(Color.GREEN);
		world.getPlayState().graphics.fillRect(position.X, position.Y, width, height);

		// Show the collision box.
		world.getPlayState().graphics.setStroke(Color.ORANGE);
		world.getPlayState().graphics.strokeRect(collisionBox.getMinX(),
												collisionBox.getMinY(),
												collisionBox.getWidth(),
												collisionBox.getHeight());
	}




}
