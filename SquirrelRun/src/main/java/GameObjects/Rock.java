package GameObjects;

import javafx.scene.paint.Color;
import World.*;

public class Rock extends GameObject {

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

	public Rock(World world) {
		super(world);
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