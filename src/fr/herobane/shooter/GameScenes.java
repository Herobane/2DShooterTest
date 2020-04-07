package fr.herobane.shooter;

import java.util.ArrayList;

import fr.herobane.shooter.gameobjects.Ennemy;
import fr.herobane.shooter.handlers.SceneHandler;
import fr.herobane.shooter.scenes.Scene;

public class GameScenes
{
	
	public static Scene scene1;
	public static Scene scene2;
	public static Scene scene3;
	
	public static ArrayList<Scene> scenes = new ArrayList<Scene>();
	
	public static void initScenes(SceneHandler handler)
	{
		scene1 =  new Scene(handler);
		
		scene1.addGameObject(new Ennemy(200, 200, 32, 32, scene1));
		scene1.addGameObject(new Ennemy(300, 300, 32, 32, scene1));
		scene1.addGameObject(new Ennemy(200, 300, 32, 32, scene1));
		scene1.addGameObject(new Ennemy(300, 200, 32, 32, scene1));
		scene1.addGameObject(new Ennemy(600, 200, 32, 32, scene1));
		
		scene2 =  new Scene(handler);
		
		scene2.addGameObject(new Ennemy(600, 200, 32, 32, scene2));
		scene2.addGameObject(new Ennemy(300, 200, 32, 32, scene2));
		scene2.addGameObject(new Ennemy(680, 300, 32, 32, scene2));
		scene2.addGameObject(new Ennemy(300, 400, 32, 32, scene2));
		scene2.addGameObject(new Ennemy(500, 200, 32, 32, scene2));
		scene2.addGameObject(new Ennemy(100, 100, 32, 32, scene2));
		scene2.addGameObject(new Ennemy(120, 300, 32, 32, scene2));
		
		scene3 =  new Scene(handler);
		
		scene3.addGameObject(new Ennemy(600, 200, 32, 32, scene3));
		scene3.addGameObject(new Ennemy(300, 400, 32, 32, scene3));
		scene3.addGameObject(new Ennemy(600, 300, 32, 32, scene3));
		scene3.addGameObject(new Ennemy(400, 400, 32, 32, scene3));
		scene3.addGameObject(new Ennemy(600, 350, 32, 32, scene3));
		scene3.addGameObject(new Ennemy(100, 480, 32, 32, scene3));
		scene3.addGameObject(new Ennemy(120, 200, 32, 32, scene3));
		
		scenes.add(scene1);
		scenes.add(scene2);
		scenes.add(scene3);
	}
}
