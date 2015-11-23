package draw.chemin.shapes;

import java.awt.Graphics;

import com.sun.istack.internal.Nullable;

import draw.chemin.Chemin;
import draw.utils.IDrawingAWTCallback;
import draw.utils.IDrawingCallback;

public class Ellipse extends Chemin {
	
	Point center;
	int radius_x;
	int radiux_y;
	
	public Ellipse(Point center, int r_x, int r_y) {		
		this.center = center;
		radius_x = r_x;
		radiux_y = r_y;
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

	public int getRadiux_y() {
		return radiux_y;
	}

	public void setRadiux_y(int radiux_y) {
		this.radiux_y = radiux_y;
	}

	@Override
	public boolean isClosed() {		
		return true;
	}

	@Override
	protected Chemin getRoot() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void remove(Chemin chemin) {
		// TODO Auto-generated method stub
		
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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Point getEndPoint() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
