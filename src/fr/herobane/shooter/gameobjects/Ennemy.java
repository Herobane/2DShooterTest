package fr.herobane.shooter.gameobjects;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.ConcurrentModificationException;

import fr.herobane.shooter.Game;
import fr.herobane.shooter.scenes.Scene;


public class Ennemy extends Entity
{

	public Ennemy()
	{
		super();
	}

	public Ennemy(int xPos, int yPos, Rectangle hitbox)
	{
		super(xPos, yPos, hitbox);
	}

	public Ennemy(int xPos, int yPos, int width, int height, Scene scene)
	{
		super(xPos, yPos, width, height, scene);
	}
	
	@Override
	public void tick()
	{
		super.tick();
		
		try
		{
			for(GameObject gameObject : scene.getGameObjects())
			{	
				if(gameObject instanceof Bullet)
				{
					Bullet bullet = (Bullet) gameObject;
					
					if(this.hitbox.intersects(bullet.getHitbox()))
					{
						bullet.kill();
						this.kill();
					}
				}
			}
			
			if(this.hitbox.intersects(Game.handler.getPlayer().getHitbox()))
			{
				Game.handler.getPlayer().setAlive(false);
				Game.handler.getPlayer().kill();
			}
		}
		catch(ConcurrentModificationException e) {}
	}

	@Override
	public void render(Graphics g)
	{
		g.setColor(Color.PINK);
		g.fillRect(xPos, yPos, width, height);
	}

}
