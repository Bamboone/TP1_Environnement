package Graphique;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

/**
 * Cette classe s'occupe d'appeler le main de l'application.
 * 
 * @author Gabriel L�vesque-Duval
 * @author Hugo Migner
 * @version 1.0
 */
public class Application {

	/**
	 * Cette m�thode est le main de l'application qui cr�e la fenetre de
	 * l'application et g�re les �venement de la fen�tre.
	 * @param args
	 */
	public static void main( String[] args ) {
		Fenetre fenetre = new Fenetre();

		WindowListener fenetreListener = new WindowAdapter() {

			public void windowClosing( WindowEvent w ) {
				fenetre.getListenerMenus().quitter();
			}
		};

		fenetre.addWindowListener( fenetreListener );

		fenetre.setVisible( true );

	}

}
