package draw.interfaces.impl;

import java.awt.Graphics;

import com.sun.istack.internal.Nullable;

import draw.chemin.shapes.Arc;
import draw.chemin.shapes.Cercle;
import draw.chemin.shapes.Ellipse;
import draw.chemin.shapes.Ligne;
import draw.chemin.shapes.Point;
import draw.utils.Crayon;
import draw.visitors.interfaces.IDessinateur;


public class Graphics2dDessinateur implements IDessinateur {
	
	public Graphics2dDessinateur() {
		
	}
	
	@Override
	public void dessine(Ellipse e, Crayon crayon, @Nullable Graphics g) {
		
		
	}

	@Override
	public void dessine(Cercle c, Crayon crayon, @Nullable Graphics g) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void dessine(Arc a, Crayon crayon, @Nullable Graphics g) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void dessine(Point p, Crayon crayon, @Nullable Graphics g) {
		System.out.println("dessine Point");
		//method g.drawPoint unfortunately does not exist, so use this workaround
		g.drawLine(p.getX(), p.getY(), p.getX(), p.getY());
		
	}

	@Override
	public void dessine(Ligne l, Crayon crayon, @Nullable Graphics g) {
		System.out.println("dessine Ligne");
		g.drawLine(l.getP1().getX(), l.getP1().getY(), l.getP2().getX(), l.getP2().getY());
				
	}

	
	
	/*public void paint(Graphics g) {
		System.out.println("time to paint!");
		super.paintComponent(g);
		// Draw Text
        g.drawString("This is my custom Panel!", 10, 20);		
		
	}*/
}
