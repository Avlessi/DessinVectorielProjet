package draw.interfaces.impl;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;

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
	Color defaultColor = Color.BLACK;
	
	
	public AwtDrawer() {
		panel = new DrawPanel();
		this.add(panel);
		this.pack();
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}	
	
	class DrawPanel extends JPanel implements IDrawingAWTCallback {
		Graphics g;
		List<Chemin> chemins = new ArrayList<Chemin>();
				
		public void addChemin(Chemin chemin) {
			chemins.add(chemin);
			repaint();
		}
		
		
		@Override
		public void paint(Graphics g) {
			super.paintComponent(g);	
			g.setColor(defaultColor);
			
			for(Chemin chemin : chemins) {
				chemin.accept(this, g);		
			}
		}

		
		@Override
		public void drawingAWTCallback(Point p, Graphics g) {
			System.out.println("paint point");
			
			Graphics2D g2 = (Graphics2D)g;			
			g2.setColor(defaultColor);
			
			if(p.getCrayon() != null) {
				g2.setColor(p.getCrayon().getColor());
				g2.setStroke(new BasicStroke(p.getCrayon().getThickness()));
			}
			g2.drawOval(p.getX(), p.getY(), 3, 3);			
		}
		
		@Override
		public void drawingAWTCallback(Line l, Graphics g) {
			System.out.println("paint line");
			g.setColor(defaultColor);
			
						
			Graphics2D g2 = (Graphics2D)g;			
			g2.setColor(defaultColor);
			
			if(l.getCrayon() != null) {
				g2.setColor(l.getCrayon().getColor());
				g2.setStroke(new BasicStroke(l.getCrayon().getThickness()));
			}
			g2.drawLine(l.getP1().getX(), l.getP1().getY(), l.getP2().getX(), l.getP2().getY());
		}

		@Override
		public void drawingAWTCallback(Circle c, Graphics g) {
			System.out.println("paint circle");
			g.setColor(defaultColor);
			
			Graphics2D g2 = (Graphics2D)g;			
			g2.setColor(defaultColor);
			
			if(c.getCrayon() != null) {
				g2.setColor(c.getCrayon().getColor());
				g2.setStroke(new BasicStroke(c.getCrayon().getThickness()));
			}
			g.drawArc(c.getCenter().getX(), c.getCenter().getY(), 2 * c.getRadius(), 2 * c.getRadius(), 0, 360);
			
		}		

		@Override
		public void drawingAWTCallback(Ellipse ellipse, Graphics g) {
			System.out.println("paint ellipse");
			g.setColor(defaultColor);
			
			Graphics2D g2 = (Graphics2D)g;			
			g2.setColor(defaultColor);
			
			if(ellipse.getCrayon() != null) {
				g2.setColor(ellipse.getCrayon().getColor());
				g2.setStroke(new BasicStroke(ellipse.getCrayon().getThickness()));
			}
			g2.drawArc(ellipse.getCenter().getX(), ellipse.getCenter().getY(), 2 * ellipse.getRadius_x(), 2 * ellipse.getRadiux_y(), 0, 360);
			
		}

		@Override
		public void drawingAWTCallback(Arc arc, Graphics g) {
			System.out.println("paint arc");
			g.setColor(defaultColor);
			
			Graphics2D g2 = (Graphics2D)g;			
			g2.setColor(defaultColor);
			
			if(arc.getCrayon() != null) {
				g2.setColor(arc.getCrayon().getColor());
				g2.setStroke(new BasicStroke(arc.getCrayon().getThickness()));
			}
			g2.drawArc(arc.getCenter().getX(), arc.getCenter().getY(), 2 * arc.getRadius_x(), 2 * arc.getRadius_y(), arc.getStartAngle(), arc.getArcAngle());
		}

		@Override
		public void drawingAWTCallback(ComplexChemin l, Graphics g) {
			g.setColor(defaultColor);
			// TODO Auto-generated method stub			
		}
	}	

	@Override
	public void draw(Chemin chemin) {	
		panel.addChemin(chemin);
		
	}

	
}