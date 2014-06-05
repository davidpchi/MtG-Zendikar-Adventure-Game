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
	
	MainPlayer player;
	
	ArrayList<GameObject> gameObjs;
	
	public GamePanel(int width, int height) {
		frameCounter = new Timer(10, new drawActionListener());
		test1 = 0;
		
		myWidth = width;
		myHeight = height;
		
		setPreferredSize(new Dimension(myWidth, myHeight));
		setFocusable(true);
		addKeyListener(new myKeyListener());
		
		gameObjs = new ArrayList<GameObject>();
		player = new MainPlayer(0,0);
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
	}
	
	public void myRender() {
		repaint();
	}
	
	public void paint(Graphics g) {
		for (int i = 0; i < gameObjs.size(); i++) {
			gameObjs.get(i).paint(g);
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
