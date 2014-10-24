import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.Timer;


public class UIMenu extends UIObject{

	ArrayList<UIMenuItem> menuItems;
	int curSelectedItem;
	Timer frameCounter; 
	boolean canSelect;
	
	public UIMenu(GamePanel parent, int x, int y) {
		super(parent, x, y);
		menuItems = new ArrayList<UIMenuItem>();
		curSelectedItem = 0;
		frameCounter = new Timer(400, new selectActionListener());
		frameCounter.stop();
		canSelect = true;
	}
	
	public void selectNextItem() {
		menuItems.get(curSelectedItem).isSelected = false;
		
		if (curSelectedItem < (menuItems.size() - 1)) {
			curSelectedItem++;
		}
		else {
			curSelectedItem = 0;
		}
		
		menuItems.get(curSelectedItem).isSelected = true;
	}
	
	public void selectPrevItem() {
		menuItems.get(curSelectedItem).isSelected = false;
		
		if (curSelectedItem > 0) {
			curSelectedItem--;
		}
		else {
			curSelectedItem = menuItems.size() - 1;
		}
		
		menuItems.get(curSelectedItem).isSelected = true;
	}
	
	public void update() {
		if (parent.isUpPressed && canSelect) {
			selectPrevItem();
			canSelect = false;
			frameCounter.start();
		}
		else if (parent.isDownPressed && canSelect) {
			selectNextItem();
			canSelect = false;
			frameCounter.start();
		}
		if (!parent.isDownPressed && !parent.isUpPressed) {
			frameCounter.stop();
			canSelect = true;
		}
	}
	
	public void paint(Graphics g) {
		for (int i = 0; i < menuItems.size(); i++) {
			menuItems.get(i).paint(g);
		}
	}
	
	public void addMenuItem(UIMenuItem newItem) {
		if (newItem != null) 
			menuItems.add(newItem);
	}
	
	private class selectActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			canSelect = true;
		}
	}
}
