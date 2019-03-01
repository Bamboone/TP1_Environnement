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
                int response = JOptionPane.showConfirmDialog(null, " Voulez-vous vraiment quitter?", 
                		"Confirmation", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                if (response == JOptionPane.YES_OPTION) {
                    System.exit(0);
                }
            }
        };
        
        fenetre.addWindowListener( fenetreListener );
        
        fenetre.setVisible(true);

	}

}
