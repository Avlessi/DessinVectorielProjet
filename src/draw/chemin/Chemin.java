package draw.chemin;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

import com.sun.istack.internal.Nullable;

import draw.utils.Crayon;
import draw.visitors.interfaces.IDessinateur;

/*A path (or guide - see Variables and Data Types for the difference) in Asymptote is simply 
a piecewise cubic function of a parameter t, parameterized as t ranges from 0 to the number of nodes
(say n) that determine the path. The most basic way to make paths is by joining points 
(which can be thought of as paths with length 0) or paths p, q together with one of the following
operators: 
	p--q  connects the end of path p to the beginning of q with a straight line. 
	p..q  connects them with a Bezier cubic spline interpolation so that paths are joined smoothly.	
*/

public abstract class Chemin {
	
	protected List<Chemin> segments = new ArrayList<Chemin>();
	protected Crayon crayon;
	float zoom = 1f;	
	protected IDessinateur dessinateur;
//	protected IEtiquetable etiquetable;
//	protected IRemplissable remplissable;
	
	public void setDessinateur(IDessinateur dess) {
		this.dessinateur = dess;
	}
	
	public Crayon getCrayon() {
		return crayon;
	}

	public void setCrayon(Crayon crayon) {
		this.crayon = crayon;
	}

	public float getZoom() {
		return zoom;
	}

	public void setZoom(float zoom) {
		this.zoom = zoom;
	}	
	
	public abstract void accept(IDessinateur v, @Nullable Graphics g);	
	
	protected Chemin getRoot() {
		return segments.get(0);
	}
	
	//public abstract Point getPointArrivee();
	
	//public abstract Point getPointDepart();
	
	
	public abstract boolean isFerme();	
	
	protected void addSegment(Chemin chemin) {
		segments.add(chemin);
	}
	
	protected void remove(Chemin chemin) {
		segments.remove(chemin);
	}


}
