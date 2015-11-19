package draw.interfaces.impl;

import draw.chemin.Chemin;
import draw.chemin.ComplexChemin;
import draw.chemin.shapes.Arc;
import draw.chemin.shapes.Circle;
import draw.chemin.shapes.Ellipse;
import draw.chemin.shapes.Line;
import draw.chemin.shapes.Point;
import draw.interfaces.IDrawer;
import draw.utils.IDrawingCallback;

public class SvgDrawer implements IDrawer, IDrawingCallback {

	@Override
	public void draw(Chemin chemin) {
		chemin.accept(this);
	}

	@Override
	public void drawingCallback(Line l) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void drawingCallback(Circle c) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void drawingCallback(Point p) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void drawingCallback(Ellipse e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void drawingCallback(Arc l) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void drawingCallback(ComplexChemin l) {
		// TODO Auto-generated method stub
		
	}

}
