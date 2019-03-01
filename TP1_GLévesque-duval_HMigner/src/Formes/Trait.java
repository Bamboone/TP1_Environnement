package Formes;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class Trait extends Forme{

	public Trait(Color contour, int epaisseur) {
		super(contour, epaisseur);
	}

	@Override
	public void setParametres( int x1, int y1, int x2, int y2 ) {
		setX1( x1 );
		setX2( x2 );
		setY1( y1 );
		setY2( y2 );
	}

	@Override
	public void tracer( Graphics g ) {
		Graphics2D g2 = (Graphics2D)g;
		g2.setStroke( new BasicStroke(getEpaisseur()) );
		g2.setColor( getContour() );
		g2.drawLine( getX1(), getY1(), getX2(), getY2() );
	}
}
