package draw.interfaces;

import java.awt.Color;

import draw.chemin.Chemin;

public interface IFiller {
	public void fill(Chemin c, Color color);
	public boolean contains(Chemin c);
	public Color getColor(Chemin c);	
}
