import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.newdawn.slick.Animation;
import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.BasicGame;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.SpriteSheet;
import org.newdawn.slick.geom.Circle;
import org.newdawn.slick.geom.Rectangle;

public class SimpleSlick extends BasicGame
{
	//	SpriteSheet pokemon;
	//	Animation pokeAnimation;
	Player x;
	Projectile y;
	Circle circle = null;
	Rectangle rect = null;
	int xpos = 200;
	int ypos = 200;
	int radius = 50;
	int rx = 100;
	int ry = 100;
	int rh = 50;
	int rw = 50;
	public SimpleSlick(String gamename)
	{
		super(gamename);
	}

	@Override
	public void init(GameContainer gc) throws SlickException {
		//		pokemon = new SpriteSheet("res/pokemon.png", 120, 176);
		//		pokeAnimation = new Animation(pokemon, 100);
		x = new Player(100, 100, 100, 100);
		y = new Projectile(10, 10, 10);
		circle = new Circle(xpos, ypos, radius);
		rect = new Rectangle(rx, ry, rh, rw);
	}

	@Override
	public void update(GameContainer gc, int i) throws SlickException {
		//		pokeAnimation.update(i);
		Input input = gc.getInput();
		if(!x.isNull()) {
			if(input.isKeyPressed(Input.KEY_ESCAPE)) gc.exit();
			if(input.isKeyDown(Input.KEY_W)) {
				circle.setY(ypos -= 10);
				x.moveUp(10);
			}
			if(input.isKeyDown(Input.KEY_S)) {
				circle.setY(ypos += 10);
				x.moveDown(10);
			}
			if(input.isKeyDown(Input.KEY_A)) {
				circle.setX(xpos -= 10);
				x.moveLeft(10);
			}
			if(input.isKeyDown(Input.KEY_D)) {
				circle.setX(xpos += 10);
				x.moveRight(10);
			}
			if(input.isKeyDown(Input.KEY_Q)) circle.setRadius(radius += 10);
			if(input.isKeyDown(Input.KEY_E)) circle.setRadius(radius -= 10);
			if(input.isKeyDown(Input.KEY_EQUALS)) x.destroy();
			if(circle.intersects(rect)) {
				if(xpos >= rect.getX()) circle.setX(xpos++);
				else circle.setX(xpos--);
				if(ypos >= rect.getY()) circle.setY(ypos++);
				else circle.setY(ypos--);
			}
			if(xpos > 640) xpos = 0;
			if(ypos > 480) ypos = 0;
			if(xpos < 0) xpos = 640;
			if(ypos < 0) ypos = 480;
			if(x.intersection(rect)) x.damage(1);
			if(x.returnHealth() == 0) x.destroy();
		}
		else {
			if(input.isKeyPressed(Input.KEY_ESCAPE)) {
				gc.exit();
			}
			if(input.isKeyDown(Input.KEY_W)) circle.setY(ypos -= 10);
			if(input.isKeyDown(Input.KEY_S)) circle.setY(ypos += 10);
			if(input.isKeyDown(Input.KEY_A)) circle.setX(xpos -= 10);
			if(input.isKeyDown(Input.KEY_D)) circle.setX(xpos += 10);
			if(input.isKeyDown(Input.KEY_Q)) circle.setRadius(radius += 10);
			if(input.isKeyDown(Input.KEY_E)) circle.setRadius(radius -= 10);
			if(circle.intersects(rect)) {
				if(xpos >= rect.getX()) circle.setX(xpos++);
				else circle.setX(xpos--);
				if(ypos >= rect.getY()) circle.setY(ypos++);
				else circle.setY(ypos--);
			}
			if(xpos > 640) xpos = 0;
			if(ypos > 480) ypos = 0;
			if(xpos < 0) xpos = 640;
			if(ypos < 0) ypos = 480;
		}
	}

	@Override
	public void render(GameContainer gc, Graphics g) throws SlickException
	{
		if(!x.isNull()) {
			x.draw();
			g.draw(x.rect);
			//		Random rand = new Random();
			//		Color random = new Color(rand.nextInt(), rand.nextInt(), rand.nextInt());
			//		g.setColor(random);
			//		g.fill(circle);
			g.draw(circle);
			g.draw(rect);
			//		g.setColor(Color.white);
			g.drawString(Float.toString(circle.getX()), 0, 10);
			g.drawString(Float.toString(circle.getY()), 0, 25);
			g.drawString("Health: " + Integer.toString(x.returnHealth()), 0, 50);
			//		Random rand = new Random();
			//		Color random = new Color(rand.nextInt(), rand.nextInt(), rand.nextInt());
			//		g.setBackground(random);
		}
		else {
			g.draw(circle);
			g.draw(rect);
			g.drawString(Float.toString(circle.getX()), 0, 10);
			g.drawString(Float.toString(circle.getY()), 0, 25);
		}
	}

	public static void main(String[] args)
	{
		try
		{
			AppGameContainer appgc;
			appgc = new AppGameContainer(new SimpleSlick("Simple Slick Game"));
			appgc.setDisplayMode(640, 480, false);
			appgc.setTargetFrameRate(60);
			//			appgc.setVSync(true);
			appgc.setShowFPS(false);
			//			appgc.setFullscreen(true);
			appgc.start();
		}
		catch (SlickException ex)
		{
			Logger.getLogger(SimpleSlick.class.getName()).log(Level.SEVERE, null, ex);
		}
	}
}