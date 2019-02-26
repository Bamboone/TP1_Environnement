package Graphique;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import Formes.Forme;

public class ListenerMenus implements ActionListener, AffichageConstantes {

	private JMenuItem optionNouveau, optionEnregistrer, optionEnregistrerSous, optionOuvrir, optionQuitter,
			optionAPropos;

	private PanDessin panDessin;

	public ListenerMenus( JMenuItem optionNouveau, JMenuItem optionEnregistrer, JMenuItem optionEnregistrerSous,
			JMenuItem optionOuvrir, JMenuItem optionQuitter, JMenuItem optionAPropos, PanDessin panDessin ) {

		this.optionNouveau = optionNouveau;
		this.optionEnregistrer = optionEnregistrer;
		this.optionEnregistrerSous = optionEnregistrerSous;
		this.optionOuvrir = optionOuvrir;
		this.optionQuitter = optionQuitter;
		this.optionAPropos = optionAPropos;
		this.panDessin = panDessin;

	}

	@Override
	public void actionPerformed( ActionEvent e ) {

		if ( e.getSource() == optionNouveau ) {
			panDessin.setListe( new ArrayList<Forme>() );
			panDessin.repaint();

		} else if ( e.getSource() == optionEnregistrer ) {

		} else if ( e.getSource() == optionEnregistrerSous ) {

		} else if ( e.getSource() == optionOuvrir ) {

		} else if ( e.getSource() == optionQuitter ) {
			System.exit( 0 );

		} else if ( e.getSource() == optionAPropos ) {
			JOptionPane.showMessageDialog( null, A_PROPOS, "À Propos", JOptionPane.INFORMATION_MESSAGE,
					new ImageIcon( new ImageIcon( Fenetre.class.getResource( iconeApp ) ).getImage()
							.getScaledInstance( 200, 300, Image.SCALE_SMOOTH ) ) );
		}

	}

}
