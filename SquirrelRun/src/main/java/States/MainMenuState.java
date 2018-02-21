package States;

import Controllers.*;
import mainPackage.*;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.TextAlignment;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class MainMenuState extends GameState {

	/********************
	*					*
	*	  VARIABLES		*
	*					*
	*********************/

	VBox holder;
	Label titleLabel;
	Button playGameBtn;
	Button creditsBtn;







	/********************
	*					*
	*	     INIT		*
	*					*
	*********************/

	public MainMenuState(GameController gc) {
		super(gc);

		// Initialize the title screen elements.
		holder = new VBox();
		titleLabel = new Label("Squirrel Run");
		playGameBtn = new Button("Play Game");
		creditsBtn = new Button("Credits");

		// Alignment.
		titleLabel.setTextAlignment(TextAlignment.CENTER);
		titleLabel.setTextFill(Color.WHITE);
		titleLabel.setFont(Font.font("Avenir", FontWeight.BOLD, 40));
		playGameBtn.setMinSize(100, 40);
		creditsBtn.setMinSize(100, 40);

		holder.setAlignment(Pos.CENTER);
		VBox.setMargin(titleLabel, new Insets(0,0,15,0));
		VBox.setMargin(playGameBtn, new Insets(0,0,15,0));
		VBox.setMargin(creditsBtn, new Insets(0,0,15,0));

		// Add those elements to the holder view.
		holder.getChildren().addAll(titleLabel, playGameBtn, creditsBtn);

		// Add action on button.
		playGameBtn.setOnAction(e -> { this.gc.switchState(1); });
		creditsBtn.setOnAction(e -> { this.gc.switchState(2); });


		root.getChildren().addAll(canvas, holder);
		scene = new Scene(root, Main.WIDTH, Main.HEIGHT);
	}




	/********************
	*					*
	*	  FUNCTIONS		*
	*					*
	*********************/

	public void initialize() {
		// System.out.println("Initialized!");
	}

	public void update() {
		// System.out.println("Updating");
	}

	public void draw() {
		clear();

		graphics.setFill(Color.GREEN);
		graphics.fillRect(0, 0, Main.WIDTH, Main.HEIGHT);
	}



}