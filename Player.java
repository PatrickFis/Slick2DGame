import org.newdawn.slick.Animation;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.SpriteSheet;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.geom.Shape;


class Player {
	int posx, posy, health, mana;
	SpriteSheet pokemon;
	Animation pokeAnimation;
	Rectangle rect;
	Rectangle healthBar;
	Rectangle manaBar;
	Player() throws SlickException {
		posx = 0;
		posy = 0;
		health = 0;
		mana = 0;
		pokemon = new SpriteSheet("res/pokemon.png", 120, 176);
		pokeAnimation = new Animation(pokemon, 100);
		rect = new Rectangle(posx, posy, 120, 176);
		healthBar = new Rectangle(10, 10, 100, 10);
		manaBar = new Rectangle(10, 20, 100, 10);
	}
	Player(int posx, int posy, int health, int mana) throws SlickException {
		this.posx = posx;
		this.posy = posy;
		this.health = health;
		this.mana = mana;
		pokemon = new SpriteSheet("res/pokemon.png", 120, 176);
		pokeAnimation = new Animation(pokemon, 100);
		rect = new Rectangle(posx, posy, 120, 176);
		healthBar = new Rectangle(10, 10, 100, 10);
		manaBar = new Rectangle(10, 20, 100, 10);
	}
	void draw() {
		pokeAnimation.draw(posx, posy);
	}
	void moveRight(int move) {
		posx += move;
		rect.setX(posx);
	}
	void moveLeft(int move) {
		posx -= move;
		rect.setX(posx);
	}
	void moveUp(int move) {
		posy -= move;
		rect.setY(posy);
	}
	void moveDown(int move) {
		posy += move;
		rect.setY(posy);
	}
	boolean intersection(Shape shape) {
		if(rect.intersects(shape)) return true;
		else return false;
	}
	int returnHealth() {
		return health;
	}
	int returnMana() {
		return mana;
	}
	void damage(int damage) {
		health -= damage;
	}
	void destroy() {
		pokeAnimation = null;
	}
	boolean isNull() {
		return pokeAnimation == null;
	}
}