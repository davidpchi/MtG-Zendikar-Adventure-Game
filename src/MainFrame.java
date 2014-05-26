import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.JPanel;


public class MainFrame {
	public MainFrame() {
		JFrame test = new JFrame();
		test.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel panel1 = new JPanel();
		panel1.setPreferredSize(new Dimension(100,100));
		
		test.add(panel1); 
		test.pack();
		test.setVisible(true);
	}
	
	public static void main(String[] args) {
		MainFrame frame = new MainFrame();
		System.out.println("Finished running main");
	}
}
