package draw.interfaces.impl;

import java.awt.Graphics;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import draw.Dessin;
import draw.chemin.Chemin;
import draw.chemin.ComplexChemin;
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
import draw.utils.IDrawingCallback;

public class SvgDrawer implements IDrawer, IDrawingCallback {			
	
	List<Chemin> chemins = new ArrayList<Chemin>();
	BufferedWriter writer;
	String svgStartString = "<!DOCTYPE html>\n<html>\n<body>\n<svg height='1000' width='1000'>\n";
	String svgEndString = "\n</svg>\n</body>\n</html>";
	IFiller filler;
	ILabeler labeler;
	IInserter inserter;
	
	public SvgDrawer(IFiller filler, ILabeler labeler, IInserter inserter) {		
		
		this.filler = filler;
		this.labeler = labeler;
		this.inserter = inserter;		
	}

	@Override
	public void draw(Chemin chemin) {
		chemins.add(chemin);		
		try{ 
			writer = new BufferedWriter(new FileWriter(new File(Dessin.svgFilePath)));
			writer.write(svgStartString);
			for(Chemin c : chemins) {
				c.accept(this);		
			}
			writer.write(svgEndString);
		}
		catch(IOException e) {
			System.err.println(e.getMessage());
		}
		finally {
			try {
				writer.close();
			} catch (IOException e) {
				System.err.println(e.getMessage());
			}
		}
	}

	@Override
	public void drawingCallback(Line l) {		
		String pars = String.format("x1='%d' y1='%d' x2='%d' y2='%d' ", l.getP1().getX(), l.getP1().getY(), l.getP2().getX(), l.getP2().getY());
		String style = "style='";
		String stroke = String.format("stroke:rgb(%d,%d,%d); stroke-width:%d; ", l.getCrayon().getColor().getRed(), l.getCrayon().getColor().getGreen(), l.getCrayon().getColor().getBlue(), l.getCrayon().getThickness());
		style += stroke;
		style += "'";
		String xml = "<line " + pars + style + " />\n";
		try {
			writer.write(xml);			
			writer.flush();
		} catch(IOException e) {
			System.err.println(e.getMessage());
		}		
	}

	@Override
	public void drawingCallback(Circle c) {
		String pars = String.format("cx='%d' cy='%d' r='%d' ", c.getCenter().getX(), c.getCenter().getY(), c.getRadius());
		String style = "style='";
		String stroke = String.format("stroke:rgb(%d,%d,%d); stroke-width:%d; ", c.getCrayon().getColor().getRed(), c.getCrayon().getColor().getGreen(), c.getCrayon().getColor().getBlue(), c.getCrayon().getThickness());
		String fill = "";
		if(c.isClosed() && filler.contains(c) ) {
			fill += String.format("fill:rgb(%d,%d,%d); ", filler.getColor(c).getRed(), filler.getColor(c).getGreen(), filler.getColor(c).getBlue());
		}
		else {
			fill += "fill:rgb(255, 255, 255); ";
		}
		style += stroke;
		style += fill;
		style += "'";
		String xml = "<circle " + pars + style + " />\n";
		try {
			writer.write(xml);
			writer.flush();
		} catch(IOException e) {
			System.err.println(e.getMessage());
		}		
	}

	@Override
	public void drawingCallback(Point p) {
		String xml = "";
		if(!labeler.contains(p)) {
			String pars = String.format("cx='%d' cy='%d' r='%d' ", p.getX(), p.getY(), 1);
			String style = "style='";
			String stroke = String.format("stroke:rgb(%d,%d,%d); stroke-width:%d; ", p.getCrayon().getColor().getRed(), p.getCrayon().getColor().getGreen(), p.getCrayon().getColor().getBlue(), p.getCrayon().getThickness());
			style += stroke;		
			style += "'";
			xml = "<circle " + pars + style + " />\n";
		}
		else {
			String pars = String.format("x='%d' y='%d' ", p.getX(), p.getY());
			String style = "style='";
			String stroke = String.format("stroke:rgb(%d,%d,%d); stroke-width:%d; ", p.getCrayon().getColor().getRed(), p.getCrayon().getColor().getGreen(), p.getCrayon().getColor().getBlue(), p.getCrayon().getThickness());
			style += stroke;		
			style += "'";
			xml = "<text " + pars + style + ">" + labeler.getLabelMap(p) + "</text>\n";
		}		
		try {
			writer.write(xml);
			writer.flush();
		} catch(IOException e) {
			System.err.println(e.getMessage());
		}
	}

