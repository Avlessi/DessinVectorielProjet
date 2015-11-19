package draw.chemin;

import java.awt.Graphics;

import draw.utils.Crayon;
import draw.utils.IDrawingAWTCallback;
import draw.utils.IDrawingCallback;


/*A path (or guide - see Variables and Data Types for the difference) in Asymptote is simply 
a piecewise cubic function of a parameter t, parameterized as t ranges from 0 to the number of nodes
(say n) that determine the path. The most basic way to make paths is by joining points 
(which can be thought of as paths with length 0) or paths p, q together with one of the following
operators: 
	p--q  connects the end of path p to the beginning of q with a straight line. 
	p..q  connects them with a Bezier cubic spline interpolation so that paths are joined smoothly.	
*/

public abstract class Chemin {
	
	
	private Crayon crayon;	
	
	public Crayon getCrayon() {
		return crayon;
	}

	public void setCrayon(Crayon crayon) {
		this.crayon = crayon;
	}		
	
	protected abstract Chemin getRoot();	
	
	//public abstract Point getPointArrivee();
	
	//public abstract Point getPointDepart();
		
	public abstract void accept(IDrawingAWTCallback callback, Graphics g);
	
	public abstract void accept(IDrawingCallback callback);
	
	public abstract boolean isClosed();	
	
	public abstract void remove(Chemin chemin);
	
	public void connectWithLine(Chemin chemin) {
		//TODO		
	}
	
	public void connectWithBezier(Chemin chemin) {
		//TODO
	}
}
