package draw.visitors.interfaces;

import draw.chemin.shapes.Arc;
import draw.chemin.shapes.Cercle;
import draw.chemin.shapes.Ellipse;
import draw.chemin.shapes.Point;
import draw.utils.Crayon;

public interface IDessinateur {
	public void dessine(Ellipse e, Crayon crayon);
	public void dessine(Cercle c, Crayon crayon);
	public void dessine(Arc a, Crayon crayon);
	public void dessine(Point p, Crayon crayon);
}