	@Override
	public void drawingCallback(Ellipse e) {
		String pars = String.format("cx='%d' cy='%d' rx='%d' ry='%d' ", e.getCenter().getX(), e.getCenter().getY(), e.getRadius_x(), e.getRadiux_y());
		String style = "style='";
		String stroke = String.format("stroke:rgb(%d,%d,%d); stroke-width:%d; ", e.getCrayon().getColor().getRed(), e.getCrayon().getColor().getGreen(), e.getCrayon().getColor().getBlue(), e.getCrayon().getThickness());
		
		String fill = "";
		if(e.isClosed() && filler.contains(e) ) {
			fill += String.format("fill:rgb(%d,%d,%d); ", filler.getColor(e).getRed(), filler.getColor(e).getGreen(), filler.getColor(e).getBlue());
		}
		else {
			fill += "fill:rgb(255, 255, 255); ";
		}		
		style += stroke;
		style += fill;
		style += "'";		
		String xml = "<ellipse " + pars + style + " />\n";
		try {
			writer.write(xml);
			writer.flush();
		} catch(IOException ex) {
			System.err.println(ex.getMessage());
		}
		
	}

	@Override
	public void drawingCallback(Arc l) {
		
		float angleInRadians = (float) (1f * (l.getStartAngle() - 90) * Math.PI / 180.0);
		float start_x = l.getCenter().getX() + (float)(l.getRadius_x() * Math.cos(angleInRadians));
		float start_y = l.getCenter().getY() + (float)(l.getRadius_y() * Math.sin(angleInRadians));
		
		float angleInRadians2 = (float) (1f * (l.getArcAngle() - 90) * Math.PI / 180.0);
		float end_x = l.getCenter().getX() + (float)(l.getRadius_x() * Math.cos(angleInRadians2));
		float end_y = l.getCenter().getY() + (float)(l.getRadius_y() * Math.sin(angleInRadians2));
		
		int arcSweep = l.getArcAngle() - l.getStartAngle() <= 180 ? 0 : 1; 
				
		String pars = String.format("d='M %f %f A %d %d %d %d %d %f %f' ", start_x, start_y, l.getRadius_x(), l.getRadius_y(), 0, arcSweep, 0, end_x, end_y);
		String style = "style='";
		String stroke = String.format("stroke:rgb(%d,%d,%d); stroke-width:%d; ", l.getCrayon().getColor().getRed(), l.getCrayon().getColor().getGreen(), l.getCrayon().getColor().getBlue(), l.getCrayon().getThickness());
		style += stroke;
		style += "'";
		String xml = "<path " + pars + style + " />\n";
		try {
			writer.write(xml);
			writer.flush();
		} catch(IOException ex) {
			System.err.println(ex.getMessage());
		}		
	}
	
	@Override
	public void drawingCallback(Rectangle r) {
		String pars = String.format("x='%d' y='%d' width='%d' height='%d' ", r.getP1().getX(), r.getP1().getY(), r.getWidth(), r.getHeight());
		String style = "style='";
		String stroke = String.format("stroke:rgb(%d,%d,%d); stroke-width:%d; ", r.getCrayon().getColor().getRed(), r.getCrayon().getColor().getGreen(), r.getCrayon().getColor().getBlue(), r.getCrayon().getThickness());
		
		String fill = "";
		if(r.isClosed() && filler.contains(r) ) {
			fill += String.format("fill:rgb(%d,%d,%d); ", filler.getColor(r).getRed(), filler.getColor(r).getGreen(), filler.getColor(r).getBlue());
		}
		else {
			fill += "fill:rgb(255, 255, 255); ";
		}		
		style += stroke;
		style += fill;
		style += "'";		
		String xml = "<rect " + pars + style + " />\n";
		try {
			writer.write(xml);
			writer.flush();
		} catch(IOException ex) {
			System.err.println(ex.getMessage());
		}		
	}

	@Override
	public void drawingCallback(ComplexChemin l) {
		// TODO Auto-generated method stub
		
	}


	

	

}
