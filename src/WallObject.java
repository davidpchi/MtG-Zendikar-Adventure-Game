import java.awt.Image;


public class WallObject extends GameObject{
	public WallObject(GamePanel parent, int x, int y, int width, int height, Image image) {
		super(parent, x,y,width,height,true);
		setImage(image);
	}
}
