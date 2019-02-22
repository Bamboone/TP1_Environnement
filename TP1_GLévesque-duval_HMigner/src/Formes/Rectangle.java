package Formes;

import java.awt.Color;
import java.awt.Graphics;

public class Rectangle extends Forme{
	
	private int largeur;
	private int hauteur;

	public Rectangle(int x1, int y1, int x2, int y2, Color contour, Color remplissage) {
		super(x1, y1, x2, y2, contour, remplissage);
	}

	@Override
	public void setParametres( int x1, int y1, int x2, int y2 ) {
		
	}

	@Override
	public void tracer( Graphics g ) {
		
	}
	
}
