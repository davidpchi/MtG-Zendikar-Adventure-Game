import javax.swing.JFrame;

public class MainFrame {
	public MainFrame() {
		JFrame test = new JFrame();
		test.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		GamePanel panel1 = new GamePanel(500,500);
		
		test.add(panel1); 
		test.pack();
		test.setVisible(true);
	}
	
	public static void main(String[] args) {
		MainFrame frame = new MainFrame();
		System.out.println("Finished running main");
	}
}
