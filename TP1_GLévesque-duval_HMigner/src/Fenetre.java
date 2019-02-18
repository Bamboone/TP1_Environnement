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
	private ButtonGroup groupeFormes, groupePinceaux, groupeSeaux;
	private JToggleButton boutonOvale, boutonRectangle, boutonTrait;
	private JToggleButton boutonPinceauBleuClair, boutonPinceauBleuMarin, boutonPinceauJaune, boutonPinceauMauve,
			boutonPinceauNoir, boutonPinceauOrange;
	private JToggleButton boutonSeauRouge, boutonSeauRose, boutonSeauVert, boutonSeauNoir, boutonSeauJaune, boutonSeauBleu; 

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
		menuAPropos = new JMenu( "� propos" );

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

		optionAPropos = new JMenuItem( "� propos" );

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
		
		boutonPinceauBleuClair.setToolTipText( "Contour bleu clair" );
		boutonPinceauBleuMarin.setToolTipText( "Contour bleu marin" );
		boutonPinceauJaune.setToolTipText( "Contour jaune" );
		boutonPinceauMauve.setToolTipText( "Contour mauve" );
		boutonPinceauNoir.setToolTipText( "Contour noir" );
		boutonPinceauOrange.setToolTipText( "Contour orange" );
		
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
		barreOutils.addSeparator();
		
		ImageIcon imageSeauRouge = new ImageIcon( Fenetre.class.getResource( "images/fillrouge.png" ) );
		image = imageSeauRouge.getImage();
		image = image.getScaledInstance( 20, 25, Image.SCALE_SMOOTH );
		imageSeauRouge = new ImageIcon( image );
		
		ImageIcon imageSeauRose = new ImageIcon( Fenetre.class.getResource( "images/fillrose.png" ) );
		image = imageSeauRose.getImage();
		image = image.getScaledInstance( 20, 25, Image.SCALE_SMOOTH );
		imageSeauRose = new ImageIcon( image );
		
		ImageIcon imageSeauVert = new ImageIcon( Fenetre.class.getResource( "images/fillvert.png" ) );
		image = imageSeauVert.getImage();
		image = image.getScaledInstance( 20, 25, Image.SCALE_SMOOTH );
		imageSeauVert = new ImageIcon( image );
		
		ImageIcon imageSeauNoir = new ImageIcon( Fenetre.class.getResource( "images/fillnoir.png" ) );
		image = imageSeauNoir.getImage();
		image = image.getScaledInstance( 20, 25, Image.SCALE_SMOOTH );
		imageSeauNoir = new ImageIcon( image );
		
		ImageIcon imageSeauJaune = new ImageIcon( Fenetre.class.getResource( "images/filljaune.png" ) );
		image = imageSeauJaune.getImage();
		image = image.getScaledInstance( 20, 25, Image.SCALE_SMOOTH );
		imageSeauJaune = new ImageIcon( image );
		
		ImageIcon imageSeauBleu = new ImageIcon( Fenetre.class.getResource( "images/fillbleu.png" ) );
		image = imageSeauBleu.getImage();
		image = image.getScaledInstance( 20, 25, Image.SCALE_SMOOTH );
		imageSeauBleu = new ImageIcon( image );
		
		boutonSeauRouge = new JToggleButton( imageSeauRouge );
		boutonSeauRose = new JToggleButton( imageSeauRose );
		boutonSeauVert = new JToggleButton( imageSeauVert );
		boutonSeauNoir = new JToggleButton( imageSeauNoir );
		boutonSeauJaune = new JToggleButton( imageSeauJaune );
		boutonSeauBleu = new JToggleButton( imageSeauBleu );
		
		boutonSeauRouge.setToolTipText( "Remplissage rouge" );
		boutonSeauRose.setToolTipText( "Remplissage rose" );
		boutonSeauVert.setToolTipText( "Remplissage vert" );
		boutonSeauNoir.setToolTipText( "Remplissage noir" );
		boutonSeauJaune.setToolTipText( "Remplissage jaune" );
		boutonSeauBleu.setToolTipText( "Remplissage bleu" );
		
		groupeSeaux = new ButtonGroup();
		
		groupeSeaux.add( boutonSeauRouge );
		groupeSeaux.add( boutonSeauRose );
		groupeSeaux.add( boutonSeauVert );
		groupeSeaux.add( boutonSeauNoir );
		groupeSeaux.add( boutonSeauJaune );
		groupeSeaux.add( boutonSeauBleu );
		
		barreOutils.add( boutonSeauRouge);
		barreOutils.add( boutonSeauRose);
		barreOutils.add( boutonSeauVert);
		barreOutils.add( boutonSeauNoir);
		barreOutils.add( boutonSeauJaune);
		barreOutils.add( boutonSeauBleu);
		
		

		return barreOutils;
	}
}
