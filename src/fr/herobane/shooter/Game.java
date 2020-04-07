package fr.herobane.shooter;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferStrategy;

public class Game extends Canvas implements Runnable
{
	
	private static final long serialVersionUID = -169514751260574799L;
	
	public static int width = 720, height = width / 12 * 9;
	
	public static boolean running;
	
	public static boolean gameOver;
	
	public static int playerID = 0;
	
	private Thread mainThread;
	
	public static GameHandler handler;
	
	@SuppressWarnings("unused")
	private int lastFPS;

	public Game()
	{	

		handler = new GameHandler(this);	
		
		new GameFrame("2D Top View Shooter", new Dimension(width, height), this);
		gameOver = false;
		
		this.addKeyListener(new GameInput(this));
		this.requestFocus();
	}
	
	public synchronized void start()
	{
		running = true;
		
		this.mainThread = new Thread(this);
		this.mainThread.start();
	}
	
	public synchronized void stop() throws InterruptedException
	{
		this.mainThread.join();
		running = false;
	}

	@Override
	public void run()
	{
		long lastTime = System.nanoTime();
		double amountOfTick = 60.0;
		double ns = 1000000000 / amountOfTick;
		double delta = 0;
		long timer = System.currentTimeMillis();
		int frames = 0;
		
		while(running)
		{
			long now = System.nanoTime();
			delta += (now - lastTime) / ns;
			lastTime = now;
			
			while(delta >= 1)
			{
				tick();
				delta--;
			}
			
			if(running)
				render();
			
			frames++;
			
			if(System.currentTimeMillis() - timer > 1000)
			{
				timer += 1000;
				this.lastFPS = frames;
				frames = 0;
			}
			
		}
		
		try { stop(); } catch(InterruptedException e) { e.printStackTrace(); }
	}
	
	public void tick()
	{
		handler.tick();
	}
	
	public void render()
	{
		BufferStrategy bs = this.getBufferStrategy();
		
		if(bs == null)
		{
			this.createBufferStrategy(3);
			return;
		}
		
		Graphics2D g = (Graphics2D) bs.getDrawGraphics();
		
		g.setColor(Color.WHITE);
		g.fillRect(0, 0, width, height);
		
		if(gameOver)
		{
			g.setColor(Color.BLACK);
			g.setFont(new Font("Arial", Font.BOLD, 20));
			g.drawString("Game Over, press R to restart", 200, 180);
		}
		
		handler.render(g);
		
		g.dispose();
		bs.show();
	}
	
	public static void main(String[] args)
	{
		new Game();
	}
	
}
