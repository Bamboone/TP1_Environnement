package Graphique;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JOptionPane;

public class Application {

	public static void main( String[] args ) {
		Fenetre fenetre = new Fenetre();
		
		WindowListener fenetreListener = new WindowAdapter() {

            public void windowClosing(WindowEvent w) {
                fenetre.getListenerMenus().quitter();
            }
        };
        
        fenetre.addWindowListener( fenetreListener );
        
        fenetre.setVisible(true);

	}

}
