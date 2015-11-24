package draw.chemin.shapes;

import java.awt.Graphics;

import draw.callbacks.IDrawingAWTCallback;
import draw.callbacks.IDrawingCallback;
import draw.chemin.Chemin;

public class Line extends Chemin {
	
	Point p1, p2;
	
	public Line(Point p1, Point p2) {
		this.p1 = p1;
		this.p2 = p2;
	}

	public Point getP1() {
		return p1;
	}

	public void setP1(Point p1) {
		this.p1 = p1;
	}

	public Point getP2() {
		return p2;
	}

	public void setP2(Point p2) {
		this.p2 = p2;
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
		return this.p1;
	}

	@Override
	public Point getEndPoint() {
		return this.p2;
	}
	
}
