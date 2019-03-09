package Graphique;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.nio.file.DirectoryStream.Filter;
import java.nio.file.Paths;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;

import Formes.Forme;
import Formes.Ovale;

public class ListenerMenus implements ActionListener, AffichageConstantes {

	private JMenuItem optionNouveau, optionEnregistrer, optionEnregistrerSous, optionOuvrir, optionQuitter,
			optionAPropos;

	private JFrame fenetre;
	
	private PanDessin panDessin;
	
	private FileFilter filtre = new FileNameExtensionFilter("Dessin FakePaint", "dfp");

	public ListenerMenus( JMenuItem optionNouveau, JMenuItem optionEnregistrer, JMenuItem optionEnregistrerSous,
			JMenuItem optionOuvrir, JMenuItem optionQuitter, JMenuItem optionAPropos, PanDessin panDessin, JFrame fenetre ) {

		this.optionNouveau = optionNouveau;
		this.optionEnregistrer = optionEnregistrer;
		this.optionEnregistrerSous = optionEnregistrerSous;
		this.optionOuvrir = optionOuvrir;
		this.optionQuitter = optionQuitter;
		this.optionAPropos = optionAPropos;
		this.panDessin = panDessin;
		this.fenetre = fenetre;

	}
	
	private void ouvrir() throws FileNotFoundException {
		JFileChooser choixFichier = new JFileChooser();
		choixFichier.setFileFilter(filtre);
		if ( choixFichier.showOpenDialog( null ) == JFileChooser.APPROVE_OPTION ) {
		File f = choixFichier.getSelectedFile();
		FileInputStream fic = new FileInputStream(f);
		try {
			ObjectInputStream objetReader = new ObjectInputStream(fic);
			ArrayList<Forme> formes = (ArrayList<Forme>) objetReader.readObject();
			objetReader.close();
			panDessin.setListe(formes);
			panDessin.repaint();
			fenetre.setTitle(f.getName() + " - FakePaint");
		}catch(Exception ex){
			System.out.println(ex.getMessage()+ "Ce fichier ne contient pas de dessin");
		}
		}
	}
	
	private void enregistrer() throws FileNotFoundException {
		JFileChooser choixFichier = new JFileChooser();
		choixFichier.setFileFilter(filtre);
		if ( choixFichier.showSaveDialog( null ) == JFileChooser.APPROVE_OPTION ) {
		File f = choixFichier.getSelectedFile();
		FileOutputStream fic = new FileOutputStream(f);
		try {
			ObjectOutputStream objetWriter = new ObjectOutputStream(fic);
			objetWriter.writeObject(panDessin.getListe());
			objetWriter.close();
		}catch(Exception ex){
			System.out.println(ex.getLocalizedMessage());
		}
		}
	}

	@Override
	public void actionPerformed( ActionEvent e ) {

		if ( e.getSource() == optionNouveau ) {
			panDessin.setListe( new ArrayList<Forme>() );
			panDessin.repaint();

		} else if ( e.getSource() == optionEnregistrer ) {
			try {
				enregistrer();
			}catch(Exception ex){
				
			}
		} else if ( e.getSource() == optionEnregistrerSous ) {

		} else if ( e.getSource() == optionOuvrir ) {

			try {
				ouvrir();
			}catch(Exception ex){
				
			}
			
		} else if ( e.getSource() == optionQuitter ) {
			 int response = JOptionPane.showConfirmDialog(null, " Voulez-vous vraiment quitter?", 
             		"Confirmation", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
             if (response == JOptionPane.YES_OPTION) {
                 System.exit(0);
             }

		} else if ( e.getSource() == optionAPropos ) {
			JOptionPane.showMessageDialog( null, A_PROPOS, "À Propos", JOptionPane.INFORMATION_MESSAGE,
					new ImageIcon( new ImageIcon( Fenetre.class.getResource( iconeApp ) ).getImage()
							.getScaledInstance( 200, 300, Image.SCALE_SMOOTH ) ) );
		}

	}

}
