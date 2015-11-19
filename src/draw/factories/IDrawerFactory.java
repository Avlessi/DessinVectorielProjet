package draw.factories;

import draw.DrawType;
import draw.interfaces.IDrawer;

public interface IDrawerFactory {	
	public IDrawer create(DrawType type);
		
	
}
