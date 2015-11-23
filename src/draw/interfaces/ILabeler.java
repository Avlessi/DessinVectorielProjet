package draw.interfaces;

import java.util.Map;

import draw.chemin.shapes.Point;

public interface ILabeler {
	
	public void label(String text, Point location);
	
	public boolean contains(Point p);
	
	public String getLabelMap(Point p);
}
