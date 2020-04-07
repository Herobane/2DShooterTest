package fr.herobane.shooter.handlers;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.util.ConcurrentModificationException;

import fr.herobane.shooter.Game;
import fr.herobane.shooter.GameHandler;
import fr.herobane.shooter.GameScenes;
import fr.herobane.shooter.gameobjects.Ennemy;
import fr.herobane.shooter.gameobjects.GameObject;
import fr.herobane.shooter.scenes.Scene;

public class SceneHandler
{

	protected Scene currentScene;
	
	private GameHandler handler;
	
	private int level;
	
	private boolean theEnd = false;
	
	public SceneHandler(GameHandler handler)
	{
		this.handler = handler;
		
		this.level = 1;
		
		GameScenes.initScenes(this);
		currentScene = GameScenes.scenes.get(level - 1);
		
		handler.getPlayer().setCurrentScene(currentScene);
		
	}

	public void tick()
	{
		try
		{
			
			int ennemies = 0;
			
			for(GameObject gameObject : this.currentScene.getGameObjects())
			{
				gameObject.tick();
				
				if(gameObject instanceof Ennemy)
				{
					ennemies++;
				}
			}
			
			if(ennemies == 0)
			{
				level++;
				this.reload();
			}
		} 
		catch(ConcurrentModificationException e) {}
		
	}
	
	public void render(Graphics g)
	{
		try
		{
			for(GameObject gameObject : this.currentScene.getGameObjects())
			{
				gameObject.render(g);
			}
		}
		catch(ConcurrentModificationException e) {}
		
		if(theEnd)
		{
			g.setColor(Color.BLACK);
			g.setFont(new Font("Arial", Font.BOLD, 20));
			g.drawString("GG", 350, 200);
			
			Game.running = false;
		}
	}
	
	public void reload()
	{
		try
		{
			this.currentScene = GameScenes.scenes.get(level - 1);
			handler.getPlayer().setCurrentScene(currentScene);
			handler.getPlayer().setPositionX(20);
			handler.getPlayer().setPositionY(20);
		}
		catch(IndexOutOfBoundsException e)
		{
			theEnd = true;
		}
		
	}
	
	public GameHandler getGameHandler()
	{
		return this.handler;
	}
	
	public Scene getCurrentScene()
	{
		return this.currentScene;
	}


}
