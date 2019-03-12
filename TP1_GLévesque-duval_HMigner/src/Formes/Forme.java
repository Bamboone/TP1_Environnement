package Formes;

import java.awt.Color;
import java.awt.Graphics;
import java.io.Serializable;

/**
 * Cette classe est une classe abstraite qui regroupe les formes.
 * @author Gabriel Lévesque-Duval
 * @author Hugo Migner
 * @version 1.0
 */

public abstract class Forme implements Serializable{

	/**
	 * Numéro de sérialization 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * Coordonée x1
	 */
	private int x1;
	/**
	 * Coordonée y1
	 */
	private int y1;
	
	/**
	 * Coordonée x2
	 */
	private int x2;
	/**
	 * Coordonée y2
	 */
	private int y2;
	
	/**
	 * Couleur de contour de la forme
	 */
	private Color contour;
	/**
	 * Taille de l'épaisseur de la forme
	 */
	private int epaisseur;
	
	/**
	 * Constructeur par défaut de la classe Forme.
	 */
	public Forme() {
		
	}
	
	/**
	 * Constructeur de la classe Forme.
	 * @param contour Couleur de contour de la forme
	 * @param epaisseur Taille de l'épaisseur de la forme
	 */
	public Forme( Color contour, int epaisseur) {
		

		this.contour = contour;
		this.epaisseur = epaisseur;
		
	}
	
	/**
	 * Mutateur de la coordonée x1.
	 * @param x1 Coordonée x1
	 */
	public void setX1(int x1) {
		this.x1 = x1;
	}
	
	/**
	 * Mutateur de la coordonée y1.
	 * @param y1 Coordonée y1
	 */
	public void setY1(int y1) {
		this.y1 = y1;
	}
	
	/**
	 * Mutateur de la coordonée x2.
	 * @param x2 Coordonée x2
	 */
	public void setX2(int x2) {
		this.x2 = x2;
	}
	/**
	 * Mutateur de la coordonée y2.
	 * @param y2 Coordonée y2
	 */
	public void setY2(int y2) {
		this.y2 = y2;
	}
	
	/**
	 * Accesseur de la coordonnée x1.
	 * @return Coordonnée x1
	 */
	public int getX1() {
		return x1;
	}
	
	/**
	 * Accesseur de la coordonnée y1.
	 * @return Coordonnée y1
	 */
	public int getY1() {
		return y1;
	}
	
	/**
	 * Accesseur de la coordonnée x2.
	 * @return Coordonnée x2
	 */
	public int getX2() {
		return x2;
	}
	
	/**
	 * Accesseur de la coordonnée y2.
	 * @return Coordonnée y2
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
	 * @return La taille de l'épaisseur du contour
	 */
	public int getEpaisseur() {
		return epaisseur;
	}
	
	/**
	 * Méthode abstraite qui modifie les paramètre de la forme.
	 * @param x1 Coordonnée x1
	 * @param y1 Coordonnée y1
	 * @param x2 Coordonnée x2
	 * @param y2 Coordonnée y2
	 */
	public abstract void setParametres(int x1, int y1, int x2, int y2);
	
	/**
	 * Méthode abstraite qui permet de tracer la forme dans le panneau de dessin.
	 * @param g Graphics du panneau de dessin
	 */
	public abstract void tracer (Graphics g);
	
	
	
}
