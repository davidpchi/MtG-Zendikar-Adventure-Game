import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

import com.default_ui.UIHealthbar;
import com.default_ui.UIMenu;
import com.default_ui.UIMenuItem;
import com.default_ui.UIText;
import com.zen_main.GamePanel;
import com.zen_main.UIObject;

public class DemoScene extends GamePanel {
	
	MainPlayer player;
	int test1;
	UIMenu tempMenu;
	
	public DemoScene(int worldWidth, int worldHeight, int camWidth, int camHeight) {
		super(worldWidth, worldHeight, camWidth, camHeight);
		
		player = new MainPlayer(this, cam.width / 2, cam.height / 2);
		
		//update camera with player in the center
		cam.x = player.x - cam.width / 2;
		cam.y = player.y - cam.height / 2;
		
		WallObject tempWall = new WallObject(this, 0,250,500,64, null);
		gameObjs.add(tempWall);
		
		tempWall = new WallObject(this, 250,200,500,64, null);
		gameObjs.add(tempWall);

		tempWall = new WallObject(this, 400,150,500,64, null);
		gameObjs.add(tempWall);
		
		tempWall = new WallObject(this, 600,150,500,64, null);
		gameObjs.add(tempWall);
		
		tempWall = new WallObject(this, 1000,150,500,64, null);
		gameObjs.add(tempWall);
		
		tempWall = new WallObject(this, 1200,150,500,64, null);
		gameObjs.add(tempWall);
		
		gameObjs.add(player);
		
		gameObjs.add(new ChargeSphere(this, 100, 100));
		
		/*
		int particleDensity = 10;
		int particleSize = 10;
		int particleAngle = 90; 
		int particleLife = 100;
		int particleFrequency = 50;
		int particleSpeed = 2; 
		//TODO: NEED TO FIX THE ARC OF SPRAY FOR PARTICLE GENERATOR
		ParticleGenerator testParticle = new ParticleGenerator(
				player.x, 
				player.y, 
				particleDensity, 
				particleSize, 
				GameObject.Direction.UP, 
				particleAngle, 
				particleLife, 
				particleFrequency, 
				particleSpeed, 
				Toolkit.getDefaultToolkit().getImage(MainPlayer.class.getResource("fire.gif")));
		//testParticle.setParticleGravity(1);
		testParticle.setIsGrowParticle(true);
		testParticle.growRate = 0.1;
		gameObjs.add(testParticle);
		*/
		
		tempMenu = new UIMenu(this, 50,10);
		UIMenuItem item1 = new UIMenuItem(this, 50, 10, 32, 32, "temp1");
		UIMenuItem item2 = new UIMenuItem(this, 50, 30, 32, 32, "temp2");
		UIMenuItem item3 = new UIMenuItem(this, 50, 50, 32, 32, "temp3");
		
		tempMenu.addMenuItem(item1);
		tempMenu.addMenuItem(item2);
		tempMenu.addMenuItem(item3);
		
		UIObjs = new ArrayList<UIObject>();
		//DEBUG: add some temporary text to showcase UI
		UIObjs.add(new UIText(this, 10, 32, "This is a test"));
		UIObjs.add(new UIHealthbar(this, 10, 40, 128, 16));
		UIObjs.add(tempMenu);
		
		//DEBUG: start running the game immediately
		start();
	}
	
	public void myUpdate() {
		super.myUpdate();
		test1++;
		
		//center camera on the player
		if ((player.x - cam.x) <= cam.renderEdge) {
			cam.x -= cam.followSpeed;
		}
		
		if (((cam.x + cam.width) - player.x ) <= cam.renderEdge) {
			cam.x += cam.followSpeed;
		}
		
		if ((player.y - cam.y) <= cam.renderEdge) {
			cam.y -= cam.followSpeed;
		}
		
		if (((cam.y + cam.height) - player.y) <= cam.renderEdge) {
			cam.y += cam.followSpeed;
		}
	}
	
	public void myRender() {
		repaint();
	}
	
	public void paint(Graphics g) {
		super.paint(g);
		
		//draw background grid
		for (int i = 0; i < myWidth; i += 32) {
			g.setColor(Color.LIGHT_GRAY);
			g.drawLine(i - cam.x, 0 - cam.y, i - cam.x, myHeight - cam.y);
		}
		
		for (int i = 0; i < myHeight; i += 32) {
			g.setColor(Color.LIGHT_GRAY);
			g.drawLine(0 - cam.x, i - cam.y, myWidth - cam.x, i - cam.y);
		}
	}
}
