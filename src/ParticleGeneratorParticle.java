import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;


public class ParticleGeneratorParticle extends GameObject{
	boolean flaggedForDelete;
	double particleSize;
	int particleLife;
	int particleSpeed;
	int particleGravity;
	Point particleTarget;
	Color particleColor;
	Image particleImage;
	boolean isSolidParticle;
	boolean isGrowParticle;
	
	double growRate;
	
	private double gravPull;
	private double moveAngle;
	
	public ParticleGeneratorParticle(
			GamePanel parent,
			int x,
			int y,
			int particleSize,
			int particleLife,
			int particleSpeed,
			int particleGravity,
			boolean isSolidParticle,
			boolean isGrowParticle,
			Point particleTarget,
			Color particleColor,
			Image particleImage) {
		super(parent, x, y);
		this.particleSize = particleSize;
		this.particleLife = particleLife;
		this.particleSpeed = particleSpeed;
		this.particleGravity = particleGravity;
		this.particleTarget = particleTarget;
		this.particleColor = particleColor;
		this.particleImage = particleImage;
		
		this.isSolidParticle = isSolidParticle;
		this.isGrowParticle = isGrowParticle;
		
		flaggedForDelete = false;
		gravPull = 0;
		growRate = 2;
		moveAngle = Math.atan2(particleTarget.y - y, particleTarget.x - x);
	}
	
	public ParticleGeneratorParticle(GamePanel parent, int x, int y) {
		this(parent, x, y, 2, 10, 5, 0, false, false, new Point(x, y - 10), Color.black, null);
	}
	
	public void setGrowRate(double growRate) {
		this.growRate = growRate;
	}
	
	public void update() {
		//TODO: IMPLEMENT SOLID PARTICLE PHYSICS
		
		if (isGrowParticle) {
			particleSize = particleSize + growRate;
		}
		
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
		if (particleImage == null) {
			g.setColor(particleColor);
			g.fillOval(x - cam.x, y - cam.y, (int)particleSize, (int)particleSize);
		}
		else {
			g.drawImage(particleImage, x - cam.x, y - cam.y, null);
		}
	}
}
