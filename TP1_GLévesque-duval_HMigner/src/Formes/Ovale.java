package Formes;

import java.awt.Color;
import java.awt.Graphics;

public class Ovale extends Rectangle{

	public Ovale( int x1, int y1, int x2, int y2, Color contour, Color remplissage ) {
		super( x1, y1, x2, y2, contour, remplissage );

	}

	@Override
	public void tracer( Graphics g ) {

		g.setColor( getContour() );
		g.drawOval( getX1()-1, getY1()-1, getLargeur()+2, getHauteur()+2);
		g.setColor( getRemplissage() );
		g.fillOval( getX1(), getY1(), getLargeur(), getHauteur() );
		
	}

}
