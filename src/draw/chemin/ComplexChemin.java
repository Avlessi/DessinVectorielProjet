package draw.chemin;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

import draw.chemin.connection.CheminConnection;
import draw.chemin.connection.impl.BezierCurveConnection;
import draw.chemin.connection.impl.EmptyConnection;
import draw.chemin.connection.impl.LineConnection;
import draw.utils.IDrawingAWTCallback;
import draw.utils.IDrawingCallback;

public class ComplexChemin extends Chemin {
			
	private CheminConnection prevConnection;
	
	public ComplexChemin(Chemin chemin) {
		this.prevConnection = new LineConnection(null, chemin);		
	}
	
	public ComplexChemin(int x1, int y1, int x2, int y2, Chemin chemin) {
		this.prevConnection = new BezierCurveConnection(this.prevConnection, x1, y1, x2, y2, chemin);
	}

	@Override
	protected Chemin getRoot() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isClosed() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void remove(Chemin chemin) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void accept(IDrawingAWTCallback callback, Graphics g) {
		callback.drawingAWTCallback(this, g);
		
	}

	@Override
	public void accept(IDrawingCallback callback) {
		callback.drawingCallback(this);		
	}
}
