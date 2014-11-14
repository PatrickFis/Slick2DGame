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

public class SimpleSlick extends BasicGame
{
	SpriteSheet pokemon;
	Animation pokeAnimation;
	Circle circle = null;
	int xpos = 200;
	int ypos = 200;
	int radius = 50;
	public SimpleSlick(String gamename)
	{
		super(gamename);
	}

	@Override
	public void init(GameContainer gc) throws SlickException {
		pokemon = new SpriteSheet("res/pokemon.png", 120, 176);
		pokeAnimation = new Animation(pokemon, 100);
		circle = new Circle(xpos, ypos, radius);
		}

	@Override
	public void update(GameContainer gc, int i) throws SlickException {
//		pokeAnimation.update(i);
		Input input = gc.getInput();
		if(input.isKeyPressed(Input.KEY_ESCAPE)) {
			gc.exit();
		}
		if(input.isKeyDown(Input.KEY_W)) {
			circle.setY(ypos -= 10);
		}
		if(input.isKeyDown(Input.KEY_S)) {
			circle.setY(ypos += 10);
		}
		if(input.isKeyDown(Input.KEY_A)) {
			circle.setX(xpos -= 10);
		}
		if(input.isKeyDown(Input.KEY_D)) {
			circle.setX(xpos += 10);
		}
		if(input.isKeyDown(Input.KEY_Q)) {
			circle.setRadius(radius += 10);
		}
		if(input.isKeyDown(Input.KEY_E)) {
			circle.setRadius(radius -= 10);
		}
	}

	@Override
	public void render(GameContainer gc, Graphics g) throws SlickException
	{
//		pokeAnimation.draw(100, 100);
		g.draw(circle);
//		Random rand = new Random();
//		Color random = new Color(rand.nextInt(), rand.nextInt(), rand.nextInt());
//		g.setBackground(random);
	}

	public static void main(String[] args)
	{
		try
		{
			AppGameContainer appgc;
			appgc = new AppGameContainer(new SimpleSlick("Simple Slick Game"));
			appgc.setDisplayMode(640, 480, false);
			appgc.setTargetFrameRate(30);
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
