package draw.chemin.shapes;

import draw.chemin.Courbe;
import draw.visitors.interfaces.IDessinateur;

public class Cercle extends Courbe {
	public void accept(IDessinateur v) {
		v.dessine(this, crayon);
	}
}
