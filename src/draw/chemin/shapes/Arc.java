package draw.chemin.shapes;

import java.awt.Graphics;

import draw.callbacks.IDrawingAWTCallback;
import draw.callbacks.IDrawingCallback;
import draw.chemin.Chemin;

public class Arc extends Chemin {
	
	Point center;
	int radius_x;
	int radius_y;
	int startAngle;
	int arcAngle;
		
	public Arc(Point center, int radius_x, int radius_y, int startAngle, int arcAngle) {
		this.center = center;
		this.radius_x = radius_x;
		this.radius_y = radius_y;
		this.startAngle = startAngle;
		this.arcAngle = arcAngle;		
	}
	
	public Point getCenter() {
		return center;
	}

	public void setCenter(Point center) {
		this.center = center;
	}

	public int getRadius_x() {
		return radius_x;
	}

	public void setRadius_x(int radius_x) {
		this.radius_x = radius_x;
	}

	public int getRadius_y() {
		return radius_y;
	}

	public void setRadius_y(int radius_y) {
		this.radius_y = radius_y;
	}

	public int getStartAngle() {
		return startAngle;
	}

	public void setStartAngle(int startAngle) {
		this.startAngle = startAngle;
	}

	public int getArcAngle() {
		return arcAngle;
	}

	public void setArcAngle(int arcAngle) {
		this.arcAngle = arcAngle;
	}

	@Override
	public boolean isClosed() {		
		return false;
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
		Point p = new Point(center.getX(), center.getY() - radius_y);
		return p;
	}

	@Override
	public Point getEndPoint() {
		Point p = new Point(center.getX(), center.getY() - radius_y);
		return p;
	}
}
