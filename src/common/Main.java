package common;

import java.awt.Color;

import draw.Dessin;
import draw.DrawType;
import draw.chemin.Chemin;
import draw.utils.Crayon;

public class Main {
	public static void main(String [] args) {
		
		Dessin d = new Dessin(DrawType.AWT);		
		Crayon crayon = d.createCrayon(Color.BLUE, 1);
		
		Chemin ligne = d.createLine(5, 5, 5, 15);
		ligne.setCrayon(crayon);
		d.draw(ligne);
		
		Chemin ligne2 = d.createLine(500, 5, 500, 15);
		d.draw(ligne2);
		
		Chemin path = ligne.connectWithBezier(ligne2, 200, 100, 400, 100);
		d.draw(path);
		
		Chemin ligne3 = d.createLine(600, 40, 650, 100);
		d.draw(ligne3);				
		
		Chemin path2 = path.connectWithLine(ligne3);
		d.draw(path2);
		
		Chemin p = d.createPoint(75, 75);
		d.draw(p);
		
		Crayon circleCrayon = d.createCrayon(Color.orange, 4);
		Chemin circle = d.createCircle(100, 100, 20);
		circle.setCrayon(circleCrayon);
		d.draw(circle);
		
		d.label("Cool text", 500, 500);
		
		Crayon myCrayon = d.createCrayon(Color.GREEN, 5);
		Chemin ellipse = d.createEllipse(150, 150, 20, 15);
		ellipse.setCrayon(myCrayon);
		d.fill(ellipse, Color.BLUE);
		d.draw(ellipse);		
		
		Chemin arc = d.createArc(200, 200, 18, 10, 0, 90);
		d.draw(arc);
		
		Chemin rect = d.createRectangle(500, 500, 100, 100);
		d.fill(rect, Color.GRAY);
		d.draw(rect);		
		
		d.viewInBrowser();
	}
}
