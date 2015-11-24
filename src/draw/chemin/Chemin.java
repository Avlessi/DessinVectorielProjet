package draw.chemin;

import java.awt.Color;
import java.awt.Graphics;

import draw.callbacks.IDrawingAWTCallback;
import draw.callbacks.IDrawingCallback;
import draw.chemin.shapes.Point;
import draw.utils.Crayon;


public abstract class Chemin {
	
	public Chemin() {
		setCrayon(new Crayon(Color.BLACK, 1));
	}
	
	private Crayon crayon;	
	
	public Crayon getCrayon() {
		return crayon;
	}

	public void setCrayon(Crayon crayon) {
		this.crayon = crayon;
	}		
	
	public abstract Point getStartPoint();
	
	public abstract Point getEndPoint();	
		
	public abstract void accept(IDrawingAWTCallback callback, Graphics g);
	
	public abstract void accept(IDrawingCallback callback);
	
	public abstract boolean isClosed();	
	
	
	public Chemin connectWithLine(Chemin chemin) {
		if(this instanceof ComplexChemin) {			
			ComplexChemin c = (ComplexChemin) this;
			c.addLineConnection(chemin);
			return this;
		}		
		return new ComplexChemin(this, chemin);		
	}
	
	public Chemin connectWithBezier(Chemin chemin, int x1, int y1, int x2, int y2) {
		if(this instanceof ComplexChemin) {			
			ComplexChemin c = (ComplexChemin) this;
			c.connectWithBezier(chemin, x1, y1, x2, y2);
			return c;
		}
		
		return new ComplexChemin(x1, y1, x2, y2, this, chemin);
	}
}
