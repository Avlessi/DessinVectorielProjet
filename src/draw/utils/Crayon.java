package draw.utils;

import java.awt.Color;

import draw.Dessin;

public class Crayon {
	
	Color color;
	int thickness;
	
	public Crayon(Color color, int thickness) {
		this.color = color;
		this.thickness = thickness;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public int getThickness() {
		return thickness;
	}

	public void setThickness(int thickness) {
		this.thickness = thickness;
	}
	
	
}
