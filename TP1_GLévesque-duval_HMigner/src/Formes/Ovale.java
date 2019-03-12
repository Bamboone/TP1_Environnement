package Formes;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

/**
 * Cette classe h�rite de la classe rectangle et permet de cr�er une forme ovale.
 * @author Gabriel L�vesque-Duval
 * @author Hugo Migner
 * @version 1.0
 */
public class Ovale extends Rectangle{

	/**
	 * Num�ro de s�rialization 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Constructeur de la classe Ovale.
	 * @param contour Couleur de contour de la forme
	 * @param remplissage Couleur de remplissage de la forme
	 * @param epaisseur Taille de l'�paisseur de la forme
	 */
	public Ovale(Color contour, Color remplissage, int epaisseur) {
		super(contour, remplissage, epaisseur);

	}

	/**
	 * M�thode qui permet de tracer l'ovale dans le panneau de dessin.
	 */
	@Override
	public void tracer( Graphics g ) {

		Graphics2D g2 = (Graphics2D)g;
		g2.setStroke( new BasicStroke(getEpaisseur()) );
		g2.setColor( getRemplissage() );
		g2.fillOval( getX1(), getY1(), getLargeur(), getHauteur() );
		g2.setColor( getContour() );
		g2.drawOval( getX1(), getY1(), getLargeur(), getHauteur());
		
	}

}
