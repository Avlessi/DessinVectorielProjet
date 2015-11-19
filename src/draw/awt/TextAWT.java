package draw.awt;

import java.awt.Graphics;

public class TextAWT {
	String text;
	//Graphics g;
	int pos_x;
	int pos_y;
	
	public TextAWT(String text, int pos_x, int pos_y) {
		this.text = text;		
		this.pos_x = pos_x;
		this.pos_y = pos_y;
	}
	
	public void paint(Graphics g) {
		g.drawString(text, pos_x, pos_y);
	}
	
}
