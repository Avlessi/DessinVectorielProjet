package draw.chemin.shapes;

import java.awt.Graphics;


import draw.chemin.Chemin;
import draw.utils.IDrawingAWTCallback;
import draw.utils.IDrawingCallback;

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
	public void remove(Chemin chemin) {		
		
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
}
