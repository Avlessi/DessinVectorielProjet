package draw;

import java.awt.Color;

import draw.chemin.Chemin;
import draw.chemin.shapes.Point;
import draw.chemin.shapes.Rectangle;
import draw.factories.IDrawerFactory;
import draw.factories.IFillerFactory;
import draw.factories.IInserterFactory;
import draw.factories.ILabelerFactory;
import draw.factories.impl.DrawerFactory;
import draw.factories.impl.FillerFactory;
import draw.factories.impl.InserterFactory;
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
	IInserterFactory insertFactory;
	
	public Painter(DrawType drawType) {
		
		fillFactory = new FillerFactory();
		labelFactory = new LabelerFactory();
		insertFactory = new InserterFactory();
		
		drawFactory = new DrawerFactory();		
		
		this.filler = fillFactory.create(drawType);
		this.labeler = labelFactory.create(drawType);
		this.inserter = insertFactory.create(drawType);
		
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
	
	public void insert(Chemin cheminToCut, Rectangle clipRect) {
		if(inserter != null) {
			inserter.insert(cheminToCut, clipRect);
		}
	}

	public IDrawerFactory getDrawFactory() {
		return drawFactory;
	}

	public void setDrawFactory(IDrawerFactory drawFactory) {
		this.drawFactory = drawFactory;
	}

	public IFillerFactory getFillFactory() {
		return fillFactory;
	}

	public void setFillFactory(IFillerFactory fillFactory) {
		this.fillFactory = fillFactory;
	}

	public ILabelerFactory getLabelFactory() {
		return labelFactory;
	}

	public void setLabelFactory(ILabelerFactory labelFactory) {
		this.labelFactory = labelFactory;
	}

	public IInserterFactory getInsertFactory() {
		return insertFactory;
	}

	public void setInsertFactory(IInserterFactory insertFactory) {
		this.insertFactory = insertFactory;
	}	
}
