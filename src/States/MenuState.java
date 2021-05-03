package States;

import java.awt.Color;
import java.awt.Graphics2D;

import Classes.State;

public class MenuState extends State {
	
	
	public MenuState() {
		super("MenuState");

	}

	
	@Override
	public void render()
	{
		Graphics2D g = getGraphics2D();
		g.setColor(Color.blue);
		g.fillRect(100, 100, 100, 100);
		g.setColor(Color.red);
		g.drawString("menu", 120,120);
		super.render();
		////here write what you want to do in this window
	}
	@Override
	public void update()
	{
		super.update();
	}
}
