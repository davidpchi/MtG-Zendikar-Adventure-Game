import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;


public abstract class GameObject {
	int x;
	int y;
	int width;
	int height;
	int yVel;
	int xVel;
	Image image;
	boolean isSolid;
	
	public enum Direction {
	    NORTH, SOUTH, EAST, WEST, UP, DOWN, LEFT, RIGHT
	}
	
	public GameObject() {
		this(0,0,32,32, false);
	}
	
	public GameObject(int x, int y) {
		this(x,y,32,32, false);
	}

	public GameObject(int x, int y, int width, int height, boolean isSolid) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.isSolid = isSolid;
		this.yVel = 0;
		this.xVel = 0;
	}
	
	public void setImage(Image image) {
		this.image = image;
	}
	
	public void update() {

	}
	
	public void paint(RenderCamera cam, Graphics g) {
		g.setColor(Color.RED);
		g.drawRect(x - cam.x, y - cam.y, width, height);
	}
	
	public boolean isColliding(GameObject other) {
		boolean xValid = false;
		boolean yValid = false;
		
		//this handles complete collisions
		if ((x+width > other.x && x+width < other.x + other.width) || 
			(x > other.x && x < other.x + other.width)) {
			xValid = true;
		}
		
		if ((y+height > other.y && y+height < other.y+other.height) ||
			(y > other.y && y < other.y + other.height)) {
			yValid = true;
		}
		
		//this handles collision clipping issues
		for (int i = 0; i < Math.abs(yVel); i++) {
			if ((y+height+i > other.y && y+height+i < other.y+other.height) ||
					(y-i > other.y && y-i < other.y + other.height)) {
					yValid = true;
			}
		}
		
		//this handles complete collisions
		if ((x+width > other.x && x+width < other.x + other.width) || 
			(x > other.x && x < other.x + other.width)) {
			xValid = true;
		}
		
		return (xValid && yValid);
	}
}
