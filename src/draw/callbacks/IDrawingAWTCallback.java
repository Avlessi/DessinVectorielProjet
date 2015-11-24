package draw.callbacks;

import java.awt.Graphics;

import draw.chemin.ComplexChemin;
import draw.chemin.shapes.Arc;
import draw.chemin.shapes.Circle;
import draw.chemin.shapes.Ellipse;
import draw.chemin.shapes.Line;
import draw.chemin.shapes.Point;
import draw.chemin.shapes.Rectangle;

public interface IDrawingAWTCallback {
	public void drawingAWTCallback(Line l, Graphics g);
	public void drawingAWTCallback(Circle c, Graphics g);
	public void drawingAWTCallback(Point p, Graphics g);
	public void drawingAWTCallback(Ellipse e, Graphics g);
	public void drawingAWTCallback(Arc l, Graphics g);	
	public void drawingAWTCallback(Rectangle r, Graphics g);
	public void drawingAWTCallback(ComplexChemin l, Graphics g);
}
