import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Image;
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
	private ButtonGroup groupeFormes, groupePinceaux;
	private JToggleButton boutonOvale, boutonRectangle, boutonTrait;
	private JToggleButton boutonPinceauBleuClair, boutonPinceauBleuMarin, boutonPinceauJaune, boutonPinceauMauve,
			boutonPinceauNoir, boutonPinceauOrange;

	public Fenetre() {
		super( "FakePaint" );
		setSize( 800, 800 );
		barreMenu = createMenuBar();

		setJMenuBar( barreMenu );

		barreOutils = createToolbar();
		barreOutils.setFloatable( false );
		add( barreOutils, BorderLayout.NORTH );

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
		Image image;

		ImageIcon imageOvale = new ImageIcon( Fenetre.class.getResource( "images/ovale.jpg" ) );
		image = imageOvale.getImage();
		image = image.getScaledInstance( 20, 25, Image.SCALE_SMOOTH );
		imageOvale = new ImageIcon( image );

		ImageIcon imageRectangle = new ImageIcon( Fenetre.class.getResource( "images/rectangle.jpg" ) );
		image = imageRectangle.getImage();
		image = image.getScaledInstance( 20, 25, Image.SCALE_SMOOTH );
		imageRectangle = new ImageIcon( image );

		ImageIcon imageTrait = new ImageIcon( Fenetre.class.getResource( "images/trait.jpg" ) );
		image = imageTrait.getImage();
		image = image.getScaledInstance( 20, 25, Image.SCALE_SMOOTH );
		imageTrait = new ImageIcon( image );

		boutonOvale = new JToggleButton( imageOvale );
		boutonRectangle = new JToggleButton( imageRectangle );
		boutonTrait = new JToggleButton( imageTrait );

		boutonOvale.setToolTipText( "Ovale" );
		boutonRectangle.setToolTipText( "Rectangle" );
		boutonTrait.setToolTipText( "Trait" );

		groupeFormes.add( boutonOvale );
		groupeFormes.add( boutonRectangle );
		groupeFormes.add( boutonTrait );

		barreOutils.add( boutonOvale );
		barreOutils.add( boutonRectangle );
		barreOutils.add( boutonTrait );
		barreOutils.addSeparator();
		
		groupePinceaux = new ButtonGroup();
		
		ImageIcon imagePinceauxBleuClair = new ImageIcon( Fenetre.class.getResource( "images/bleuclair.jpg" ) );
		image = imagePinceauxBleuClair.getImage();
		image = image.getScaledInstance( 20, 25, Image.SCALE_SMOOTH );
		imagePinceauxBleuClair = new ImageIcon( image );
		
		ImageIcon imagePinceauxBleuMarin = new ImageIcon( Fenetre.class.getResource( "images/bleumarin.jpg" ) );
		image = imagePinceauxBleuMarin.getImage();
		image = image.getScaledInstance( 20, 25, Image.SCALE_SMOOTH );
		imagePinceauxBleuMarin = new ImageIcon( image );
		
		ImageIcon imagePinceauxJaune = new ImageIcon( Fenetre.class.getResource( "images/jaune.jpg" ) );
		image = imagePinceauxJaune.getImage();
		image = image.getScaledInstance( 20, 25, Image.SCALE_SMOOTH );
		imagePinceauxJaune = new ImageIcon( image );
		
		ImageIcon imagePinceauxMauve = new ImageIcon( Fenetre.class.getResource( "images/mauve.jpg" ) );
		image = imagePinceauxMauve.getImage();
		image = image.getScaledInstance( 20, 25, Image.SCALE_SMOOTH );
		imagePinceauxMauve = new ImageIcon( image );
		
		ImageIcon imagePinceauxNoir = new ImageIcon( Fenetre.class.getResource( "images/noir.jpg" ) );
		image = imagePinceauxNoir.getImage();
		image = image.getScaledInstance( 20, 25, Image.SCALE_SMOOTH );
		imagePinceauxNoir = new ImageIcon( image );
		
		ImageIcon imagePinceauxOrange = new ImageIcon( Fenetre.class.getResource( "images/orange.jpg" ) );
		image = imagePinceauxOrange.getImage();
		image = image.getScaledInstance( 20, 25, Image.SCALE_SMOOTH );
		imagePinceauxOrange = new ImageIcon( image );
		
		boutonPinceauBleuClair = new JToggleButton( imagePinceauxBleuClair );
		boutonPinceauBleuMarin = new JToggleButton(imagePinceauxBleuMarin);
		boutonPinceauJaune = new JToggleButton(imagePinceauxJaune);
		boutonPinceauMauve = new JToggleButton(imagePinceauxMauve);
		boutonPinceauNoir = new JToggleButton(imagePinceauxNoir);
		boutonPinceauOrange = new JToggleButton(imagePinceauxOrange);
		
		boutonPinceauBleuClair.setToolTipText( "Pinceau bleu clair" );
		boutonPinceauBleuMarin.setToolTipText( "Pinceau bleu marin" );
		boutonPinceauJaune.setToolTipText( "Pinceau jaune" );
		boutonPinceauMauve.setToolTipText( "Pinceau mauve" );
		boutonPinceauNoir.setToolTipText( "Pinceau noir" );
		boutonPinceauOrange.setToolTipText( "Pinceau orange" );
		
		groupePinceaux.add( boutonPinceauBleuClair );
		groupePinceaux.add( boutonPinceauBleuMarin );
		groupePinceaux.add( boutonPinceauJaune );
		groupePinceaux.add( boutonPinceauMauve );
		groupePinceaux.add( boutonPinceauNoir );
		groupePinceaux.add( boutonPinceauOrange );
		
		barreOutils.add( boutonPinceauBleuClair );
		barreOutils.add( boutonPinceauBleuMarin );
		barreOutils.add( boutonPinceauJaune );
		barreOutils.add( boutonPinceauMauve );
		barreOutils.add( boutonPinceauNoir );
		barreOutils.add( boutonPinceauOrange );
		
		

		return barreOutils;
	}
}
