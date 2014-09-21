import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.Timer;

public class GamePanel extends JPanel{
	Timer frameCounter; 
	int test1;
	int myWidth;
	int myHeight;
	
	RenderCamera cam;
	
	MainPlayer player;
	
	ArrayList<GameObject> gameObjs;
	
	public GamePanel(int worldWidth, int worldHeight, int camWidth, int camHeight) {
		frameCounter = new Timer(10, new drawActionListener());
		test1 = 0;
		
		myWidth = worldWidth;
		myHeight = worldHeight;
		
		cam = new RenderCamera(0, 0, camWidth, camHeight);
		
		setPreferredSize(new Dimension(camWidth, camHeight));
		setFocusable(true);
		addKeyListener(new myKeyListener());
		
		gameObjs = new ArrayList<GameObject>();
		player = new MainPlayer(cam.width / 2,cam.height / 2, this);
		
		//update camera with player in the center
		cam.x = player.x - cam.width / 2;
		cam.y = player.y - cam.height / 2;
		
		WallObject tempWall = new WallObject(0,250,500,64, null);
		gameObjs.add(tempWall);
		
		tempWall = new WallObject(250,200,500,64, null);
		gameObjs.add(tempWall);

		tempWall = new WallObject(400,150,500,64, null);
		gameObjs.add(tempWall);
		
		tempWall = new WallObject(600,150,500,64, null);
		gameObjs.add(tempWall);
		
		tempWall = new WallObject(1000,150,500,64, null);
		gameObjs.add(tempWall);
		
		tempWall = new WallObject(1200,150,500,64, null);
		gameObjs.add(tempWall);
		
		gameObjs.add(player);
		
		//DEBUG: start running the game immediately
		start();
	}
	
	/**
	 * Start the game
	 */
	public void start() {
		frameCounter.start();
	}
	
	public void myUpdate() {
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
		
		//need to re-factor rendering based on camera and world space
		for (int i = 0; i < gameObjs.size(); i++) {
			gameObjs.get(i).paint(cam, g);
		}
	}
	
	private class drawActionListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			myUpdate();
			myRender();
		}
		
	}
	
	private class myKeyListener implements KeyListener {
		public void keyPressed(KeyEvent e) {
			int key = e.getKeyCode();
			
			if (key == KeyEvent.VK_W) {
				System.out.println("w pressed");
				player.upPressed();
			}
			if (key == KeyEvent.VK_A) {
				System.out.println("a pressed");
				player.leftPressed();
			}
			if (key == KeyEvent.VK_S) {
				System.out.println("s pressed");
				player.downPressed();
			}
			if (key == KeyEvent.VK_D) {
				System.out.println("d pressed");
				player.rightPressed();
			}
		}
		
		public void keyReleased(KeyEvent e) {
			int key = e.getKeyCode();
			
			if (key == KeyEvent.VK_W) {
				System.out.println("w released");
				player.upReleased();
			}
			if (key == KeyEvent.VK_A) {
				System.out.println("a released");
				player.leftReleased();
			}
			if (key == KeyEvent.VK_S) {
				System.out.println("s released");
				player.downReleased();
			}
			if (key == KeyEvent.VK_D) {
				System.out.println("d released");
				player.rightReleased();
			}
		}
		
		public void keyTyped(KeyEvent e) {}

	}
}
