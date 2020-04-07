package fr.herobane.shooter.gameobjects;

import java.awt.Graphics;

import fr.herobane.shooter.Game;
import fr.herobane.shooter.GameHandler;

public abstract class GameObject
{
	
	protected int xPos, yPos;
	
	protected int ID;
	protected static int instances = 0;
	
	protected GameHandler handler;
	
	protected Game game;
	
	public GameObject()
	{
		this.xPos = 0;
		this.yPos = 0;
		
		this.ID = instances;
		instances++;
	}
	
	public GameObject(int xPos, int yPos)
	{
		this.xPos = xPos;
		this.yPos = yPos;
		
		instances++;
		this.ID = instances;
	}
	
	public abstract void tick();
	public abstract void render(Graphics g);
	
	public final void link(Game game)
	{
		this.game = game;
	}
	
	public int getID()
	{
		return this.ID;
	}
	
	public int getPositionX()
	{
		return this.xPos;
	}
	
	public int getPositionY()
	{
		return this.yPos;
	}
	
	public void setPositionX(int xPos)
	{
		this.xPos = xPos;
	}
	
	public void setPositionY(int yPos)
	{
		this.yPos = yPos;
	}

}
