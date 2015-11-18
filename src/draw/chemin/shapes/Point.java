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
		v.dessine(this, getCrayon(), g);
	}

	@Override
	public boolean isFerme() {	
		return true;
	}

	@Override
	public void addSegment(Chemin chemin) {		
		
	}

	@Override
	public void remove(Chemin chemin) {		
		
	}

	@Override
	protected Chemin getRoot() {
		// TODO Auto-generated method stub
		return null;
	}	
}
