import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

public class MainPlayer extends GameObject{
	
	public MainPlayer(int x, int y) {
		super(x,y,32,32);
		Image myImage = Toolkit.getDefaultToolkit().getImage(MainPlayer.class.getResource("player.gif")); 
		setImage(myImage);
	}
	
	public void paint(Graphics g) {
		g.setColor(Color.RED);
		g.drawOval(0,0,32,32);
		g.drawImage(image, 32, 32, null);
	}
}
