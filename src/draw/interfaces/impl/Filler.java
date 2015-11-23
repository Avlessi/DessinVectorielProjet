package draw.interfaces.impl;

import java.awt.Color;
import java.util.HashMap;
import java.util.Map;

import draw.chemin.Chemin;
import draw.interfaces.IFiller;

public class Filler implements IFiller {

	private Map<Chemin, Color> map = new HashMap<Chemin, Color>(); 
	
	@Override
	public void fill(Chemin c, Color color) {
		map.put(c, color);		
	}

	@Override
	public boolean contains(Chemin c) {
		return map.containsKey(c);
	}

	@Override
	public Color getColor(Chemin c) {
		return map.get(c);
	}
}
