package draw.chemin.connection.impl;

import draw.chemin.Chemin;
import draw.chemin.connection.CheminConnection;

public class LineConnection implements CheminConnection {	
	
	CheminConnection previousConnection;
	Chemin chemin;
	
	public LineConnection(CheminConnection c, Chemin chemin) {
		this.previousConnection = c;
		this.chemin = chemin;
	}
	
	public CheminConnection connectWithLine(Chemin c) {
		return new LineConnection(this, c);
	}

	@Override
	public CheminConnection getParentConnection() {
		return previousConnection;
	}

	@Override
	public Chemin getChemin() {
		return this.chemin;
	}

	@Override
	public CheminConnection connectWithBezier(int x1, int y1, int x2, int y2, Chemin chemin) {
		//return new BezierCurveConnection(c, chemin)
		return null;
	}
	
}
