import java.awt.Graphics;
import java.util.ArrayList;


public class UIMenu extends UIObject{

	ArrayList<UIMenuItem> menuItems;
	int curSelectedItem;
	
	public UIMenu(int x, int y) {
		super(x, y);
		menuItems = new ArrayList<UIMenuItem>();
		curSelectedItem = 0;
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
	
	public void paint(Graphics g) {
		for (int i = 0; i < menuItems.size(); i++) {
			menuItems.get(i).paint(g);
		}
	}
	
	public void addMenuItem(UIMenuItem newItem) {
		if (newItem != null) 
			menuItems.add(newItem);
	}
}
