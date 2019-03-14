package Graphique;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.io.Serializable;
import java.util.*;

import javax.swing.JPanel;

import Formes.*;


/**
 * Cette classe permet de g�rer le panneau de dessin, de dessiner dans l'application et de g�rer les actions de l'utilisateur.
 * 
 * @author Hugo Migner
 * @author Gabriel L�vesque-Duval
 * @version 1.0
 *
 */
public class PanDessin extends JPanel implements MouseListener, MouseMotionListener, AffichageConstantes, Serializable {

	/**
	 * Num�ro de s�rialization.
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Couleur du contour
	 */
	private Color contour;

	/**
	 * Couleur du remplissage de la forme
	 */
	private Color remplissage;

	/**
	 * Type de la figure
	 */
	private int typeFigure;

	/**
	 * La forme courant � dessiner
	 */
	private Forme formeCourante;
	
	/**
	 * L'�paisseur du trait � dessiner
	 */
	private int epaisseur;

	/**
	 * Le premier gard� en m�moire pour dessiner les formes.
	 */
	MouseEvent premierClic;

	/**
	 * La liste des formes dessin�es.
	 */
	private ArrayList<Forme> liste = new ArrayList<>();
	
	/**
	 * Boolean pour savoir si le dessin est sauvegard�.
	 */
	private boolean sauvegarde = true;

	/**
	 * Constructeur du PanDessin
	 */
	public PanDessin() {
		addMouseListener( this );
		addMouseMotionListener( this );
	}

	/**
	 * Mutateur pour changer la couleur du contour.
	 * @param contour Couleur du contour.
	 */
	public void setContour( Color contour ) {
		this.contour = contour;
	}

	/**
	 * Mutateur pour changer la couleur du remplissage.
	 * @param remplissage Couleur du remplissage
	 */
	public void setRemplissage( Color remplissage ) {
		this.remplissage = remplissage;
	}

	/**
	 * Mutateur pour changer le type de la figure � dessiner.
	 * @param typeFigure Type de la figure
	 */
	public void setTypeFigure( int typeFigure ) {
		this.typeFigure = typeFigure;
	}
	
	/**
	 * Mutateur pour changer l'�paisseur du trait du dessin.
	 * @param epaisseur �paisseur
	 */
	public void setEpaisseur( int epaisseur ) {
		this.epaisseur = epaisseur;
	}
	
	/**
	 * Mutateur pour changer la liste qui contient les formes dessin�es.
	 * @param liste Liste contenant les formes dessin�es.
	 */
	public void setListe(ArrayList<Forme> liste) {
		this.liste = liste;
	}
	
	/**
	 * Accesseur pour r�cup�rer la liste des formes dessin�es.
	 * @return La liste des formes dessin�es. (ArrayList)
	 */
	public ArrayList<Forme> getListe(){
		return liste;
	}
	
	/**
	 * Mutateur pour changer l'�tat de sauvegarde.
	 * @param sauvegarde �tat de sauvegarde.
	 */
	public void setSauvegarde(boolean sauvegarde) {
		this.sauvegarde = sauvegarde;
	}
	
	/**
	 * Accesseur pour r�cup�rer l'�tat de sauvegarde.
	 * @return L'�tat de sauvegarde.
	 */
	public boolean isSauvegarde() {
		return sauvegarde;
	}

	/**
	 * Red�finission de la m�thode paintComponent pour dessiner les formes sur le panneau.
	 */
	@Override
	public void paintComponent( Graphics g ) {
		super.paintComponent( g );
		for ( Forme forme : liste ) {
			forme.tracer( g );
		
		}	

		if(formeCourante != null) {
			formeCourante.tracer(g);
		}
	}

	/**
	 * Red�finission de la m�thode mouseDragged pour afficher la forme � dessiner durant le mouvement de la souris.
	 */
	@Override
	public void mouseDragged( MouseEvent e ) {

		if ( typeFigure == OVALE ) {

			formeCourante = new Ovale( contour, remplissage, epaisseur );
		} else if ( typeFigure == RECTANGLE ) {
			
			formeCourante = new Rectangle( contour, remplissage, epaisseur );
			
		} else if ( typeFigure == TRAIT ) {
			formeCourante = new Trait( contour, epaisseur );
		}else if(typeFigure == TRIANGLE) {
			formeCourante = new Triangle( contour, remplissage, epaisseur );
		}
		
		formeCourante.setParametres( premierClic.getX(), premierClic.getY(), e.getX(), e.getY() );
		repaint();

	}

	/**
	 * Red�finission obligatoire des m�thodes de l'interface MouseListener.
	 */
	@Override
	public void mouseMoved( MouseEvent e ) {

	}

	/**
	 * Red�finission obligatoire des m�thodes de l'interface MouseListener.
	 */
	@Override
	public void mouseClicked( MouseEvent e ) {

	}

	/**
	 * Red�finission obligatoire des m�thodes de l'interface MouseListener.
	 */
	@Override
	public void mouseEntered( MouseEvent e ) {

	}

	/**
	 * Red�finission obligatoire des m�thodes de l'interface MouseListener.
	 */
	@Override
	public void mouseExited( MouseEvent e ) {

	}

	/**
	 * Red�finission de la m�thode mousePressed pour enregistrer le premier clic de l'utilisateur.
	 */
	@Override
	public void mousePressed( MouseEvent e ) {

		premierClic = e;

	}

	/**
	 * Red�finission de la m�thode mouseReleased pour enregistrer les formes dans la liste et dessiner la dite forme sur le panneau.
	 */
	@Override
	public void mouseReleased( MouseEvent e ) {

		if(formeCourante !=null) {
			liste.add( formeCourante );
			formeCourante = null;
			sauvegarde=false;
		}
		repaint();


		
	}

}
