import java.awt.Color;
import java.awt.Image;
import java.awt.Point;
import java.util.ArrayList;

import com.sun.xml.internal.bind.v2.schemagen.xmlschema.Particle;


public class ParticleGenerator extends GameObject{
	
	public enum Direction {
	    NORTH, SOUTH, EAST, WEST, UP, DOWN, LEFT, RIGHT
	}
	
	int particleDensity;
	int particleSize;
	Direction particleDirection;
	int particleAngle;
	int particleLife;
	int particleFrequency;
	Image particleImage;
	Color particleColor;
	ArrayList<ParticleGeneratorParticle> particles; 
	int particleGravity;
	
	private int timerVar;
	
	public ParticleGenerator(int x, int y, int particleDensity, int particleSize, Direction particleDirection, int particleAngle, int particleLife, int particleFrequency, Image particleImage) {
		super(x,y);
		
		this.particleDensity = particleDensity;
		this.particleSize = particleSize;
		this.particleDirection = particleDirection;
		this.particleAngle = particleAngle;
		this.particleImage = particleImage;
		particleColor = Color.black;
		this.particleLife = particleLife;
		this.particleFrequency = particleFrequency;
		particles = new ArrayList<ParticleGeneratorParticle>();
		particleGravity = 0; 
		timerVar = 0;
	}
	
	public ParticleGenerator(int x, int y, int particleDensity, int particleSize, Direction particleDirection, int particleAngle, int particleLife, int particleFrequency, Color particleColor) {
		super(x,y);
		
		this.particleDensity = particleDensity;
		this.particleSize = particleSize;
		this.particleDirection = particleDirection;
		this.particleAngle = particleAngle;
		this.particleImage = null;
		this.particleColor = particleColor;
		this.particleLife = particleLife;
		this.particleFrequency = particleFrequency;
		particles = new ArrayList<ParticleGeneratorParticle>();
		particleGravity = 0;
		
		timerVar = 0;
	}
	
	public ParticleGenerator(int x, int y, int particleDensity, int particleSize, Direction particleDirection, int particleAngle, int particleLife, int particleFrequency) {
		this(x, y, particleDensity, particleSize, particleDirection, particleAngle, particleLife, particleFrequency, Color.black);
	}
	
	public void update() {
		//add particles if we haven't hit the particle Density cap
		if (timerVar != particleFrequency) {
			timerVar++;
		}
		else {
			//TODO: using direction and angle, calculate a point to have the particle move toward
			Point targetPoint = new Point();
			
			//if we haven't hit the density cap, add a particle
			if (particles.size() <= particleDensity) {
				//TODO: finish ParticleGeneratorParticle constructor
				particles.add(new ParticleGeneratorParticle());
			}
			timerVar = 0;
		}
		
		//loop through all existing particles and see which ones are marked for deletion
		ArrayList<ParticleGeneratorParticle> particlesToDelete = new ArrayList<ParticleGeneratorParticle>();
		for (int i = 0; i < particles.size(); i++) {
			if (particles.get(i).flaggedForDelete) {
				particlesToDelete.add(particles.get(i));
			}
		}
		
		//delete all particles that are marked for deletion
		for (int i = 0; i < particlesToDelete.size(); i++) {
			particles.remove(particlesToDelete.get(i));
		}
	}
	
	public void setParticleGravity(int particleGravity) {
		this.particleGravity = particleGravity;
	}
	
}
