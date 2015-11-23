package draw.factories.impl;

import draw.DrawType;
import draw.factories.IFillerFactory;
import draw.interfaces.IFiller;
import draw.interfaces.impl.Filler;

public class FillerFactory implements IFillerFactory{

	@Override
	public IFiller create(DrawType type) {
		return new Filler();
	}
	
}
