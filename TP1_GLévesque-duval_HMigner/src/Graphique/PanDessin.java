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


public class PanDessin extends JPanel implements MouseListener, MouseMotionListener, AffichageConstantes, Serializable {

	private static final long serialVersionUID = 1L;

	private Color contour;

	private Color remplissage;

	private int typeFigure;

	private Forme formeCourante;
	
	private int epaisseur;

	MouseEvent premierClic;

	private ArrayList<Forme> liste = new ArrayList<>();
	
	private boolean sauvegarde = true;

	
	public PanDessin() {
		addMouseListener( this );
		addMouseMotionListener( this );
	}

	public Color getContour() {
		return contour;
	}

	public void setContour( Color contour ) {
		this.contour = contour;
	}

	public Color getRemplissage() {
		return remplissage;
	}

	public void setRemplissage( Color remplissage ) {
		this.remplissage = remplissage;
	}

	public void setTypeFigure( int typeFigure ) {
		this.typeFigure = typeFigure;
	}
	
	public void setEpaisseur( int epaisseur ) {
		this.epaisseur = epaisseur;
	}
	
	public void setListe(ArrayList<Forme> liste) {
		this.liste = liste;
	}
	
	public ArrayList<Forme> getListe(){
		return liste;
	}
	
	public void setSauvegarde(boolean sauvegarde) {
		this.sauvegarde = sauvegarde;
	}
	
	public boolean isSauvegarde() {
		return sauvegarde;
	}

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

	@Override
	public void mouseMoved( MouseEvent e ) {

	}

	@Override
	public void mouseClicked( MouseEvent e ) {

	}

	@Override
	public void mouseEntered( MouseEvent e ) {

	}

	@Override
	public void mouseExited( MouseEvent e ) {

	}

	@Override
	public void mousePressed( MouseEvent e ) {

		premierClic = e;

	}

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
