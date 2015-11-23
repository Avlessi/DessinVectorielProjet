package draw.factories;

import draw.DrawType;
import draw.interfaces.IDrawer;
import draw.interfaces.IFiller;
import draw.interfaces.IInserter;
import draw.interfaces.ILabeler;

public interface IDrawerFactory {	
	//public IDrawer create(DrawType type);	
	public IDrawer create(DrawType type, IFiller filler, ILabeler labeler, IInserter inserter);
		
	
}
