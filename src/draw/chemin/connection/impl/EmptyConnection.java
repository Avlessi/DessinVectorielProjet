package draw.chemin.connection.impl;

import draw.chemin.Chemin;
import draw.chemin.connection.CheminConnection;

public class EmptyConnection implements CheminConnection{
	Chemin chemin;
	public EmptyConnection(Chemin chemin) {
		this.chemin = chemin;
	}
	@Override
	public CheminConnection connectWithLine(Chemin c) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public CheminConnection getParentConnection() {		
		return null;
	}
	@Override
	public Chemin getChemin() {
		return this.chemin;
	}
	@Override
	public CheminConnection connectWithBezier(int x1, int y1, int x2, int y2, Chemin chemin) {
		// TODO Auto-generated method stub
		return null;
	}
		
}
