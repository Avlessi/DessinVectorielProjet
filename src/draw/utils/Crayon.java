package draw.utils;

import java.awt.Color;

import draw.Dessin;

//va representer un patron FlyWeight
public class Crayon {
	Dessin parentDessin;
	
	public Crayon(Dessin dessin) {
		this.parentDessin = dessin;
	}
	
	public Crayon(Color color, int thickness ) {
		
	}
	
	public void setParentDessin(Dessin d) {
		this.parentDessin = d;
	}
}
