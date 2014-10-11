import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;


public class UIMenuItem extends UIObject{

	String displayText;
	Image defaultImage;
	
	boolean isSelected;
	Image selectedImage;
	
	public UIMenuItem(int x, int y, int width, int height) {
		this(x, y, width, height, "", null);
	}
	
	public UIMenuItem(int x, int y, int width, int height, Image image) {
		this(x, y, width, height, "", image);
	}
	
	public UIMenuItem(int x, int y, int width, int height, String text) {
		this(x, y, width, height, text, null);
	}
	
	public UIMenuItem(int x, int y, int width, int height, String text, Image image) {
		this(x, y, width, height, text, image, image);
	}
	
	public UIMenuItem(int x, int y, int width, int height, String text, Image defaultImage, Image selectedImage) {
		super(x, y, width, height);
		displayText = text;
		this.defaultImage = defaultImage;
		this.selectedImage = selectedImage;
	}
	
	public void paint(Graphics g) {
		if (isSelected) {
			if (selectedImage != null)
				g.drawImage(selectedImage, x, y, null);
			else {
				g.setColor(Color.RED);
				g.drawString(displayText, x, y);
			}
		}
		else {
			if (selectedImage != null)
				g.drawImage(defaultImage, x, y, null);
			else {
				g.setColor(Color.BLACK);
				g.drawString(displayText, x, y);
			}
		}
	}
}
