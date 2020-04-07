package fr.herobane.shooter;

import java.awt.Canvas;
import java.awt.Dimension;

import javax.swing.JFrame;

public class GameFrame extends Canvas
{

	private static final long serialVersionUID = -5953342470177424359L;
	
	private JFrame frame;
	private Game game;
	
	public GameFrame(String title, Dimension dimension, Game game)
	{
		this.frame = new JFrame(title);
		this.game = game;
		
		this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.frame.setSize(dimension);
		this.frame.setResizable(false);
		this.frame.setLocationRelativeTo(null);
		this.frame.add(game);
		this.frame.setVisible(true);
		
		this.game.start();
	}

}
