import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;


public abstract class GameObject {
	int x;
	int y;
	int width;
	int height;
	Image image;
	boolean isSolid;
	
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
	}
	
	public void setImage(Image image) {
		this.image = image;
	}
	
	public void paint(Graphics g) {
		g.setColor(Color.RED);
		g.drawRect(x, y, width, height);
	}
	
	public boolean isColliding(GameObject other) {
		boolean xValid = false;
		boolean yValid = false;
		
		if ((x+width > other.x && x+width < other.x + other.width) || 
			(x > other.x && x < other.x + other.width)) {
			xValid = true;
		}
		
		if ((y+height > other.y && y+height < other.y+other.height) ||
			(y > other.y && y < other.y + other.height)) {
			yValid = true;
		}
		
		return (xValid && yValid);
	}
}
