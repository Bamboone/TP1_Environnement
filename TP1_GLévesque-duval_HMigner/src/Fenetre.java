import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JToggleButton;
import javax.swing.JToolBar;
import javax.swing.KeyStroke;

public class Fenetre extends JFrame {

	private static final long serialVersionUID = 1L;

	private JMenuBar barreMenu;
	private JMenu menuFichier, menuAPropos;
	private JMenuItem optionNouveau, optionEnregistrer, optionEnregistrerSous, optionOuvrir, optionQuitter,
			optionAPropos;
	private JToolBar barreOutils;
	private ButtonGroup groupeFormes, groupeContour, groupeSeaux;
	private final int NB_BOUTONS = 15;
	private JPanel panDessin;

	public Fenetre() {
		super( "Sans titre - FakePaint" );
		setSize( 800, 800 );
		setIconImage( ( new ImageIcon( Fenetre.class.getResource( "images/iconeApplication.png" ) ).getImage() ) );
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		setLocation( dim.width / 2 - this.getSize().width / 2, dim.height / 2 - this.getSize().height / 2 );
		barreMenu = createMenuBar();

		setJMenuBar( barreMenu );

		barreOutils = createToolbar();
		barreOutils.setFloatable( false );
		add( barreOutils, BorderLayout.NORTH );

		panDessin = new JPanel();

		add( panDessin );

		setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );

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

		menuFichier.add( optionNouveau );
		menuFichier.add( optionEnregistrer );
		menuFichier.add( optionEnregistrerSous );
		menuFichier.add( optionOuvrir );
		menuFichier.addSeparator();
		menuFichier.add( optionQuitter );

		optionAPropos = new JMenuItem( "À propos" );

		menuAPropos.add( optionAPropos );

		return barreMenu;
	}

	private JToolBar createToolbar() {

		barreOutils = new JToolBar();
		groupeFormes = new ButtonGroup();
		groupeContour = new ButtonGroup();
		groupeSeaux = new ButtonGroup();
		Image image;

		ImageIcon[] tabImages = new ImageIcon[NB_BOUTONS];
		String[] lienImages = { "images/ovale.jpg", "images/rectangle.jpg", "images/trait.jpg", "images/bleuclair.jpg",
				"images/bleumarin.jpg", "images/jaune.jpg", "images/mauve.jpg", "images/noir.jpg", "images/orange.jpg",
				"images/fillrouge.png", "images/fillrose.png", "images/fillvert.png", "images/fillnoir.png",
				"images/filljaune.png", "images/fillbleu.png" };
		JToggleButton[] tabBoutons = new JToggleButton[NB_BOUTONS];
		String[] tabToolTips = { "Ovale", "Rectangle", "Trait", "Contour bleu clair", "Contour bleu marin",
				"Contour jaune", "Contour mauve", "Contour noir", "Contour orange", "Remplissage rouge",
				"Remplissage rose", "Remplissage vert", "Remplissage noir", "Remplissage jaune", "Remplissage bleu" };

		for ( int i = 0; i < NB_BOUTONS; i++ ) {
			tabImages[i] = new ImageIcon( Fenetre.class.getResource( lienImages[i] ) );
			image = tabImages[i].getImage();
			image = image.getScaledInstance( 20, 25, Image.SCALE_SMOOTH );
			tabImages[i] = new ImageIcon( image );
		}
		for ( int i = 0; i < 3; i++ ) {
			tabBoutons[i] = new JToggleButton( tabImages[i] );
			groupeFormes.add( tabBoutons[i] );
			tabBoutons[i].setToolTipText( tabToolTips[i] );
			barreOutils.add( tabBoutons[i] );
		}
		barreOutils.addSeparator();
		for ( int i = 3; i < 9; i++ ) {
			tabBoutons[i] = new JToggleButton( tabImages[i] );
			groupeContour.add( tabBoutons[i] );
			tabBoutons[i].setToolTipText( tabToolTips[i] );
			barreOutils.add( tabBoutons[i] );
		}
		barreOutils.addSeparator();
		for ( int i = 9; i < NB_BOUTONS; i++ ) {
			tabBoutons[i] = new JToggleButton( tabImages[i] );
			groupeSeaux.add( tabBoutons[i] );
			tabBoutons[i].setToolTipText( tabToolTips[i] );
			barreOutils.add( tabBoutons[i] );
		}

		return barreOutils;
	}
}
