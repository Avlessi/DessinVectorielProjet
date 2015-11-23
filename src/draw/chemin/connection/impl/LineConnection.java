package draw.chemin.connection.impl;

import draw.chemin.Chemin;
import draw.chemin.connection.CheminConnection;

public class LineConnection implements CheminConnection {	
	
	CheminConnection parentConnection;
	Chemin chemin;
	
	public LineConnection(CheminConnection c, Chemin chemin) {
		this.parentConnection = c;
		this.chemin = chemin;
	}	

	@Override
	public CheminConnection getParentConnection() {
		return parentConnection;
	}

	@Override
	public Chemin getChemin() {
		return this.chemin;
	}	

	@Override
	public ConnectionType getConnectionType() {
		return ConnectionType.Line;
	}
	
}
