package draw.chemin.shapes;

import draw.chemin.Chemin;
import draw.visitors.interfaces.IDessinateur;

public class Point extends Chemin {
	
	float x;
	float y;
	
	public Point(int x, int y) {
		
	}
	
	public float getX() {
		return this.x;		
	}
	
	public void setX(float x) {
		this.x = x;
	}
	
	public float getY() {
		return this.y;
	}
	
	public void setY(float y) {
		this.y = y;
	}
	
	
	public void accept(IDessinateur v) {
		v.dessine(this, crayon);
	}

	@Override
	public boolean isFerme() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	protected void addSegment(Chemin chemin) {
		
		
	}

	@Override
	protected void remove(Chemin chemin) {		
		
	}	
}
