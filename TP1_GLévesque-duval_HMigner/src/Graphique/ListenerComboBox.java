package Graphique;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;

public class ListenerComboBox implements ActionListener{
	
	JComboBox<Integer> comboBoxEpaisseur;
	PanDessin pan;
	
	public ListenerComboBox(JComboBox<Integer> comboBoxEpaisseur, PanDessin pan) {
		
		this.comboBoxEpaisseur = comboBoxEpaisseur;
		this.pan = pan;
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public void actionPerformed( ActionEvent e ) {
		
		JComboBox<Integer> source = (JComboBox<Integer>)e.getSource();
		pan.setEpaisseur( (int)source.getSelectedItem() );
		
	}

}
