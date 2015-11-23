package draw.factories;

import draw.DrawType;
import draw.interfaces.IFiller;

public interface IFillerFactory {
	public IFiller create(DrawType type);
}
