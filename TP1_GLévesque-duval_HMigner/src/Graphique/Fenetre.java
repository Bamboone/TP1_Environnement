package Graphique;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.*;
import javax.swing.*;

/**
 * Cette classe hérite de la classe JFrame et implémente l'interface AffichageConstantes. Elle permet de créer la fenêtre,
 * la barre de menu et la barre d'outils.
 * 
 * @author Hugo Migner
 * @author Gabriel Lévesque-Duval
 * @version 1.0
 *
 */

public class Fenetre extends JFrame implements AffichageConstantes {

	/**
	 * Numéro de sérialization
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * La barre de menu
	 */
	private JMenuBar barreMenu;
	/**
	 * Les deux menu, le menu pour gérer les actions sur un fichier et le menu "À propos"
	 */
	private JMenu menuFichier, menuAPropos;
	/**
	 * Toutes les boutons pour options du menu.
	 */
	private JMenuItem optionNouveau, optionEnregistrer, optionEnregistrerSous, optionOuvrir, optionQuitter,
			optionAPropos;
	/**
	 * La barre d'outils
	 */
	private JToolBar barreOutils;
	/**
	 * Des groupes de boutons pour regrouper les différents groupes de boutons
	 */
	private ButtonGroup groupeFormes, groupeContour, groupeSeaux;
	/**
	 * Le panneau de dessin, l'objet créé vient de la classe précédemment créée, PanDessin
	 */
	private PanDessin panDessin;
	/**
	 * Un tableau d'images, pour les boutons de la barre d'outils
	 */
	private ImageIcon[] tabImages = new ImageIcon[NB_BOUTONS];
	/**
	 * Un tableau de boutons, pour la barre d'outils
	 */
	private JToggleButton[] tabBoutons = new JToggleButton[NB_BOUTONS];
	/**
	 * Le listener pour les boutons de la barre d'outils
	 */
	private ListenerBoutons gestionnaireBoutons;
	/**
	 * Le listener pour les boutons du menu.
	 */
	private ListenerMenus gestionaireMenus;
	/**
	 * Une combo box pour la boîte d'options pour l'épaisseur du crayon.
	 */
	private JComboBox<Integer> comboBoxEpaisseur;

	/**
	 * Constructeur de la classe Fenetre
	 * Aucun paramètre
	 */
	public Fenetre() {
		super( "Sans titre - FakePaint" );
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setSize( 800, 800 );
		setIconImage( ( new ImageIcon( Fenetre.class.getResource( iconeApp ) ).getImage() ) );
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		setLocation( dim.width / 2 - this.getSize().width / 2, dim.height / 2 - this.getSize().height / 2 );
		panDessin = new PanDessin();
		barreMenu = createMenuBar();
		setJMenuBar( barreMenu );
		gestionnaireBoutons = new ListenerBoutons( tabBoutons, panDessin );
		barreOutils = createToolbar();
		barreOutils.setFloatable( false );
		add( barreOutils, BorderLayout.NORTH );
		
		

		add( panDessin );

	}
	
	/**
	 * Accesseur pour le listener des boutons du menu.
	 * @return gestionnaireMenus (Le listener)
	 */
	public ListenerMenus getListenerMenus() {
		return gestionaireMenus;
	}

