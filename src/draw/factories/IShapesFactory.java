package draw.factories;

import draw.chemin.shapes.Arc;
import draw.chemin.shapes.Circle;
import draw.chemin.shapes.Ellipse;
import draw.chemin.shapes.Line;
import draw.chemin.shapes.Point;
import draw.chemin.shapes.Rectangle;

public interface IShapesFactory {
	public Point createPoint(int x, int y);
	
	public Arc createArc(Point center, int rx, int ry, int startAngle, int arcAngle);
	
	public Ellipse createEllipse(Point center, int rx, int ry);
	
	public Circle createCircle(Point p, int r);
	
	public Line createLine(int x1, int y1, int x2, int y2);
	
	public Line createLine(Point p1, Point p2);
	
	public Rectangle createRectangle(Point p1, Point p2, Point p3, Point p4);
	
	public Rectangle createRectangle(int x, int y, int width, int height);
}
