import java.awt.Image;


public abstract class GameObject {
	int x;
	int y;
	int width;
	int height;
	Image image;
	
	public GameObject() {
		this(0,0,32,32, null);
	}
	
	public GameObject(int x, int y) {
		this(x,y,32,32, null);
	}
	
	public GameObject(int x, int y, int width, int height, Image image) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.image = image;
		
	}
}
