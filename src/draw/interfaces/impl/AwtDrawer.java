package draw.interfaces.impl;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;

import draw.awt.EllipseAWT;
import draw.chemin.Chemin;
import draw.chemin.ComplexChemin;
import draw.chemin.shapes.Arc;
import draw.chemin.shapes.Circle;
import draw.chemin.shapes.Ellipse;
import draw.chemin.shapes.Line;
import draw.chemin.shapes.Point;
import draw.interfaces.IDrawer;
import draw.utils.IDrawingAWTCallback;

public class AwtDrawer extends JFrame implements IDrawer {
	
	DrawPanel panel;
	
	public AwtDrawer() {
		panel = new DrawPanel();
		this.add(panel);
		this.pack();
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}
	
	class DrawPanel extends JPanel implements IDrawingAWTCallback {
		
		List<Chemin> chemins = new ArrayList<Chemin>();
		
		public void addChemin(Chemin chemin) {
			chemins.add(chemin);
			repaint();
		}
		
		
		@Override
		public void paint(Graphics g) {
			super.paintComponent(g);
			for(Chemin chemin : chemins) {
				chemin.accept(this, g);		
			}
		}

		
		@Override
		public void drawingAWTCallback(Point p, Graphics g) {
			System.out.println("paint point");
			g.drawOval(p.getX(), p.getY(), 3, 3);			
		}
		
		@Override
		public void drawingAWTCallback(Line l, Graphics g) {
			System.out.println("paint line");
			g.drawLine(l.getP1().getX(), l.getP1().getY(), l.getP2().getX(), l.getP2().getY());
		}

		@Override
		public void drawingAWTCallback(Circle c, Graphics g) {
			System.out.println("paint circle");
			g.drawArc(c.getCenter().getX(), c.getCenter().getY(), 2 * c.getRadius(), 2 * c.getRadius(), 0, 360);
			
		}		

		@Override
		public void drawingAWTCallback(Ellipse ellipse, Graphics g) {
			System.out.println("paint ellipse");
			g.drawArc(ellipse.getCenter().getX(), ellipse.getCenter().getY(), 2 * ellipse.getRadius_x(), 2 * ellipse.getRadiux_y(), 0, 360);
			
		}

		@Override
		public void drawingAWTCallback(Arc arc, Graphics g) {
			System.out.println("paint arc");
			g.drawArc(arc.getCenter().getX(), arc.getCenter().getY(), 2 * arc.getRadius_x(), 2 * arc.getRadius_y(), arc.getStartAngle(), arc.getArcAngle());
		}

		@Override
		public void drawingAWTCallback(ComplexChemin l, Graphics g) {
			// TODO Auto-generated method stub
			
		}
	}
	
	public void update(Ellipse e, Object g) {
		Graphics g2 = (Graphics) g;
		EllipseAWT a = new EllipseAWT(e);
		a.paint(g2);
	}

	@Override
	public void draw(Chemin chemin) {	
		panel.addChemin(chemin);
		
	}

	
}
