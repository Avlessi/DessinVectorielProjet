package draw.awt;

import java.awt.Graphics;

import draw.chemin.shapes.Line;

public class LineAWT {
	Line l;	
	
	public LineAWT(Line l) {
		this.l = l;
	}
	
	public void paint(Graphics g) {
		g.drawLine(l.getP1().getX(), l.getP1().getY(), l.getP2().getX(), l.getP2().getY());
	}
	
	
}
