package draw.chemin.shapes;

import draw.chemin.Courbe;
import draw.visitors.interfaces.IDessinateur;

public class Ligne extends Courbe {
	
	Point p1, p2;
	
	public Ligne(Point p1, Point p2) {
		this.p1 = p1;
		this.p2 = p2;
	}

	@Override
	public void accept(IDessinateur v) {
		v.dessine(this, crayon);		
	}
	
}
