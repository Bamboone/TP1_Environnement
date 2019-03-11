package Graphique;

import java.awt.Image;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;

import Formes.Forme;

public class ListenerMenus implements ActionListener, AffichageConstantes {

	private JMenuItem optionNouveau, optionEnregistrer, optionEnregistrerSous, optionOuvrir, optionQuitter,
			optionAPropos;

	private JFrame fenetre;

	private PanDessin panDessin;

	private FileFilter filtre = new FileNameExtensionFilter("Dessin FakePaint (*.dfp)", "dfp");

	private boolean nouveau = true;

	private File fichier;

	public ListenerMenus(JMenuItem optionNouveau, JMenuItem optionEnregistrer, JMenuItem optionEnregistrerSous,
			JMenuItem optionOuvrir, JMenuItem optionQuitter, JMenuItem optionAPropos, PanDessin panDessin,
			JFrame fenetre) {

		this.optionNouveau = optionNouveau;
		this.optionEnregistrer = optionEnregistrer;
		this.optionEnregistrerSous = optionEnregistrerSous;
		this.optionOuvrir = optionOuvrir;
		this.optionQuitter = optionQuitter;
		this.optionAPropos = optionAPropos;
		this.panDessin = panDessin;
		this.fenetre = fenetre;

	}

	@SuppressWarnings("unchecked")
	private void ouvrir() throws FileNotFoundException {

		if (!panDessin.isSauvegarde()) {
			int response = JOptionPane.showConfirmDialog(null,
					"Voulez-vous sauvegarder le dessin avant d'ouvrir un nouveau?", "Confirmation",
					JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
			if (response == JOptionPane.YES_OPTION) {
				try {
					enregistrer();
				} catch (Exception ex) {

				}
			}
		}

		JFileChooser choixFichier = new JFileChooser();
		choixFichier.setFileFilter(filtre);
		if (choixFichier.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
			fichier = choixFichier.getSelectedFile();
			if(fichier.exists()) {
				FileInputStream fic = new FileInputStream(fichier);
				try {
					ObjectInputStream objetReader = new ObjectInputStream(fic);
					ArrayList<Forme> formes = (ArrayList<Forme>) objetReader.readObject();
					objetReader.close();
					panDessin.setListe(formes);
					panDessin.repaint();
					fenetre.setTitle(fichier.getName() + " - FakePaint");
					panDessin.setSauvegarde(true);
					nouveau = false;
				} catch (Exception ex) {
					System.out.println("Ce fichier ne contient pas de dessin");
				}
			}else {
				System.out.println("Erreur, ce fichier n'existe pas.");
			}
			
		}
	}

	private void enregistrer() throws FileNotFoundException {

		if (nouveau) {
			enregistrerSous();
		} else {
			FileOutputStream fic = new FileOutputStream(fichier);
			try {
				ObjectOutputStream objetWriter = new ObjectOutputStream(fic);
				objetWriter.writeObject(panDessin.getListe());
				panDessin.setSauvegarde(true);
				objetWriter.close();
			} catch (Exception ex) {
				System.out.println(ex.getLocalizedMessage());
			}
		}

	}

	private void enregistrerSous() throws FileNotFoundException {

		JFileChooser choixFichier = new JFileChooser();
		choixFichier.setFileFilter(filtre);
		if (choixFichier.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) {
			fichier = choixFichier.getSelectedFile();
			fenetre.setTitle(fichier.getName() + " - FakePaint");
			nouveau = false;
			FileOutputStream fic = new FileOutputStream(fichier);
			try {
				ObjectOutputStream objetWriter = new ObjectOutputStream(fic);
				objetWriter.writeObject(panDessin.getListe());
				panDessin.setSauvegarde(true);
				objetWriter.close();
			} catch (Exception ex) {
				System.out.println(ex.getLocalizedMessage());
			}
			nouveau = false;
		}
	}

	public void quitter() {
		int response = JOptionPane.showConfirmDialog(null, "Voulez-vous vraiment quitter?", "Confirmation",
				JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
		if (response == JOptionPane.YES_OPTION) {
			if (!panDessin.isSauvegarde()) {
				int responseSauvegarder = JOptionPane.showConfirmDialog(null,
						"Voulez-vous sauvegarder le dessin avant de quitter?", "Confirmation",
						JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
				if (responseSauvegarder == JOptionPane.YES_OPTION) {
					try {
						enregistrer();
					} catch (Exception ex) {

					}
				}
			}
			System.exit(0);
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == optionNouveau) {
			if (!panDessin.isSauvegarde()) {
				int response = JOptionPane.showConfirmDialog(null,
						"Voulez-vous sauvegarder le dessin avant d'en créer un nouveau?", "Confirmation",
						JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
				if (response == JOptionPane.YES_OPTION) {
					try {
						enregistrer();
					} catch (Exception ex) {

					}
				}
			}
			panDessin.setListe(new ArrayList<Forme>());
			panDessin.repaint();
			nouveau = true;
			panDessin.setSauvegarde( true );
			fenetre.setTitle("Sans titre - FakePaint");

		} else if (e.getSource() == optionEnregistrer) {
			try {
				enregistrer();
			} catch (Exception ex) {

			}
		} else if (e.getSource() == optionEnregistrerSous) {
			try {
				enregistrerSous();
			} catch (Exception ex) {

			}
		} else if (e.getSource() == optionOuvrir) {

			try {
				ouvrir();
			} catch (Exception ex) {

			}

		} else if (e.getSource() == optionQuitter) {

			quitter();

		} else if (e.getSource() == optionAPropos) {
			JOptionPane.showMessageDialog(null, A_PROPOS, "À Propos", JOptionPane.INFORMATION_MESSAGE,
					new ImageIcon(new ImageIcon(Fenetre.class.getResource(iconeApp)).getImage().getScaledInstance(200,
							300, Image.SCALE_SMOOTH)));
		}

	}

}
