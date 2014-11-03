package com.default_ui;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;

import com.zen_main.GamePanel;
import com.zen_main.UIObject;



public class UIMenuItem extends UIObject{

	String displayText;
	Image defaultImage;
	
	boolean isSelected;
	Image selectedImage;
	
	public UIMenuItem(GamePanel parent, int x, int y, int width, int height) {
		this(parent, x, y, width, height, "", null);
	}
	
	public UIMenuItem(GamePanel parent, int x, int y, int width, int height, Image image) {
		this(parent, x, y, width, height, "", image);
	}
	
	public UIMenuItem(GamePanel parent, int x, int y, int width, int height, String text) {
		this(parent, x, y, width, height, text, null);
	}
	
	public UIMenuItem(GamePanel parent, int x, int y, int width, int height, String text, Image image) {
		this(parent, x, y, width, height, text, image, image);
	}
	
	public UIMenuItem(GamePanel parent, int x, int y, int width, int height, String text, Image defaultImage, Image selectedImage) {
		super(parent, x, y, width, height);
		displayText = text;
		this.defaultImage = defaultImage;
		this.selectedImage = selectedImage;
	}
	
	public void paint(Graphics g) {
		if (isSelected) {
			if (selectedImage != null)
				g.drawImage(selectedImage, x, y, null);
			else {
				g.setColor(Color.RED);
				g.drawString(displayText, x, y);
			}
		}
		else {
			if (selectedImage != null)
				g.drawImage(defaultImage, x, y, null);
			else {
				g.setColor(Color.BLACK);
				g.drawString(displayText, x, y);
			}
		}
	}
}
