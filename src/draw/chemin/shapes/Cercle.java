package draw.chemin.shapes;

import draw.chemin.Courbe;
import draw.visitors.interfaces.IDessinateur;

public class Cercle extends Courbe {
	
	Point center;
	float radius;
	
	public Cercle(Point p, float r) {
		this.center = p;
		this.radius = r;
	}
	
	public void accept(IDessinateur v) {
		v.dessine(this, crayon);
	}
}
