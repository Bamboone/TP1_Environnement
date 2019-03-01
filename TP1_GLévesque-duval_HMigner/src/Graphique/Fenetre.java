package Graphique;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.*;
import javax.swing.*;

public class Fenetre extends JFrame implements AffichageConstantes {

	private static final long serialVersionUID = 1L;

	private JMenuBar barreMenu;
	private JMenu menuFichier, menuAPropos;
	private JMenuItem optionNouveau, optionEnregistrer, optionEnregistrerSous, optionOuvrir, optionQuitter,
			optionAPropos;
	private JToolBar barreOutils;
	private ButtonGroup groupeFormes, groupeContour, groupeSeaux;
	private PanDessin panDessin;
	private ImageIcon[] tabImages = new ImageIcon[NB_BOUTONS];
	private JToggleButton[] tabBoutons = new JToggleButton[NB_BOUTONS];
	private ListenerBoutons gestionnaireBoutons;
	private ListenerMenus gestionaireMenus;

	public Fenetre() {
		super( "Sans titre - FakePaint" );
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
				optionQuitter, optionAPropos, panDessin );
		
		optionNouveau.addActionListener( gestionaireMenus );
		optionEnregistrer.addActionListener( gestionaireMenus );
		optionEnregistrerSous.addActionListener( gestionaireMenus );
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
		tabBoutons[0].setSelected( true );
		tabBoutons[0].doClick();
		tabBoutons[NB_FORMES].setSelected( true );
		tabBoutons[NB_FORMES].doClick();
		tabBoutons[NB_BOUTONS - NB_REMPLISSAGE].setSelected( true );
		tabBoutons[NB_BOUTONS - NB_REMPLISSAGE].doClick();

		return barreOutils;
	}
}
