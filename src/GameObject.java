import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;


public abstract class GameObject {
	int x;
	int y;
	int width;
	int height;
	Image image;
	
	public GameObject() {
		this(0,0,32,32);
	}
	
	public GameObject(int x, int y) {
		this(x,y,32,32);
	}

	public GameObject(int x, int y, int width, int height) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	}
	
	public void setImage(Image image) {
		this.image = image;
	}
	
	public void paint(Graphics g) {
		g.setColor(Color.RED);
		g.drawOval(x, y, width, height);
	}
}
