package Formes;

import java.awt.Color;
import java.awt.Graphics;

public class Ovale extends Rectangle{

	public Ovale( Color contour, Color remplissage ) {
		super( contour, remplissage );

	}

	@Override
	public void tracer( Graphics g ) {

		g.setColor( getContour() );
		g.drawOval( getX1()-1, getY1()-1, getLargeur()+2, getHauteur()+2);
		g.setColor( getRemplissage() );
		g.fillOval( getX1(), getY1(), getLargeur(), getHauteur() );
		
	}

}
