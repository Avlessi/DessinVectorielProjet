package draw.chemin.shapes;

import java.awt.Graphics;

import draw.callbacks.IDrawingAWTCallback;
import draw.callbacks.IDrawingCallback;
import draw.chemin.Chemin;

public class Circle extends Chemin {
	
	Point center;
	int radius;
	
	public Circle(Point p, int r) {
		this.center = p;
		this.radius = r;
	}	

	public Point getCenter() {
		return center;
	}

	public void setCenter(Point center) {
		this.center = center;
	}

	public int getRadius() {
		return radius;
	}

	public void setRadius(int radius) {
		this.radius = radius;
	}

	@Override
	public boolean isClosed() {
		return true;
	}	

	@Override
	public void accept(IDrawingAWTCallback callback, Graphics g) {
		callback.drawingAWTCallback(this, g);		
	}

	@Override
	public void accept(IDrawingCallback callback) {
		callback.drawingCallback(this);		
	}

	@Override
	public Point getStartPoint() {
		Point p = new Point(center.getX(), center.getY() - radius);
		return p;
	}

	@Override
	public Point getEndPoint() {
		Point p = new Point(center.getX(), center.getY() - radius);
		return p;
	}
}
