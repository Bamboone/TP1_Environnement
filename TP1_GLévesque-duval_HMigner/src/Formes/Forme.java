package Formes;

import java.awt.Color;
import java.awt.Graphics;

public abstract class Forme {

	private int x1;
	private int y1;
	
	private int x2;
	private int y2;
	
	private Color contour;
	private Color remplissage;
	
	public Forme() {
		
	}
	
	public Forme(int x1, int y1, int x2, int y2, Color contour, Color remplissage) {
		this.x1 = x1;
		this.y1 = y1;
		this.x2 = x2;
		this.y2 = y2;
		
		this.contour = contour;
		this.remplissage = remplissage;
		
	}
	
	public int getX1() {
		return x1;
	}
	
	public int gety1() {
		return y1;
	}
	
	public int getx2() {
		return x2;
	}
	
	public int gety2() {
		return y2;
	}
	
	public Color getContour() {
		return contour;
	}
	
	public void setContour(Color contour) {
		this.contour = contour;
	}
	
	public Color getRemplissage() {
		return remplissage;
	}
	
	public void setRemplissage(Color remplissage) {
		this.remplissage = remplissage;
	}
	
	
	public abstract void setParametres(int x1, int y1, int x2, int y2);
	
	public abstract void tracer (Graphics g);
	
	
	
}
