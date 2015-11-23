package draw.interfaces.impl;

import java.util.HashMap;
import java.util.Map;

import draw.chemin.Chemin;
import draw.chemin.shapes.Point;
import draw.interfaces.ILabeler;

public class Labeler implements ILabeler {	
	Map<Point, String> labelMap = new HashMap<Point, String>();
	
	@Override
	public void label(String text, Point location) {		
		labelMap.put(location, text);
	}

	@Override
	public boolean contains(Point p) {
		return labelMap.containsKey(p);
	}	

	@Override
	public String getLabelMap(Point p) {
		return labelMap.get(p);
	}
}
