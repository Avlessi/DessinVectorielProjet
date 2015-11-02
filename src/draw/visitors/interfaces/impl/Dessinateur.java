package draw.visitors.interfaces.impl;

import java.awt.Graphics2D;

import draw.chemin.shapes.Arc;
import draw.chemin.shapes.Cercle;
import draw.chemin.shapes.Ellipse;
import draw.chemin.shapes.Point;
import draw.utils.Crayon;
import draw.visitors.interfaces.IDessinateur;

public class Dessinateur implements IDessinateur {
	
	public Dessinateur(Graphics2D g) {
		
	}
	
		

	@Override
	public void dessine(Ellipse e, Crayon crayon) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void dessine(Cercle c, Crayon crayon) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void dessine(Arc a, Crayon crayon) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void dessine(Point p, Crayon crayon) {
		// TODO Auto-generated method stub
		
	}

}
