import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


public class MainPlayer extends GameObject{
	
	private boolean isJumping;
	
	private boolean isFacingRight;
	private boolean isFacingLeft;

	public MainPlayer(GamePanel parent, int x, int y) {
		super(parent, x,y,32,32, false);
		this.parent = parent;
		Image myImage = Toolkit.getDefaultToolkit().getImage(MainPlayer.class.getResource("player.gif")); 
		setImage(myImage);
		isFacingRight = true;
		isFacingLeft = false;
	}
		
	public void paint(RenderCamera cam, Graphics g) {
		processMove();
		
		if (isJumping) 
			g.setColor(Color.GREEN);
		else if (isFacingLeft)
			g.setColor(Color.RED);
		else if (isFacingRight)
			g.setColor(Color.BLUE);
		
		g.drawOval(x - cam.x, y - cam.y, 32, 32);
		g.drawImage(image, 32, 32, null);
		
		//show which side the character is facing
	}
	
	private void processMove() {
		if (parent.isLeftPressed) {
			xVel = -5;
			isFacingLeft = true;
			isFacingRight = false;
		}
		else if (parent.isRightPressed) {
			xVel = 5;
			isFacingLeft = false;
			isFacingRight = true;
		}
		else {
			if (xVel > 0)
				xVel--;
			else if (xVel < 0)
				xVel++;
			else
				xVel = 0;
		}
		
		x = x + xVel;

		
		//jump
		if (parent.isUpPressed) {
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
}
