package Formes;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class Ovale extends Rectangle{

	public Ovale(Color contour, Color remplissage, int epaisseur) {
		super(contour, remplissage, epaisseur);

	}

	@Override
	public void tracer( Graphics g ) {

		Graphics2D g2 = (Graphics2D)g;
		g2.setStroke( new BasicStroke(getEpaisseur()) );
		g2.setColor( getRemplissage() );
		g2.fillOval( getX1(), getY1(), getLargeur(), getHauteur() );
		g2.setColor( getContour() );
		g2.drawOval( getX1(), getY1(), getLargeur(), getHauteur());
		
	}

}
