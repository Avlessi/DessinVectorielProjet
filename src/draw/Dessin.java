package draw;

import java.awt.Color;

import draw.chemin.Chemin;
import draw.chemin.shapes.Arc;
import draw.chemin.shapes.Circle;
import draw.chemin.shapes.Ellipse;
import draw.chemin.shapes.Point;
import draw.factories.DrawerFactory;
import draw.factories.IDrawerFactory;
import draw.factories.ShapesFactory;
import draw.utils.Crayon;

/**
 *
 * Dessin class serves as a manager class
 */

public class Dessin {
	Painter painter;	
	IDrawerFactory drawFactory;
	DrawType drawType;
	
	public Dessin() {		
		drawType = DrawType.AWT; // set default draw type
		drawFactory = new DrawerFactory();		
		painter = new Painter(drawFactory.create(drawType));				
	}
	
	protected void setPainter(Painter p) {
		this.painter = p;
	}
	
	/**	 
	 * this method will reset Drawer!  
	 * 
	 */
	public void setDrawType(DrawType type) {		
		if(drawType != type) {
			drawType = type;
			// go to another drawing implementation
			// a new drawer context will be created
			painter.setDrawer(drawFactory.create(type));
		}		
	}
	/**
	 * get drawer type
	 * @return
	 */
	public DrawType getDrawType() {
		return this.drawType;
	}	
	
	public void draw(Chemin chemin) {		
		painter.draw(chemin);		
	}
	
	public void label() {
		//TODO
		//painter.label();
	}
	
	public void fill() {
		//TODO
		//painter.fill();
	}
	
	public void insert() {
		//TODO
		//painter.insert():
	}
	
	public Chemin createPoint(int x, int y) {
		return ShapesFactory.createPoint(x, y);
	}
	
	public Chemin createLine(int x1, int y1, int x2, int y2) {
		return ShapesFactory.createLine(x1, y1, x2, y2);
	}	
	
	public Chemin createArc(int center_x, int center_y, int rx, int ry, int startAngle, int arcAngle) {
		return ShapesFactory.createArc(ShapesFactory.createPoint(center_x, center_y), rx, ry, startAngle, arcAngle);
	}
	
	public Chemin createEllipse(int center_x, int center_y, int rx, int ry) {
		return ShapesFactory.createEllipse(ShapesFactory.createPoint(center_x, center_y), rx, ry);
	}
	
	public Chemin createCircle(int center_x, int center_y, int r) {
		return ShapesFactory.createCircle(ShapesFactory.createPoint(center_x, center_y), r);		
	}		
	
	public Crayon createCrayon(Color color, int thickness) {
		return new Crayon(color, thickness);
	}
	
}