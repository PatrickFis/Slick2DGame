import java.util.logging.Level;
import java.util.logging.Logger;

import org.newdawn.slick.Animation;
import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.BasicGame;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.SpriteSheet;

public class Animationexample extends BasicGame
{
	SpriteSheet x;
	Animation animate;
	public Animationexample(String gamename)
	{
		super(gamename);
	}

	@Override
	public void init(GameContainer gc) throws SlickException 
	{
		SpriteSheet [] sprites = {};


		SpriteSheet x = new SpriteSheet("res/sword_man.png",100,103);
		animate = new Animation(x,100);
	}

	@Override
	public void update(GameContainer gc, int i) throws SlickException 
	{
		animate.update(i);
	}

	@Override
	public void render(GameContainer gc, Graphics g) throws SlickException
	{
		animate.draw(400,400);
	}

	public static void main(String[] args)
	{
		try
		{
			AppGameContainer appgc;
			appgc = new AppGameContainer(new Animationexample("Simple Slick Game"));
			appgc.setDisplayMode(1280, 720, false);
			appgc.start();
		}
		catch (SlickException ex)
		{
			Logger.getLogger(Animationexample.class.getName()).log(Level.SEVERE, null, ex);
		}
	}
}
