import java.awt.Color;
import java.awt.Graphics;



public class UIText extends UIObject{
	String displayText;
	Color textColor;
	
	public UIText(GamePanel parent, int x, int y, String displayText) {
		this(parent, x, y, displayText, Color.BLACK);
	}
	
	public UIText(GamePanel parent, int x, int y, String displayText, Color textColor) {
		super(parent, x, y);
		this.displayText = displayText;
		this.textColor = textColor;
	}
	
	public void paint(Graphics g) {
		g.setColor(textColor);
		g.drawString(displayText, x, y);
	}
}
