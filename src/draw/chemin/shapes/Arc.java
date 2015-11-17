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
		v.dessine(this, crayon, g);
		
	}

	@Override
	public boolean isFerme() {
		// TODO Auto-generated method stub
		return false;
	}
}
