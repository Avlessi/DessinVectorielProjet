package draw.factories.impl;

import draw.DrawType;
import draw.factories.ILabelerFactory;
import draw.interfaces.ILabeler;
import draw.interfaces.impl.Labeler;

public class LabelerFactory implements ILabelerFactory{

	@Override
	public ILabeler create(DrawType type) {
		return new Labeler();
	}

}
