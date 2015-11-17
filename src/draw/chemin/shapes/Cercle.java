package draw.chemin.shapes;

import java.awt.Graphics;

import com.sun.istack.internal.Nullable;

import draw.chemin.Chemin;
import draw.visitors.interfaces.IDessinateur;

public class Cercle extends Chemin {
	
	Point center;
	float radius;
	
	public Cercle(Point p, float r) {
		this.center = p;
		this.radius = r;
	}
	
	public void accept(IDessinateur v, @Nullable Graphics g) {
		v.dessine(this, crayon, g);
	}

	@Override
	public boolean isFerme() {
		// TODO Auto-generated method stub
		return false;
	}
}
