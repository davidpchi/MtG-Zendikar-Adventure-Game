import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;


public class ParticleGeneratorParticle extends GameObject{
	boolean flaggedForDelete;
	int particleSize;
	int particleLife;
	int particleSpeed;
	int particleGravity;
	Point particleTarget;
	Color particleColor;
	Image particleImage;
	
	private double gravPull;
	private double moveAngle;
	
	public ParticleGeneratorParticle(int x, int y, int particleSize, int particleLife, int particleSpeed, int particleGravity, Point particleTarget, Color particleColor, Image particleImage) {
		this.x = x;
		this.y = y;
		this.particleSize = particleSize;
		this.particleLife = particleLife;
		this.particleSpeed = particleSpeed;
		this.particleGravity = particleGravity;
		this.particleTarget = particleTarget;
		this.particleColor = particleColor;
		this.particleImage = particleImage;
		
		flaggedForDelete = false;
		gravPull = 0;
		moveAngle = Math.atan2(particleTarget.y - y, particleTarget.x - x);
	}
	
	public ParticleGeneratorParticle(int x, int y) {
		this(x, y, 2, 10, 5, 0, new Point(x, y - 10), Color.black, null);
	}
	
	public void update() {
		x += particleSpeed * Math.cos(moveAngle);
		y += particleSpeed * Math.sin(moveAngle);
		
		if (particleGravity > 0) {
			y += gravPull;
			gravPull+= particleGravity/10.0;
		}
		
		if (particleLife > 0) {
			particleLife--;
		}
		else {
			flaggedForDelete = true;
		}
	}
	
	public void paint(RenderCamera cam, Graphics g) {
		g.setColor(particleColor);
		g.fillOval(x - cam.x, y - cam.y, particleSize, particleSize);
	}
}
