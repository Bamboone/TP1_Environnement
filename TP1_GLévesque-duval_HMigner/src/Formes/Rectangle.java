package Formes;

import java.awt.BasicStroke;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

/**
 * Cette classe hérite de la classe forme et permet de créer un rectangle.
 * @author Gabriel Lévesque-Duval
 * @author Hugo Migner
 * @version 1.0
 */
public class Rectangle extends Forme {
	
	/**
	 * Numéro de sérialization 
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * Largeur de la forme
	 */
	private int largeur;
	
	/**
	 * Hauteur de la forme
	 */
	private int hauteur;
	
	/**
	 * Couleur de remplissage de la forme 
	 */
	private Color remplissage;
	
	/**
	 * Constructeur de la classe Rectangle.
	 * @param contour Couleur de contour de la forme
	 * @param remplissage Couleur de remplissage de la forme
	 * @param epaisseur Taille de l'épaisseur de la forme
	 */
	public Rectangle(Color contour, Color remplissage, int epaisseur) {
		super(contour, epaisseur);
		
		
		this.remplissage = remplissage;
		
		
	}
	
	/**
	 * Accesseur de la largeur de la forme.
	 * @return Largeur de la forme
	 */
	public int getLargeur() {
		return largeur;
	}
	
	/**
	 * Accesseur de la hauteur de la forme.
	 * @return Hauteur de la forme
	 */
	public int getHauteur() {
		return hauteur;
	}
	
	/**
	 * Accesseur de la couleur de remplissage de la forme.
	 * @return Couleur de remplissage de la forme
	 */
	public Color getRemplissage() {
		return remplissage;
	}
	
	/**
	 * Méthode qui modifie les paramètre de la forme selon les coordonnées reçues.
	 * 
	 */
	@Override
	public void setParametres( int x1, int y1, int x2, int y2 ) {
		
		if(x2>x1 && y2>y1) {
			setX1( x1 );
			setX2( x2 );
			setY1( y1 );
			setY2( y2 );
			largeur = x2-x1;
			hauteur = y2-y1;
		}else if(x1>x2 && y2>y1) {
			setX1( x2 );
			setX2( x1 );
			setY1( y1 );
			setY2( y2 );
			largeur = x1-x2;
			hauteur = y2-y1;
		}else if(x2>x1 && y1>y2 ) {
			setX1( x1 );
			setX2( x2 );
			setY1( y2 );
			setY2( y1 );
			largeur = x2-x1;
			hauteur = y1-y2;
		}else {
			setX1( x2 );
			setX2( x1 );
			setY1( y2 );
			setY2( y1 );
			largeur = x1-x2;
			hauteur = y1-y2;
		}
		
		
		
	}

	/**
	 * Méthode qui permet de tracer le rectangle dans le panneau de dessin.
	 */
	@Override
	public void tracer( Graphics g ) {
		Graphics2D g2 = (Graphics2D)g;
		g2.setStroke( new BasicStroke(getEpaisseur()) );
		g2.setColor( remplissage );
		g2.fillRect( getX1(), getY1(), largeur, hauteur );
		g2.setColor( getContour() );
		g2.drawRect( getX1(), getY1(), largeur, hauteur);
	}
	
}
