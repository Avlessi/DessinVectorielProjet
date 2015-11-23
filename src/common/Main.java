package common;

import java.awt.Color;

import draw.Canvas;
import draw.Dessin;
import draw.DrawType;
import draw.chemin.Chemin;
import draw.utils.Crayon;

public class Main {
	public static void main(String [] args) {
		//Canvas c = Canvas.getCanvas();
		Dessin d = new Dessin(DrawType.SVG);		
		Crayon crayon = d.createCrayon(Color.BLUE, 1);
		
		Chemin ligne = d.createLine(5, 5, 15, 15);
		ligne.setCrayon(crayon);
		d.draw(ligne);
		
		Chemin ligne2 = d.createLine(30, 30, 60, 60);
		d.draw(ligne2);
		
		Chemin p = d.createPoint(75, 75);
		d.draw(p);
		
		Crayon circleCrayon = d.createCrayon(Color.orange, 4);
		Chemin circle = d.createCircle(100, 100, 20);
		circle.setCrayon(circleCrayon);
		d.draw(circle);
		
		d.label("Cool text", 10, 10);
		
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
