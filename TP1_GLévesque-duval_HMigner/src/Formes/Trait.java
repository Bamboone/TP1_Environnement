package Formes;

import java.awt.BasicStroke;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

/**
 * Cette classe hérite de la classe forme et permet de créer un trait.
 * @author Gabriel Lévesque-Duval
 * @author Hugo Migner
 * @version 1.0
 */
public class Trait extends Forme {

	/**
	 * Numéro de sérialization 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Constructeur de la classe Trait.
	 * @param contour Couleur du trait.
	 * @param epaisseur Taille de l'épaisseur du trait.
	 */
	public Trait(Color contour, int epaisseur) {
		super(contour, epaisseur);
	}

	/**
	 * Méthode qui modifie les paramètre de la forme selon les coordonnées reçues.
	 */
	@Override
	public void setParametres( int x1, int y1, int x2, int y2 ) {
		setX1( x1 );
		setX2( x2 );
		setY1( y1 );
		setY2( y2 );
	}

	/**
	 * Méthode qui permet de tracer le trait dans le panneau de dessin.
	 */
	@Override
	public void tracer( Graphics g ) {
		Graphics2D g2 = (Graphics2D)g;
		g2.setStroke( new BasicStroke(getEpaisseur()) );
		g2.setColor( getContour() );
		g2.drawLine( getX1(), getY1(), getX2(), getY2() );
	}
}
