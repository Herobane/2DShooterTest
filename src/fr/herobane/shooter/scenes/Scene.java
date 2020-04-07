package fr.herobane.shooter.scenes;

import java.util.LinkedList;

import fr.herobane.shooter.gameobjects.GameObject;
import fr.herobane.shooter.handlers.SceneHandler;

public class Scene
{
	private LinkedList<GameObject> gameObjects = new LinkedList<GameObject>();
	
//	private SceneHandler handler;
	
	public Scene(SceneHandler handler)
	{
//		this.handler = handler;
	}
	
	public void addGameObject(GameObject object)
	{
		this.gameObjects.add(object);
	}
	
	public LinkedList<GameObject> getGameObjects()
	{
		return this.gameObjects;
	}
}
