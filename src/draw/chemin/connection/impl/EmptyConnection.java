package draw.chemin.connection.impl;

import draw.chemin.Chemin;
import draw.chemin.connection.CheminConnection;

public class EmptyConnection implements CheminConnection{
	Chemin chemin;
	public EmptyConnection(Chemin chemin) {
		this.chemin = chemin;
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
	public ConnectionType getConnectionType() {
		return ConnectionType.Empty;
	}
		
}
