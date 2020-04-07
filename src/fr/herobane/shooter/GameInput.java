package fr.herobane.shooter;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import fr.herobane.shooter.gameobjects.Direction;
import fr.herobane.shooter.gameobjects.Player;


public class GameInput extends KeyAdapter
{

	@SuppressWarnings("unused")
	private Game game;
	private Player player;
	
	private ArrayList<Integer> keys = new ArrayList<Integer>();
	
	public GameInput(Game game)
	{
		super();
		
		this.game = game;
		this.player = (Player) Game.handler.getPlayer();
	}

	@Override
	public void keyTyped(KeyEvent e)
	{
		
	}

	@Override
	public void keyPressed(KeyEvent e)
	{	
		int keyCode = e.getKeyCode();
		
		switch(keyCode)
		{
			case 65:
				player.move(Direction.WEST, 1);
				player.setFacing(Direction.WEST);
				break;
			case 68:
				player.move(Direction.EAST, 1);
				player.setFacing(Direction.EAST);
				break;
			case 87:
				player.move(Direction.NORTH, 1);
				player.setFacing(Direction.NORTH);
				break;
			case 83:
				player.move(Direction.SOUTH, 1);
				player.setFacing(Direction.SOUTH);
				break;
		}
		
		if(!keys.contains(e.getKeyCode()))
		{
	        keys.add(e.getKeyCode());
	    }
		
		if(keys.contains(KeyEvent.VK_SPACE))
		{
			player.shoot();
		}
		
		if(keys.contains(KeyEvent.VK_R))
		{
			if(Game.gameOver)
			{
				Game.gameOver = false;
				Game.handler.getPlayer().setAlive(true);
				
				player.setPositionX(20);
				player.setPositionY(20);
				
				player.setVelocityX(0);
				player.setVelocityY(0);
			}
		}
	}

	@Override
	public void keyReleased(KeyEvent e)
	{
		int keyCode = e.getKeyCode();
		
		switch(keyCode)
		{
			case 65:
				player.move(Direction.WEST, 0);
				break;
			case 68:
				player.move(Direction.EAST, 0);
				break;
			case 87:
				player.move(Direction.NORTH, 0);
				break;
			case 83:
				player.move(Direction.SOUTH, 0);
				break;
		}
		
		if(keys.contains(e.getKeyCode()))
		{
	        keys.remove(keys.indexOf(e.getKeyCode()));
	    }
	}

}
