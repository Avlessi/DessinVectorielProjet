package draw.awt;

import java.awt.Graphics;

import draw.chemin.shapes.Ellipse;

public class EllipseAWT {
	Ellipse ellipse;
	
	public EllipseAWT(Ellipse ellipse) {
		this.ellipse = ellipse;
	}
	
	public void paint(Graphics g) {
		g.drawArc(ellipse.getCenter().getX(), ellipse.getCenter().getY(), 2 * ellipse.getRadius_x(), 2 * ellipse.getRadiux_y(), 0, 360);
	}
}
