package draw.interfaces;

import draw.chemin.Chemin;
import draw.chemin.shapes.Rectangle;

public interface IInserter {
	public void insert(Chemin cheminToCut, Rectangle clipRect);
	public boolean contains(Chemin cheminToCut);
	public Rectangle getClipRect(Chemin cheminToCut);
}
