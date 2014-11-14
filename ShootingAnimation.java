import java.util.logging.Level;
import java.util.logging.Logger;
import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.BasicGame;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Circle;
import org.newdawn.slick.geom.Rectangle;

public class Shooting extends BasicGame
{
	Rectangle rect = null;
	Circle circle = null;
	Circle bullet = null;
	int xpos;
	int ypos;
	double Cxpos;
	double Cypos;
	boolean fire;
	public Shooting(String gamename)
	{
		super(gamename);
	}

	@Override
	public void init(GameContainer gc) throws SlickException 
	{
		xpos = 50;
		ypos = 50;
		rect = new Rectangle(xpos,ypos,50,50);
		bullet = new Circle(xpos + 50,ypos,10);
		circle = new Circle(300,50,50);
		Cxpos = circle.getX();
		Cypos = circle.getY();
	}

	@Override
	public void update(GameContainer gc, int i) throws SlickException 
	{
		Input input = gc.getInput();
		if(bullet != null && circle != null)
		{
			if(bullet.intersects(circle))
			{
				bullet = null;
				circle = null;
			}
		}
		if(bullet != null)
		{
			if(input.isKeyDown(input.KEY_SPACE))
			{
				fire = true;
			}
			if(fire == true)
			{
				bullet.setX(xpos += 1);
			}
		}
	}

	@Override
	public void render(GameContainer gc, Graphics g) throws SlickException
	{
		Input input = gc.getInput();
		g.setBackground(Color.white);
		g.setColor(Color.red);
		g.fill(rect);
		g.draw(rect);
		g.setColor(Color.blue);
		if(circle != null)
		{
			g.fill(circle);
			g.draw(circle);
		}
		if(bullet != null)
		{
			if(fire == true)
			{
				g.setColor(Color.green);
				g.fill(bullet);
				g.draw(bullet);
			}

		}
		else{
			g.setColor(Color.red);
			g.drawString("KABOOM",(float)Cxpos,(float)Cypos);
		}
	}

	public static void main(String[] args)
	{
		try
		{
			AppGameContainer appgc;
			appgc = new AppGameContainer(new Shooting("Simple Slick Game"));
			appgc.setDisplayMode(640, 480, false);
			appgc.start();
		}
		catch (SlickException ex)
		{
			Logger.getLogger(Shooting.class.getName()).log(Level.SEVERE, null, ex);
		}
	}
}
