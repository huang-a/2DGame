import javax.swing.*;
import java.awt.*;


/*
 * Concerns:
 * 1. System.out.println does not print on terminal.
*/
public class MainMenu {

	private JFrame menu;
	private JButton start, settings, credits;

	public MainMenu(){
		menu=new JFrame("Menu");
		start=new JButton("Start");
		settings=new JButton("Settings");
		credits=new JButton("Credits");
		
		menu.setLayout(new GridLayout(3,0));
		menu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container temp=menu.getContentPane();
		temp.add(start);
		temp.add(settings);
		temp.add(credits);
		menu.setSize(300, 400);
		menu.setResizable(false);
		menu.setVisible(true);
		
		while(menu.isShowing())
			listen();
	}

	public MainMenu(int frameWidth, int frameHeight){


		menu=new JFrame("Menu");
		start=new JButton("Start");
		settings=new JButton("Settings");
		credits=new JButton("Credits");
		
		//menu.setLayout(/* custom layout */);
		menu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container temp=menu.getContentPane();
		temp.add(start);
		temp.add(settings);
		temp.add(credits);
		menu.setSize(frameWidth, frameHeight);
		menu.setResizable(false);
		menu.setVisible(true);
		
		while(menu.isShowing())
			listen();
	}


	
	public void listen(){
		if(start.getModel().isPressed()) start();
		else if(settings.getModel().isPressed()) settings();
		else if(credits.getModel().isPressed()) credits();
	}
	
	protected void start(){


		//System.out.println("start is pressed");
	}



	protected void settings(){


		//System.out.println("settings is pressed");
	}



	protected void credits(){


		//System.out.println("credits is pressed");		
	}


	public static void main(String[] args){
		MainMenu menu=new MainMenu();
	}
}
