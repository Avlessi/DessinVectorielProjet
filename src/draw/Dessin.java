package draw;

import java.awt.Color;
import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

import draw.chemin.Chemin;
import draw.chemin.shapes.Point;
import draw.factories.IShapesFactory;
import draw.factories.impl.ShapesFactory;
import draw.utils.Crayon;

/**
 *
 * Dessin class serves as a manager class. All drawing functions and
 * creation of new figures should be addressed to this class 
 */

public class Dessin {
	public static final String svgFilePath = "output/svg.html";
	private Painter painter;		
	private DrawType drawType;
	private IShapesFactory shapesFactory;

	public Dessin(DrawType type) {
		shapesFactory = new ShapesFactory();
		drawType = type;		
		painter = new Painter(type);		

	}

	protected void setPainter(Painter p) {
		this.painter = p;
	}
	
	protected void setShapesFactory(IShapesFactory factory) {
		shapesFactory = factory;
	}

	/*public void setDrawType(DrawType type) {
		this.drawType = type;
	}*/

	public DrawType getDrawType() {		
		return this.drawType;
	}	

	public void draw(Chemin chemin) {		
		painter.draw(chemin);		
	}

	public void label(String text, int x, int y) {
		Point p = shapesFactory.createPoint(x, y);		
		painter.draw(p);		
		painter.label(text, p);
	}

	public void fill(Chemin chemin, Color color) {		
		painter.fill(chemin, color);
	}

	public void insert(Chemin cheminToCut, int left_x, int top_y, int width, int height) {		
		painter.insert(cheminToCut, shapesFactory.createRectangle(left_x, top_y, width, height));
	}

	public Chemin createPoint(int x, int y) {
		return shapesFactory.createPoint(x, y);
	}

	public Chemin createLine(int x1, int y1, int x2, int y2) {
		return shapesFactory.createLine(x1, y1, x2, y2);
	}	

	public Chemin createArc(int center_x, int center_y, int rx, int ry, int startAngle, int arcAngle) {
		return shapesFactory.createArc(shapesFactory.createPoint(center_x, center_y), rx, ry, startAngle, arcAngle);
	}

	public Chemin createEllipse(int center_x, int center_y, int rx, int ry) {
		return shapesFactory.createEllipse(shapesFactory.createPoint(center_x, center_y), rx, ry);
	}

	public Chemin createCircle(int center_x, int center_y, int r) {
		return shapesFactory.createCircle(shapesFactory.createPoint(center_x, center_y), r);		
	}

	public Chemin createRectangle(int x1, int y1, int x2, int y2, int x3, int y3, int x4, int y4) {
		return shapesFactory.createRectangle(shapesFactory.createPoint(x1, y1), 
				shapesFactory.createPoint(x2, y2), shapesFactory.createPoint(x3, y3), 
				shapesFactory.createPoint(x4, y4));
	}
	
	public Chemin createRectangle(int left_x, int top_y, int width, int height) {
		return shapesFactory.createRectangle(left_x, top_y, width, height);
	}

	public Crayon createCrayon(Color color, int thickness) {
		return new Crayon(color, thickness);
	}

	public void viewInBrowser() {
		if(drawType == DrawType.SVG) {
			File svgFile = new File(Dessin.svgFilePath);
			try {
				Desktop.getDesktop().browse(svgFile.toURI());
			} catch (IOException e) {				
				e.printStackTrace();
			}		
		}
	}
}