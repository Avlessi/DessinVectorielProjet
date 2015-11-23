package draw.chemin.connection;

import draw.chemin.Chemin;

public interface CheminConnection {
	
	enum ConnectionType {
		Line, BezierCurve
	}
	
	public CheminConnection connectWithLine(Chemin c);
	public CheminConnection connectWithBezier(int x1, int y1, int x2, int y2, Chemin chemin);
	public CheminConnection getParentConnection();
	public Chemin getChemin();
}