	/**
	 * Méthode qui créé la barre de menus, avec tous les boutons, les bons raccourcis et leurs actions respectives.
	 * @return La barre de menus
	 */
	private JMenuBar createMenuBar() {

		barreMenu = new JMenuBar();

		menuFichier = new JMenu( "Fichier" );
		menuAPropos = new JMenu( "À propos" );

		barreMenu.add( menuFichier );
		barreMenu.add( menuAPropos );

		optionNouveau = new JMenuItem( "Nouveau" );
		optionNouveau.setAccelerator( KeyStroke.getKeyStroke( KeyEvent.VK_N, InputEvent.CTRL_DOWN_MASK ) );
		optionEnregistrer = new JMenuItem( "Enregistrer" );
		optionEnregistrer.setAccelerator( KeyStroke.getKeyStroke( KeyEvent.VK_S, InputEvent.CTRL_DOWN_MASK ) );
		optionEnregistrerSous = new JMenuItem( "Enregistrer sous" );
		optionOuvrir = new JMenuItem( "Ouvrir" );
		optionOuvrir.setAccelerator( KeyStroke.getKeyStroke( KeyEvent.VK_O, InputEvent.CTRL_DOWN_MASK ) );
		optionQuitter = new JMenuItem( "Quitter" );
		optionQuitter.setAccelerator( KeyStroke.getKeyStroke( KeyEvent.VK_Q, InputEvent.CTRL_DOWN_MASK ) );
		optionAPropos = new JMenuItem( "À propos" );
		
		gestionaireMenus = new ListenerMenus( optionNouveau, optionEnregistrer, optionEnregistrerSous, optionOuvrir,
				optionQuitter, optionAPropos, panDessin, this );
		
		optionNouveau.addActionListener( gestionaireMenus );
		optionEnregistrer.addActionListener( gestionaireMenus );
		optionEnregistrerSous.addActionListener( gestionaireMenus );
		optionOuvrir.addActionListener( gestionaireMenus );
		optionQuitter.addActionListener( gestionaireMenus );

		menuFichier.add( optionNouveau );
		menuFichier.add( optionEnregistrer );
		menuFichier.add( optionEnregistrerSous );
		menuFichier.add( optionOuvrir );
		menuFichier.addSeparator();
		menuFichier.add( optionQuitter );

		optionAPropos.addActionListener( gestionaireMenus );

		menuAPropos.add( optionAPropos );

		return barreMenu;
	}

	/**
	 * Méthode qui créé la barre d'outils avec tous ses boutons, les bonnes images, les bons groupes et leurs fonctions respectives.
	 * @return La barre d'outils
	 */
	private JToolBar createToolbar() {

		barreOutils = new JToolBar();
		groupeFormes = new ButtonGroup();
		groupeContour = new ButtonGroup();
		groupeSeaux = new ButtonGroup();
		Image image;

		for ( int i = 0; i < NB_BOUTONS; i++ ) {
			tabImages[i] = new ImageIcon( Fenetre.class.getResource( lienImages[i] ) );
			image = tabImages[i].getImage();
			image = image.getScaledInstance( 20, 25, Image.SCALE_SMOOTH );
			tabImages[i] = new ImageIcon( image );
		}
		for ( int i = 0; i < NB_FORMES; i++ ) {
			tabBoutons[i] = new JToggleButton( tabImages[i] );
			groupeFormes.add( tabBoutons[i] );
			tabBoutons[i].setToolTipText( tabToolTips[i] );
			barreOutils.add( tabBoutons[i] );
			tabBoutons[i].addActionListener( gestionnaireBoutons );
		}
		barreOutils.addSeparator();
		for ( int i = NB_FORMES; i < NB_FORMES + NB_CONTOURS; i++ ) {
			tabBoutons[i] = new JToggleButton( tabImages[i] );
			groupeContour.add( tabBoutons[i] );
			tabBoutons[i].setToolTipText( tabToolTips[i] );
			barreOutils.add( tabBoutons[i] );
			tabBoutons[i].addActionListener( gestionnaireBoutons );
		}
		barreOutils.addSeparator();
		for ( int i = NB_BOUTONS - NB_REMPLISSAGE; i < NB_BOUTONS; i++ ) {
			tabBoutons[i] = new JToggleButton( tabImages[i] );
			groupeSeaux.add( tabBoutons[i] );
			tabBoutons[i].setToolTipText( tabToolTips[i] );
			barreOutils.add( tabBoutons[i] );
			tabBoutons[i].addActionListener( gestionnaireBoutons );
		}
		barreOutils.addSeparator();
		comboBoxEpaisseur = new JComboBox<>( tabComboBox );
		ListenerComboBox gestionnaireComboBox = new ListenerComboBox( comboBoxEpaisseur, panDessin );
		comboBoxEpaisseur.addActionListener( gestionnaireComboBox );
		comboBoxEpaisseur.setToolTipText( tabToolTips[NB_BOUTONS] );
		barreOutils.add( comboBoxEpaisseur );
		tabBoutons[0].setSelected( true );
		tabBoutons[0].doClick();
		tabBoutons[NB_FORMES].setSelected( true );
		tabBoutons[NB_FORMES].doClick();
		tabBoutons[NB_BOUTONS - NB_REMPLISSAGE].setSelected( true );
		tabBoutons[NB_BOUTONS - NB_REMPLISSAGE].doClick();

		return barreOutils;
	}
	
	
}
