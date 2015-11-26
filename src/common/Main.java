package common;

import java.awt.Color;

import draw.Dessin;
import draw.DrawType;
import draw.chemin.Chemin;
import draw.utils.Crayon;

public class Main {
	public static void main(String [] args) {

		// make drawing using all existing graphics implementations
		for(DrawType drawType : DrawType.values()) {
			
			// create a drawing context and provide it a type of drawing you wish:
			//DrawType.AWT or DrawType.SVG
			Dessin d = new Dessin(drawType);
			
			//create Crayon instance which will define a color and a thickness of a figure
			//it will be associated with 
			Crayon crayon = d.createCrayon(Color.BLUE, 1);
			
			//create line
			Chemin ligne = d.createLine(5, 5, 5, 15);
			//associate crayon
			ligne.setCrayon(crayon);
			
			//draw a figure
			d.draw(ligne);

			Chemin ligne2 = d.createLine(500, 5, 500, 15);
			d.draw(ligne2);

			//connection a figure with another figure using cubic Bezier curve.
			//integer arguments like these (200, 100), (400, 100) are Bezier control points  
			Chemin path = ligne.connectWithBezier(ligne2, 200, 100, 400, 100);
			d.draw(path);

			//create line
			Chemin ligne3 = d.createLine(600, 40, 650, 100);
			d.draw(ligne3);				

			//coonection a figure with another figure using a line
			Chemin path2 = path.connectWithLine(ligne3);
			
			//draw a figure
			d.draw(path2);
			
			//make a label at a point (150, 50)
			d.label("Complex path", 150, 50);

			//create point
			Chemin p = d.createPoint(800, 600);
			d.draw(p);			
			
			d.label("simple point", 800, 590);

			Crayon circleCrayon = d.createCrayon(Color.orange, 4);
			//create circle
			Chemin circle = d.createCircle(800, 400, 100);
			circle.setCrayon(circleCrayon);
			d.draw(circle);			

			Crayon myCrayon = d.createCrayon(Color.GREEN, 5);
			//create ellipse 
			//here (150,150) - coordinates of a center
			//20, 15 - radius_x and radius_y correspondingly
			Chemin ellipse = d.createEllipse(150, 150, 20, 15);
			ellipse.setCrayon(myCrayon);
			
			//fill ellipse with blue color
			d.fill(ellipse, Color.BLUE);
			d.draw(ellipse);			
			
			//make a label
			d.label("Orange rectangle", 400, 400);
			
			//create rectangle
			Chemin rect = d.createRectangle(400, 400, 200, 200);
			d.fill(rect, Color.ORANGE);
			d.draw(rect);	
			
			//create a circle
			Chemin circle1 = d.createCircle(200, 200, 50);
			
			//label
			d.label("Insert circle", 200, 200);
			
			//clip circle into a rectangular area
			//Here (200,200) are coordinates of left_x,top_y point, 150 and 150 are
			//width and length correspondingly
 			d.insert(circle1, 200, 200, 150, 150);
			
			//draw circle to make an update after insert
			d.draw(circle1);

			if(drawType == DrawType.SVG)
				d.viewInBrowser();
									
		}	
	}
}
