package draw.chemin.shapes;

import java.awt.Graphics;

import com.sun.istack.internal.Nullable;

import draw.chemin.Chemin;
import draw.visitors.interfaces.IDessinateur;

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
	
	
	public void accept(IDessinateur v, @Nullable Graphics g) {
		v.dessine(this, crayon, g);
	}

	@Override
	public boolean isFerme() {	
		return true;
	}

	@Override
	protected void addSegment(Chemin chemin) {		
		
	}

	@Override
	protected void remove(Chemin chemin) {		
		
	}	
}
