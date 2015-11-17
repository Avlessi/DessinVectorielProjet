package draw.visitors.interfaces;

import java.awt.Graphics;

import com.sun.istack.internal.Nullable;

import draw.chemin.shapes.Arc;
import draw.chemin.shapes.Cercle;
import draw.chemin.shapes.Ellipse;
import draw.chemin.shapes.Ligne;
import draw.chemin.shapes.Point;
import draw.utils.Crayon;

public interface IDessinateur {
	public void dessine(Ellipse e, Crayon crayon, @Nullable Graphics g);
	public void dessine(Cercle c, Crayon crayon, @Nullable Graphics g);
	public void dessine(Arc a, Crayon crayon, @Nullable Graphics g);
	public void dessine(Point p, Crayon crayon, @Nullable Graphics g);
	public void dessine(Ligne l, Crayon crayon, @Nullable Graphics g);
}
