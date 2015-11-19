package draw.factories;

import draw.chemin.Chemin;
import draw.chemin.shapes.Arc;
import draw.chemin.shapes.Circle;
import draw.chemin.shapes.Ellipse;
import draw.chemin.shapes.Line;
import draw.chemin.shapes.Point;

public class ShapesFactory {
	public static enum ShapeTypes {
		Arc,
		Circle,
		Ellipse,
		Line,
		Point
	}
	
	public static Point createPoint(int x, int y) {
		return new Point(x, y);
	}
	
	public static Arc createArc(Point center, int rx, int ry, int startAngle, int arcAngle) {
		return new Arc(center, rx, ry, startAngle, arcAngle);
	}
	
	public static Ellipse createEllipse(Point center, int rx, int ry) {
		return new Ellipse(center, rx, ry);
	}
	
	public static Circle createCircle(Point p, int r) {
		return new Circle(p, r);		
	}
	
	public static Line createLine(int x1, int y1, int x2, int y2) {
		return new Line(createPoint(x1, y1), createPoint(x2, y2));	
	}
	
	public static Line createLine(Point p1, Point p2) {
		return new Line(p1, p2);	
	}
}
