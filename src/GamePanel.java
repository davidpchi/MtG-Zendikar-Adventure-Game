import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.Timer;

public class GamePanel extends JPanel{
	Timer frameCounter; 
	int test1;
	
	public GamePanel() {
		frameCounter = new Timer(10, new drawActionListener());
		test1 = 0;
		
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
		g.setColor(Color.RED);
		g.drawOval(test1, test1, 16, 16);
	}
	
	private class drawActionListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			myUpdate();
			myRender();
		}
		
	}
}
