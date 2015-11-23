package draw.factories.impl;

import draw.chemin.shapes.Arc;
import draw.chemin.shapes.Circle;
import draw.chemin.shapes.Ellipse;
import draw.chemin.shapes.Line;
import draw.chemin.shapes.Point;
import draw.chemin.shapes.Rectangle;
import draw.factories.IShapesFactory;

public class ShapesFactory implements IShapesFactory {
	
	@Override
	public Point createPoint(int x, int y) {
		return new Point(x, y);
	}	
	
	@Override
	public Arc createArc(Point center, int rx, int ry, int startAngle, int arcAngle) {
		return new Arc(center, rx, ry, startAngle, arcAngle);
	}
	
	@Override
	public Ellipse createEllipse(Point center, int rx, int ry) {
		return new Ellipse(center, rx, ry);
	}
	
	@Override
	public Circle createCircle(Point p, int r) {
		return new Circle(p, r);		
	}
	
	@Override
	public Line createLine(int x1, int y1, int x2, int y2) {
		return new Line(createPoint(x1, y1), createPoint(x2, y2));	
	}
	
	@Override
	public Line createLine(Point p1, Point p2) {
		return new Line(p1, p2);	
	}
	
	@Override
	public Rectangle createRectangle(Point p1, Point p2, Point p3, Point p4) {
		return new Rectangle(p1, p2, p3, p4);
	}

	@Override
	public Rectangle createRectangle(int x, int y, int width, int height) {
		Point p1 = createPoint(x, y);
		Point p2 = createPoint(x + width, y);
		Point p3 = createPoint(x + width, y + height);
		Point p4 = createPoint(x, y + width);
		return createRectangle(p1, p2, p3, p4);
	}
}
