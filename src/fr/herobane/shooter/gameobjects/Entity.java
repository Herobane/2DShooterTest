package fr.herobane.shooter.gameobjects;

import java.awt.Rectangle;

import fr.herobane.shooter.Game;
import fr.herobane.shooter.scenes.Scene;


public abstract class Entity extends SolidObject
{

	protected int xVel, yVel;
	
	protected int width, height;
	
	protected Scene scene;
	
	public Entity()
	{
		super();
		
		this.xVel = 0;
		this.yVel = 0;
		this.width = 0;
		this.height = 0;
	}

	public Entity(int xPos, int yPos, Rectangle hitbox)
	{
		super(xPos, yPos, hitbox);
		
		this.xVel = 0;
		this.yVel = 0;
		
		this.width = (int) hitbox.getWidth();
		this.height = (int) hitbox.getHeight();
	}
	
	public Entity(int xPos, int yPos, int width, int height, Scene scene)
	{
		this.xPos = xPos;
		this.yPos = yPos;
		this.xVel = 0;
		this.yVel = 0;
		this.width = width;
		this.height = height;
		this.scene = scene;
	}
	
	public void kill()
	{
		Game.handler.getSceneHandler().getCurrentScene().getGameObjects().remove(this);
	}
	
	@Override
	public void tick()
	{
		this.xPos += xVel;
		this.yPos += yVel;
		
		this.hitbox = new Rectangle(xPos, yPos, width, height);
	}
	
	public int getVelocityX()
	{
		return this.xVel;
	}
	
	public int getVelocityY()
	{
		return this.yVel;
	}
	
	public void setVelocityX(int xVel)
	{
		this.xVel = xVel;
	}
	
	public void setVelocityY(int yVel)
	{
		this.yVel = yVel;
	}

}
