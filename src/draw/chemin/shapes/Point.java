package draw.chemin.shapes;

import java.awt.Graphics;

import draw.callbacks.IDrawingAWTCallback;
import draw.callbacks.IDrawingCallback;
import draw.chemin.Chemin;

public class Point extends Chemin {
	
	int x;
	int y;
	
	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public int getX() {
		return this.x;		
	}
	
	public void setX(int x) {
		this.x = x;
	}
	
	public int getY() {
		return this.y;
	}
	
	public void setY(int y) {
		this.y = y;
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
		return this;
	}

	@Override
	public Point getEndPoint() {
		return this;
	}	
}
