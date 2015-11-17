package draw.interfaces.impl;

import java.awt.Graphics;

import javax.swing.JPanel;

import draw.chemin.Chemin;
import draw.visitors.interfaces.IDessinateur;

public class DessinateurPanel extends JPanel {
	
	Chemin chemin;
	IDessinateur dess;
	
	public DessinateurPanel(Chemin chemin, IDessinateur dess) {
		this.chemin = chemin;
		this.dess = dess;
	}
	
	public void paint(Graphics g) {
		//System.out.println("call to paint");		
		super.paintComponent(g);		
		chemin.accept(dess, g);
		
	}	

}
