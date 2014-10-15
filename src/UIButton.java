import java.awt.Color;
import java.awt.Image;


public class UIButton extends UIObject{
	
	Image image; 
	String text;
	Color bgColor;
	
	public UIButton(int x, int y, int width, int height, Image image) {
		this(x, y, width, height, image, "", Color.BLACK);
	}
	
	public UIButton(int x, int y, int width, int height, String text, Color bgColor) {
		this(x, y, width, height, null, text, bgColor);
	}
	
	public UIButton(int x, int y, int width, int height, Image image, String text, Color bgColor) {
		super(x, y, width, height);
		this.image = image;
		this.text = text;
		this.bgColor = bgColor;
	}
}
