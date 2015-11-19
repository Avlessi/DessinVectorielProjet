package draw.chemin;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

import draw.chemin.connection.CheminConnection;
import draw.utils.IDrawingAWTCallback;
import draw.utils.IDrawingCallback;

public class ComplexChemin extends Chemin {
			
	private CheminConnection connection;	

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
