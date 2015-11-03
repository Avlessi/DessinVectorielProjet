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
						
		Point p = d.creerPoint(0, 0);
		float rx = 5f;
		float ry = 10f;
		Chemin chemin = d.ajouterEllipse(p, rx, ry);
		Chemin chemin2 = d.ajouterCercle(p, 5);
		
		int epaisseur = 1; 
		Crayon crayon = d.creerCrayon(epaisseur, Color.BLACK);
		Point p1 = d.creerPoint(20, 20);
		Point p2 = d.creerPoint(30, 30);
		Chemin chemin3 = d.ajouterLigne(p1, p2);
		d.draw(crayon);
				
	}
}
