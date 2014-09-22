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
	private boolean isJumping;
	private GamePanel parent;

	public MainPlayer(int x, int y, GamePanel parent) {
		super(x,y,32,32, false);
		this.parent = parent;
		Image myImage = Toolkit.getDefaultToolkit().getImage(MainPlayer.class.getResource("player.gif")); 
		setImage(myImage);
	}
		
	public void paint(RenderCamera cam, Graphics g) {
		processMove();
		
		g.setColor(Color.RED);
		g.drawOval(x - cam.x, y - cam.y, 32, 32);
		g.drawImage(image, 32, 32, null);
	}
	
	private void processMove() {
		if (isLeftPressed) {
			xVel = -5;
		}
		else if (isRightPressed) {
			xVel = 5;
		}
		else {
			xVel = 0;
		}
		
		x = x + xVel;

		
		//jump
		if (isUpPressed) {
			if (isJumping == false) {
				isJumping = true;
				yVel = 20;
			}
		}
		if (isJumping) {
			y = y - yVel;
			yVel--;
		}
				
		//hit the ground
		GameObject temp;
		isJumping = true;
		for (int i = 0; i < parent.gameObjs.size(); i++) {
			temp = parent.gameObjs.get(i);
			if (temp.isSolid == true) {
				if (isColliding(temp)) {
					isJumping = false;
					yVel = 0;
				}
			}
		}
		//if (isDownPressed)
		//	y = y + 5;
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
