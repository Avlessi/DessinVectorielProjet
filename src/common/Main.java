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
		//Chemin chemin2 = d.ajouterCercle(10, 10, 5);
		//Chemin chemin3 = d.ajouterLigne(0, 0, 1, 1);		
				
		//float epaisseur = 5;
		//Crayon crayon = d.creerCrayon(epaisseur, Color.BLACK);		
		
		if(chemin.isFerme()) {			
			//chemin.remplir(crayon);			
		}
		//d.scale(3.0);		
	}
}
