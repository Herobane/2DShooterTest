package fr.herobane.shooter.gameobjects;

import java.awt.Rectangle;

public abstract class SolidObject extends GameObject
{

	protected Rectangle hitbox;
	
	public SolidObject()
	{
		super();
		
		this.hitbox = new Rectangle();
	}
	
	public SolidObject(int xPos, int yPos, Rectangle hitbox)
	{
		super(xPos, yPos);
		
		this.hitbox = hitbox;
	}

	public Rectangle getHitbox()
	{
		return this.hitbox;
	}
	
	public void setHitbox(Rectangle hitbox)
	{
		this.hitbox = hitbox;
	}

}
