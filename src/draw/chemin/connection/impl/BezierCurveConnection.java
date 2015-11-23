package draw.chemin.connection.impl;

import draw.chemin.Chemin;
import draw.chemin.connection.CheminConnection;

public class BezierCurveConnection implements CheminConnection {
	
	CheminConnection previousConnection;
	Chemin chemin;	
	int x1, y1;
	int x2, y2;
	int x3, y3;

	public BezierCurveConnection(CheminConnection c, int x1, int y1, int x2, int y2, Chemin chemin) {
		
	}	
	
	@Override
	public CheminConnection connectWithLine(Chemin c) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CheminConnection connectWithBezier(int x1, int y1, int x2, int y2, Chemin chemin) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CheminConnection getParentConnection() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Chemin getChemin() {
		// TODO Auto-generated method stub
		return null;
	}

}
