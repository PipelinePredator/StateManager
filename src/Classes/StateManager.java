package Classes;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;

import javax.swing.JFrame;

import States.MenuState;

public class StateManager {
	
	
	private ArrayList<State> allStates;
	private int currentState;
	private JFrame gameFrame;
	
	
	public StateManager(JFrame jFrame)
	{
		this.gameFrame = jFrame;
		allStates = new ArrayList<State>();
		initialiseAllStates();
	}
	
	private void initialiseAllStates()
	{
		allStates.add(new MenuState());
		
	}
	
	public void setCurrentState(String stateName) 
	{
		for(int i = 0; i<allStates.size(); i ++)
		{
			if(stateName.equals(allStates.get(i).getStateName()))
			{
				currentState = i;
			}
		}
	}
	
	public void startCurrentState() 
	{
		gameFrame.add(allStates.get(currentState));
		allStates.get(currentState).start();
		
	}
	
	public void stopCurrentState() 
	{
		gameFrame.remove(allStates.get(currentState));
		allStates.get(currentState).stop();
	}
	
	
	
	
}
