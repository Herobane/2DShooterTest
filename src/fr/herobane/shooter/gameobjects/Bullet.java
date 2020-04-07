package fr.herobane.shooter.gameobjects;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

import fr.herobane.shooter.Game;
import fr.herobane.shooter.scenes.Scene;


public class Bullet extends Entity
{

	protected Direction facing;
	
	public Bullet()
	{
		super();
	}

	public Bullet(int xPos, int yPos, Rectangle hitbox)
	{
		super(xPos, yPos, hitbox);
	}

	public Bullet(int xPos, int yPos, int width, int height, Scene scene)
	{
		super(xPos, yPos, width, height, scene);
		
		facing = Direction.EAST;
	}

	@Override
	public void tick()
	{
		super.tick();
		
		switch(this.facing)
		{
			case WEST:
				this.xVel = -5;
				break;
			case EAST:
				this.xVel = 5;
				break;
			case NORTH:
				this.yVel = -5;
				break;
			case SOUTH:
				this.yVel = 5;
				break;
		}
		
		if(this.xPos > Game.width)
		{
			this.kill();
		}
	}
	
	@Override
	public void render(Graphics g)
	{
		g.setColor(Color.RED);
		g.fillRect(xPos, yPos, width, height);
	}
	
	public Bullet setFacing(Direction facing)
	{
		this.facing = facing;
		
		return this;
	}

}
