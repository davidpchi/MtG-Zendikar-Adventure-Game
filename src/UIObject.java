import java.awt.Graphics;
import java.awt.Point;


public abstract class UIObject {
	int x;
	int y; 
	int width;
	int height;
	
	GamePanel parent;
	
	public UIObject(GamePanel parent, int x, int y, int width, int height) {
		this.parent = parent;
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	}
	
	public UIObject(GamePanel parent, int x, int y) {
		this(parent, x, y, 0, 0);
	}
	
	public void update() {
		
	}
	
	public void paint(Graphics g) {
		g.drawRect(x, y, width, height);
	}
	
	public static boolean isClickInsideBounds(Point point, UIObject obj) {
		return ((point.x > obj.x) &&
				(point.y > obj.y)&&
				(point.y < obj.y + obj.height) &&
				(point.x < obj.x + obj.width));
	}
}
