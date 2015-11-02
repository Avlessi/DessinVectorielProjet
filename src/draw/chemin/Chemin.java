package draw.chemin;

import java.util.ArrayList;
import java.util.List;


import draw.utils.Crayon;
import draw.visitors.interfaces.IDessinateur;

public abstract class Chemin {
	
	protected List<Chemin> segments = new ArrayList<Chemin>();
	protected Crayon crayon;
	float zoom = 1f;	
	protected IDessinateur dessinateur;
//	protected IEtiquetable etiquetable;
//	protected IRemplissable remplissable;
	
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
	
	public abstract void accept(IDessinateur v);	
	
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
