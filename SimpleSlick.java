import java.util.logging.Level;
import java.util.logging.Logger;

import org.newdawn.slick.Animation;
import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.BasicGame;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.SpriteSheet;

public class SimpleSlick extends BasicGame
{
	SpriteSheet pokemon;
	Animation pokeAnimation;
	public SimpleSlick(String gamename)
	{
		super(gamename);
	}

	@Override
	public void init(GameContainer gc) throws SlickException {
		pokemon = new SpriteSheet("res/pokemon.png", 130, 176);
		pokeAnimation = new Animation(pokemon, 100);
		}

	@Override
	public void update(GameContainer gc, int i) throws SlickException {
//		pokeAnimation.update(i);
	}

	@Override
	public void render(GameContainer gc, Graphics g) throws SlickException
	{
		pokeAnimation.draw(100, 100);
	}

	public static void main(String[] args)
	{
		try
		{
			AppGameContainer appgc;
			appgc = new AppGameContainer(new SimpleSlick("Simple Slick Game"));
			appgc.setDisplayMode(640, 480, false);
			appgc.start();
		}
		catch (SlickException ex)
		{
			Logger.getLogger(SimpleSlick.class.getName()).log(Level.SEVERE, null, ex);
		}
	}
}

//class Sprite {
//	Animation sprite;
//	Image i1;
//	Sprite() {
//		
//	}
//	
//}
