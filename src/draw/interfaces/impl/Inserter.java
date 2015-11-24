package draw.interfaces.impl;

import java.util.HashMap;
import java.util.Map;

import draw.chemin.Chemin;
import draw.chemin.shapes.Rectangle;
import draw.interfaces.IInserter;

public class Inserter implements IInserter {
	
	private Map<Chemin, Rectangle> cheminMap = new HashMap<Chemin, Rectangle>();

	@Override
	public boolean contains(Chemin cheminToCut) {
		return cheminMap.containsKey(cheminToCut);
	}	

	@Override
	public void insert(Chemin cheminToCut, Rectangle clipRect) {
		cheminMap.put(cheminToCut, clipRect);		
	}

	@Override
	public Rectangle getClipRect(Chemin cheminToCut) {
		return cheminMap.get(cheminToCut);
	}
}
