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
 * Cette classe permet de gérer le panneau de dessin, de dessiner dans l'application et de gérer les actions de l'utilisateur.
 * 
 * @author Hugo Migner
 * @author Gabriel Lévesque-Duval
 * @version 1.0
 *
 */
public class PanDessin extends JPanel implements MouseListener, MouseMotionListener, AffichageConstantes, Serializable {

	/**
	 * Numéro de sérialization.
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
	 * La forme courant à dessiner
	 */
	private Forme formeCourante;
	
	/**
	 * L'épaisseur du trait à dessiner
	 */
	private int epaisseur;

	/**
	 * Le premier gardé en mémoire pour dessiner les formes.
	 */
	MouseEvent premierClic;

	/**
	 * La liste des formes dessinées.
	 */
	private ArrayList<Forme> liste = new ArrayList<>();
	
	/**
	 * Boolean pour savoir si le dessin est sauvegardé.
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
	 * Mutateur pour changer le type de la figure à dessiner.
	 * @param typeFigure Type de la figure
	 */
	public void setTypeFigure( int typeFigure ) {
		this.typeFigure = typeFigure;
	}
	
	/**
	 * Mutateur pour changer l'épaisseur du trait du dessin.
	 * @param epaisseur Épaisseur
	 */
	public void setEpaisseur( int epaisseur ) {
		this.epaisseur = epaisseur;
	}
	
	/**
	 * Mutateur pour changer la liste qui contient les formes dessinées.
	 * @param liste Liste contenant les formes dessinées.
	 */
	public void setListe(ArrayList<Forme> liste) {
		this.liste = liste;
	}
	
	/**
	 * Accesseur pour récupérer la liste des formes dessinées.
	 * @return La liste des formes dessinées. (ArrayList)
	 */
	public ArrayList<Forme> getListe(){
		return liste;
	}
	
	/**
	 * Mutateur pour changer l'état de sauvegarde.
	 * @param sauvegarde État de sauvegarde.
	 */
	public void setSauvegarde(boolean sauvegarde) {
		this.sauvegarde = sauvegarde;
	}
	
	/**
	 * Accesseur pour récupérer l'état de sauvegarde.
	 * @return L'état de sauvegarde.
	 */
	public boolean isSauvegarde() {
		return sauvegarde;
	}

	/**
	 * Redéfinission de la méthode paintComponent pour dessiner les formes sur le panneau.
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
	 * Redéfinission de la méthode mouseDragged pour afficher la forme à dessiner durant le mouvement de la souris.
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
	 * Redéfinission obligatoire des méthodes de l'interface MouseListener.
	 */
	@Override
	public void mouseMoved( MouseEvent e ) {

	}

	/**
	 * Redéfinission obligatoire des méthodes de l'interface MouseListener.
	 */
	@Override
	public void mouseClicked( MouseEvent e ) {

	}

	/**
	 * Redéfinission obligatoire des méthodes de l'interface MouseListener.
	 */
	@Override
	public void mouseEntered( MouseEvent e ) {

	}

	/**
	 * Redéfinission obligatoire des méthodes de l'interface MouseListener.
	 */
	@Override
	public void mouseExited( MouseEvent e ) {

	}

	/**
	 * Redéfinission de la méthode mousePressed pour enregistrer le premier clic de l'utilisateur.
	 */
	@Override
	public void mousePressed( MouseEvent e ) {

		premierClic = e;

	}

	/**
	 * Redéfinission de la méthode mouseReleased pour enregistrer les formes dans la liste et dessiner la dite forme sur le panneau.
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
