package Formes;

import java.awt.Color;
import java.awt.Graphics;
import java.io.Serializable;

/**
 * Cette classe est une classe abstraite qui regroupe les formes.
 * @author Gabriel L�vesque-Duval
 * @author Hugo Migner
 * @version 1.0
 */

public abstract class Forme implements Serializable{

	/**
	 * Num�ro de s�rialization 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * Coordon�e x1
	 */
	private int x1;
	/**
	 * Coordon�e y1
	 */
	private int y1;
	
	/**
	 * Coordon�e x2
	 */
	private int x2;
	/**
	 * Coordon�e y2
	 */
	private int y2;
	
	/**
	 * Couleur de contour de la forme
	 */
	private Color contour;
	/**
	 * Taille de l'�paisseur de la forme
	 */
	private int epaisseur;
	
	/**
	 * Constructeur par d�faut de la classe Forme.
	 */
	public Forme() {
		
	}
	
	/**
	 * Constructeur de la classe Forme.
	 * @param contour Couleur de contour de la forme
	 * @param epaisseur Taille de l'�paisseur de la forme
	 */
	public Forme( Color contour, int epaisseur) {
		

		this.contour = contour;
		this.epaisseur = epaisseur;
		
	}
	
	/**
	 * Mutateur de la coordon�e x1.
	 * @param x1 Coordon�e x1
	 */
	public void setX1(int x1) {
		this.x1 = x1;
	}
	
	/**
	 * Mutateur de la coordon�e y1.
	 * @param y1 Coordon�e y1
	 */
	public void setY1(int y1) {
		this.y1 = y1;
	}
	
	/**
	 * Mutateur de la coordon�e x2.
	 * @param x2 Coordon�e x2
	 */
	public void setX2(int x2) {
		this.x2 = x2;
	}
	/**
	 * Mutateur de la coordon�e y2.
	 * @param y2 Coordon�e y2
	 */
	public void setY2(int y2) {
		this.y2 = y2;
	}
	
	/**
	 * Accesseur de la coordonn�e x1.
	 * @return Coordonn�e x1
	 */
	public int getX1() {
		return x1;
	}
	
	/**
	 * Accesseur de la coordonn�e y1.
	 * @return Coordonn�e y1
	 */
	public int getY1() {
		return y1;
	}
	
	/**
	 * Accesseur de la coordonn�e x2.
	 * @return Coordonn�e x2
	 */
	public int getX2() {
		return x2;
	}
	
	/**
	 * Accesseur de la coordonn�e y2.
	 * @return Coordonn�e y2
	 */
	public int getY2() {
		return y2;
	}
	
	/**
	 * Accesseur de la couleur de contour.
	 * @return Couleur de contour de la forme
	 */
	public Color getContour() {
		return contour;
	}
	
	/**
	 * Accesseur de l'epaisseur du contour.
	 * @return La taille de l'�paisseur du contour
	 */
	public int getEpaisseur() {
		return epaisseur;
	}
	
	/**
	 * M�thode abstraite qui modifie les param�tre de la forme.
	 * @param x1 Coordonn�e x1
	 * @param y1 Coordonn�e y1
	 * @param x2 Coordonn�e x2
	 * @param y2 Coordonn�e y2
	 */
	public abstract void setParametres(int x1, int y1, int x2, int y2);
	
	/**
	 * M�thode abstraite qui permet de tracer la forme dans le panneau de dessin.
	 * @param g Graphics du panneau de dessin
	 */
	public abstract void tracer (Graphics g);
	
	
	
}
