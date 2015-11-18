package draw.chemin.shapes;

import java.awt.Graphics;

import com.sun.istack.internal.Nullable;

import draw.chemin.Chemin;
import draw.visitors.interfaces.IDessinateur;

public class Ligne extends Chemin {
	
	Point p1, p2;
	
	public Ligne(Point p1, Point p2) {
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
	public void accept(IDessinateur v, @Nullable Graphics g) {
		v.dessine(this, getCrayon(), g);		
	}

	@Override
	public boolean isFerme() {		
		return true;
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
