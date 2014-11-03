import java.awt.Image;

import com.zen_main.GameObject;
import com.zen_main.GamePanel;



public class WallObject extends GameObject{
	public WallObject(GamePanel parent, int x, int y, int width, int height, Image image) {
		super(parent, x,y,width,height,true);
		setImage(image);
	}
}
