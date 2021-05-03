package Classes;
import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;

public class State extends Canvas implements Runnable {

	private volatile boolean running = false;
	private long ticks = 0;
	private BufferedImage screen = new BufferedImage(GameFrame.WIDTH,GameFrame.HEIGHT, BufferedImage.TYPE_INT_ARGB); ///change to get witdh and heigth, also can be transparent
	private Graphics2D g = getScreen().createGraphics();
	
	private  String stateName;
	
	public State(String name)
	{
		this.stateName = name;
	}
	
	public void start()
	{
		if(!running)
		{
			running = true;
			new Thread(this).start();
		}
	}
	public void stop()
	{
		if(running)
		{
			running = false;
		}
	}
	
	public Graphics2D getGraphics2D()
	{
		return g;
	}
	public boolean isRunning() {
		return running;
	}


	public long getTicks() {
		return ticks;
	}
	
	public void render()
	{
		BufferStrategy bufferStrategy = getBufferStrategy();
		if (bufferStrategy == null)
		{
			createBufferStrategy(3);
			return;
		}
		Graphics g = bufferStrategy.getDrawGraphics();
		g.drawImage(screen,0,0,GameFrame.WIDTH,GameFrame.HEIGHT, this);
		g.dispose();
		bufferStrategy.show();
		
	}
	public void update()
	{
		ticks++;
	}

	
	
	
	@Override
	public void run() {
		while(running)
		{
			update();
			render();
		}
		
	}
	public BufferedImage getScreen() {
		return screen;
	}
	public String getStateName() {
		return stateName;
	}

}
