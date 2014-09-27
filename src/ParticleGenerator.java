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
	
	private int timerVar;
	private Random generator;
	
	public ParticleGenerator(int x, int y, int particleDensity, int particleSize, Direction particleDirection, int particleAngle, int particleLife, int particleFrequency, int particleSpeed, Image particleImage) {
		super(x,y);
		
		this.particleDensity = particleDensity;
		this.particleSize = particleSize;
		this.particleDirection = particleDirection;
		this.particleAngle = particleAngle;
		this.particleImage = particleImage;
		particleColor = Color.black;
		this.particleLife = particleLife;
		this.particleFrequency = particleFrequency;
		this.particleSpeed = particleSpeed;
		particles = new ArrayList<ParticleGeneratorParticle>();
		particleGravity = 0; 
		
		timerVar = 0;
		generator = new Random();
	}
	
	public ParticleGenerator(int x, int y, int particleDensity, int particleSize, Direction particleDirection, int particleAngle, int particleLife, int particleFrequency, int particleSpeed, Color particleColor) {
		super(x,y);
		
		this.particleDensity = particleDensity;
		this.particleSize = particleSize;
		this.particleDirection = particleDirection;
		this.particleAngle = particleAngle;
		this.particleImage = null;
		this.particleColor = particleColor;
		this.particleLife = particleLife;
		this.particleFrequency = particleFrequency;
		this.particleSpeed = particleSpeed;
		particles = new ArrayList<ParticleGeneratorParticle>();
		particleGravity = 0;
		
		timerVar = 0;
		generator = new Random();
	}
	
	public ParticleGenerator(int x, int y, int particleDensity, int particleSize, Direction particleDirection, int particleAngle, int particleLife, int particleFrequency, int particleSpeed) {
		this(x, y, particleDensity, particleSize, particleDirection, particleAngle, particleLife, particleFrequency, particleSpeed, Color.black);
	}
	
	public void update() {
		//add particles if we haven't hit the particle Density cap
		if (timerVar != particleFrequency) {
			timerVar++;
		}
		else {
			//if we haven't hit the density cap, add a particle
			if (particles.size() <= particleDensity) {
				int targetY = 0; 
				int targetX = 0;
				
				//TODO: PROGRAM OTHER DIRECTIONS SUCH AS DOWN, LEFT, ETC
				if (particleDirection == Direction.UP || particleDirection == Direction.NORTH) {
					targetY = y - 1000;
					int angleVal = generator.nextInt(particleAngle);
					System.out.println(angleVal + " - " + Math.tan(angleVal/2.0));
					if (generator.nextBoolean())
						targetX = x + (int) (Math.tan(angleVal/2.0) * 1000.0);
					else
						targetX = x - (int) (Math.tan(angleVal/2.0) * 1000.0);
				}
				Point targetPoint = new Point(targetX, targetY);
				
				particles.add(new ParticleGeneratorParticle(x-particleSize/2, y-particleSize/2, particleSize, particleLife, particleSpeed, particleGravity, targetPoint, particleColor, particleImage));
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
	}
	
	public void setParticleGravity(int particleGravity) {
		this.particleGravity = particleGravity;
	}
	
}
