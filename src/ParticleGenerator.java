import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.util.ArrayList;
import java.util.Random;


public class ParticleGenerator extends GameObject{

	int particleDensity;
	int particleSize;
	Direction particleDirection;
	int particleAngle;
	int particleLife;
	int particleFrequency;
	int particleSpeed;
	Image particleImage;
	Color particleColor;
	ArrayList<ParticleGeneratorParticle> particles; 
	int particleGravity;
	double growRate;
	
	boolean isGrowParticle;
	boolean isOneShot;
	boolean isSolidParticle;
	
	private int timerVar;
	private Random generator;
	
	private int targetX;
	private int targetY;
	
	public ParticleGenerator(GamePanel parent, int x, int y, int particleDensity, int particleSize, Direction particleDirection, int particleAngle, int particleLife, int particleFrequency, int particleSpeed, Image particleImage) {
		this(parent, x, y, particleDensity, particleSize, particleDirection, particleAngle, particleLife, particleFrequency, particleSpeed, Color.black, particleImage);
	}
	
	public ParticleGenerator(GamePanel parent, int x, int y, int particleDensity, int particleSize, Direction particleDirection, int particleAngle, int particleLife, int particleFrequency, int particleSpeed, Color particleColor) {
		this(parent, x, y, particleDensity, particleSize, particleDirection, particleAngle, particleLife, particleFrequency, particleSpeed, particleColor, null);
	}
	
	public ParticleGenerator(GamePanel parent, int x, int y, int particleDensity, int particleSize, Direction particleDirection, int particleAngle, int particleLife, int particleFrequency, int particleSpeed, Color particleColor, Image particleImage) {
		super(parent, x, y);

		this.particleDensity = particleDensity;
		this.particleSize = particleSize;
		this.particleDirection = particleDirection;
		this.particleAngle = particleAngle;
		this.particleImage = particleImage;
		this.particleColor = particleColor;
		this.particleLife = particleLife;
		this.particleFrequency = particleFrequency;
		this.particleSpeed = particleSpeed;
		particles = new ArrayList<ParticleGeneratorParticle>();
		particleGravity = 0;
		growRate = 2;
		
		isOneShot = false;
		isSolidParticle = false;
		isGrowParticle = false;
		
		timerVar = 0;
		generator = new Random();
	}
 
	
	public ParticleGenerator(GamePanel parent, int x, int y, int particleDensity, int particleSize, Direction particleDirection, int particleAngle, int particleLife, int particleFrequency, int particleSpeed) {
		this(parent, x, y, particleDensity, particleSize, particleDirection, particleAngle, particleLife, particleFrequency, particleSpeed, Color.black);
	}
	
	public void update() {
		//add particles if we haven't hit the particle Density cap
		if (timerVar != particleFrequency) {
			timerVar++;
		}
		else {
			//if we haven't hit the density cap, add a particle
			if (particles.size() <= particleDensity) {
				targetY = 0; 
				targetX = 0;
				
				int angleVal = (int)Math.toRadians(generator.nextInt(particleAngle));
				
				if (particleDirection == Direction.UP || particleDirection == Direction.NORTH) {
					targetY = y - 1000;
					
					if (generator.nextBoolean())
						targetX = x + (int) (Math.tan(angleVal/2.0) * 1000.0);
					else
						targetX = x - (int) (Math.tan(angleVal/2.0) * 1000.0);
				}
				else if (particleDirection == Direction.LEFT || particleDirection == Direction.WEST) {
					targetX = x - 1000;
					
					if (generator.nextBoolean())
						targetY = y + (int) (Math.tan(angleVal/2.0) * 1000.0);
					else
						targetY = y - (int) (Math.tan(angleVal/2.0) * 1000.0);
				}
				else if (particleDirection == Direction.RIGHT || particleDirection == Direction.EAST){
					targetX = x + 1000;
					
					if (generator.nextBoolean())
						targetY = y + (int) (Math.tan(angleVal/2.0) * 1000.0);
					else
						targetY = y - (int) (Math.tan(angleVal/2.0) * 1000.0);
				}
				else if (particleDirection == Direction.DOWN || particleDirection == Direction.SOUTH){
					targetY = y + 1000;
					
					if (generator.nextBoolean())
						targetX = x + (int) (Math.tan(angleVal/2.0) * 1000.0);
					else
						targetX = x - (int) (Math.tan(angleVal/2.0) * 1000.0);
				}
				
				Point targetPoint = new Point(targetX, targetY);
				
				ParticleGeneratorParticle newParticle = new ParticleGeneratorParticle(
						parent, 
						x-particleSize/2,
						y-particleSize/2,
						particleSize,
						particleLife,
						particleSpeed,
						particleGravity,
						isSolidParticle,
						isGrowParticle,
						targetPoint,
						particleColor,
						particleImage);
				newParticle.setGrowRate(growRate);
				
				particles.add(newParticle);
			}
			timerVar = 0;
		}
		
		//loop through all existing particles and see which ones are marked for deletion
		ArrayList<ParticleGeneratorParticle> particlesToDelete = new ArrayList<ParticleGeneratorParticle>();
		for (int i = 0; i < particles.size(); i++) {
			if (particles.get(i).flaggedForDelete) {
				particlesToDelete.add(particles.get(i));
			}
			else {
				particles.get(i).update();
			}
		}
		
		//delete all particles that are marked for deletion
		for (int i = 0; i < particlesToDelete.size(); i++) {
			particles.remove(particlesToDelete.get(i));
		}
	}
	
	public void paint(RenderCamera cam, Graphics g) {
		for (int i = 0 ;i < particles.size(); i++) {
			particles.get(i).paint(cam, g);
		}
		
		//TODO: DEBUG TO SEE RANGE OF PARTICLES
		g.drawLine(x-cam.x,y-cam.y,targetX-cam.x, targetY-cam.y);
	}
	
	public void setParticleGravity(int particleGravity) {
		this.particleGravity = particleGravity;
	}
	
	public void setIsOneShot(boolean isOneShot) {
		this.isOneShot = isOneShot;
	}
	
	public void setIsSolidParticle(boolean isSolidParticle) {
		this.isSolidParticle = isSolidParticle;
	}
	
	public void setIsGrowParticle(boolean isGrowParticle) {
		this.isGrowParticle = isGrowParticle;
	}
	
}
