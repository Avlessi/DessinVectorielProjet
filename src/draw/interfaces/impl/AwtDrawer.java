package draw.interfaces.impl;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.GeneralPath;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;

import draw.chemin.Chemin;
import draw.chemin.ComplexChemin;
import draw.chemin.connection.CheminConnection;
import draw.chemin.connection.CheminConnection.ConnectionType;
import draw.chemin.connection.impl.BezierCurveConnection;
import draw.chemin.shapes.Arc;
import draw.chemin.shapes.Circle;
import draw.chemin.shapes.Ellipse;
import draw.chemin.shapes.Line;
import draw.chemin.shapes.Point;
import draw.chemin.shapes.Rectangle;
import draw.interfaces.IDrawer;
import draw.interfaces.IFiller;
import draw.interfaces.IInserter;
import draw.interfaces.ILabeler;
import draw.utils.IDrawingAWTCallback;

public class AwtDrawer extends JFrame implements IDrawer {
	
	DrawPanel panel;
	Color defaultColor = Color.BLACK;
	IFiller filler;
	ILabeler labeler;
	IInserter inserter;
	
	public AwtDrawer(IFiller filler, ILabeler labeler, IInserter inserter) {		
		panel = new DrawPanel();
		panel.setPreferredSize(new Dimension(1000,1000)); 
		
		this.filler = filler;
		this.labeler = labeler;
		this.inserter = inserter;
		
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
			Graphics2D g2 = (Graphics2D)g;
			
			g2.setColor(p.getCrayon().getColor());
			g2.setStroke(new BasicStroke(p.getCrayon().getThickness()));
			
			if(!labeler.contains(p)) { // simple point								
				g2.drawOval(p.getX(), p.getY(), 3, 3);
			}
			else { //label			
				String text = labeler.getLabelMap(p);				
				g2.drawString(text, p.getX(), p.getY());
			}
		}
		
		@Override
		public void drawingAWTCallback(Line l, Graphics g) {			
			g.setColor(defaultColor);			
						
			Graphics2D g2 = (Graphics2D)g;			
			
			g2.setColor(l.getCrayon().getColor());
			g2.setStroke(new BasicStroke(l.getCrayon().getThickness()));
			
			g2.drawLine(l.getP1().getX(), l.getP1().getY(), l.getP2().getX(), l.getP2().getY());			
		}

		@Override
		public void drawingAWTCallback(Circle c, Graphics g) {			
			g.setColor(defaultColor);
			
			Graphics2D g2 = (Graphics2D)g;			
			
			if(c.getCrayon() != null) {
				g2.setColor(c.getCrayon().getColor());
				g2.setStroke(new BasicStroke(c.getCrayon().getThickness()));
			}
			g.drawArc(c.getCenter().getX(), c.getCenter().getY(), 2 * c.getRadius(), 2 * c.getRadius(), 0, 360);
			
			// fill
			if(c.isClosed() && filler.contains(c) ) {			
				filler.getColor(c);
				g2.setColor(filler.getColor(c));
				g.fillArc(c.getCenter().getX(), c.getCenter().getY(), 2 * c.getRadius(), 2 * c.getRadius(), 0, 360);
			}			
		}		

		@Override
		public void drawingAWTCallback(Ellipse ellipse, Graphics g) {			
			g.setColor(defaultColor);
			
			Graphics2D g2 = (Graphics2D)g;			
			g2.setColor(defaultColor);
			
			if(ellipse.getCrayon() != null) {
				g2.setColor(ellipse.getCrayon().getColor());
				g2.setStroke(new BasicStroke(ellipse.getCrayon().getThickness()));
			}
			g2.drawArc(ellipse.getCenter().getX(), ellipse.getCenter().getY(), 2 * ellipse.getRadius_x(), 2 * ellipse.getRadiux_y(), 0, 360);
								
			//fill
			if(ellipse.isClosed() && filler.contains(ellipse) ) {			
				filler.getColor(ellipse);
				g2.setColor(filler.getColor(ellipse));
				g2.fillArc(ellipse.getCenter().getX(), ellipse.getCenter().getY(), 2 * ellipse.getRadius_x(), 2 * ellipse.getRadiux_y(), 0, 360);
			}			
			
			
		}

		@Override
		public void drawingAWTCallback(Arc arc, Graphics g) {			
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
		public void drawingAWTCallback(Rectangle r, Graphics g) {
			
			g.setColor(defaultColor);
			
			Graphics2D g2 = (Graphics2D)g;			
			
			if(r.getCrayon() != null) {
				g2.setColor(r.getCrayon().getColor());
				g2.setStroke(new BasicStroke(r.getCrayon().getThickness()));
			}
			g2.drawRect(r.getP1().getX(), r.getP1().getY(), r.getWidth(), r.getHeight());
			
			// fill
			if(r.isClosed() && filler.contains(r) ) {			
				filler.getColor(r);
				g2.setColor(filler.getColor(r));
				g2.fillRect(r.getP1().getX(), r.getP1().getY(), r.getWidth(), r.getHeight());
			}			
		}

		@Override
		public void drawingAWTCallback(ComplexChemin l, Graphics g) {
			g.setColor(defaultColor);
			Graphics2D g2 = (Graphics2D)g;
			
			System.out.println("draw complex path");
			
			CheminConnection connection = l.getConnection();
			while(connection != null) {
				Chemin c = connection.getChemin();
				
				System.out.println(connection.getConnectionType());
				
				if(connection.getConnectionType() == ConnectionType.Line) {					
					g.drawLine(connection.getChemin().getStartPoint().getX(), 
							connection.getChemin().getStartPoint().getY(), 
						    connection.getParentConnection().getChemin().getEndPoint().getX(),
						    connection.getParentConnection().getChemin().getEndPoint().getY());
				}
				else if(connection.getConnectionType() == ConnectionType.BezierCurve) {
					
					BezierCurveConnection bezierConnection = (BezierCurveConnection)connection;
					
					System.out.println("chemin is " + bezierConnection.getChemin());
					
					GeneralPath path = new GeneralPath();
					path.moveTo(bezierConnection.getParentConnection().getChemin().getEndPoint().getX(),
							bezierConnection.getParentConnection().getChemin().getEndPoint().getY());
					
					path.curveTo(bezierConnection.getX1(), bezierConnection.getY1(),
							bezierConnection.getX2(), bezierConnection.getY2(),
							bezierConnection.getChemin().getStartPoint().getX(), 
							bezierConnection.getChemin().getStartPoint().getY());
					g2.draw(path);
				}
				else if(connection.getConnectionType() == ConnectionType.Empty) {					
					connection.getChemin().accept(this, g);
				}				
				
				connection = connection.getParentConnection();
			} 
			
		}		

		
	}	

	@Override
	public void draw(Chemin chemin) {	
		panel.addChemin(chemin);		
	}	
}
