import java.awt.Graphics;


public abstract class UIObject {
	int x;
	int y; 
	int width;
	int height;
	
	public UIObject(int x, int y, int width, int height) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	}
	
	public UIObject(int x, int y) {
		this(x,y,0,0);
	}
	
	public void update() {
		
	}
	
	public void paint(Graphics g) {
		g.drawRect(x, y, width, height);
	}
}
