import java.awt.Color;
import java.awt.Graphics;

import com.zen_main.GameObject;
import com.zen_main.GamePanel;
import com.zen_main.RenderCamera;


public class ChargeSphereParticle extends GameObject{
	
	int xTarget;
	int yTarget;
	int particleSpeed;
	private double moveAngle;

	boolean flaggedForDelete;
	
	public ChargeSphereParticle(GamePanel parent, int x, int y, int xTarget, int yTarget) {
		super(parent, x, y);
		this.xTarget = xTarget;
		this.yTarget = yTarget;
		flaggedForDelete = false;
		width = parent.randomGen.nextInt(16);
		height = width;
		particleSpeed = 4;
	}
	
	public void update() {
		moveAngle = Math.atan2(yTarget - y, xTarget - x);
		
		x += particleSpeed * Math.cos(moveAngle);
		y += particleSpeed * Math.sin(moveAngle);
	}
	
	public void paint(RenderCamera cam, Graphics g) {
		g.setColor(Color.BLUE);
		g.drawOval(x - cam.x, y - cam.y, width, height);
	}
}
