package fr.herobane.shooter;

import java.awt.Graphics;

import fr.herobane.shooter.gameobjects.GameObject;
import fr.herobane.shooter.gameobjects.Player;
import fr.herobane.shooter.handlers.SceneHandler;

public class GameHandler
{
	
//	private EventHandler eventHandler;
	protected SceneHandler sceneHandler;
	
	protected Game game;
	protected Player player;
	
	public GameHandler(Game game)
	{
		this.game = game;
		this.player = new Player(20, 20, 32, 32, this);
		
		sceneHandler = new SceneHandler(this);
		
	}
	
	
	
	public GameObject getGameObject(int ID)
	{
		return this.sceneHandler.getCurrentScene().getGameObjects().get(ID);
	}
	
	/**
	 * Add a GameObject to the handled GameObjects
	 * @param gameObject the GameObject to add to the list
	 * @return the ID of the GameObject
	 */
	public void addGameObject(GameObject gameObject)
	{
		this.sceneHandler.getCurrentScene().getGameObjects().add(gameObject);
	}
	
	public void tick()
	{
		player.tick();
		
		sceneHandler.tick();
	}
	
	public void render(Graphics g)
	{
		if(player.isAlive())
			player.render(g);
		
		sceneHandler.render(g);
	}
	
	public Game getGame()
	{
		return this.game;
	}
	
	public SceneHandler getSceneHandler()
	{
		return this.sceneHandler;
	}
	
	public Player getPlayer()
	{
		return this.player;
	}

}
