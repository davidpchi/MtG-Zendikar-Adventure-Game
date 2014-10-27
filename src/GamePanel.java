

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JPanel;
import javax.swing.Timer;


public abstract class GamePanel extends JPanel {
	
	Timer frameCounter; 
	int myWidth;
	int myHeight;
	
	boolean isLeftPressed;
	boolean isRightPressed;
	boolean isUpPressed;
	boolean isDownPressed;
	
	protected RenderCamera cam;
	
	ArrayList<GameObject> gameObjs;
	ArrayList<UIObject> UIObjs;
	ArrayList<KeyEvent> boundKeys;
	
	Random randomGen; 

	public GamePanel(int worldWidth, int worldHeight, int camWidth, int camHeight) {
		frameCounter = new Timer(10, new drawActionListener());
		
		myWidth = worldWidth;
		myHeight = worldHeight;
		
		cam = new RenderCamera(0, 0, camWidth, camHeight);
		
		setPreferredSize(new Dimension(camWidth, camHeight));
		setFocusable(true);
		addKeyListener(new myKeyListener());
		
		gameObjs = new ArrayList<GameObject>();
		UIObjs = new ArrayList<UIObject>();
		boundKeys = new ArrayList<KeyEvent>();
		
		randomGen = new Random();
		//NOTE: Does not start the game immediately
	}
	
	/**
	 * Start the game
	 */
	public void start() {
		frameCounter.start();
	}
	
	public void myUpdate() {		
		//run update on all game objects
		for (int i = 0; i < gameObjs.size(); i++) {
			gameObjs.get(i).update();
		}
		
		//run update on all UI objects
		for (int i = 0; i < UIObjs.size(); i++) {
			UIObjs.get(i).update();
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
		
		for (int i = 0; i < UIObjs.size(); i++) {
			UIObjs.get(i).paint(g);
		}
	}
	
	public void leftPressed() {
		isLeftPressed = true;
	}
	
	public void rightPressed() {
		isRightPressed = true;
	}
	
	public void upPressed() {
		isUpPressed = true;
	}
	
	public void downPressed() {
		isDownPressed = true;
	}
	
	public void leftReleased() {
		isLeftPressed = false;
	}
	
	public void rightReleased() {
		isRightPressed = false;
	}
	
	public void upReleased() {
		isUpPressed = false;
	}
	
	public void downReleased() {
		isDownPressed = false;
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
				upPressed();
			}
			if (key == KeyEvent.VK_A) {
				System.out.println("a pressed");
				leftPressed();
			}
			if (key == KeyEvent.VK_S) {
				System.out.println("s pressed");
				downPressed();
			}
			if (key == KeyEvent.VK_D) {
				System.out.println("d pressed");
				rightPressed();
			}
		}
		
		public void keyReleased(KeyEvent e) {
			int key = e.getKeyCode();
			
			if (key == KeyEvent.VK_W) {
				System.out.println("w released");
				upReleased();
			}
			if (key == KeyEvent.VK_A) {
				System.out.println("a released");
				leftReleased();
			}
			if (key == KeyEvent.VK_S) {
				System.out.println("s released");
				downReleased();
			}
			if (key == KeyEvent.VK_D) {
				System.out.println("d released");
				rightReleased();
			}
		}
		
		public void keyTyped(KeyEvent e) {}

	}
}
