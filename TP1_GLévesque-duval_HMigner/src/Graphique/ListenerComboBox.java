package Graphique;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;

/**
 * Cette classe est un listener pour le combo box qui d�termine l'�paisseur du dessin.
 * 
 * @author Hugo Migner
 * @author Gabriel L�vesque-Duval
 * @version 1.0
 *
 */
public class ListenerComboBox implements ActionListener{
	
	/**
	 * La combo box de Integer pour l'�paisseur
	 */
	JComboBox<Integer> comboBoxEpaisseur;
	
	/**
	 * Le panneau de dessin
	 */
	PanDessin pan;
	
	/**
	 * Constructeur du listener
	 * @param comboBoxEpaisseur Le combo box pour l'�paisseur
	 * @param pan Le panneau de dessin
	 */
	public ListenerComboBox(JComboBox<Integer> comboBoxEpaisseur, PanDessin pan) {
		
		this.comboBoxEpaisseur = comboBoxEpaisseur;
		this.pan = pan;
		
	}

	/**
	 * Red�finission de la m�thode actionPerformed pour changer l'�paisseur du dessin selon le choix dans le combo box.
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void actionPerformed( ActionEvent e ) {
		
		JComboBox<Integer> source = (JComboBox<Integer>)e.getSource();
		pan.setEpaisseur( (int)source.getSelectedItem() );
		
	}

}
