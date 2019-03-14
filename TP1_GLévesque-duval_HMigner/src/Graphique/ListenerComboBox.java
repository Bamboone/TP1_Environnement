package Graphique;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;

/**
 * Cette classe est un listener pour le combo box qui détermine l'épaisseur du dessin.
 * 
 * @author Hugo Migner
 * @author Gabriel Lévesque-Duval
 * @version 1.0
 *
 */
public class ListenerComboBox implements ActionListener{
	
	/**
	 * La combo box de Integer pour l'épaisseur
	 */
	JComboBox<Integer> comboBoxEpaisseur;
	
	/**
	 * Le panneau de dessin
	 */
	PanDessin pan;
	
	/**
	 * Constructeur du listener
	 * @param comboBoxEpaisseur Le combo box pour l'épaisseur
	 * @param pan Le panneau de dessin
	 */
	public ListenerComboBox(JComboBox<Integer> comboBoxEpaisseur, PanDessin pan) {
		
		this.comboBoxEpaisseur = comboBoxEpaisseur;
		this.pan = pan;
		
	}

	/**
	 * Redéfinission de la méthode actionPerformed pour changer l'épaisseur du dessin selon le choix dans le combo box.
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void actionPerformed( ActionEvent e ) {
		
		JComboBox<Integer> source = (JComboBox<Integer>)e.getSource();
		pan.setEpaisseur( (int)source.getSelectedItem() );
		
	}

}
