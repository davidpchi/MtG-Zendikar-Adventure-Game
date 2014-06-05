import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class MainPlayer extends GameObject{
	
	private boolean isLeftPressed;
	private boolean isRightPressed;
	private boolean isUpPressed;
	private boolean isDownPressed;
	
	public MainPlayer(int x, int y) {
		super(x,y,32,32);
		Image myImage = Toolkit.getDefaultToolkit().getImage(MainPlayer.class.getResource("player.gif")); 
		setImage(myImage);
	}
	
	public void paint(Graphics g) {
		processMove();
		
		g.setColor(Color.RED);
		g.drawOval(x,y,32,32);
		g.drawImage(image, 32, 32, null);
	}
	
	private void processMove() {
		if (isLeftPressed)
			x = x - 5;
		if (isRightPressed) 
			x = x + 5;
		if (isUpPressed)
			y = y - 5;
		if (isDownPressed)
			y = y + 5;
	}
	
	public void leftPressed() {
		isLeftPressed = true;
	}
	
	public void rightPressed() {
		isRightPressed = true;
	}
	
	public void upPressed() {
		isUpPressed = true;
	}
	
	public void downPressed() {
		isDownPressed = true;
	}
	
	public void leftReleased() {
		isLeftPressed = false;
	}
	
	public void rightReleased() {
		isRightPressed = false;
	}
	
	public void upReleased() {
		isUpPressed = false;
	}
	
	public void downReleased() {
		isDownPressed = false;
	}
}
