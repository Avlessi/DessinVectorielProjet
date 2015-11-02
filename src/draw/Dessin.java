package draw;

import java.awt.Color;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.List;

import draw.chemin.Chemin;
import draw.chemin.shapes.Cercle;
import draw.chemin.shapes.Ellipse;
import draw.chemin.shapes.Ligne;
import draw.chemin.shapes.Point;
import draw.utils.Crayon;
import draw.visitors.interfaces.IDessinateur;
import draw.visitors.interfaces.impl.Dessinateur;

public class Dessin {
	Canvas parentCanvas;
	List<Chemin> cheminList = new ArrayList<Chemin>();	
	float zoom = 1f;
	
	public Dessin() {		
	}
	
	public float getZoom() {
		return this.zoom;
	}
	
	public void setZoom(float zoom) {
		this.zoom = zoom;
	}
	
	public Dessin(Canvas canvas) {
		this.parentCanvas = canvas;
	}
	
	public void draw(Crayon crayon) {
		//TODO 
		Graphics2D g = null;
		IDessinateur dess = new Dessinateur(g);
		for(Chemin chemin: cheminList) {
			chemin.accept(dess);
		}
	}
	
	public Point creerPoint(int x, int y) {
		return new Point(x, y);
	}
	
	public Chemin ajouterEllipse(Point p, float rx, float ry) {
		Chemin c = new Ellipse(p, rx, ry); 
		return c;
	}
	
	public Chemin ajouterCercle(Point p, float r) {
		Chemin c = new Cercle(p, r);
		cheminList.add(c);
		return c;
	}
	
	public Chemin ajouterLigne(Point p1, Point p2) {
		Chemin c = new Ligne(p1, p2);
		cheminList.add(c);
		return c;
	}
	
	public Crayon creerCrayon(int epaisseur, Color color) {
		Crayon crayon = new Crayon(epaisseur, color);
		return crayon;
	}
	
	public void etiqueter() {
		//TODO
	}	
	
	public void remplir() {
		//TODO
	}
	
	public void inserer() {
		//TODO
	}
	
}
