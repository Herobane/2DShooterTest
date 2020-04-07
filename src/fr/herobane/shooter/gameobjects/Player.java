package fr.herobane.shooter.gameobjects;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import fr.herobane.shooter.Game;
import fr.herobane.shooter.GameHandler;
import fr.herobane.shooter.scenes.Scene;

public class Player extends Entity
{
	
	private long shootTimer;
	
	protected int shotsPerSecond = 2;
	
	protected Scene currentScene;
	
	protected boolean alive;
	
	protected Direction facing;
	
	protected Image eastSprite;
	protected Image westSprite;
	protected Image northSprite;
	protected Image southSprite;
	
	public Player()
	{
		super();
		
		this.ID = Game.playerID;
	}
	
	public Player(int xPos, int yPos, Rectangle hitbox)
	{
		super(xPos, yPos, hitbox);
		
		this.ID = Game.playerID;
	}
	
	public Player(int xPos, int yPos, int width, int height, GameHandler handler)
	{
		super(xPos, yPos, width, height, null);
		
		this.ID = Game.playerID;
		this.handler = handler;
		
		this.alive = true;
		
		this.facing = Direction.EAST;
		
		try
		{
			this.eastSprite = ImageIO.read(new File("east.png"));
			this.westSprite = ImageIO.read(new File("west.png"));
			this.northSprite = ImageIO.read(new File("north.png"));
			this.southSprite = ImageIO.read(new File("south.png"));

		}
		catch (IOException e) {}
	}
	
	public void move(Direction direction, int pressed)
	{
		if(alive)
		{
			switch(direction)
			{
				case WEST:
					this.xVel = -3 * pressed;
					break;
				case EAST:
					this.xVel = 3 * pressed;
					break;
				case NORTH:
					this.yVel = -3 * pressed;
					break;
				case SOUTH:
					this.yVel = 3 * pressed;
					break;
			}
		}
	}
	
	public void shoot()
	{
		long currentTime = System.currentTimeMillis();
		
		if((currentTime - shootTimer) > (1000 / shotsPerSecond) && alive)
		{
			try
			{
				switch(facing)
				{
					case WEST:
						Game.handler.getSceneHandler().getCurrentScene().addGameObject(new Bullet(this.xPos + this.width / 2, this.yPos + this.height / 2, 15, 15, this.scene).setFacing(Direction.WEST));
						break;
					case EAST:
						Game.handler.getSceneHandler().getCurrentScene().addGameObject(new Bullet(this.xPos + this.width / 2, this.yPos + this.height / 2, 15, 15, this.scene).setFacing(Direction.EAST));
						break;
					case NORTH:
						Game.handler.getSceneHandler().getCurrentScene().addGameObject(new Bullet(this.xPos + this.width / 2, this.yPos + this.height / 2, 15, 15, this.scene).setFacing(Direction.NORTH));
						break;
					case SOUTH:
						Game.handler.getSceneHandler().getCurrentScene().addGameObject(new Bullet(this.xPos + this.width / 2, this.yPos + this.height / 2, 15, 15, this.scene).setFacing(Direction.SOUTH));
						break;
				}
				
				shootTimer = System.currentTimeMillis();
			}
			catch(NullPointerException e) {e.printStackTrace();}
			
		}
	}
	
	@Override
	public void kill()
	{
		Game.gameOver = true;
	}

	@Override
	public void tick()
	{
		super.tick();
	}

	@Override
	public void render(Graphics g)
	{
		switch(facing)
		{
			case WEST:
				g.drawImage(westSprite, xPos, yPos, null);
				break;
			case EAST:
				g.drawImage(eastSprite, xPos, yPos, null);
				break;
			case NORTH:
				g.drawImage(northSprite, xPos, yPos, null);
				break;
			case SOUTH:
				g.drawImage(southSprite, xPos, yPos, null);
				break;
		}
	}
	
	public void setCurrentScene(Scene scene)
	{
		this.currentScene = scene;
	}
	
	public boolean isAlive()
	{
		return this.alive;
	}
	
	public void setAlive(boolean alive)
	{
		this.alive = alive;
	}
	
	public Direction getFacing()
	{
		return this.facing;
	}
	
	public void setFacing(Direction facing)
	{
		this.facing = facing;
	}

}
