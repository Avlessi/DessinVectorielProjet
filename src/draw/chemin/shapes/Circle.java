package draw.chemin.shapes;

import java.awt.Graphics;

import draw.chemin.Chemin;
import draw.utils.IDrawingAWTCallback;
import draw.utils.IDrawingCallback;

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
}
