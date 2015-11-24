package common;

import java.awt.Color;

import draw.Dessin;
import draw.DrawType;
import draw.chemin.Chemin;
import draw.utils.Crayon;

public class Main {
	public static void main(String [] args) {

		for(DrawType drawType : DrawType.values()) {
			
			Dessin d = new Dessin(drawType);		
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
			
			d.label("Complex path", 150, 50);

			Chemin p = d.createPoint(800, 600);
			d.draw(p);			
			d.label("simple point", 800, 590);

			Crayon circleCrayon = d.createCrayon(Color.orange, 4);
			Chemin circle = d.createCircle(800, 400, 100);
			circle.setCrayon(circleCrayon);
			d.draw(circle);			

			Crayon myCrayon = d.createCrayon(Color.GREEN, 5);
			Chemin ellipse = d.createEllipse(150, 150, 20, 15);
			ellipse.setCrayon(myCrayon);
			d.fill(ellipse, Color.BLUE);
			d.draw(ellipse);			
			
			d.label("Orange rectangle", 400, 400);
			Chemin rect = d.createRectangle(400, 400, 200, 200);
			d.fill(rect, Color.ORANGE);
			d.draw(rect);	
			
			Chemin circle1 = d.createCircle(200, 200, 50);
						
			d.label("Insert circle", 200, 200);
			d.insert(circle1, 200, 200, 150, 150);
			
			d.draw(circle1);

			if(drawType == DrawType.SVG)
				d.viewInBrowser();
		}	
	}
}
