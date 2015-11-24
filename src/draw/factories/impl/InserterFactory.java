package draw.factories.impl;

import draw.DrawType;
import draw.factories.IInserterFactory;
import draw.interfaces.IInserter;
import draw.interfaces.impl.Inserter;

public class InserterFactory implements IInserterFactory {

	@Override
	public IInserter create(DrawType type) {
		return new Inserter();
	}

}
