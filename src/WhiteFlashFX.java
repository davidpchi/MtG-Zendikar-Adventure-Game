import java.awt.Color;
import java.awt.Graphics;

import com.zen_main.GameObject;
import com.zen_main.GamePanel;
import com.zen_main.RenderCamera;


public class WhiteFlashFX extends GameObject{
	int flashSpeed;
	int flashCounter;
	int alphaTransparency;
	
	public WhiteFlashFX(GamePanel parent, int flashSpeed) {
		super(parent, 0, 0, parent.myWidth, parent.myHeight, false);
		this.flashSpeed = flashSpeed;
		flashCounter = 0;
		alphaTransparency = 255;
	}
	
	public void paint(RenderCamera cam, Graphics g) {
		g.setColor(new Color(255,255,255, alphaTransparency));
		g.fillRect(x, y, width, height);
	}
	
	public void update() {
		if (flashCounter < flashSpeed) {
			flashCounter++;
			alphaTransparency--;
		}
	}
}
