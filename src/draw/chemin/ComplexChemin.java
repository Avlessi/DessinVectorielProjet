package draw.chemin;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

import draw.chemin.connection.CheminConnection;
import draw.visitors.interfaces.IDessinateur;

public class ComplexChemin extends Chemin {
			
	private CheminConnection connection; 

	@Override
	public void accept(IDessinateur v, Graphics g) {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected Chemin getRoot() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isFerme() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void addSegment(Chemin chemin) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void remove(Chemin chemin) {
		// TODO Auto-generated method stub
		
	}

}
