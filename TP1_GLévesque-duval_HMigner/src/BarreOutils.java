import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Image;
import java.io.File;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JToggleButton;
import javax.swing.JToolBar;

public class BarreOutils extends JFrame {
	private static final long serialVersionUID = 1L;
	
	private JToolBar barreOutils;
	private JPanel panneau;
	private ButtonGroup groupeFormes;
	private JToggleButton boutonOvale;
	private JToggleButton boutonRectangle;
	private JToggleButton boutonTrait;

	public BarreOutils() {
		setTitle( "Barre d'outils " );
		setSize( 300, 300 );
		panneau = new JPanel();
		panneau.setBackground( Color.white );
		add( panneau );

		barreOutils = createToolbar();
		add( barreOutils, BorderLayout.SOUTH );

	}

	private JToolBar createToolbar() {
		barreOutils = new JToolBar();
		groupeFormes = new ButtonGroup();
		
		ImageIcon imageOvale = new ImageIcon(BarreOutils.class.getResource( "images/ovale.jpg" ));
		Image image = imageOvale.getImage();
		Image imageResize = image.getScaledInstance( 60, 60, Image.SCALE_SMOOTH );
		imageOvale = new ImageIcon(imageResize);
		
		ImageIcon imageRectangle = new ImageIcon(BarreOutils.class.getResource( "images/rectangle.jpg" ));
		Image image2 = imageRectangle.getImage();
		Image imageResize2 = image2.getScaledInstance( 60, 60, Image.SCALE_SMOOTH );
		imageRectangle = new ImageIcon(imageResize2);
		
		ImageIcon imageTrait = new ImageIcon(BarreOutils.class.getResource( "images/trait.jpg" ));
		Image image3 = imageTrait.getImage();
		Image imageResize3 = image3.getScaledInstance( 60, 60, Image.SCALE_SMOOTH );
		imageTrait = new ImageIcon(imageResize3);
		
		boutonOvale = new JToggleButton(imageOvale);
		boutonRectangle = new JToggleButton(imageRectangle);
		boutonTrait = new JToggleButton(imageTrait);
		
		boutonOvale.setToolTipText( "Ovale" );
		boutonRectangle.setToolTipText( "Rectangle" );
		boutonTrait.setToolTipText( "Trait" );
		
		groupeFormes.add( boutonOvale );
		groupeFormes.add( boutonRectangle );
		groupeFormes.add( boutonTrait );
		
		barreOutils.add( boutonOvale );
		barreOutils.add( boutonRectangle );
		barreOutils.add( boutonTrait );
		
		return barreOutils;
	}

}
