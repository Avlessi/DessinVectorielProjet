package draw.factories;

import draw.DrawType;
import draw.interfaces.IInserter;

public interface IInserterFactory {
	public IInserter create(DrawType type);
}
