package draw.factories.impl;

import draw.DrawType;
import draw.factories.IDrawerFactory;
import draw.interfaces.IDrawer;
import draw.interfaces.IFiller;
import draw.interfaces.IInserter;
import draw.interfaces.ILabeler;
import draw.interfaces.impl.AwtDrawer;
import draw.interfaces.impl.SvgDrawer;

public class DrawerFactory implements IDrawerFactory {
		

	/*@Override
	public IDrawer create(DrawType type) {
		switch(type) {
			case AWT:
				return new AwtDrawer();
			case SVG:
				return new SvgDrawer();
			default:
				throw new RuntimeException("Proposed drawer does not exist!");
		}		
	}*/

	@Override
	public IDrawer create(DrawType type, IFiller filler, ILabeler labeler, IInserter inserter) {
		switch(type) {
			case AWT:
				return new AwtDrawer(filler, labeler, inserter);
			case SVG:
				return new SvgDrawer(filler, labeler, inserter);
			default:
				throw new RuntimeException("Proposed drawer does not exist!");
		}
	}
	
}
