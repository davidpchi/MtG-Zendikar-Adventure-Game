import java.awt.Image;


public class WallObject extends GameObject{
	public WallObject(int x, int y, int width, int height, Image image) {
		super(x,y,width,height,true);
		setImage(image);
	}
}
