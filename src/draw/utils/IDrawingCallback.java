package draw.utils;

import java.awt.Graphics;

import draw.chemin.ComplexChemin;
import draw.chemin.shapes.Arc;
import draw.chemin.shapes.Circle;
import draw.chemin.shapes.Ellipse;
import draw.chemin.shapes.Line;
import draw.chemin.shapes.Point;

public interface IDrawingCallback {
	public void drawingCallback(Line l);
	public void drawingCallback(Circle c);
	public void drawingCallback(Point p);
	public void drawingCallback(Ellipse e);
	public void drawingCallback(Arc l);
	public void drawingCallback(ComplexChemin l);
}
