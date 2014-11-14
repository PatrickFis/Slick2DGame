import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.lwjgl.opengl.Display;
import org.newdawn.slick.Animation;
import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.BasicGame;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.Renderable;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.SpriteSheet;
import org.newdawn.slick.geom.Circle;

public class Animationexample extends BasicGame
{
	SpriteSheet x;
	Animation animate = null;
	Circle circle =  null;
	int xpos = 200;
	int ypos = 200;
	public Animationexample(String gamename)
	{
		super(gamename);
	}

	@Override
	public void init(GameContainer gc) throws SlickException 
	{
		SpriteSheet [] sprites = {};


		SpriteSheet x = new SpriteSheet("res/sword.png",80,108);
		animate = new Animation(x,100);
		circle = new Circle(xpos,ypos,10);
	}

	@Override
	public void update(GameContainer gc, int i) throws SlickException 
	{
		Input input = gc.getInput();
		if(input.isKeyDown(input.KEY_W))
		{
			circle.setY(ypos -= 1);
		}
		if(input.isKeyDown(input.KEY_S))
		{
			circle.setY(ypos += 1);
		}
		if(input.isKeyDown(input.KEY_A))
		{
			circle.setX(xpos -= 1);
		}
		if(input.isKeyDown(input.KEY_D))
		{
			circle.setX(xpos += 1);
		}	
		animate.update(i);
	}

	@Override
	public void render(GameContainer gc, Graphics g) throws SlickException
	{
		Input input = gc.getInput();
		animate.draw(400,400);
		g.setBackground(Color.red);
		g.draw(circle);
	
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
