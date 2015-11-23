package draw.factories;

import draw.DrawType;
import draw.interfaces.ILabeler;

public interface ILabelerFactory {
	public ILabeler create(DrawType type);
}
