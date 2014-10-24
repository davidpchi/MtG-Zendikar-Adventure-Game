import java.awt.Color;
import java.awt.Graphics;
import java.util.Date;
import java.util.Random;


public class UIHealthbar extends UIObject{
	
	Color startColor;
	Color endColor;
	Color bgColor;
	int percent;
	
	public UIHealthbar(GamePanel parent, int x, int y, int width, int height, Color startColor, Color endColor, Color bgColor) {
		super(parent, x, y, width, height);
		this.startColor = startColor;
		this.endColor = endColor;
		this.bgColor = bgColor;
		percent = 100;
	}
	
	public UIHealthbar(GamePanel parent, int x, int y, int width, int height) {
		this(parent, x, y, width, height, Color.red, Color.green, Color.black);
	}
	
	public void update() {
		
	}
	
	public void paint(Graphics g) {
		g.setColor(bgColor);
		g.fillRect(x, y, width, height);
		
		double ratio = percent / 100.0;
		
		int red = (int)Math.abs((ratio * endColor.getRed()) + ((1 - ratio) * startColor.getRed()));
		int green = (int)Math.abs((ratio * endColor.getGreen()) + ((1 - ratio) * startColor.getGreen()));
		int blue = (int)Math.abs((ratio * endColor.getBlue()) + ((1 - ratio) * startColor.getBlue()));
		
		g.setColor(new Color(red,green,blue));
		g.fillRect(x, y, (int) (ratio * width), height);
	}
}
