package draw;

import java.awt.Color;

import draw.chemin.Chemin;
import draw.chemin.shapes.Point;
import draw.factories.IDrawerFactory;
import draw.factories.IFillerFactory;
import draw.factories.ILabelerFactory;
import draw.factories.impl.DrawerFactory;
import draw.factories.impl.FillerFactory;
import draw.factories.impl.LabelerFactory;
import draw.interfaces.IDrawer;
import draw.interfaces.IFiller;
import draw.interfaces.IInserter;
import draw.interfaces.ILabeler;

public class Painter {
	IDrawer drawer;
	ILabeler labeler;	
	IFiller filler;
	IInserter inserter;
	
	IDrawerFactory drawFactory;
	IFillerFactory fillFactory;
	ILabelerFactory labelFactory;
	
	public Painter(DrawType drawType) {
		
		fillFactory = new FillerFactory();
		labelFactory = new LabelerFactory();
		
		drawFactory = new DrawerFactory();
		
		
		this.filler = fillFactory.create(drawType);
		this.labeler = labelFactory.create(drawType);
		
		this.drawer = drawFactory.create(drawType, filler, labeler, inserter);		
	}	
	
	public void draw(Chemin chemin) {
		drawer.draw(chemin);
	}
	
	public void label(String text, Point location) {
		if(labeler != null) {
			labeler.label(text, location);
		}
	}
	
	public void fill(Chemin chemin, Color color) {
		if(filler != null) {			
			filler.fill(chemin, color);
		}
	}
	
	public void setDrawer(IDrawer drawer) {
		this.drawer = drawer;
	}		
	
	public void setFiller(IFiller filler) {
		this.filler = filler;
	}
	
	public void setLabeler(ILabeler labeler) {
		this.labeler = labeler;
	}
}
