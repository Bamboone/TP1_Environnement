package Graphique;

import java.awt.Color;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JToggleButton;

/**
 * Cette classe est un listener pour nos boutons, qui implémente les interfaces ActionListener et AffichageConstantes.
 * 
 * @author Hugo Migner
 * @author Gabriel Lévesque-Duval
 * @version 1.0
 *
 */
public class ListenerBoutons implements ActionListener, AffichageConstantes {

	/**
	 * Le tableau pour les boutons de la barre d'outils
	 */
	JToggleButton[] tabBoutons;
	
	/**
	 * Le panneau de dessin, qui vient de la classe PanDessin
	 */
	PanDessin pan;

	/**
	 * Constructeur du listener
	 * @param tabBoutons Tableau de boutons de la barre d'outils
	 * @param pan Panneau de dessin
	 */
	public ListenerBoutons( JToggleButton[] tabBoutons, PanDessin pan ) {

		this.tabBoutons = tabBoutons;
		this.pan = pan;

	}

	/**
	 * Méthode permettant d'activer le remplissage dépendemment de la forme
	 * @param activation Boolean qui définit si le remplissage devrait être activé
	 */
	public void activerRemplissage( boolean activation ) {

		for ( int i = NB_BOUTONS - NB_REMPLISSAGE; i < NB_BOUTONS; i++ ) {

			tabBoutons[i].setEnabled( activation );

		}

	}

	/**
	 * Redéfinission de la méthode actionPerformed pour définir quel bouton est activé et quoi faire selon.
	 */
	@Override
	public void actionPerformed( ActionEvent e ) {

		for ( JToggleButton bouton : tabBoutons ) {

			if ( bouton == e.getSource() ) {

				if ( bouton.getToolTipText().equals( "Ovale" ) ) {
					pan.setTypeFigure( OVALE );
					activerRemplissage( true );
				} else if ( bouton.getToolTipText().equals( "Rectangle" ) ) {
					pan.setTypeFigure( RECTANGLE );
					activerRemplissage( true );
				} else if ( bouton.getToolTipText().equals( "Trait" ) ) {
					pan.setTypeFigure( TRAIT );
					activerRemplissage( false );
				} else if ( bouton.getToolTipText().equals( "Triangle" ) ) {
					pan.setTypeFigure( TRIANGLE );
					activerRemplissage( true );
				} else if ( bouton.getToolTipText().equals( "Contour bleu clair" ) ) {
					pan.setContour( Color.cyan );
				} else if ( bouton.getToolTipText().equals( "Contour bleu marin" ) ) {
					pan.setContour( Color.blue );
				} else if ( bouton.getToolTipText().equals( "Contour jaune" ) ) {
					pan.setContour( Color.yellow );
				} else if ( bouton.getToolTipText().equals( "Contour mauve" ) ) {
					pan.setContour( Color.MAGENTA );
				} else if ( bouton.getToolTipText().equals( "Contour noir" ) ) {
					pan.setContour( Color.BLACK );
				} else if ( bouton.getToolTipText().equals( "Contour orange" ) ) {
					pan.setContour( Color.ORANGE );
				} else if ( bouton.getToolTipText().equals( "Remplissage rouge" ) ) {
					pan.setRemplissage( Color.RED );
				} else if ( bouton.getToolTipText().equals( "Remplissage rose" ) ) {
					pan.setRemplissage( Color.PINK );
				} else if ( bouton.getToolTipText().equals( "Remplissage vert" ) ) {
					pan.setRemplissage( Color.GREEN );
				} else if ( bouton.getToolTipText().equals( "Remplissage noir" ) ) {
					pan.setRemplissage( Color.BLACK );
				} else if ( bouton.getToolTipText().equals( "Remplissage jaune" ) ) {
					pan.setRemplissage( Color.YELLOW );
				} else if ( bouton.getToolTipText().equals( "Remplissage bleu" ) ) {
					pan.setRemplissage( Color.BLUE );
				}
			}

		}
	}

}
