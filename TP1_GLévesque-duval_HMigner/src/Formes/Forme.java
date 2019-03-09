package Formes;

import java.awt.Color;
import java.awt.Graphics;
import java.io.Serializable;

public abstract class Forme implements Serializable{


	private static final long serialVersionUID = 1L;
	private int x1;
	private int y1;
	
	private int x2;
	private int y2;
	
	private Color contour;
	private int epaisseur;
	
	
	public Forme() {
		
	}
	
	public Forme( Color contour, int epaisseur) {
		

		this.contour = contour;
		this.epaisseur = epaisseur;
		
	}
	
	public void setX1(int x1) {
		this.x1 = x1;
	}
	
	public void setY1(int y1) {
		this.y1 = y1;
	}
	
	public void setX2(int x2) {
		this.x2 = x2;
	}
	
	public void setY2(int y2) {
		this.y2 = y2;
	}
	
	public int getX1() {
		return x1;
	}
	
	public int getY1() {
		return y1;
	}
	
	public int getX2() {
		return x2;
	}
	
	public int getY2() {
		return y2;
	}
	
	public Color getContour() {
		return contour;
	}
	
	public void setContour(Color contour) {
		this.contour = contour;
	}
	
	public int getEpaisseur() {
		return epaisseur;
	}
	
	
	public abstract void setParametres(int x1, int y1, int x2, int y2);
	
	public abstract void tracer (Graphics g);
	
	
	
}
