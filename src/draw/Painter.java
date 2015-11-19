package draw;

import draw.chemin.Chemin;
import draw.interfaces.IDrawer;
import draw.interfaces.IFiller;
import draw.interfaces.IInserter;
import draw.interfaces.ILabeler;

public class Painter {
	IDrawer drawer;
	ILabeler labeler;	
	IFiller filler;
	IInserter inserter;	
	
	public Painter(IDrawer drawer) {
		this.drawer = drawer;
	}	
	
	public void draw(Chemin chemin) {
		drawer.draw(chemin);
	}
	
	public void setDrawer(IDrawer drawer) {
		this.drawer = drawer;
	}		
}
