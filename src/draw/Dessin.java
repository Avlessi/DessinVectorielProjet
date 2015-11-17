package draw;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import draw.chemin.Chemin;
import draw.chemin.shapes.Arc;
import draw.chemin.shapes.Cercle;
import draw.chemin.shapes.Ellipse;
import draw.chemin.shapes.Ligne;
import draw.chemin.shapes.Point;
import draw.interfaces.impl.DessinateurPanel;
import draw.interfaces.impl.Graphics2dDessinateur;
import draw.utils.Crayon;

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
	
	public void dessiner(Chemin chemin, Crayon crayon) {
		//TODO		
		JFrame frame = new JFrame("Dessin");
		//Graphics2dDessinateur panel = new Graphics2dDessinateur();
		DessinateurPanel panel = new DessinateurPanel(chemin, new Graphics2dDessinateur());
		frame.add(panel);
			
		
		/*IDessinateur dess = new Dessinateur();
		for(Chemin chemin: cheminList) {
			chemin.accept(dess);
		}*/
		
		frame.setVisible(true);
		frame.pack();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				
		
		//chemin.accept(panel);
	}
	
	public void dessinerSvg() {
		
	}
	
	public Point creerPoint(int x, int y) {
		return new Point(x, y);
	}
	
	public Chemin creerArc(Point center, float rx) {
		return new Arc(center, rx);
	}
	
	public Chemin creerllipse(Point center, float rx, float ry) {
		return new Ellipse(center, rx, ry);
	}
	
	public Chemin creerCercle(Point p, float r) {
		Chemin c = new Cercle(p, r);		
		return c;
	}
	
	public Chemin creerLigne(Point p1, Point p2) {
		return new Ligne(p1, p2);	
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
