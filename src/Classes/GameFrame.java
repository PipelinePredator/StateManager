package Classes;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;

import javax.swing.JFrame;

public class GameFrame extends JFrame {
	
	
	public static final int WIDTH = 650, HEIGHT = 650;
	StateManager stateManager;
	
	public GameFrame()
	{
		setSize(WIDTH, HEIGHT);
		setVisible(true);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		
		initialise();
	}

	private void initialise() {
		stateManager = new StateManager(this);
		stateManager.setCurrentState("MenuState");
		stateManager.startCurrentState();
		
	}
	
	@Override
	public void paint(Graphics g)
	{
		
	}
	
	public static void main(String[] args) {
		new GameFrame();
	}
}
