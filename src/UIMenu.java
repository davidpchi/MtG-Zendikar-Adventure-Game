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
		if (curSelectedItem < (menuItems.size() - 1)) {
			curSelectedItem++;
		}
		else {
			curSelectedItem = 0;
		}
	}
}
