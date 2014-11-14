import java.util.logging.Level;
import java.util.logging.Logger;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.BasicGame;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Rectangle;

public class Game extends BasicGame
{
	Player x;
	Rectangle rect = null;
	Projectile y;
	boolean fire;
	int rx = 100;
	int ry = 100;
	int rh = 50;
	int rw = 50;
	public Game(String gamename)
	{
		super(gamename);
	}

	@Override
	public void init(GameContainer gc) throws SlickException {
		x = new Player(100, 100, 100, 100);
		y = new Projectile(x.posx, x.posy, 10);
		rect = new Rectangle(rx, ry, rh, rw);
	}

	@Override
	public void update(GameContainer gc, int i) throws SlickException {
		Input input = gc.getInput();
		if(!x.isNull()) {
			if(input.isKeyPressed(Input.KEY_ESCAPE)) gc.exit();
			if(input.isKeyDown(Input.KEY_W)) {
				x.moveUp(10);
			}
			if(input.isKeyDown(Input.KEY_S)) {
				x.moveDown(10);
			}
			if(input.isKeyDown(Input.KEY_A)) {
				x.moveLeft(10);
			}
			if(input.isKeyDown(Input.KEY_D)) {
				x.moveRight(10);
			}
			if(y != null) {
				if(input.isKeyDown(Input.KEY_Q)) {
					fire = true;
				}
				if(fire == true) {
					y.circle.setX(y.xpos += 1);
				}
			}
			if(input.isKeyDown(Input.KEY_EQUALS)) x.destroy();
			if(x.intersection(rect)) x.damage(1);
			if(x.returnHealth() == 0) x.destroy();
		}
		else {
			if(input.isKeyPressed(Input.KEY_ESCAPE)) {
				gc.exit();
			}
		}
	}

	@Override
	public void render(GameContainer gc, Graphics g) throws SlickException
	{
		if(!x.isNull()) {
			x.draw();
			g.draw(x.rect);
			g.draw(rect);
			g.drawString("Health: " + Integer.toString(x.returnHealth()), 0, 50);
			g.setColor(Color.red);
			g.fillRect(x.healthBar.getX(), x.healthBar.getY(), x.returnHealth(), x.healthBar.getHeight());
			g.setColor(Color.blue);
			g.fillRect(x.manaBar.getX(), x.manaBar.getY(), x.returnMana(), x.manaBar.getHeight());
			g.setColor(Color.white);
		}
		else {
			g.draw(rect);
		}
		if(y != null)
		{
			if(fire == true)
			{
				g.setColor(Color.green);
				g.fill(y.circle);
				g.draw(y.circle);
			}

		}
	}

	public static void main(String[] args)
	{
		try
		{
			AppGameContainer appgc;
			appgc = new AppGameContainer(new Game("Game"));
			appgc.setDisplayMode(640, 480, false);
			appgc.setTargetFrameRate(60);
			//			appgc.setVSync(true);
			appgc.setShowFPS(false);
			//			appgc.setFullscreen(true);
			appgc.start();
		}
		catch (SlickException ex)
		{
			Logger.getLogger(Game.class.getName()).log(Level.SEVERE, null, ex);
		}
	}
}