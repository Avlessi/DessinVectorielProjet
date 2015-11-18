package draw.chemin.shapes;

import java.awt.Graphics;

import com.sun.istack.internal.Nullable;

import draw.chemin.Chemin;
import draw.visitors.interfaces.IDessinateur;

public class Arc extends Chemin {
	
	Point center;
	float radius;	
	
	
	public Arc(Point center, float radius) {
		this.center = center;
		this.radius = radius;
	}

	@Override
	public void accept(IDessinateur v, @Nullable Graphics g) {
		v.dessine(this, getCrayon(), g);
		
	}

	@Override
	public boolean isFerme() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	protected Chemin getRoot() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addSegment(Chemin chemin) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void remove(Chemin chemin) {
		// TODO Auto-generated method stub
		
	}
}
