import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;


public class ChargeSphere extends GameObject{
	
	ArrayList<ChargeSphereParticle> particles;
	
	public ChargeSphere(GamePanel parent, int x, int y) {
		super(parent, x, y);
		width = 18;
		height = 18;
		
		particles = new ArrayList<ChargeSphereParticle>();
	}
	
	public void update() {
		//loop through all existing particles and see which ones are marked for deletion
		ArrayList<ChargeSphereParticle> particlesToDelete = new ArrayList<ChargeSphereParticle>();
		for (int i = 0; i < particles.size(); i++) {
			ChargeSphereParticle curParticle = particles.get(i);
			if (curParticle.flaggedForDelete) {
				particlesToDelete.add(curParticle);
			}
			else {
				curParticle.update();
			}
			
			//if particles are colliding with the sphere, mark them for delete
			//then increase the size of sphere
			if (this.isColliding(curParticle)) {
				curParticle.flaggedForDelete = true;
				width++;
				height++;
			}
		}
		
		//delete all particles that are marked for deletion
		for (int i = 0; i < particlesToDelete.size(); i++) {
			particles.remove(particlesToDelete.get(i));
		}
		
		//randomly spawn charge particles to build up sphere size
		if (parent.randomGen.nextInt(100) > 10) {
			int newX = x + parent.randomGen.nextInt(width * 5) - parent.randomGen.nextInt(width * 5);
			int newY = y + parent.randomGen.nextInt(width * 5) - parent.randomGen.nextInt(width * 5);
			particles.add(new ChargeSphereParticle(parent, newX, newY, x, y));
		}
	}
	
	public void paint(RenderCamera cam, Graphics g) {
		g.setColor(Color.BLUE);
		g.fillOval(x - width/2 - cam.x, y - height/2 - cam.y, width, height);
		
		for (int i = 0 ;i < particles.size(); i++) {
			particles.get(i).paint(cam, g);
		}
	}
}
