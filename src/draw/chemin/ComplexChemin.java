package draw.chemin;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

import draw.callbacks.IDrawingAWTCallback;
import draw.callbacks.IDrawingCallback;
import draw.chemin.connection.CheminConnection;
import draw.chemin.connection.impl.BezierCurveConnection;
import draw.chemin.connection.impl.EmptyConnection;
import draw.chemin.connection.impl.LineConnection;
import draw.chemin.shapes.Point;

public class ComplexChemin extends Chemin {
			
	private CheminConnection connection;
	
	public ComplexChemin(Chemin firstChemin, Chemin secondChemin) {
		CheminConnection emptyCon = new EmptyConnection(firstChemin);
		connection = new LineConnection(emptyCon, secondChemin);
	}
	
	public ComplexChemin(int x1, int y1, int x2, int y2, Chemin firstChemin, Chemin secondChemin) {
		CheminConnection emptyCon = new EmptyConnection(firstChemin);
		this.connection = new BezierCurveConnection(emptyCon, x1, y1, x2, y2, secondChemin);		
	}
	
	public void addLineConnection(Chemin c) {
		this.connection = new LineConnection(connection, c);
	}
	
	public void addBezierConnection(int x1, int y1, int x2, int y2, Chemin chemin) {
		this.connection = new BezierCurveConnection(this.connection, x1, y1, x2, y2, chemin);
	}
	
	public CheminConnection getConnection() {
		return this.connection;
	}

	

	@Override
	public boolean isClosed() {
		if(getStartPoint().getX() == getEndPoint().getX() &&
				getStartPoint().getY() == getEndPoint().getY())
			return true;
		return false;
	}	
	
	@Override
	public void accept(IDrawingAWTCallback callback, Graphics g) {
		callback.drawingAWTCallback(this, g);		
	}

	@Override
	public void accept(IDrawingCallback callback) {
		callback.drawingCallback(this);		
	}

	@Override
	public Point getStartPoint() {
		CheminConnection con = this.connection;
		while(con.getParentConnection() != null) {			
			con = con.getParentConnection();
		}
		return con.getChemin().getStartPoint();
	}

	@Override
	public Point getEndPoint() {
		return this.connection.getChemin().getEndPoint();
	}
}
