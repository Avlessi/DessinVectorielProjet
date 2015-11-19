package common;

import java.awt.Color;

import draw.Canvas;
import draw.Dessin;
import draw.chemin.Chemin;
import draw.chemin.shapes.Point;
import draw.utils.Crayon;

public class Main {
	public static void main(String [] args) {
		Canvas c = Canvas.getCanvas();
		Dessin d = c.creerDessin();	
		
		Crayon crayon = d.createCrayon(Color.BLACK, 1);
		
		Chemin ligne = d.createLine(5, 5, 15, 15);
		ligne.setCrayon(crayon);
		d.draw(ligne);
		
		Chemin ligne2 = d.createLine(30, 30, 60, 60);
		d.draw(ligne2);
		
		Chemin p = d.createPoint(75, 75);
		d.draw(p);
		
		Chemin circle = d.createCircle(100, 100, 20);
		d.draw(circle);
		
		Chemin ellipse = d.createEllipse(150, 150, 20, 15);
		d.draw(ellipse);
		
		Chemin arc = d.createArc(200, 200, 18, 10, 0, 90);
		d.draw(arc);
	}
}
