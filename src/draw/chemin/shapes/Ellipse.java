package draw.chemin.shapes;

import java.awt.Graphics;

import com.sun.istack.internal.Nullable;

import draw.callbacks.IDrawingAWTCallback;
import draw.callbacks.IDrawingCallback;
import draw.chemin.Chemin;

public class Ellipse extends Chemin {
	
	Point center;
	int radius_x;
	int radius_y;
	
	public Ellipse(Point center, int r_x, int r_y) {		
		this.center = center;
		radius_x = r_x;
		radius_y = r_y;
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

	public void setRadius_y(int radiux_y) {
		this.radius_y = radiux_y;
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
		Point p = new Point(center.getX(), center.getY() - radius_y);
		return p;
	}

	@Override
	public Point getEndPoint() {
		Point p = new Point(center.getX(), center.getY() - radius_y);
		return p;
	}
	
}
