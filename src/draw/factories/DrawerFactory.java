package draw.factories;

import draw.DrawType;
import draw.interfaces.IDrawer;
import draw.interfaces.impl.AwtDrawer;
import draw.interfaces.impl.SvgDrawer;

public class DrawerFactory implements IDrawerFactory {
		

	@Override
	public IDrawer create(DrawType type) {
		switch(type) {
			case AWT:
				return new AwtDrawer();
			case SVG:
				return new SvgDrawer();
			default:
				throw new RuntimeException("Proposed drawer does not exist!");
		}		
	}
	
}
