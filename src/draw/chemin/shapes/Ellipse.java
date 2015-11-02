package draw.chemin.shapes;

import draw.chemin.Courbe;
import draw.visitors.interfaces.IDessinateur;

public class Ellipse extends Courbe {
	
	Point center;
	float radius_x;
	float radiux_y;
	
	public Ellipse(Point center, float r_x, float r_y) {		
		this.center = center;
		radius_x = r_x;
		radiux_y = r_y;
	}
		
	public void accept(IDessinateur v) {
		v.dessine(this, crayon);
	}
	
}
