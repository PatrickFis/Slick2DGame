import org.newdawn.slick.geom.Circle;


public class Projectile {
	int xpos, ypos, radius;
	Circle circle;
	Projectile() {
		xpos = 0;
		ypos = 0;
		radius = 0;
		circle = new Circle(xpos, ypos, radius);
	}
	Projectile(int xpos, int ypos, int radius) {
		this.xpos = xpos;
		this.ypos = ypos;
		this.radius = radius;
		circle = new Circle(xpos, ypos, radius);
	}
	void moveX(int x) {
		xpos += x;
	}
	void moveY(int y) {
		ypos += y;
	}
}
