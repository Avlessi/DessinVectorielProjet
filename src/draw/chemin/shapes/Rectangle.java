package draw.chemin.shapes;

import java.awt.Graphics;

import draw.chemin.Chemin;
import draw.utils.IDrawingAWTCallback;
import draw.utils.IDrawingCallback;

public class Rectangle extends Chemin {
	
	private Point p1, p2, p3, p4;
	private int width;
	private int height;
	
	public Rectangle(Point p1, Point p2, Point p3, Point p4) {
		this.p1 = p1;
		this.p2 = p2;
		this.p3 = p3;
		this.p4 = p4;
		this.width = p2.getX() - p1.getX();
		this.height = p4.getY() - p1.getY();
	}	
	
	public Point getP1() {
		return p1;
	}


	public Point getP2() {
		return p2;
	}


	public Point getP3() {
		return p3;
	}


	public Point getP4() {
		return p4;
	}


	public int getWidth() {
		return width;
	}


	public int getHeight() {
		return height;
	}
	
	@Override
	protected Chemin getRoot() {
		// TODO Auto-generated method stub
		return null;
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
	public boolean isClosed() {
		return true;
	}

	@Override
	public void remove(Chemin chemin) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Point getStartPoint() {
		return this.p1;
	}

	@Override
	public Point getEndPoint() {
		return this.p3;
	}

}
