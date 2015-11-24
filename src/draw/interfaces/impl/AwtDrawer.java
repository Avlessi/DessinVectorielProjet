package draw.interfaces.impl;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Area;
import java.awt.geom.Ellipse2D;
import java.awt.geom.GeneralPath;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;

import draw.callbacks.IDrawingAWTCallback;
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
			if(!chemins.contains(chemin)) {
				chemins.add(chemin);
			}
			//initiate a new invoke of the method void paint(Graphics g)
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
			Graphics2D g2 = (Graphics2D)g;

			g2.setColor(p.getCrayon().getColor());
			g2.setStroke(new BasicStroke(p.getCrayon().getThickness()));

			if(!labeler.contains(p)) { // simple point								
				g2.drawOval(p.getX(), p.getY(), 3, 3);
				g2.fillOval(p.getX(), p.getY(), 3, 3);
			}
			else { //label			
				String text = labeler.getLabelMap(p);				
				g2.drawString(text, p.getX(), p.getY());
			}
		}

		@Override
		public void drawingAWTCallback(Line l, Graphics g) {
			Graphics2D g2 = (Graphics2D)g;			

			g2.setColor(l.getCrayon().getColor());
			g2.setStroke(new BasicStroke(l.getCrayon().getThickness()));

			Line2D line = new Line2D.Float(l.getP1().getX(), l.getP1().getY(), l.getP2().getX(), l.getP2().getY());
			g2.draw(line);
		}

		@Override
		public void drawingAWTCallback(Circle c, Graphics g) {
			Graphics2D g2 = (Graphics2D)g;

			g2.setColor(c.getCrayon().getColor());
			g2.setStroke(new BasicStroke(c.getCrayon().getThickness()));

			if(!inserter.contains(c)) {				
				g2.drawOval(c.getCenter().getX() - c.getRadius(), c.getCenter().getY() - c.getRadius(), 2 * c.getRadius(), 2 * c.getRadius());
			}

			// fill
			if(filler.contains(c)) {				
				g2.setColor(filler.getColor(c));				
				g2.fillOval(c.getCenter().getX() - c.getRadius(), c.getCenter().getY() - c.getRadius(), 2 * c.getRadius(), 2 * c.getRadius());
			}

			//insert
			if(inserter.contains(c)) {				
				Rectangle r = inserter.getClipRect(c);
				Rectangle2D rect = new Rectangle2D.Float(r.getP1().getX(), r.getP1().getY(), r.getWidth(), r.getHeight());				
				g2.setClip(rect);				
				g2.fillOval(c.getCenter().getX() - c.getRadius(), c.getCenter().getY() - c.getRadius(), 2 * c.getRadius(), 2 * c.getRadius());
				//clear clip
				g2.setClip(null);
			}
		}		

		@Override
		public void drawingAWTCallback(Ellipse ellipse, Graphics g) {
			Graphics2D g2 = (Graphics2D)g;						

			g2.setColor(ellipse.getCrayon().getColor());
			g2.setStroke(new BasicStroke(ellipse.getCrayon().getThickness()));
			if(!inserter.contains(ellipse)) {				
				g2.drawOval(ellipse.getCenter().getX() - ellipse.getRadius_x(), ellipse.getCenter().getY() - ellipse.getRadius_y(),
						2 * ellipse.getRadius_x(), 2 * ellipse.getRadius_y());
			}
			
			//fill
			if(filler.contains(ellipse) ) {				
				g2.setColor(filler.getColor(ellipse));				
				g2.fillOval(ellipse.getCenter().getX() - ellipse.getRadius_x(), ellipse.getCenter().getY() - ellipse.getRadius_y(),
						2 * ellipse.getRadius_x(), 2 * ellipse.getRadius_y());
			}

			//insert
			if(inserter.contains(ellipse)) {				
				Rectangle r = inserter.getClipRect(ellipse);
				Rectangle2D rect = new Rectangle2D.Float(r.getP1().getX(), r.getP1().getY(), r.getWidth(), r.getHeight());				
				g2.setClip(rect);				
				g2.fillOval(ellipse.getCenter().getX() - ellipse.getRadius_x(), ellipse.getCenter().getY() - ellipse.getRadius_y(),
						2 * ellipse.getRadius_x(), 2 * ellipse.getRadius_y());
				//clear clip
				g2.setClip(null);
			}
		}

		@Override
		public void drawingAWTCallback(Arc arc, Graphics g) {
			Graphics2D g2 = (Graphics2D)g;

			g2.setColor(arc.getCrayon().getColor());
			g2.setStroke(new BasicStroke(arc.getCrayon().getThickness()));

			g2.drawArc(arc.getCenter().getX() - arc.getRadius_x(), arc.getCenter().getY() - arc.getRadius_y(),
					2 * arc.getRadius_x(), 2 * arc.getRadius_y(), arc.getStartAngle(), arc.getArcAngle());			
		}

		@Override
		public void drawingAWTCallback(Rectangle r, Graphics g) {
			Graphics2D g2 = (Graphics2D)g;

			g2.setColor(r.getCrayon().getColor());
			g2.setStroke(new BasicStroke(r.getCrayon().getThickness()));

			if(!inserter.contains(r)) {
				g2.drawRect(r.getP1().getX(), r.getP1().getY(), r.getWidth(), r.getHeight());
			}

			// fill
			if(filler.contains(r)) {			
				g2.setColor(filler.getColor(r));
				g2.fillRect(r.getP1().getX(), r.getP1().getY(), r.getWidth(), r.getHeight());
			}

			//insert
			if(inserter.contains(r)) {				
				Rectangle clipRect = inserter.getClipRect(r);
				Rectangle2D rect = new Rectangle2D.Float(clipRect.getP1().getX(), clipRect.getP1().getY(), clipRect.getWidth(), clipRect.getHeight());				
				g2.setClip(rect);				
				g2.fillRect(r.getP1().getX(), r.getP1().getY(), r.getWidth(), r.getHeight());
				//clear clip
				g2.setClip(null);
			}
		}

		@Override
		public void drawingAWTCallback(ComplexChemin l, Graphics g) {
			g.setColor(defaultColor);
			Graphics2D g2 = (Graphics2D)g;			

			CheminConnection connection = l.getConnection();
			while(connection != null) {						

				if(connection.getConnectionType() == ConnectionType.Line) {					
					g.drawLine(connection.getChemin().getStartPoint().getX(), 
							connection.getChemin().getStartPoint().getY(), 
							connection.getParentConnection().getChemin().getEndPoint().getX(),
							connection.getParentConnection().getChemin().getEndPoint().getY());


				}
				else if(connection.getConnectionType() == ConnectionType.BezierCurve) {

					BezierCurveConnection bezierConnection = (BezierCurveConnection)connection;					

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
				}								
				connection.getChemin().accept(this, g);

				connection = connection.getParentConnection();
			} 

		}		

	}	

	@Override
	public void draw(Chemin chemin) {	
		panel.addChemin(chemin);		
	}	
}
